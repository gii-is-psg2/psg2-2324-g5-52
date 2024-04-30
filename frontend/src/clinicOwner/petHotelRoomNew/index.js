import "../../static/css/auth/authButton.css";
import "../../static/css/auth/authPage.css";
import tokenService from "../../services/token.service";
import getErrorModal from "../../util/getErrorModal";
import { petHotelRoomEditInputs } from "./form/petHotelRoomEditInputs";
import FormGenerator from "../../components/formGenerator/formGenerator";
import { useState, useEffect, useRef } from "react";
import {useNavigate} from "react-router-dom";
import { Default, Feature, On, feature } from "pricing4react";
import { fetchWithPricingInterceptor } from "pricing4react";

const jwt = tokenService.getLocalAccessToken();

export default function EditpetHotelRoom() {
  const navigator = useNavigate();


  const emptyItem = {
    name: "",
    pettype: "",
    clinic: "",
    size: 0,
  };

  const [message, setMessage] = useState(null);
  const [visible, setVisible] = useState(false);
  const [petHotelRoom, setPetHotelRoom] = useState(emptyItem);  

  const editpetHotelRoomFormRef = useRef(null);

  function handleSubmit({ values }) {
    if (!editpetHotelRoomFormRef.current.validate()) return;

    fetchWithPricingInterceptor(`/api/v1/clinicOwners/petHotelRooms`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${jwt}`,
        },
        body: JSON.stringify(values),
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
      petHotelRoomEditInputs.forEach((input) => {
        input.defaultValue = "";
      });
  }, [petHotelRoom]);

  const modal = getErrorModal(setVisible, visible, message);

  return (
    <div className="auth-page-container">
      <Feature>
        <On expression={feature("roomService")}>
          {<h2>{"Add a Pet Hotel Room"}</h2>}
          {modal}
          <div className="auth-form-container">
              <FormGenerator
                ref={editpetHotelRoomFormRef}
                inputs={petHotelRoomEditInputs}
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
