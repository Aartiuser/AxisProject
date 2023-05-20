import Home1 from '../img/Home1.avif';
import Home2 from '../img/Home2.avif';
import Home3 from '../img/Home3.avif';
import aarti from  '../img/Aarti.jpg';
import Carousel from 'react-bootstrap/Carousel';
import blue from "../img/blue.avif";
function Home(){
    return(
        <div style={{
            backgroundImage: `url(${blue})`,
            backgroundRepeat: 'no-repeat',
            backgroundSize: 'cover',
            backgroundPosition: 'center',
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            minHeight: '100vh',
        }}>
            <div style={{ marginTop: '20px'}}>
            <div className="container">
                <center>
            <Carousel style={{fontFamily:'Montserrat', width: '1000px', // Adjust the width as per your requirements
                margin: '0 auto'}} >
                <Carousel.Item>
                    <img className="d-block w-100" src={Home1} alt="First slide" height='500px' width='600px'/>
                    <Carousel.Caption>
                        <h1>Welcome to Aarti Event Management System</h1>
                        <p style={{fontSize:'25px'}}>Exclusive Events, Priceless Memories</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img className="d-block w-100" src={Home2} alt="Second slide" height='500px' width='600px'/>
                    <Carousel.Caption>
                        <h1>Welcome to Aarti Event Management System</h1>
                        <p style={{fontSize:'25px'}}>Exclusive Events, Priceless Memories</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img className="d-block w-100" src={Home3} alt="Third slide" height='500px' width='600px' />
                    <Carousel.Caption>
                        <h1>Welcome to Aarti Event Management System</h1>
                        <p style={{fontSize:'25px'}}>Exclusive Events, Priceless Memories</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
                </center>
        </div>
                <br/>
            <center style={{fontFamily:'Montserrat'}}>
                <div style={{ width: '200px', height: '200px', borderRadius: '50%', overflow: 'hidden' }}>
                    <img src={aarti} alt="Owner of Event Management site" style={{ width: '100%', height: '100%', objectFit: 'cover' }}/>
                </div>
                <h5 style={{color:'black',fontSize:'25px'}}><b>~Developer</b></h5>
                <br/><br/>
            </center>
        </div>
        </div>
            );
        }
export default Home;