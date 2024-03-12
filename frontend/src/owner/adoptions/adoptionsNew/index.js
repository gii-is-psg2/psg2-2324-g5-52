import "../../../static/css/auth/authButton.css";
import "../../../static/css/auth/authPage.css";
import tokenService from "../../../services/token.service";
import getErrorModal from "../../../util/getErrorModal";
import FormGenerator from "../../../components/formGenerator/formGenerator";
import { formValidators } from "../../../validators/formValidators";
import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";

const jwt = tokenService.getLocalAccessToken();


export default function NewAdoption() {
  const navigator = useNavigate();

  const urlParams = new URLSearchParams(window.location.search);
  const petName = urlParams.get('petName');

  const defaultAdoption = {
    petNameId: petName.id,
    description: "",
  };

  const [message, setMessage] = useState(null);
  const [visible, setVisible] = useState(false);
  const [adoption, setAdoption] = useState(defaultAdoption);

  const adoptionNewInputsRef = useRef(null);

  function handleSubmit({ values }) {

    fetch(`/api/v1/adoptions`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
      body: JSON.stringify(values),
    })
      .then((res) => {
        if (res.status === 201) {
          navigator("/adoptions");
        }
      })
      .catch((err) => {
        setMessage(err.message);
      });

  }

  const modal = getErrorModal(setVisible, visible, message);

  return (
    <div className="auth-page-container">
      {<h2>{"Apply to an adoption"}</h2>}
      {modal}
      <div className="auth-form-container">
        <FormGenerator
          ref={adoptionNewInputsRef}
          inputs={[
            {
              tag: "Description",
              name: "description",
              type: "text",
              defaultValue: "",
              isRequired: true,
              validators: [formValidators.notEmptyValidator],
            }
          ]}
          initialValues={adoption}
          onSubmit={handleSubmit}
          buttonText="Add"
          buttonClassName="auth-button"
        />
      </div>
    </div>
  );
}
