import React, {Component} from 'react';

class Footer extends Component {
    render() {
        return (
            <div  style={{ position: 'fixed', bottom: 0, left: 0, right: 0, height: '40px', background: 'black', color:'white',fontSize:'20px',fontFamily:'Montserrat'}}>
                <center>
                    <footer className = "footer">
                        <span>Made with <span role="img" aria-label="Heart">❤️</span> by P Aarti</span><span role="img" aria-label="Wink">😉</span>
                    </footer>
                </center>
            </div>
        );
    }
}

export default Footer;