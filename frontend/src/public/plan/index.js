import React from "react";
import "../../static/css/pricing/pricingPage.css";
import {BsDot} from "react-icons/bs";
import {TbCurrencyDollarOff} from "react-icons/tb";
import {FaTimes, FaCheck} from "react-icons/fa";
import {PiCrownSimpleFill} from "react-icons/pi";
import {IoDiamond} from "react-icons/io5";

export default function PlanList() {

  return (
    <div className="pricing-page-container">
      <div>
        <h1 className="pricing-title">Pricing Plans</h1>
      </div>
      <div className="section-pricing">
        <div className="pricing-container">
          <div className="pricing-card text-center">
            <div className="title">
              <div className="icon">
                <TbCurrencyDollarOff color="white" />
              </div>
              <h2>BASIC</h2>
            </div>
            <div className="plan-price">
              <h4>15€ / month</h4>
            </div>
            <div className="option">
              <ul>
                <li>
                  <BsDot color="white" /> 2 pets
                </li>
                <li>
                  <BsDot color="white" /> 1 visit per month and pet
                </li>
                <li>
                  <BsDot color="white" /> Low support priority
                </li>
                <li>
                  <FaTimes color="red" /> Include SLA
                </li>
                <li>
                  <FaTimes color="red" /> Adoptions service
                </li>
                <li>
                  <FaTimes color="red" /> Vet Selection for Visits
                </li>
                <li>
                  <FaTimes color="red" /> Calendar with Upcoming Visits
                </li>
                <li>
                  <FaTimes color="red" /> Pet Hotel Room service
                </li>
                <li>
                  <FaTimes color="red" /> Booking service
                </li>
                <li>
                  <FaTimes color="red" /> Online Consultation
                </li>
              </ul>
            </div>
          </div>
          {/* END Col one */}
          <div className="pricing-card text-center">
            <div className="title">
              <div className="icon">
                <PiCrownSimpleFill color="white" style={{ transform: "rotate(270deg)" }} />
              </div>
              <h2>GOLD</h2>
            </div>
            <div className="plan-price">
              <h4>30€ / month</h4>
            </div>
            <div className="option">
              <ul>
                <li>
                  <BsDot color="white" /> 4 pets
                </li>
                <li>
                  <BsDot color="white" /> 3 visit per month and pet
                </li>
                <li>
                  <BsDot color="white" /> Medium support priority
                </li>
                <li>
                  <FaCheck color="green" /> Include SLA
                </li>
                <li>
                  <FaCheck color="green" /> Adoptions service
                </li>
                <li>
                  <FaCheck color="green" /> Vet Selection for Visits
                </li>
                <li>
                  <FaCheck color="green" /> Calendar with Upcoming Visits
                </li>
                <li>
                  <FaTimes color="red" /> Pet Hotel Room service
                </li>
                <li>
                  <FaTimes color="red" /> Booking service
                </li>
                <li>
                  <FaTimes color="red" /> Online Consultation
                </li>
              </ul>
            </div>
          </div>
          {/* END Col two */}
          <div className="pricing-card text-center">
            <div className="title" style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
              <div className="icon">
                <IoDiamond color="white" />
              </div>
              <h2>PLATINUM</h2>
            </div>
            <div className="plan-price">
              <h4>50€ / month</h4>
            </div>
            <div className="option">
              <ul>
                <li>
                  <BsDot color="white" /> 7 pets
                </li>
                <li>
                  <BsDot color="white" /> 6 visit per month and pet
                </li>
                <li>
                  <BsDot color="white" /> High support priority
                </li>
                <li>
                  <FaCheck color="green" /> Include SLA
                </li>
                <li>
                  <FaCheck color="green" /> Adoptions service
                </li>
                <li>
                  <FaCheck color="green" /> Vet Selection for Visits
                </li>
                <li>
                  <FaCheck color="green" /> Calendar with Upcoming Visits
                </li>
                <li>
                  <FaCheck color="green" /> Pet Hotel Room service
                </li>
                <li>
                  <FaCheck color="green" /> Booking service
                </li>
                <li>
                  <FaCheck color="green" /> Online Consultation
                </li>
              </ul>
            </div>
          </div>
          {/* END Col three */}
        </div>
      </div>
    </div>
  );
}
