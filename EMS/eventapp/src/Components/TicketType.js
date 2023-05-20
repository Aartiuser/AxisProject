import {MDBCard, MDBCardBody, MDBContainer, MDBInput} from "mdb-react-ui-kit";
import React, {useContext, useState} from "react";
import UserService from "../Services/UserService";
import fan from "../img/fan.jpg";

function TicketType(props){
    const [formData, setFormData] = useState({
        type: '',
        description: '',
    });
    const [showForm, setShowForm] = useState(true);

     async function Create (e){
        e.preventDefault();
        const typeData = {
            type: formData.type,
            description:formData.description
        };

      await UserService.addTicketType(typeData);
        setShowForm(false);
        window.location.replace('/UserHome');
    }

    return(
        <div style={{ backgroundImage: `url(${fan})`, backgroundRepeat: 'no-repeat', backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '80vh',fontFamily:'Montserrat' }}>
            <div>
                {showForm &&(
                    <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >
                        <div className='mask gradient-custom-3'></div>
                        <MDBCard className='m-5' style={{maxWidth: '600px'}}>
                            <MDBCardBody className='px-5'>
                                <h2 className="text-uppercase text-center mb-5">Create a New Ticket Type</h2>
                                <MDBInput wrapperClass='mb-1' label='Type of Ticket' size='lg' id='type' type='text' value={formData.type}
                                          onChange={(e) => setFormData({ ...formData, type: e.target.value })}
                                />
                                <div className="form-outline mb-4">
                                        <textarea className="form-control" id="description" rows="3" value={formData.description}
                                                  onChange={(e) => setFormData({ ...formData, description: e.target.value })}
                                        ></textarea>
                                    <label className="form-label" htmlFor="description">Event Description</label>
                                </div>
                                <button onClick={Create} className='mb-4 w-100 btn btn-dark'>Create Ticket Type</button>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBContainer>
                )}
            </div>

        </div>
    )
}
export default TicketType;
