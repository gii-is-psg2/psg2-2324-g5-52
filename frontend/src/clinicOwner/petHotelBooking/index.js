import "../../static/css/auth/authButton.css";
import "../../static/css/auth/authPage.css";
import tokenService from "../../services/token.service";
import getErrorModal from "../../util/getErrorModal";
import {petHotelBookingEditInputs} from "./form/petHotelBookingEditInputs";
import FormGenerator from "../../components/formGenerator/formGenerator";
import { useState, useEffect, useRef } from "react";
import {useLocation, useNavigate} from "react-router-dom";
import { Default, Feature, On, feature } from "pricing4react";
import { fetchWithPricingInterceptor } from "pricing4react";

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

    fetchWithPricingInterceptor(`/api/v1/clinicOwners/bookings`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${jwt}`,
        },
        body: JSON.stringify(booking),
      })
      .then((res) => {
        if (res.ok) {
          navigator("/petHotelRooms");
        }
        else{
          const contentType = res.headers.get("Content-Type");
          if (contentType && contentType.includes("application/json")) {
            return res.json().then((errorData) => {
              let errorMessage = errorData.message;
              alert(errorMessage);
            });
          } else {
            return res.text().then((errorMessage) => {
              setMessage(errorMessage);
              setVisible(true);
            });
          }
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

    <Feature>
      <On expression={feature("booking")}>
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
      </On>
      <Default>
      <p>Adoptions disabled due to constraints in your plan</p>
      </Default>
    </Feature>

      
    </div>
  );
}
