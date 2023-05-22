import React, {Component, useState} from 'react';
import star from "../../img/star.avif";
import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import UserService from "../../Services/UserService";
import CarouselComponent from "../CarouselComponent";
import Home from "../Home";

function EventDate(){
    const[sdate,setDate]=useState('');
    const [showForm, setShowForm] = useState(true);
    const [showTable, setShowTable] = useState(false);
    //const today = new Date().toISOString().substr(0, 10);
    const[events,setevent]=useState([]);
    const Search = async (e) => {
        e.preventDefault();
            try {
                const response = await UserService.getEventBydate(sdate);
                setevent(response.data);
                console.log(events);

            } catch (error) {
                console.error("Error fetching Events:", error);
            }
            setShowForm(false);
            setShowTable(true);
        };
    const Close=()=>{
        setShowTable(false);
        window.location.replace("/UserHome");
    }
    const Book=(event)=>{
        const queryParams = new URLSearchParams({ event: JSON.stringify(event) });
        window.location.replace(`/BookTicket?${queryParams.toString()}`);

    }

        return (
            <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat', backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '90vh',fontFamily:'Montserrat' }}>
                <div>
                    {showForm &&(
                        <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                            <div className='mask gradient-custom-3'></div>
                            <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                                <MDBCardBody className='px-5'>
                                    <h2 className="text-uppercase text-center mb-5">Date</h2>

                                    <MDBInput wrapperClass='mb-1' label='Start date' size='lg' id='sdate' type='date'  value={sdate}
                                              onChange={(e) => setDate(e.target.value )}
                                    />
                                    <button onClick={Search} className='mb-4 w-100 btn btn-dark'>Search Event</button>
                                </MDBCardBody>
                            </MDBCard>
                        </MDBContainer>
                    )}
                </div>
                {showTable&&(
                    <div className="container custom-container" >
                        <center>
                            <h1 style={{ fontSize: '50px' ,fontFamily:'Montserrat'}}>Events Scheduled On {sdate}</h1>
                            <div className="row">
                                <table className='table table-striped table-bordered' style={{width: '100%', background: 'whitesmoke',fontFamily:'Montserrat' }} >
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
                                    {events.map( event =>(
                                            <tr key={event.id} >
                                                <td style={{fontSize:'20px'}}>{event.name}</td>
                                                <td style={{fontSize:'20px'}}>{event.location}</td>
                                                <td style={{fontSize:'20px'}}>{event.sdate}</td>
                                                <td style={{fontSize:'20px'}}>{event.edate}</td>
                                                <td style={{fontSize:'20px'}}>{event.description}</td>
                                                <td>
                                                    <div className="button-container">
                                                        <button onClick={() =>Book(event)} className="btn btn-info" style={{ fontFamily: 'Montserrat', marginLeft: "10px", marginTop: "10px", whiteSpace: "nowrap" }}>BOOK TICKET</button>
                                                    </div>
                                                </td>
                                            </tr>
                                    ))}
                                    </tbody>
                                </table>
                                <button style={{ marginLeft: "10px" , marginTop:"10px",fontFamily:'Montserrat'}} onClick={() => Close()} className="btn btn-danger">CLOSE</button>
                            </div>
                        </center>
                    </div>
                )}
                <br/>
<CarouselComponent/>
            </div>
        );
}

export default EventDate;