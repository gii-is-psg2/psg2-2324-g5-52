import "../../static/css/auth/authButton.css";
import "../../static/css/auth/authPage.css";
import tokenService from "../../services/token.service";
import getErrorModal from "../../util/getErrorModal";
import {petHotelBookingEditInputs} from "./form/petHotelBookingEditInputs";
import FormGenerator from "../../components/formGenerator/formGenerator";
import { useState, useEffect, useRef } from "react";
import {useLocation, useNavigate} from "react-router-dom";

const jwt = tokenService.getLocalAccessToken();

export default function EditpetHotelBooking() {
  const navigator = useNavigate();
  const location = useLocation();

  const emptyItem = {
    startDate: "",
    endDate: "",
    pet: "",
  };

  const [message, setMessage] = useState(null);
  const [visible, setVisible] = useState(false);
  const [petHotelBooking, setPetHotelBooking] = useState(emptyItem);
  const petHotelRoom = location.state?.room


  const editpetHotelBookingFormRef = useRef(null);

  function handleSubmit({ values }) {
    if (!editpetHotelBookingFormRef.current.validate()) return;
    const booking = {
      startDate : values.startDate,
      endDate : values.endDate,
      pet : values.pet,
      petHotelRoom : petHotelRoom
    }

    fetch(`/api/v1/clinicOwners/bookings`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${jwt}`,
        },
        body: JSON.stringify(booking),
      })
      .then((res) => {
        if (res.status === 201) {
          navigator("/petHotelRooms");
        }
      })
      .catch((err) => {
        setMessage(err.message);
      });
    
  }

  useEffect(() => {
      petHotelBookingEditInputs.forEach((input) => {
        input.defaultValue = "";
      });
  }, [petHotelBooking]);

  const modal = getErrorModal(setVisible, visible, message);

  return (
    <div className="auth-page-container">
      {<h2>{"Add a Booking"}</h2>}
      {modal}
      <div className="auth-form-container">
          <FormGenerator
            ref={editpetHotelBookingFormRef}
            inputs={petHotelBookingEditInputs}
            onSubmit={handleSubmit}
            buttonText="Add"
            buttonClassName="auth-button"
          />
      </div>
    </div>
  );
}
