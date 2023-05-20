import React, {Component} from 'react';
import star from "../img/star.avif";
import UserService from "../Services/UserService";

class OrderHistory extends Component {
    constructor(props) {
        super(props);
        this.state = {
            orders: []
        }
    }
    componentDidMount() {
        UserService.getOrderByUser(this.props.email).then((res) => {
            this.setState({
                orders: res.data
            });
        });
    }
    render() {
        return (
            <div>
                <div style={{ backgroundImage: `url(${star})`, backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover',
                    backgroundPosition: 'center' ,fontFamily:'Montserrat', minHeight: '90vh'}}>
                    <div className="container custom-container" >
                        <center>
                            <h1 style={{ fontSize: '50px' }}>Your Orders</h1>
                            <div className="row">
                                <table className='table table-striped table-bordered' style={{width: '100%', background: 'whitesmoke' }} >
                                    <thead className='table-dark'>
                                    <tr>
                                        <th style={{fontSize:'20px'}}><b>Order Id</b></th>
                                        <th style={{fontSize:'20px'}}><b>Event Title</b></th>
                                        <th style={{fontSize:'20px'}}><b>Order Price</b></th>
                                        <th style={{fontSize:'20px'}}><b>Order Date</b></th>
                                        <th style={{fontSize:'20px'}}><b>Order Quantity</b></th>
                                        <th style={{fontSize:'20px'}}><b>Ticket Number</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {this.state.orders.map(
                                        order =>
                                            <tr key={order.orderid} >
                                                <td style={{fontSize:'20px'}}>{order.orderid}</td>
                                                <td style={{fontSize:'20px'}}>{order.event.name}</td>
                                                <td style={{fontSize:'20px'}}>{order.price}</td>
                                                <td style={{fontSize:'20px'}}>{order.orderdate}</td>
                                                <td style={{fontSize:'20px'}}>{order.quantity}</td>
                                                <td style={{fontSize:'20px'}}>{order.ticket.id}</td>
                                            </tr>
                                    )}
                                    </tbody>
                                </table>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
        );
    }
}

export default OrderHistory;