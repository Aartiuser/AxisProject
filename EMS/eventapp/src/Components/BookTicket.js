import React, {useEffect, useState} from "react";
import UserService from "../Services/UserService";
import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import {MDBModal, MDBModalBody, MDBModalFooter, MDBModalHeader} from "mdbreact";
import validator from "validator";
import star from "../img/star.avif";
import * as emailjs from "@emailjs/browser";

function BookTicket(props){

    const [formData, setFormData] = useState({
        quantity: '',
        cardno:'',
    });

    const [showForm, setShowForm] = useState(true);
    const [tickets, setTicket] = useState([]);
    const [type, setype] = useState([]);
    const [ticket, seticket] = useState([]);
    const [selectedTicketType, setSelectedTicketType] = useState('');
    const [ticketPrice, setTicketPrice] = useState(null);
    const [ticketQuantity, setTicketQuantity] = useState(null);
    const [showPaymentModal, setShowPaymentModal] = useState(false);
    const [showSuccessModal, setShowSuccessModal] = useState(false);
    const [orderData, setOrderData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [errors, setErrors] = useState({});

    const urlParams = new URLSearchParams(window.location.search);
    const event = JSON.parse(urlParams.get('event'));
    const Book = async (e) => {
        e.preventDefault();
        //Validations

        const newErrors = {};
        if (!formData.quantity) {
            newErrors.quantity = 'Quantity is required';
        }else if(!validator.isNumeric(formData.quantity)){
            newErrors.quantity='Invalid Quantity format';
        }
        setErrors(newErrors);

        if (Object.keys(newErrors).length === 0) {
            const currentDate = new Date();
            const totalPrice = ticketPrice * formData.quantity;
            const order = {
                quantity: formData.quantity,
                price: totalPrice,
                event: event,
                email: props.email,
                ticket: ticket,
                orderdate: currentDate.toISOString()
            }
            setOrderData(order);
            setShowPaymentModal(true);
            setShowForm(false);
        }
    }
    const handleTypechange=(e)=>{
        e.preventDefault();
        setSelectedTicketType(e.target.value)
    }

    const handlePayment = async () => {
        const newErrors = {};

        if (!formData.cardno) {
            newErrors.cardno = 'Card Number is required';
        }else if(!validator.isNumeric(formData.cardno)){
            newErrors.cardno='Invalid Card format';
        }

        setErrors(newErrors);
        if(Object.keys(newErrors).length === 0) {

            try {
                setLoading(true);

                const response = await UserService.addOrder(orderData);
                console.log('Order placed:', response.data);
                setLoading(false);
                setShowPaymentModal(false);
                setShowSuccessModal(true);
            } catch (error) {
                console.error('Error placing order:', error);
                setLoading(false);
                // Handle the error and show an error message to the user
            }
            const templateParams = {
                ToEmail: props.email, // Set the recipient email address
                quantity: formData.quantity,
                ticketType: type.type,
                event: event.name
            };

            emailjs.send('default_service', 'template_k8mqwaj', templateParams, 'LHhJbnhY6oswXnMOX')
                .then((response) => {
                    console.log('Email sent!', response.status, response.text);
                })
                .catch((error) => {
                    console.error('Error sending email:', error);
                });
        }
    };

    const handleSuccessModalClose = () => {
        setShowSuccessModal(false);
        //UserService.updateTicket(upticket)
       window.location.replace("/OrderHistory")
    };
    const cancelPayment=()=>{
        setShowPaymentModal(false);
        window.location.replace("/UserHome")
    }
    useEffect(() => {
        const fetchTickets = async () => {
            try {
                const response = await UserService.getTicketsbyid(event.id);
                setTicket(response.data);
            } catch (error) {
                console.error('Error fetching tickets:', error);
            }
        };

        fetchTickets();
    }, [event.id]);

    useEffect(() => {
        if (selectedTicketType) {
            const fetchTicketPrice = async () => {
                try {
                    const response = await UserService.getTicketByTypeEId(selectedTicketType,event.id);
                    setTicketPrice(response.data.price);
                    setTicketQuantity(response.data.quantity);
                } catch (error) {
                    console.error("Error fetching ticket price:", error);
                    setTicketPrice(null);
                }
            };

            fetchTicketPrice();
        }
    }, [selectedTicketType]);
    useEffect(() => {
        if (selectedTicketType) {
            const gettype = async () => {
                try {
                    const response = await UserService.getTicketType(selectedTicketType);
                    setype(response.data);
                } catch (error) {
                    console.error("Error fetching ticket:", error);
                    setTicketPrice(null);
                }
            };

            gettype();
        }
    }, [selectedTicketType]);
    useEffect(() => {
        if (selectedTicketType) {
            const getticket = async () => {
                try {
                    const response = await UserService.getTicketByTypeEId(selectedTicketType,event.id);
                    seticket(response.data);
                } catch (error) {
                    console.error("Error fetching ticket:", error);
                    setTicketPrice(null);
                }
            };

            getticket();
        }
    }, [selectedTicketType]);
    return (
        <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat',
            backgroundSize: 'cover',
            backgroundPosition: 'center' ,fontFamily:'Montserrat', minHeight: '90vh'}}>
            <div >
                {showForm &&(
                    <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                        <div className='mask gradient-custom-3'></div>
                        <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                            <MDBCardBody className='px-5'>
                                <h2 className="text-uppercase text-center mb-5">Book Ticket</h2>
                                <div className="form-outline mb-4">
                                    <label className="form-label" htmlFor="type">Type of Ticket</label>
                                    <select className="form-control" id="type" value={selectedTicketType} onChange={handleTypechange} required={true}>
                                        <option value="">Select a ticket type</option>
                                        {tickets.map(ticket => (
                                            <option key={ticket.ticketType.id} value={ticket.ticketType.id}>
                                                {ticket.ticketType.type}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <p>Quantity available: {ticketQuantity !== null ? `${ticketQuantity}` : "Loading..."}</p>
                                <MDBInput wrapperClass='mb-1' label='Quantity' size='lg' id='quantity' type='number'value={formData.quantity} min={ticketQuantity}
                                          onChange={(e) => setFormData({ ...formData, quantity: e.target.value })}
                                          className={errors.quantity && 'is-invalid'}
                                />{errors.quantity && <div className='text-danger'>{errors.quantity}</div>}
                                <p>Price per ticket: {ticketPrice !== null ? "₹"+`${ticketPrice}` : "Loading..."}</p>
                                <button onClick={Book} className='mb-4 w-100 btn btn-dark'>Book</button>

                            </MDBCardBody>
                        </MDBCard>
                    </MDBContainer>
                )}
            </div>
            <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat',
                backgroundSize: 'cover',
                backgroundPosition: 'center' ,fontFamily:'Montserrat', minHeight: '90vh'}}>
                <MDBModal isOpen={showPaymentModal} toggle={() => setShowPaymentModal(false)}>
                    <MDBModalHeader toggle={() => setShowPaymentModal(false)}>Confirm Payment</MDBModalHeader>
                    <MDBModalBody>
                        <p>Total Price: ₹{ticketPrice * formData.quantity}</p>
                        <p>Quantity: {formData.quantity}</p>
                        <p>Ticket Type: {type.type}</p>
                        <MDBInput wrapperClass='mb-1' label='Debit Card Number' size='lg' id='cardno' type='number' value={formData.cardno}
                                  onChange={(e) => setFormData({ ...formData, cardno: e.target.value })}
                                  className={errors.cardno && 'is-invalid'}
                        />{errors.cardno && <div className='invalid-feedback'>{errors.cardno}</div>}
                    </MDBModalBody>
                    <MDBModalFooter>
                        <button className='btn btn-secondary' onClick={cancelPayment}>
                            Cancel
                        </button>
                        <button className='btn btn-primary' onClick={handlePayment} disabled={loading}>
                            {loading ? 'Processing...' : 'Pay'}
                        </button>
                    </MDBModalFooter>
                </MDBModal>

                <MDBModal isOpen={showSuccessModal} toggle={handleSuccessModalClose}>
                    <MDBModalHeader toggle={handleSuccessModalClose}>Payment Successful</MDBModalHeader>
                    <MDBModalBody>
                        <p>Total Price: {ticketPrice  * formData.quantity}</p>
                        <p>Quantity: {formData.quantity}</p>
                        <p>Ticket Type: {type.type}</p>
                    </MDBModalBody>
                    <MDBModalFooter>
                        <button className='btn btn-primary' onClick={handleSuccessModalClose}>
                            OK
                        </button>
                    </MDBModalFooter>
                </MDBModal>
            </div>

        </div>
    );
}
export default BookTicket;
