import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import React, {useContext, useEffect, useState} from "react";
import UserService from "../Services/UserService";
import fan from "../img/fan.jpg";
import ticketType from "./TicketType";
import validator from "validator";
import zxcvbn from "zxcvbn";

function CreateTicket(props){
    const [formData, setFormData] = useState({
        price: '',
        sdate: '',
        edate: '',
        quantity: '',
        ticketType: '',
    });
    const [showForm, setShowForm] = useState(true);
    const today = new Date().toISOString().substr(0, 10);
    const urlParams = new URLSearchParams(window.location.search);
    const event = JSON.parse(urlParams.get('event'));
    const [Ttypes, setType] = useState([]);
    const [errors, setErrors] = useState({});

    async function Create (e) {
        e.preventDefault();
        const newErrors = {};

        // Validate price
        if (!formData.price) {
            newErrors.price = 'Price is required';
        }else if(!validator.isNumeric(formData.price)){
            newErrors.price='Invalid Price format';
        }

        // Validate quant
        if (!formData.quantity) {
            newErrors.quantity = 'Quantity is required';
        }else if(!validator.isNumeric(formData.quantity)){
            newErrors.price='Invalid Quantity format';
        }

        if (!formData.edate) {
            newErrors.edate = 'Start Date is required';
        }
        if (!formData.edate) {
            newErrors.edate = 'End Date is required';
        }
        if (!formData.ticketType) {
            newErrors.ticketType = 'Type is required';
        }

        setErrors(newErrors);
        if (Object.keys(newErrors).length === 0) {
            const ticketData = {
                price: formData.price,
                sdate: formData.sdate,
                edate: formData.edate,
                quantity: formData.quantity,
                type: formData.ticketType,
                eventid: event.id,
                email: props.email
            };
            await UserService.addTicket(ticketData);
            setShowForm(false);
            window.location.replace('/UserHome');
        }
    }
    useEffect(() => {
        const fetchTicketype = async () => {
            try {
                const response = await UserService.getTickettype();
                setType(response.data);
            } catch (error) {
                console.error('Error fetching tickets:', error);
            }
        };

        fetchTicketype();
    }, [event.id]);
    const handleTypechange=(e)=>{
        e.preventDefault();
        setFormData({ ...formData, ticketType: e.target.value })
    }

    return(
        <div style={{ backgroundImage: `url(${fan})`, backgroundRepeat: 'no-repeat', backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '80vh' }}>
            <div>
                {showForm &&(
                    <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                        <div className='mask gradient-custom-3'></div>
                        <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                            <MDBCardBody className='px-5'>
                                <h2 className="text-uppercase text-center mb-5">Create a New Ticket</h2>
                                <div className="form-outline mb-4">
                                    <label className="form-label" htmlFor="type">Type of Ticket</label>
                                    <select className="form-control" id="type" value={formData.ticketType} onChange={handleTypechange} required={true}>
                                        <option value="">Select a ticket type</option>
                                        {Ttypes.map(Ttype => (
                                            <option key={Ttype.id} value={Ttype.id}>
                                                {Ttype.type}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <MDBInput wrapperClass='mb-1' label='Start date of Availability' size='lg' id='sdate' type='date' max={event.sdate} min={today}value={formData.sdate}
                                          onChange={(e) => setFormData({ ...formData, sdate: e.target.value })}
                                          className={errors.sdate && 'is-invalid'}
                                />{errors.sdate && <div className='invalid-feedback'>{errors.sdate}</div>}
                                <MDBInput wrapperClass='mb-1' label='End date of Availability' size='lg' id='edate' type='date' min={formData.sdate} max={event.sdate} value={formData.edate}
                                          onChange={(e) => setFormData({ ...formData, edate: e.target.value })}
                                          className={errors.edate && 'is-invalid'}
                                />{errors.edate && <div className='invalid-feedback'>{errors.edate}</div>}
                                <MDBInput wrapperClass='mb-1' label='Price Per Ticket' size='lg' id='price' type='number' value={formData.price}
                                          onChange={(e) => setFormData({ ...formData, price: e.target.value })}
                                          className={errors.price && 'is-invalid'}
                                />{errors.price && <div className='invalid-feedback'>{errors.price}</div>}
                                <MDBInput wrapperClass='mb-1' label='Quantity' size='lg' id='quantity' type='number' value={formData.quantity}
                                          onChange={(e) => setFormData({ ...formData, quantity: e.target.value })}
                                          className={errors.quantity && 'is-invalid'}
                                />{errors.quantity && <div className='invalid-feedback'>{errors.quantity}</div>}
                                <button onClick={Create} className='mb-4 w-100 btn btn-dark'>Create Ticket</button>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBContainer>
                )}
            </div>

        </div>
    )
}
export default CreateTicket;
