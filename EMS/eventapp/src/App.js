import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './Components/Home';
import Signup from './Components/Signup';
import Signin from './Components/Signin';
import CreateEvent from './Components/CreateEvent';
import BookTicket from './Components/BookTicket';
import { useState } from 'react';
import AttendeeHeader from './Components/AttendeeHeader';
import OrgHeader from './Components/OrgHeader';
import CreateTicket from './Components/CreateTicket';
import EventDate from './Components/Search/EventDate';
import Location from './Components/Search/Location';
import TicketSales from './Components/TicketSales';
import Type from './Components/Search/Type';
import TicketType from './Components/TicketType';
import UpdateEvent from './Components/UpdateEvent';
import OrderHistory from './Components/OrderHistory';
import Footer from './Components/Footer';
import ViewTicket from './Components/ViewTicket';
import Header from './Components/Header';
import OrgHome from './Components/OrgHome';
import AttendeeHome from './Components/AttendeeHome';

function App() {
    const [userRole, setUserRole] = useState(() => {
        const storedUserRole = localStorage.getItem('userRole');
        return storedUserRole || 'default';
    });

    const [email, setemail] = useState(localStorage.getItem('email') || 'default');
    const [event, setevent] = useState(localStorage.getItem('event') || 'default');

    const renderHeader = () => {
        console.log(userRole);
        if (userRole === 'Organiser') return <OrgHeader userRole={userRole} setUserRole={setUserRole} />;
        else if (userRole === 'Attendee') return <AttendeeHeader userRole={userRole} setUserRole={setUserRole} />;
        else if (userRole === 'default') return <Header />;
    };

    const renderUserPage = () => {
        if (userRole === 'Organiser') return <OrgHome email={email} />;
        else if (userRole === 'Attendee') return <AttendeeHome email={email} />;
        else return <Home />;
    };

    return (
        <div className="app-container">
            <Router>
                {renderHeader()}

                    <Switch>
                        <Route path="/" exact component={Home} />
                        <Route path="/register" exact component={Signup} />
                        <Route
                            path="/login"
                            render={() => <Signin setUserRole={setUserRole} setemail={setemail} />}
                        />
                        <Route path="/UserHome" render={() => renderUserPage()} />
                        <Route path="/CreateEvent" render={() => <CreateEvent email={email} />} />
                        <Route path="/Createticket" render={() => <CreateTicket email={email} />} />
                        <Route path="/update" render={() => <UpdateEvent email={email} />} />
                        <Route path="/date" exact component={EventDate} />
                        <Route path="/location" exact component={Location} />
                        <Route path="/type" exact component={Type} />
                        <Route path="/Viewtickets" render={() => <ViewTicket email={email} />} />
                        <Route path="/Viewticketsales" render={() => <TicketSales email={email} />} />
                        <Route path="/Createtype" exact component={TicketType} />
                        <Route path="/BookTicket" render={() => <BookTicket email={email} setevent={setevent} />} />
                        <Route path="/OrderHistory" render={() => <OrderHistory email={email} />} />
                    </Switch>
                <Footer />
            </Router>
        </div>
    );
}

export default App;
