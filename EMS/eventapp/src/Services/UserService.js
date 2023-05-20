import axios from "axios";
const User_ADD="http://localhost:8085/addusers";
const User_GET="http://localhost:8085/getusers";
const User_Login="http://localhost:8085/login"
const Event_ADD="http://localhost:8085/addevent";
const Event_UP="http://localhost:8085/updateevent";
const Event_DEL="http://localhost:8085/eventdelete";
const Event_GET="http://localhost:8085/getevents";
const Event_GETRole="http://localhost:8085/geteventsbyuid/";
const Ticket_GET="";
const Ticket_ADD="";
const Tickettype_GET="";
const Tickettype_ADD="";
const Order_ADD="http://localhost:8085/";
class UserService{

    getEventByRole(email){
        return axios.get(Event_GETRole+email);
    }
    delEvent(event){
        return axios.delete(Event_DEL,event);
    }
    getEvents(){
        return axios.get(Event_GET);
    }
    addEvent(event,mail){
        const data={
            events:event,
            email:mail
        }
        return axios.post(Event_ADD,data);
    }
    updateEvent(event,mail){
        const data={
            events:event,
            email:mail
        }
        return axios.put(Event_UP, data);
    }
    addUser(user){
        return axios.post(User_ADD,user);
    }
    login(user){
        console.log(user);
        return axios.post(User_Login,user);
    }
    addOrder(order){
        return axios.post(Order_ADD,order);
    }
    getTicketByType(typeid){

    }
    getTicketsbyid(eventid){

    }
}
export default new UserService();