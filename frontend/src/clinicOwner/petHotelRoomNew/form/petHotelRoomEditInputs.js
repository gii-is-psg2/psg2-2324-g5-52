import { formValidators } from "../../../validators/formValidators";
import tokenService from "../../../services/token.service";

const jwt = tokenService.getLocalAccessToken();

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
    const response = await fetch(`/api/v1/clinics?plan=PLATINUM`, {
        method: "GET",
        headers: {
          Authorization: `Bearer ${jwt}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        }
      });
    const data = await response.json();
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

export const petHotelRoomEditInputs = [
    {
        tag: "Name",
        name: "name",
        type: "text",
        defaultValue: "",
        isRequired: true,
        validators: [formValidators.notEmptyValidator],
    },
    {
        tag: "Clinic",
        name: "clinic",
        type: "select",
        values: ["None", ...clinics],
        defaultValue: "None",
        isRequired: true,
        validators: [formValidators.notEmptyValidator, formValidators.notNoneTypeValidator],
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
        tag: "Size",
        name: "size",
        type: "number",
        defaultValue: 0,
        isRequired: true,
        validators: [formValidators.notEmptyValidator],
    }
];