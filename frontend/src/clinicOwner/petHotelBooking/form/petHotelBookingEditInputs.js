import { formValidators } from "../../../validators/formValidators";
import tokenService from "../../../services/token.service";

const jwt = tokenService.getLocalAccessToken();
console.log(jwt);

const fetchPetTypes = async () => {
    const response = await fetch(`/api/v1/pets/types`, {
        method: "GET",
        headers: {
          Authorization: `Bearer ${jwt}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        }
      });
    const data = await response.json();
    console.log(data)

    if(data.message) {
        return [];
    }
    else{
        const petTypes = data.map((petType) => {
            return petType.name;
        })
        return petTypes;
    }

};

const petTypes = await fetchPetTypes();

const fetchClinics = async () => {
    const response = await fetch(`/api/v1/clinics`, {
        method: "GET",
        headers: {
          Authorization: `Bearer ${jwt}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        }
      });
    const data = await response.json();
    console.log(data)

    if(data.message) {
        return [];
    }
    else{
        const clinics = data.map((c) => {
            return c.name;
        })
        return clinics;
    }

};

const clinics = await fetchClinics();

export const petHotelBookingEditInputs = [
    {
        tag: "StartDate",
        name: "startDate",
        type: "date",
        defaultValue: "",
        isRequired: true,
        validators: [formValidators.notEmptyValidator],
    },
    {
        tag: "EndDate",
        name: "endDate",
        type: "date",
        defaultValue: "",
        isRequired: true,
        validators: [formValidators.notEmptyValidator],
    },
    {
        tag: "PetType",
        name: "petType",
        type: "select",
        values: ["None", ...petTypes],
        defaultValue: "None",
        isRequired: true,
        validators: [formValidators.notEmptyValidator, formValidators.notNoneTypeValidator],
    },
    {
        tag: "Room",
        name: "room",
        type: "number",
        defaultValue: 0,
        isRequired: true,
        validators: [formValidators.notEmptyValidator],
    }
];