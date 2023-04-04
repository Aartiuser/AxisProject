public class InheritanceActivity {
    public static void main(String[] args){
        Manager m=new Manager(126534,"Peter","Chennai India",237844,65000);
        m.calculateSalary();
        m.calculateTransportallowance();
        Trainee t=new Trainee(29846,"Jack","Mumbai India",442085,45000);
        t.calculateSalary();
        t.calculateTransportallowance();
    }
}
