package FuncInterfaces;

public class Ticket {
    long pnrNo;
    String passengerName;
    int seatNo;
    String classType;
    double ticketFare;

    public Ticket(long pnrNo, String passengerName, int seatNo, String classType, double ticketFare) {
        this.pnrNo = pnrNo;
        this.passengerName = passengerName;
        this.seatNo = seatNo;
        this.classType = classType;
        this.ticketFare = ticketFare;
    }
    public Ticket(){

    }

    public long getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(long pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(double ticketFare) {
        this.ticketFare = ticketFare;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "pnrNo=" + pnrNo +
                ", passengerName='" + passengerName + '\'' +
                ", seatNo=" + seatNo +
                ", classType='" + classType + '\'' +
                ", ticketFare=" + ticketFare +
                '}';
    }
}
