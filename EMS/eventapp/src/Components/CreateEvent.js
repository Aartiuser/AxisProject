import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import React, {useContext, useState} from "react";
import UserService from "../Services/UserService";
import fan from "../img/fan.jpg";

function CreateEvent(props){
    const [formData, setFormData] = useState({
        name: '',
        sdate: '',
        edate: '',
        location: '',
        description: '',
    });
    const [showForm, setShowForm] = useState(true);
    const today = new Date().toISOString().substr(0, 10);

    const Create = (e) => {
        e.preventDefault();
        const eventData = {
            name: formData.name,
            sdate: formData.sdate,
            edate: formData.edate,
            location: formData.location,
            description:formData.description
        };
        UserService.addEvent(eventData,props.email);
        setShowForm(false);
        window.location.replace('/UserHome');
    }

    return(
            <div style={{ backgroundImage: `url(${fan})`, backgroundRepeat: 'no-repeat', backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '80vh' }}>
                <div>
                    {showForm &&(
                        <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                            <div className='mask gradient-custom-3'></div>
                            <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                                <MDBCardBody className='px-5'>
                                    <h2 className="text-uppercase text-center mb-5">Create a New Event</h2>
                                    <MDBInput wrapperClass='mb-1' label='Name of Event' size='lg' id='name' type='text' value={formData.name}
                                              onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                                    />
                                    <MDBInput wrapperClass='mb-1' label='Start date' size='lg' id='sdate' type='date' min={today} value={formData.sdate}
                                              onChange={(e) => setFormData({ ...formData, sdate: e.target.value })}
                                    />
                                    <MDBInput wrapperClass='mb-1' label='End date' size='lg' id='edate' type='date' min={formData.sdate} value={formData.edate}
                                              onChange={(e) => setFormData({ ...formData, edate: e.target.value })}
                                    />
                                    <MDBInput wrapperClass='mb-1' label='Location' size='lg' id='location' type='text'value={formData.location}
                                              onChange={(e) => setFormData({ ...formData, location: e.target.value })}
                                    />
                                    <div className="form-outline mb-4">
                                        <textarea className="form-control" id="description" rows="3" value={formData.description}
                                                  onChange={(e) => setFormData({ ...formData, description: e.target.value })}
                                        ></textarea>
                                        <label className="form-label" htmlFor="description">Event Description</label>
                                    </div>
                                    <button onClick={Create} className='mb-4 w-100 btn btn-dark'>Create Event</button>
                                </MDBCardBody>
                            </MDBCard>
                        </MDBContainer>
                    )}
                </div>

            </div>
    )
}
export default CreateEvent;
