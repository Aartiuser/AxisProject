import React, {useEffect, useState} from "react";
import UserService from "../Services/UserService";
import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import {MDBModal, MDBModalBody, MDBModalFooter, MDBModalHeader} from "mdbreact";

function BookTicket(props){

    const [formData, setFormData] = useState({
        quantity: ''
    });

    const [showForm, setShowForm] = useState(true);
    const [tickets, setTicket] = useState([]);
    const [ticket, seticket] = useState([]);
    const [upticket, setupticket] = useState([]);
    const [selectedTicketType, setSelectedTicketType] = useState('');
    const [ticketPrice, setTicketPrice] = useState(null);
    const [showPaymentModal, setShowPaymentModal] = useState(false);
    const [showSuccessModal, setShowSuccessModal] = useState(false);
    const [orderData, setOrderData] = useState(null);
    const [loading, setLoading] = useState(false);

    const urlParams = new URLSearchParams(window.location.search);
    const event = JSON.parse(urlParams.get('event'));
    const Book = async (e) => {
        e.preventDefault();
        console.log(selectedTicketType);
      /*  try{
            const response = await UserService.getTicketByType(selectedTicketType);
            seticket(response.data[0].id);
        } catch (error) {
            console.error('Error fetching tickets:', error);
        }*/
        const currentDate = new Date();
        const totalPrice = ticketPrice * formData.quantity;
        const order={
            quantity:formData.quantity,
            price:totalPrice,
            event:event,
            email:props.email,
            ticket:ticket,
            orderdate:currentDate.toISOString()
        }
        console.log(ticket);
        setOrderData(order);
        setShowPaymentModal(true);
        setShowForm(false);
    }
    const handleTypechange=(e)=>{
        e.preventDefault();
        setSelectedTicketType(e.target.value)
    }
    const handlePayment = async () => {
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
    };
    const handleSuccessModalClose = () => {
        setShowSuccessModal(false);
        //UserService.updateTicket(upticket)
        window.location.replace("/UserHome")
        // Perform any necessary actions after payment success
        // Update ticket table, etc.
    };
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
                    const response = await UserService.getTicketByType(selectedTicketType);
                    setTicketPrice(response.data[0].price);
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
            const getticket = async () => {
                try {
                    const response = await UserService.getTicketByType(selectedTicketType);
                    seticket(response.data[0].id);
                    setupticket(response.data[0]);
                } catch (error) {
                    console.error("Error fetching ticket price:", error);
                    setTicketPrice(null);
                }
            };

            getticket();
        }
    }, [selectedTicketType]);
    return (
        <div>
            <div>
                {showForm &&(
                    <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                        <div className='mask gradient-custom-3'></div>
                        <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                            <MDBCardBody className='px-5'>
                                <h2 className="text-uppercase text-center mb-5">Book Ticket</h2>
                                <div className="form-outline mb-4">
                                    <label className="form-label" htmlFor="type">Type of Ticket</label>
                                    <select className="form-control" id="type" value={selectedTicketType} onChange={handleTypechange}>
                                        <option value="">Select a ticket type</option>
                                        {tickets.map(ticket => (
                                            <option key={ticket.ticketType.id} value={ticket.ticketType.id}>
                                                {ticket.ticketType.type}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <MDBInput wrapperClass='mb-1' label='Quantity' size='lg' id='quantity' type='number'value={formData.quantity}
                                          onChange={(e) => setFormData({ ...formData, quantity: e.target.value })}
                                />
                                <p>Price per ticket: {ticketPrice !== null ? `${ticketPrice}` : "Loading..."}</p>
                                <button onClick={Book} className='mb-4 w-100 btn btn-dark'>Book</button>

                            </MDBCardBody>
                        </MDBCard>
                    </MDBContainer>
                )}
            </div>
            <div>
                <MDBModal isOpen={showPaymentModal} toggle={() => setShowPaymentModal(false)}>
                    <MDBModalHeader toggle={() => setShowPaymentModal(false)}>Confirm Payment</MDBModalHeader>
                    <MDBModalBody>
                        <p>Total Price: {ticketPrice * formData.quantity}</p>
                        <p>Quantity: {formData.quantity}</p>
                    </MDBModalBody>
                    <MDBModalFooter>
                        <button className='btn btn-secondary' onClick={() => setShowPaymentModal(false)}>
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
                        <p>Ticket Type: {selectedTicketType}</p>
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
