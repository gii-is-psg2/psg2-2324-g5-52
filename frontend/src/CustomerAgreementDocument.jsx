import React from 'react';

const CustomerAgreement = () => {
    return (
        <>
            <h1>Customer Agreement</h1>

            <h2>Associated Services and Description</h2>
            <p>In addition to the main PetClinic Services, there must exist at least an additional Petclinic4ClinicOwner Service that allows their users (clinic owners) to request incident resolution, send user requests, and request for changes (RFC) estimations.</p>

            <h2>Pricing</h2>
            <p>There must exist at least three plans (Basic, Gold, and Platinum), whose conditions each group can establish at their convenience, provided that the following constraints are fulfilled:</p>
            <ul>
                <li>The Basic plan does not offer SLA.</li>
                <li>The Gold plan is the first to offer additional functionalities (such as Pet Hotel or Adoptions).</li>
                <li>The Platinum plan is the only one offering online consultations.</li>
                <li>The maximum number of pets and monthly visits supported for pet owners must differ for each plan.</li>
                <li>Service availability must be different for each plan. This information should be represented using a table or matrix, as is customary nowadays.</li>
            </ul>

            <h2>Duration and Termination</h2>
            <p>At least the contract must be valid during the whole academic course. The agreement must specify the termination conditions.</p>

            <h2>Service Level Agreement (SLA)</h2>
            <ul>
                <li>The SLA can vary for each service, service subcategories, and chosen plan.</li>
                <li>Additionally, the document must consider the following requirements:</li>
                <ul>
                    <li>In addition to Time to Own (TTO) and Time to Resolve (TTR) metrics, at least an additional metric that is sound and is not available in iTop.</li>
                    <li>Description of the monitoring mechanism.</li>
                    <li>User support periods. For example, from Monday to Saturday from 9:00 to 22:00, 12x5, 24x7, etc.</li>
                    <li>At least one SLA with three different levels of priority (urgency and impact).</li>
                    <li>Compensations (service credits) in case of non-compliance.</li>
                </ul>
            </ul>

            <h2>Other General Terms</h2>
            <p>Usual terms should be included to cover other aspects, such as acceptable use, privacy policy, payment terms, intellectual property, change policy, governing law, etc.</p>
        </>
    );
};

export default CustomerAgreement;
