import { useState } from "react";
import useFetchState from "../../../util/useFetchState";
import tokenService from "../../../services/token.service";
import getErrorModal from "../../../util/getErrorModal";
import { Button, Table } from "reactstrap";
import { Link } from "react-router-dom";


const user = tokenService.getUser();
const jwt = tokenService.getLocalAccessToken();

export default function OwnerAdoptionsList() {
    const [message, setMessage] = useState(null);
    const [visible, setVisible] = useState(false);
    const [petsOnAdoption, setPetsOnAdoption] = useFetchState(
        [],
        `/api/v1/pets/onAdoption`,
        jwt,
        setMessage,
        setVisible
    );

    const [myPetsAdoptions, setMyPetsAdoptions] = useFetchState(
        [],
        `/api/v1/adoptions`,
        jwt,
        setMessage,
        setVisible
    )

    const [alerts, setAlerts] = useState([]);

    function acceptAdoption(id) {
        fetch(`/api/v1/adoptions/accept/${id}`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${jwt}`,
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        })
            .then((response) => {
                if (response.status === 200) {
                    alert("Adoption accepted");
                }
            })
    }


    const adoptionsList =
        petsOnAdoption.filter((pet) => pet.owner.user.username !== user.username).map((pet) => {
            return (
                <tr key={pet.id}>
                    <td className="text-center">{pet.name}</td>
                    <td className="text-center">{pet.type.name}</td>
                    <td className="text-center">{pet.owner.user.username}</td>
                    <td className="text-center">
                        <Button outline color="success" tag={Link} to={`/adoptions/new?petName=${pet.name}`}>
                            Request adoption
                        </Button>
                    </td>
                </tr>
            );
        });

    const myAdoptionsList =
        myPetsAdoptions.map((adoption) => {
            return (
                <tr key={adoption.id}>
                    <td className="text-center">{adoption.petToAdopt}</td>
                    <td className="text-center">{adoption.newOwner}</td>
                    <td className="text-center">{adoption.description}</td>
                    <td className="text-center">
                        <Button outline color="success" onClick={() => acceptAdoption(adoption.id)}>
                            Accept
                        </Button>
                    </td>
                </tr>
            );
        });

    const modal = getErrorModal(setVisible, visible, message);

    return (
        <div>
            <div className="adoptions-list-container">
                <h1 className="text-center">Adoptions available</h1>
                {alerts.map((a) => a.alert)}
                {modal}
                <div>
                    <Table aria-label="petsOnAdoption" className="mt-4">
                        <thead>
                            <tr>
                                <th width="15%" className="text-center">Pet</th>
                                <th width="15%" className="text-center">Type</th>
                                <th width="15%" className="text-center">Owner</th>
                            </tr>
                        </thead>
                        <tbody>{adoptionsList}</tbody>
                    </Table>
                </div>
            </div>
            <div className="myAdoptions-list-container">
                <h1 className="text-center">My pets adoptions</h1>
                {alerts.map((a) => a.alert)}
                {modal}
                <div>
                    <Table aria-label="myPetsOnAdoption" className="mt-4">
                        <thead>
                            <tr>
                                <th width="15%" className="text-center">Pet</th>
                                <th width="15%" className="text-center">Owner solicitant</th>
                                <th width="15%" className="text-center">Description</th>
                            </tr>
                        </thead>
                        <tbody>{myAdoptionsList}</tbody>
                    </Table>
                </div>
            </div>
        </div>
    );


}