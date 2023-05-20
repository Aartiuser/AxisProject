import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import red from '../img/red.avif';
import leaf from '../img/leaf.avif';
import blue from '../img/blue.avif';
import Home3 from '../img/Home3.avif';
import aarti from '../img/Aarti.jpg';
import '../App.css';

class Crousel extends Component {
    render() {
        return (
            <div className="container">
                <div className="content">
                    <h1>Welcome to Aarti Event Management System</h1>
                    <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                </div>

                <div className="carousel-container">
                    <Carousel style={{ fontFamily: 'Montserrat' }}>
                        <Carousel.Item>
                            <img className="d-block w-100" src={red} alt="First slide" height="500px" width="200px" />
                            <Carousel.Caption>
                                <h1>Welcome to Aarti Event Management System</h1>
                                <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item>
                            <img className="d-block w-100" src={leaf} alt="Second slide" height="500px" width="200px" />
                            <Carousel.Caption>
                                <h1>Welcome to Aarti Event Management System</h1>
                                <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item>
                            <img className="d-block w-100" src={blue} alt="Third slide" height="500px" width="200px" />
                            <Carousel.Caption>
                                <h1>Welcome to Aarti Event Management System</h1>
                                <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item>
                            <img className="d-block w-100" src={Home3} alt="Fourth slide" height="500px" width="200px" />
                            <Carousel.Caption>
                                <h1>Welcome to Aarti Event Management System</h1>
                                <p style={{ fontSize: '25px' }}>Exclusive Events, Priceless Memories</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                    </Carousel>
                </div>

                <div className="footer">
                    <div style={{ width: '200px', height: '200px', borderRadius: '50%', overflow: 'hidden' }}>
                        <img src={aarti} alt="Owner of Event Management site" style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
                    </div>
                    <h5 style={{ color: 'black', fontSize: '25px' }}>~Developer</h5>
                </div>
            </div>
        );
    }
}

export default Crousel;
