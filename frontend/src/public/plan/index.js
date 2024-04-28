import React from "react";
import { BsDot, BsFillRocketTakeoffFill } from "react-icons/bs";
import { FaCheck, FaPaperPlane, FaTimes } from "react-icons/fa";
import { PiCrownSimpleFill } from "react-icons/pi";
import { IoDiamond } from "react-icons/io5";
import { TbCurrencyDollarOff } from "react-icons/tb";
import { ImAirplane } from "react-icons/im";
import "../../static/css/pricing/pricingPage.css";

export default function PlanList() {

  const planList = [
    {
      plan: "BASIC",
      price: "0.00",
      currency: "€",
      frecuency: "/MONTH",
      features: [
        { feature: "Number of Pets", value: 2 },
        { feature: "Visits per Month and Pet", value: 1 },
        { feature: "Support Priority", value: "Low" },
        { feature: "Include SLA", value: "No" },
        { feature: "Adoptions Service", value: "❌" },
        { feature: "Vet Selection for Visits", value: "❌" },
        { feature: "Calendar with Upcoming Visits", value: "❌" },
        { feature: "Pet Hotel Room Creation", value: "❌" },
        { feature: "Booking Creation", value: "❌" },
        { feature: "Dashboard of Your Pets", value: "❌" },
        { feature: "Online Consultation", value: "❌" }
      ]
    },
    {
      plan: "GOLD",
      price: "5.00",
      currency: "€",
      frecuency: "/MONTH",
      features: [
        { feature: "Number of Pets", value: 5 },
        { feature: "Visits per Month and Pet", value: 3 },
        { feature: "Support Priority", value: "Medium" },
        { feature: "Include SLA", value: "Yes" },
        { feature: "Adoptions Service", value: "✅" },
        { feature: "Vet Selection for Visits", value: "✅" },
        { feature: "Calendar with Upcoming Visits", value: "✅" },
        { feature: "Pet Hotel Room Creation", value: "❌" },
        { feature: "Booking Creation", value: "❌" },
        { feature: "Dashboard of Your Pets", value: "❌" },
        { feature: "Online Consultation", value: "❌" }
      ]
    },
    {
      plan: "PLATINUM",
      price: "12.00",
      currency: "€",
      frecuency: "/MONTH",
      features: [
        { feature: "Number of Pets", value: 12 },
        { feature: "Visits per Month and Pet", value: 6 },
        { feature: "Support Priority", value: "High" },
        { feature: "Include SLA", value: "Yes" },
        { feature: "Adoptions Service", value: "✅" },
        { feature: "Vet Selection for Visits", value: "✅" },
        { feature: "Calendar with Upcoming Visits", value: "✅" },
        { feature: "Pet Hotel Room Creation", value: "✅" },
        { feature: "Booking Creation", value: "✅" },
        { feature: "Dashboard of Your Pets", value: "✅" },
        { feature: "Online Consultation", value: "✅" }
      ]
    }
  ];


  return (
      <div className="section-pricing">
        <div className="pricing-container">
          <div className="pricing-table th">
            <h1>Pricing Plans</h1>
            <table className="pricing-table"> {/* Added className */}
              <thead>
                <tr>
                  <th className="pricing-table-feature">Feature</th>
                    <th className="pricing-table-free">
                      {planList[0].plan}
                      <br />
                      {planList[0].price}{planList[0].currency}{planList[0].frecuency}
                      </th>
                      <th className="pricing-table-gold">
                      {planList[1].plan}
                      <br />
                      {planList[1].price}{planList[1].currency}{planList[1].frecuency}
                      </th>
                      <th className="pricing-table-platinum">
                      {planList[2].plan}
                      <br />
                      {planList[2].price}{planList[2].currency}{planList[2].frecuency}
                      </th>
                </tr>
              </thead>
              <tbody>
                {planList[0].features.map((feature, index) => (
                  <tr key={index}>
                    <td>{feature.feature}</td>
                    {planList.map((plan, idx) => (
                      <td key={idx}>{plan.features[index].value}</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
  );
}
