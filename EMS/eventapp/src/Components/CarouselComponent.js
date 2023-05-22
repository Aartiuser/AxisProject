import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import red from '../img/red.avif';
import Home2 from '../img/Home2.avif';
import blue from '../img/blue.avif';
import Home3 from '../img/Home3.avif';
import '../App.css';
import aarti from "../img/Aarti.jpg";

class CarouselComponent extends Component {
    render() {
        return (
            <div className="card-container" style={{ display: 'flex', justifyContent: 'center', width: '100%', marginBottom: '40px' }}>
                <div className="card" style={{ border: 'none', borderRadius: '0', marginBottom: '40px',width:'830px' }}>
                    <div className="card-body">
                        <Carousel style={{ fontFamily: 'Montserrat', width: '800px' }}>
                            <Carousel.Item>
                                <img className="d-block w-100" src={red} alt="First slide" height="400px" width="200px" />
                                <Carousel.Caption>
                                    <h1>Welcome to Aarti Event Management System</h1>
                                    <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                            <Carousel.Item>
                                <img className="d-block w-100" src={Home3} alt="First slide" height="400px" width="200px" />
                                <Carousel.Caption>
                                    <h1>Welcome to Aarti Event Management System</h1>
                                    <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                            <Carousel.Item>
                                <img className="d-block w-100" src={blue} alt="First slide" height="400px" width="200px" />
                                <Carousel.Caption>
                                    <h1>Welcome to Aarti Event Management System</h1>
                                    <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                        </Carousel>
                    </div>
                </div>
                <br/>
                <center style={{fontFamily:'Montserrat'}}>
                    <div style={{ width: '200px', height: '200px', borderRadius: '50%', overflow: 'hidden',marginTop:'90px',marginLeft:'30px' }}>
                        <img src={aarti} alt="Owner of Event Management site" style={{ width: '100%', height: '100%', objectFit: 'cover' }}/>
                    </div>
                    <h5 style={{color:'black',fontSize:'25px'}}><b>~Developer</b></h5>
                    <br/><br/>
                </center>
            </div>
        );
    }
}

export default CarouselComponent;
