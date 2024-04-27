import React from 'react';

const CustomerAgreement = () => {
    return (
        <>
            <h1>Customer Agreement</h1>

            <p>Welcome to [Service Name]! By using [Service Name] ("Service"), you agree to be bound by the following terms and conditions ("Agreement"). Please read them carefully.</p>

            <ol>
                <li>
                    <strong>Acceptance of Terms</strong>
                    <p>This Agreement outlines the terms under which the Service is provided to you ("Customer"). By accessing or using the Service, you agree to comply with and be bound by this Agreement. If you do not agree to these terms, please do not use the Service.</p>
                </li>
                <li>
                    <strong>Description of Service</strong>
                    <p>[Service Name] provides [brief description of the service and its features]. The Service may be updated, expanded, or limited from time to time at our discretion.</p>
                </li>
                <li>
                    <strong>Associated services and description</strong>
                    <p></p>
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
                    <p>Your privacy is important to us. Our Privacy Policy, [link to Privacy Policy], explains how we collect, use, and protect your personal information.</p>
                </li>
                <li>
                    <strong>Pricing</strong>
                    <p></p>
                </li>
                <li>
                    <strong>Payment</strong>
                    <p>If the Service requires payment, you agree to pay all applicable fees as described on the Service website or within the Service. All fees are non-refundable, except as expressly provided in this Agreement.</p>
                </li>
                <li>
                    <strong>Intellectual Property</strong>
                    <p>All content and materials provided on the Service are the intellectual property of [Service Name] or its licensors and are protected by copyright and other intellectual property laws.</p>
                </li>
                <li>
                    <strong>Duration and termination</strong>
                    <p>duration</p>
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
                            <strong>Incident reporting procedure</strong>
                            <p>Incidents can be reported through the iTop platform. The client will create a report on the platform which will be responded to by a member of the team to confirm receipt and, if necessary, to request further information. In addition, at this point in the process a priority will be assigned and the resolution procedure will begin.
                            </p>                    
                        </li>
                        <li>
                            <strong>Resolution procedure</strong>
                            <p><strong>Diagnosis</strong>: The technical support team will diagnose the problem within the established response time.
                            </p>
                            <p><strong>Resolution</strong>: The problem will be resolved within the agreed resolution time according to the priority of the incident.
                            </p>
                            <p><strong>Communication</strong>: The customer will be informed about the status of their incident and the resolution provided.
                            </p>
                        </li>
                        <li>
                            <strong>Incident response time</strong>
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
                                        <th scope="row">Response Time</th>
                                        <td>12 hour</td>
                                        <td>24 hour</td>
                                        <td>48 hour</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Resolution Time</th>
                                        <td>48 hour</td>
                                        <td>72 hour</td>
                                        <td>96 hour</td>
                                    </tr>
                                </tbody>
                            </table>
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
                                        <th scope="row">Response Time</th>
                                        <td>10 hour</td>
                                        <td>16 hour</td>
                                        <td>24 hour</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Resolution Time</th>
                                        <td>24 hour</td>
                                        <td>48 hour</td>
                                        <td>72 hour</td>
                                    </tr>
                                </tbody>
                            </table>
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
                            <strong>Review and update of the SLA</strong>
                            <p>This SLA will be reviewed and updated annually or as needed to reflect changes in the services provided.
                            </p>
                        </li>
                    </ol>
                </li>
                <li>
                    <strong>Limitation of Liability</strong>
                    <p>[Service Name] shall not be liable for any indirect, incidental, special, consequential, or punitive damages resulting from your use of or inability to use the Service.</p>
                </li>
                <li>
                    <strong>Changes to Agreement</strong>
                    <p>We reserve the right to modify this Agreement at any time. Your continued use of the Service after any such changes constitutes your acceptance of the new terms.</p>
                </li>
                <li>
                    <strong>Governing Law</strong>
                    <p>This Agreement shall be governed by the laws of [Jurisdiction], without regard to its conflict of law provisions.</p>
                </li>
                <li>
                    <strong>Contact Information</strong>
                    <p>If you have any questions about this Agreement, please contact us at [Contact Information].</p>
                </li>
            </ol>

            <p>By using [Service Name], you acknowledge that you have read, understood, and agree to be bound by this Agreement.</p>

            
        </>
    );
};

export default CustomerAgreement;
