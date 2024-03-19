import "../../static/css/auth/authButton.css";
import "../../static/css/auth/authPage.css";
import tokenService from "../../services/token.service";
import getErrorModal from "../../util/getErrorModal";
import { petHotelRoomEditInputs } from "./form/petHotelRoomEditInputs";
import FormGenerator from "../../components/formGenerator/formGenerator";
import { useState, useEffect, useRef } from "react";
import {useNavigate} from "react-router-dom";

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

    fetch(`/api/v1/clinicOwners/petHotelRooms`, {
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
    </div>
  );
}
