import axios from "axios";
const User_ADD="http://localhost:8085/addusers";
const User_GET="http://localhost:8085/getusers";
const User_Login="http://localhost:8085/login"
const Event_ADD="http://localhost:8085/addevent";
const Event_UP="http://localhost:8085/updateevent";
const Event_DEL="http://localhost:8085/eventdelete/";
const Event_GET="http://localhost:8085/getevents";
const Event_GETRole="http://localhost:8085/geteventsbyuid/";
const Event_Date="http://localhost:8085/getbydate/";
const Event_loc="http://localhost:8085/getbyloc/";
const Event_type="http://localhost:8085/getbytyp/";
const Ticket_GET="http://localhost:8085/getticket";
const Ticket_ADD="http://localhost:8085/addtickets";
const Tickettype_GET="http://localhost:8085/gettype";
const Tickettype_Id="http://localhost:8085/gettypebyid/";
const Type_ADD="http://localhost:8085/addtype";
const Order_ADD="http://localhost:8085/addOrder";
const Ticket_EvId="http://localhost:8085/getbyevid/";
const Ticket_TEid="http://localhost:8085/getbyeidtid/";
const Ticket_UId="http://localhost:8085/getbyuid/";
const Ticket_Del="http://localhost:8085/delticket/";
const Order_User="http://localhost:8085/getorder/";
const Ticket_Sales="http://localhost:8085/ticketsales/";
const User_check="http://localhost:8085/register";

class UserService{

    getEventByRole(email){
        return axios.get(Event_GETRole+email);
    }
    delEvent(eventid){
        return axios.delete(Event_DEL+eventid);
    }
    getEvents(){
        return axios.get(Event_GET);
    }
    getEventBydate(date){
        return axios.get(Event_Date+date);
    }
    getEventByloc(loc){
        return axios.get(Event_loc+loc);
    }
    getEventBytype(type){
        return axios.get(Event_type+type);
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
    checkUser(user){
        return axios.post(User_check,user);
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
    addTicket(ticketdata){
        return axios.post(Ticket_ADD,ticketdata);
    }
    delTicket(ticketid){
        return axios.delete(Ticket_Del+ticketid);
    }
    addTicketType(ticketType){
        console.log(ticketType);
        return axios.post(Type_ADD,ticketType);
    }
    getTickets(){
        return axios.get(Ticket_GET);
    }
    getTicketByType(typeid){

    }
    getTicketSales(email){
        return axios.get(Ticket_Sales+email);
    }
    getTickettype(){
        return axios.get(Tickettype_GET);
    }
    getTicketByuid(email){
        return axios.get(Ticket_UId+email);
    }
    getTicketsbyid(eventid){
       return axios.get(Ticket_EvId+eventid);
    }
    getTicketByTypeEId(typeid,eventid){
        return axios.get(Ticket_TEid+eventid+"/"+typeid);
    }
    getTicketType(typeid){
        return axios.get(Tickettype_Id+typeid);
    }

    getOrderByUser(email){
        return axios.get(Order_User+email)
    }

}
export default new UserService();