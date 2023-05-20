import React, {useState} from 'react';
import '../App.css';
import {
    MDBContainer,
    MDBCard,
    MDBCardBody,
    MDBInput, MDBRadio
}
    from 'mdb-react-ui-kit';
import UserService from "../Services/UserService";
import Home from "./Home";


function Signin(props) {
    const [showForm, setShowForm] = useState(true);
    const [formData, setFormData] = useState({
        email:'',
        password : '',
        role:''
    });
    const handleLogin = async (event) => {
        event.preventDefault();
        const user={
            email:formData.email,
            password:formData.password,
            role:formData.role
        }
        const response = await UserService.login(user);
        if (response.data === 'success') {
            localStorage.setItem('userRole', formData.role);
            localStorage.setItem('email',formData.email);
            props.setUserRole(formData.role);
            window.location.replace('/UserHome')
            setShowForm(false);
        } else {
            alert("Wrong Credentials");
        }
    };

    return (
            <div>
                <div className="carousel-wrapper">
                    <Home/>
                </div>
                <div className='signup-overlay'>
                    {showForm &&(
                        <MDBContainer fluid className='d-flex align-items-center justify-content-center ' >

                            <MDBCard className='m-5' style={{maxWidth: '600px'}}>

                                <MDBCardBody className='px-5'>
                                    <h2 className="text-uppercase text-center mb-5">Login</h2>
                                    <p className="mb-5">Please enter your login and password!</p>

                                    <p> User Role:</p>
                                    <MDBRadio label='Organiser' name='role' value='Organiser' checked={formData.role === 'Organiser'}
                                              onChange={(e) => setFormData({ ...formData, role: e.target.value })} inline/>

                                    <MDBRadio label='Attendee' name='role' value='Attendee' checked={formData.role === 'Attendee'}
                                              onChange={(e) => setFormData({ ...formData, role: e.target.value })} inline/>

                                    <MDBInput wrapperClass='mb-2' label='Email Address' size='lg' id='email' type='email'value={formData.email}
                                              onChange={(e) => setFormData({ ...formData, email: e.target.value })}/>
                                    <MDBInput wrapperClass='mb-2' label='Password' size='lg' id='password' type='password'value={formData.password}
                                              onChange={(e) => setFormData({ ...formData, password: e.target.value })}/>

                                    <button className='mb-4 w-100 btn btn-dark' onClick={handleLogin}>Login</button>
                                    <div className={'d-flex flex-row justify-content-center mb-4'} >
                                        <p className="mb-0">Don't have an account? <a href='/register' className="fw-bold">Sign Up</a></p>

                                    </div>
                                </MDBCardBody>
                            </MDBCard>
                        </MDBContainer>
                    )}
                </div>
            </div>
    );
}

export default Signin;