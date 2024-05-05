import React from 'react';
import pricingPlansImage from './static/images/PricingPlans.png';

const CustomerAgreement = () => {
    return (
        <>
            <h1>Customer Agreement</h1>

            <p>Welcome to Pet Clinic! By using Pet Clinic ("Service"), you agree to be bound by the following terms and conditions ("Agreement"). Please read them carefully.</p>

            <ol>
                <li>
                    <strong>Acceptance of Terms</strong>
                    <p>Customer agrees to use the software in accordance with the conditions set forth in this agreement and in accordance with applicable laws and regulations. Any use of the software for illegal or unauthorized purposes is prohibited.</p>
                </li>
                <li>
                    <strong>Description of Service</strong>
                    <p>PetClinic is a web application that offers the request and creation of appointments, or veterinary consultations, for pets as its main services.</p>
                </li>
                <li>
                    <strong>Associated services and description</strong>
                    <p>As I said before, PetClinic is a web application that offers the request and creation of appointments, or veterinary consultations, for pets as its main services.
                       For which it offers various subservices and functionalities (with limits determined by the Price Plan that the client has acquired) to different user 
                       profiles.</p>

                    <p>The user profiles included in the application are: clinic owners, veterinarians and pet owners. And there are three Price Plans (Basic, Gold and Platinum) 
                        that will be detailed in the following section of the document.</p>   

                    <p>For clinic owners, the basic service offered by the application consists of creating as many clinics and veterinarians as they have, up to a limit 
                        determined by the contracted Price Plan, and allowing their clients (pet owners) to create appointments, or veterinary consultations, in their clinics</p>    

                    <p>In turn, Veterinary profile users will have the possibility of consulting the list of appointments or consultations that pet owners have scheduled 
                        with them.</p>

                    <p>Finally, for pet owners, the application allows you to register as a clinic user, register as many pets as you own (with the limit of the Price Plan 
                        acquired by the owner of your clinic), and schedule veterinary appointments with your preferred veterinarian in that clinic, on the days and hours 
                        that said veterinarian is available.</p>

                    <p>This is the fundamental service offered by the application in its 'Basic' Plan.</p>

                    <p>The 'Gold' Price Plan, in addition to the services offered by the 'Basic' Plan, offers the clinic owner, and their clients by extension, a pet "Adoptions" service, 
                        which allows pet owners announce and publish adoption requests for your pets in the application, and the possibility of connection between owners and carrying out 
                        the management from within the application itself.</p>

                    <p>For the 'Platinum' Price Plan, in addition to the services offered by the 'Gold' Plan, the "Room Reservation" service is offered, so that the owner of the clinic can 
                        in turn offer this service to his owner pets clients, in order to be able to leave their pets for a few days, in which they cannot take care of them for some reason 
                        (travel, work, etc...), in the clinic facilities.</p>

                    <p>Finally, for both the 'Gold' and 'Platinum' Plan, in addition to the main PetClinic services, the additional Petclinic4ClinicOwner service is offered that allows 
                        clinic owners to request the resolution of incidents, submit user requests and request for changes estimations (RFC).</p>                           
                </li>
                <li>
                    <strong>Use of Service</strong>
                    <p>You agree to use the Service only for lawful purposes and in accordance with this Agreement. You are responsible for all activities conducted under your account.</p>
                </li>
                <li>
                    <strong>User Accounts</strong>
                    <p>To access certain features of the Service, you may be required to create an account. You agree to provide accurate and complete information and to keep this information up-to-date.</p>
                </li>
                <li>
                    <strong>Privacy Policy</strong>
                    <p>All data provided by the Client will be subject to our privacy policy. This policy describes how we collect, use and protect Customer information. By accepting this agreement, the Client acknowledges having read and understood our privacy policy.</p>
                </li>
                <li>
                    <strong>Pricing</strong>
                    <p>
                    <img src={pricingPlansImage} alt="Pricing plans"/>
                    </p>
                </li>
                <li>
                    <strong>Payment</strong>
                    <p>The Client agrees to comply with the agreed payment conditions for the use of the software, as established in the financial agreement between both parties. Specific details regarding fees and payment terms are specified in the applicable contract.</p>
                </li>
                <li>
                    <strong>Intellectual Property</strong>
                    <p>All intellectual property rights, including but not limited to patents, copyrights, trademarks, trade secrets, and any other proprietary rights related to the software provided by Pet Clinic, shall remain the exclusive property of Pet Clinic or its licensors.</p>
                </li>
                <li>
                    <strong>Duration and termination</strong>
                    <p>The agreement will be valid during the present academic course 2023/2024, specifically, between 09/11/2023 and 05/27/2024.</p>
                    <p>We may terminate or suspend your access to the Service immediately, without prior notice or liability, for any reason, including if you breach this Agreement.</p>
                </li>
                <li>
                    <strong>SLA</strong>
                    <ol>
                        <li>
                            <strong>Scope</strong>
                            <p>This SLA covers technical support services for all Pet Clinic features for Gold or Platinum customers.</p>
                        </li>
                        <li>
                            <strong>Service availability</strong>
                            <p>In the case of <i>Gold</i> plan customers, we can guarantee a service availability of more than 95% at all times, every day of the year.
                            </p>
                            <p>
                            In the case of <i>Platinum</i> plan customers, we can guarantee a service availability of more than 99.9% at all times, every day of the year.
                            </p>
                        </li>
                        <li>
                            <strong>User support periods</strong>
                            <p>User support periods will be available from Monaday to Sunday from 9.00 am to 6.00 pm.</p>
                        </li>
                        <li>
                            <strong>Incident reporting procedure</strong>
                            <p>Incidents can be reported through the iTop platform. The client will create a report on the platform which will be responded to by a member of the team to confirm receipt and, if necessary, to request further information.
                            </p>                    
                        </li>
                        <li>
                            <strong>Resolution procedure</strong>
                            <p><strong>Diagnosis</strong>: The technical support team will diagnose the problem within the established response time and assign a priority to the reported problem.
                            </p>
                            <p><strong>Resolution</strong>: The problem will be resolved within the agreed resolution time according to the priority of the incident.
                            </p>
                            <p><strong>Communication</strong>: The customer will be informed about the status of their incident and the resolution provided.
                            </p>
                        </li>
                        <li>
                            <strong>Incident response time</strong>
                            <p>In the case of a report of a client with the <i>Basic</i> plan:
                            </p>
                            <table className='table'>
                                <thead>
                                    <tr>
                                        <th scope="col"><i>Basic</i></th>
                                        <th scope="col">High priority</th>
                                        <th scope="col">Medium priority</th>
                                        <th scope="col">Low priority</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Response Time(TTO)</th>
                                        <td>14 hour</td>
                                        <td>32 hour</td>
                                        <td>56 hour</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Resolution Time(TTR)</th>
                                        <td>56 hour</td>
                                        <td>82 hour</td>
                                        <td>104 hour</td>
                                    </tr>
                                </tbody>
                            </table>
                            <p><i>These hours are working hours, corresponding to the working hours described in the user support.</i></p>
                            <br/>
                            <p>In the case of a report of a client with the <i>Gold</i> plan:
                            </p>
                            <table className='table'>
                                <thead>
                                    <tr>
                                        <th scope="col"><i>Gold</i></th>
                                        <th scope="col">High priority</th>
                                        <th scope="col">Medium priority</th>
                                        <th scope="col">Low priority</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Response Time(TTO)</th>
                                        <td>12 hour</td>
                                        <td>24 hour</td>
                                        <td>48 hour</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Resolution Time(TTR)</th>
                                        <td>48 hour</td>
                                        <td>72 hour</td>
                                        <td>96 hour</td>
                                    </tr>
                                </tbody>
                            </table>
                            <p><i>These hours are working hours, corresponding to the working hours described in the user support.</i></p>
                            <br/>
                            <p>In the case of a report of a client with the <i>Platinum</i> plan:
                            </p>
                            <table className='table'>
                                <thead>
                                    <tr>
                                        <th scope="col"><i>Platinum</i></th>
                                        <th scope="col">High priority</th>
                                        <th scope="col">Medium priority</th>
                                        <th scope="col">Low priority</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Response Time(TTO)</th>
                                        <td>10 hour</td>
                                        <td>16 hour</td>
                                        <td>24 hour</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Resolution Time(TTR)</th>
                                        <td>24 hour</td>
                                        <td>48 hour</td>
                                        <td>72 hour</td>
                                    </tr>
                                </tbody>
                            </table>
                            <p><i>These hours are working hours, corresponding to the working hours described in the user support.</i></p>
                        </li>
                       <li>
                            <strong>Penalties</strong>
                            <p>In case of non-compliance with the commitments established in this SLA, the following penalties will be applied:
                            </p>
                            <p>
                            <p>Failure to comply with response time: 15% discount on the next invoice.</p>
                            <p>Failure to meet resolution time: 8% discount on the next invoice.</p>
                            <p>Non-fulfillment of availability: double the value of the lost time.</p>
                            </p>
                        </li>
                        <li>
                            <strong>Monitoring mechanism</strong>
                            <p>Key performance indicators such as response time, resolution time, and customer satisfaction will be monitored regularly to assess the performance of the technical support service.</p>
                            <p>Performance metrics will be collected and analyzed using monitoring tools and performance management systems.</p>
                        </li>
                        <li>
                            <strong>Review and update of the SLA</strong>
                            <p>This SLA will be reviewed and updated annually or as needed to reflect changes in the services provided.
                            </p>
                        </li>
                    </ol>
                </li>
                <li>
                    <strong>Limitation of Liability</strong>
                    <p>Pet Clinic shall not be liable for any indirect, incidental, special, consequential, or punitive damages resulting from your use of or inability to use the Service.</p>
                </li>
                <li>
                    <strong>Changes to Agreement</strong>
                    <p>Any change or modification in the conditions of this agreement must be made in writing and accepted by both parties. We reserve the right to update or modify this agreement at any time, subject to applicable legal provisions.</p>
                </li>
                <li>
                    <strong>Governing Law</strong>
                    <p>Any disputes arising from or relating to associated services shall be governed by and construed in accordance with the laws from Spain, without regard to its conflict of law principles.</p>
                </li>
                <li>
                    <strong>Contact Information</strong>
                    <p>If you have any questions about this Agreement, please contact us at ramguerom@alum.us.es.</p>
                </li>
            </ol>

            <p>By using Pet Clinic, you acknowledge that you have read, understood, and agree to be bound by this Agreement.</p>

            
        </>
    );
};

export default CustomerAgreement;
