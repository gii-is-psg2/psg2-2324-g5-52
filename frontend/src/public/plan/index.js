import React from "react";
import "../../static/css/pricing/pricingPage.css";

export default function PlanList() {

  const planList = [
    {
      plan: "BASIC",
      features: [
        { feature: "Price", value: "0.00€/MONTH" },
        { feature: "Number of Pets", value: 2 },
        { feature: "Visits per Month and Pet", value: 1 },
        { feature: "Support Priority", value: "Low" },
        { feature: "Include SLA", value: "No" },
        { feature: "Adoptions Service", value: "❌" },
        { feature: "Vet Selection for Visits", value: "❌" },
        { feature: "Calendar with Upcoming Visits", value: "❌" },
        { feature: "Pet Hotel Room Service", value: "❌" },
        { feature: "Booking Service", value: "❌" },
        { feature: "Online Consultation", value: "❌" }
      ]
    },
    {
      plan: "GOLD",
      features: [
        { feature: "Price", value: "5.00€/MONTH" },
        { feature: "Number of Pets", value: 5 },
        { feature: "Visits per Month and Pet", value: 3 },
        { feature: "Support Priority", value: "Medium" },
        { feature: "Include SLA", value: "Yes" },
        { feature: "Adoptions Service", value: "✅" },
        { feature: "Vet Selection for Visits", value: "✅" },
        { feature: "Calendar with Upcoming Visits", value: "✅" },
        { feature: "Pet Hotel Room Service", value: "❌" },
        { feature: "Booking Service", value: "❌" },
        { feature: "Online Consultation", value: "❌" }
      ]
    },
    {
      plan: "PLATINUM",
      features: [
        { feature: "Price", value: "12.00€/MONTH" },
        { feature: "Number of Pets", value: 12 },
        { feature: "Visits per Month and Pet", value: 6 },
        { feature: "Support Priority", value: "High" },
        { feature: "Include SLA", value: "Yes" },
        { feature: "Adoptions Service", value: "✅" },
        { feature: "Vet Selection for Visits", value: "✅" },
        { feature: "Calendar with Upcoming Visits", value: "✅" },
        { feature: "Pet Hotel Room Service", value: "✅" },
        { feature: "Booking Service", value: "✅" },
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
                      </th>
                      <th className="pricing-table-gold">
                      {planList[1].plan}
                      </th>
                      <th className="pricing-table-platinum">
                      {planList[2].plan}
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
