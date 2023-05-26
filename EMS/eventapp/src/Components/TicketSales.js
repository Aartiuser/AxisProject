import React, { Component } from 'react';
import { Chart, ChartSeries, ChartSeriesItem, ChartCategoryAxis, ChartCategoryAxisItem, ChartValueAxis, ChartValueAxisItem } from '@progress/kendo-react-charts';
import UserService from '../Services/UserService';
import '../App.css';
import fan from "../img/fan.jpg";

class TicketSales extends Component {
    constructor(props) {
        super(props);
        this.state = {
            orders: [],
        };
    }

    componentDidMount() {
        UserService.getTicketSales(this.props.email).then((res) => {
            const sortedOrders = res.data.sort((a, b) => {
                const titleA = a.event.name.toLowerCase();
                const titleB = b.event.name.toLowerCase();
                if (titleA < titleB) return -1;
                if (titleA > titleB) return 1;
                return 0;
            });
            this.setState({
                orders: sortedOrders,
            });
        });
    }

    render() {
        // Group the orders by event
        const groupedOrders = this.state.orders.reduce((groups, order) => {
            const eventId = order.event.id;
            if (!groups[eventId]) {
                groups[eventId] = {
                    event: order.event,
                    totalQuantity: 0,
                    totalPrice: 0,
                    orders: [],
                };
            }
            groups[eventId].totalQuantity += order.quantity;
            groups[eventId].totalPrice += order.price;
            groups[eventId].orders.push(order);
            return groups;
        }, {});

        const chartData = Object.values(groupedOrders).map((group) => ({
            event: group.event.name,
            totalOrderPrice: group.totalPrice,
        }));

        const chartCategories = Object.values(groupedOrders).map((group) => group.event.name);

        return (
            <div>
                <div
                    style={{
                        backgroundImage: `url(${fan})`,
                        backgroundRepeat: 'no-repeat',
                        backgroundSize: 'cover',
                        backgroundPosition: 'center',
                        fontFamily: 'Montserrat',
                        minHeight: '90vh',
                    }}
                >
                    <div className="container custom-container">
                        <center>
                            <h1 style={{ fontSize: '50px' }}>Your Ticket Sales</h1>
                            <div className="row">
                                <table
                                    className="table table-striped table-bordered"
                                    style={{ width: '100%', background: 'whitesmoke', fontFamily: 'Montserrat' }}
                                >
                                    <thead className="table-dark">
                                    <tr>
                                        <th style={{ fontSize: '20px' }}>
                                            <b>Event Title</b>
                                        </th>
                                        <th style={{ fontSize: '20px' }}>
                                            <b>Total Order Price</b>
                                        </th>
                                        <th style={{ fontSize: '20px' }}>
                                            <b>Total Order Quantity</b>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {Object.values(groupedOrders).map((group) => (
                                        <tr key={group.event.id}>
                                            <td style={{ fontSize: '20px' }}>{group.event.name}</td>
                                            <td style={{ fontSize: '20px' }}>{group.totalPrice}</td>
                                            <td style={{ fontSize: '20px' }}>{group.totalQuantity}</td>
                                        </tr>
                                    ))}
                                    </tbody>
                                </table>
                                <br/>
                            </div>
                            <br/><br/>
                            <h2>Analytics of Your Ticket Sales Revenue:</h2>
                            <Chart style={{ width: '800px'}}>
                                <ChartSeries>
                                    <ChartSeriesItem type="column" data={chartData} field="totalOrderPrice" name="Total Order Price" color="#800080" />
                                </ChartSeries>
                                <ChartCategoryAxis>
                                    <ChartCategoryAxisItem categories={chartCategories} labels={{ font:'Montserrat',color: '#000000', padding: { top: 10 }}} />
                                </ChartCategoryAxis>
                                <ChartValueAxis>
                                    <ChartValueAxisItem title={{ font:'Montserrat',text: 'Revenue In Rs', color: '#000000'}} color="#000000" labels={{ step: 2 }} />
                                </ChartValueAxis>
                            </Chart>
                        </center>
                    </div>
                </div>
            </div>
        );
    }
}

export default TicketSales;
