public class TestEx {
    public static void main(String[] args) {
        String s1="Aarti";
        String s2="aarti";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
        Emp emp=new Emp(23);
        Emp emp1=new Emp(23);
        Emp emp2=new Emp(25);
        System.out.println("is emp equal to emp1? "+emp.equals(emp1));
        System.out.println("is emp equal to emp2? "+emp.equals(emp2));
    }
}
class Emp{
    private int age;
    public Emp(int age){
        this.age=age;
    }
    public int hashcode(){
        return age;
    }
    public boolean equals(Object obj){
        boolean flag=false;
        Emp emp=(Emp) obj;
        if(emp.age==age)
            flag=true;
        return flag;
    }
}