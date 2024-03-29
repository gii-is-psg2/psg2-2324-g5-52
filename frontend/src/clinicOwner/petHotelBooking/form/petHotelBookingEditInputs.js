import { formValidators } from "../../../validators/formValidators";
import tokenService from "../../../services/token.service";

const user = tokenService.getUser();
const jwt = tokenService.getLocalAccessToken();

const fetchUserPets = async () => {
    const response = await fetch(`/api/v1/pets?ownerId=${user.id}`, {
        method: "GET",
        headers: {
          Authorization: `Bearer ${jwt}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        }
      });
    const data = await response.json();
    console.log(data);


    if(data.message) {
        return [];
    }
    else{
        const userPets = data.map((pets) => {
            return pets.name;
        })
        return userPets;
    }
    

};

const userPets = await fetchUserPets();


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
        tag: "Pet",
        name: "pet",
        type: "select",
        values: ["None", ...userPets],
        defaultValue: "None",
        isRequired: true,
        validators: [formValidators.notEmptyValidator, formValidators.notNoneTypeValidator],
        
    }
];