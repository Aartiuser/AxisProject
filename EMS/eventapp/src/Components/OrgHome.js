import UserService from "../Services/UserService";
import React, { Component } from 'react';
import { withRouter } from "react-router-dom";
import fan from "../img/fan.jpg";
import "../App.css";

class OrgHome extends Component {
    constructor(props) {
        super(props);
        this.state = {
            events: []
        }
        this.delete = this.delete.bind(this);
        this.create_ticket = this.create_ticket.bind(this);
        this.edit = this.edit.bind(this);
    }

    componentDidMount() {
        UserService.getEventByRole(this.props.email).then((res) => {
            this.setState({
                events: res.data
            });
        });
    }

    delete(event) {
        UserService.delEvent(event).then(res => {
            this.setState({ events: this.state.events.filter(Event => Event !== event) });
            window.location.replace('/UserHome')
        });
    }

    edit(event) {
        const queryParams = new URLSearchParams({ event: JSON.stringify(event) });
        window.location.replace(`/update?${queryParams.toString()}`);
    }

    create_ticket(event) {
        const queryParams = new URLSearchParams({ event: JSON.stringify(event) });
        window.location.replace(`/Createticket?${queryParams.toString()}`);
    }

    render() {
        return (
            <div div style={{ backgroundImage: `url(${fan})`, backgroundRepeat: 'no-repeat', backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '90vh' ,display: 'flex'}}>
                <div className="container" style={{fontFamily:'Montserrat'}}>
                    <center>
                        <h1 style={{ fontSize: '50px'}}>Events</h1>
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
                                                <button onClick={() => this.create_ticket(event)} className="btn btn-info" style={{fontFamily:'Montserrat',marginLeft: "10px", marginTop:"10px"}}>CREATE TICKET</button>
                                                <button style={{ marginLeft: "10px", marginTop:"10px",fontFamily:'Montserrat'}} onClick={() => this.edit(event)} className="btn btn-success">UPDATE EVENT</button>
                                                <button style={{ marginLeft: "10px" , marginTop:"10px",fontFamily:'Montserrat'}} onClick={() => this.delete(event)} className="btn btn-danger">DELETE</button>
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
        );
    }
}

export default withRouter(OrgHome);
