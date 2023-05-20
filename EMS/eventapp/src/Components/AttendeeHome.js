import React, {Component} from 'react';
import star from "../img/star.avif";
import UserService from "../Services/UserService";
import "../App.css";
import Crousel from "./Crousel";
class AttendeeHome extends Component {
    constructor(props) {
        super(props);
        this.state = {
            events: []
        }
        this.Book = this.Book.bind(this);
    }

    componentDidMount() {
        UserService.getEvents().then((res) => {
            this.setState({
                events: res.data
            });
        });
    }

    Book(event) {
        const queryParams = new URLSearchParams({ event: JSON.stringify(event) });
        window.location.replace(`/BookTicket?${queryParams.toString()}`);
    }
    render() {
        return (
            <div>
                <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover',
                    backgroundPosition: 'center' ,fontFamily:'Montserrat', minHeight: '100vh'}}>
                    <div className="container custom-container" >
                        <center>
                            <h1 style={{ fontSize: '50px' }}>Events</h1>
                            <div className="row">
                                <table className='table table-striped table-bordered' style={{width: '100%', background: 'whitesmoke' }} >
                                    <thead className='table-dark'>
                                    <tr>
                                        <th style={{fontSize:'20px'}}><b>Event Title</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event Location</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event Start Date</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event End Date</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event Description</b></th>
                                        <th style={{fontSize:'20px'}}><b>Actions</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {this.state.events.map(
                                        event =>
                                            <tr key={event.id} >
                                                <td style={{fontSize:'20px'}}>{event.name}</td>
                                                <td style={{fontSize:'20px'}}>{event.location}</td>
                                                <td style={{fontSize:'20px'}}>{event.sdate}</td>
                                                <td style={{fontSize:'20px'}}>{event.edate}</td>
                                                <td style={{fontSize:'20px'}}>{event.description}</td>
                                                <td>
                                                    <div className="button-container">
                                                        <button onClick={() => this.Book(event)} className="btn btn-info" style={{ fontFamily: 'Montserrat', marginLeft: "10px", marginTop: "10px", whiteSpace: "nowrap" }}>BOOK TICKET</button>
                                                    </div>
                                                </td>
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

export default AttendeeHome;