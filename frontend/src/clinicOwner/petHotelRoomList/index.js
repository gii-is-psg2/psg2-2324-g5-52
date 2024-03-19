import { useState } from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup, Table } from "reactstrap";
import tokenService from "../../services/token.service";
import useFetchState from "../../util/useFetchState";
import getErrorModal from "../../util/getErrorModal";
import "../../static/css/admin/adminPage.css";
import { useNavigate } from "react-router-dom";

const user = tokenService.getUser();
const jwt = tokenService.getLocalAccessToken();

export default function PetHotelRoomList() {
  const [message, setMessage] = useState(null);
  const [visible, setVisible] = useState(false);
  const [petHotelRooms, setPetHotelRooms] = useFetchState(
    [],
    `/api/v1/clinicOwners/petHotelRooms`,
    jwt,
    setMessage,
    setVisible
  );
  const [alerts, setAlerts] = useState([]);

  const navigator = useNavigate();

  const petHotelList =
    petHotelRooms.map((room) => {
      return (
        <tr key={room.id}>
          <td className="text-center">{room.name}</td>
          <td className="text-center">{room.petType.name}</td>
          <td className="text-center">{room.clinic.name}</td>
          <td className="text-center">{room.size}</td>
          <td className="text-center"></td>
          <td>
            <Button
              color="success"
              onClick={() => navigator("/petHotelRooms/booking", { state: { room } })}
            >
              Add a Booking
            </Button>
          </td>
        </tr>
      );
    });

  const modal = getErrorModal(setVisible, visible, message);

  return (
    <div>
      <div className="admin-page-container">
        <h1 className="text-center">Pet Hotel Rooms</h1>
        {alerts.map((a) => a.alert)}
        {modal}
        <div className="float-right">
          <Button color="success" tag={Link} to="/petHotelRooms/new">
            Add a Pet Hotel Room
          </Button>
        </div>
        <span>&nbsp;&nbsp;</span>
        <div>
          <Table aria-label="clinics" className="mt-4">
            <thead>
              <tr>
                <th width="15%" className="text-center">Name</th>
                <th width="15%" className="text-center">Pet Type</th>
                <th width="15%" className="text-center">Clinic</th>
                <th width="15%" className="text-center">Size</th>
              </tr>
            </thead>
            <tbody>{petHotelList}</tbody>
          </Table>
        </div>
      </div>
    </div>
  );
}
