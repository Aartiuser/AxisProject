import React, { useState } from 'react';
import validator from 'validator';
import zxcvbn from 'zxcvbn';
import Home from "./Home";
import {MDBCard, MDBCardBody, MDBContainer, MDBInput, MDBRadio} from "mdb-react-ui-kit";
import UserService from "../Services/UserService";
import {useHistory} from "react-router-dom";

function Signup() {
    const [showForm, setShowForm] = useState(true);
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        phone: '',
        password: '',
        confirmPassword: '',
        role:''
    });

    const [errors, setErrors] = useState({});


    async function handleRegister(e) {
        e.preventDefault();

        const newErrors = {};

        // Validate name
        if (!formData.name) {
            newErrors.name = 'Name is required';
        }

        // Validate email
        if (!formData.email) {
            newErrors.email = 'Email is required';
        } else if (!validator.isEmail(formData.email)) {
            newErrors.email = 'Invalid email format';
        }

        // Validate phone
        if (!formData.phone) {
            newErrors.phone = 'Phone number is required';
        } else if (!validator.isMobilePhone(formData.phone)) {
            newErrors.phone = 'Invalid phone number';
        }

        // Validate password strength
        const passwordStrength = zxcvbn(formData.password).score;
        if (passwordStrength < 3) {
            newErrors.password = 'Password is too weak';
        }

        // Validate password and confirm password match
        if (formData.password !== formData.confirmPassword) {
            newErrors.confirmPassword = 'Passwords do not match';
        }
        if(!formData.role){
            newErrors.name = 'Role is required';
        }

        setErrors(newErrors);

        // Submit the form if there are no errors
        if (Object.keys(errors).length === 0) {
                const userData = {
                    name: formData.name,
                    email: formData.email,
                    phone: formData.phone,
                    password: formData.password,
                    role:formData.role
                };
             setShowForm(false);
           await UserService.addUser(userData);
            window.location.replace("/");
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
                                <h2 className="text-uppercase text-center mb-5">Register</h2>
                                <p> User Role:</p>
                                <MDBRadio label='Organiser' name='role' value='Organiser' checked={formData.role === 'Organiser'}
                                          onChange={(e) => setFormData({ ...formData, role: e.target.value })} inline/>

                                <MDBRadio label='Attendee' name='role' value='Attendee' checked={formData.role === 'Attendee'}
                                          onChange={(e) => setFormData({ ...formData, role: e.target.value })} inline/>
                                <MDBInput label='Name' size='lg' id='name' type='text' value={formData.name}
                                          onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                                          className={errors.name && 'is-invalid'}
                                />
                                {errors.name && <div className='invalid-feedback'>{errors.name}</div>}

                                <MDBInput label='Email' size='lg' id='email' type='email' value={formData.email}
                                        onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                                        className={errors.email && 'is-invalid'}
                                />
                                {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                                <MDBInput label='Phone' size='lg' id='phone' type='text' value={formData.phone}
                                          onChange={(e) => setFormData({ ...formData, phone: e.target.value })}
                                          className={errors.phone && 'is-invalid'}
                                />
                                {errors.phone && <div className='invalid-feedback'>{errors.phone}</div>}
                                <MDBInput label='Password' size='lg' id='password' type='password' value={formData.password}
                                          onChange={(e) => setFormData({ ...formData, password: e.target.value })}
                                          className={errors.password && 'is-invalid'}
                                />
                                {errors.password && <div className='invalid-feedback'>{errors.password}</div>}
                                <MDBInput label='Confirm Password' size='lg' id='confirmPassword' type='password' value={formData.confirmPassword}
                                          onChange={(e) => setFormData({ ...formData, confirmPassword: e.target.value })}
                                          className={errors.confirmPassword && 'is-invalid'}
                                />
                                {errors.confirmPassword && <div className='invalid-feedback'>{errors.password}</div>}
                                <button className='mb-4 w-100 btn btn-dark' onClick={handleRegister}>Register</button>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBContainer>
                )}
            </div>


        </div>
    );
}
export default Signup;