import React, {Component} from 'react';
import star from "../img/star.avif";
import UserService from "../Services/UserService";
import "../App.css";
class ViewTicket extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tickets: []
        }
    }

    componentDidMount() {
        UserService.getTicketByuid(this.props.email).then((res) => {
            const sortedTickets = res.data.sort((a, b) => {
                const titleA = a.events.name.toLowerCase();
                const titleB = b.events.name.toLowerCase();
                if (titleA < titleB) return -1;
                if (titleA > titleB) return 1;
                return 0;
            });
            this.setState({
                tickets: sortedTickets
            });
        });
    }


    render() {
        return (
            <div>
                <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover',
                    backgroundPosition: 'center' ,fontFamily:'Montserrat', minHeight: '90vh'}}>
                    <div className="container custom-container" >
                        <center>
                            <h1 style={{ fontSize: '50px' }}>Your Tickets</h1>
                            <div className="row">
                                <table className='table table-striped table-bordered' style={{width: '100%', background: 'whitesmoke',fontFamily:'Montserrat' }} >
                                    <thead className='table-dark'>
                                    <tr>
                                        <th style={{fontSize:'20px'}}><b>Event Title</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event Location</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket Type</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket Start Date</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket End Date</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket Price</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket Quantity</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {this.state.tickets.map(
                                        ticket =>
                                            <tr key={ticket.id} >
                                                <td style={{fontSize:'20px'}}>{ticket.events.name}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.events.location}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.ticketType.type}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.startDate}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.endDate}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.price}</td>
                                                <td style={{fontSize:'20px'}}>{ticket.quantity}</td>
                                            </tr>
                                    )}
                                    </tbody>
                                </table>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
        );
    }
}

export default ViewTicket;