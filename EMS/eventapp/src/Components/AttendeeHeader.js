import React, {Component} from 'react';

class AttendeeHeader extends Component {
    constructor(props) {
        super(props);
        this.handleLogout = this.handleLogout.bind(this);
    }
    handleLogout(){
        localStorage.setItem('userRole', '');
        window.location.replace("/");
    }
    render() {
        return (
            <div style={{fontFamily:'Montserrat', fontSize:'20px'}}>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div className="container-fluid">
                        <span className="navbar-brand">Aarti Event Management</span>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                    <a className="nav-link active" aria-current="page" href="/UserHome">Home</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link active" href="/OrderHistory">Order History</a>
                                </li>
                                <li className="nav-item dropdown">
                                    <span className="nav-link dropdown-toggle active" id="navbarDropdown" role="button"
                                          data-bs-toggle="dropdown" aria-expanded="false">
                                        Search Events
                                    </span>
                                    <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a className="dropdown-item" href="/date">By Date</a></li>
                                        <li><a className="dropdown-item" href="/location">By location</a></li>
                                        <li><a className="dropdown-item" href="/type">By Event Type</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <span className="navbar-brand"> Welcome {this.props.userRole}</span>
                            <button className="btn btn-outline-info" onClick={this.handleLogout}>LOGOUT</button>

                        </div>
                    </div>
                </nav>
            </div>
        );
    }
}

export default AttendeeHeader;