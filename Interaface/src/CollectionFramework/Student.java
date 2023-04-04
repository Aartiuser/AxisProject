package CollectionFramework;

public class Student {
    String stuname;
    int rno;
    String branch;
    String city;
    public Student(String stuname,String Branch, String city,int rno){
        setStuname(stuname);
        setRno(rno);
        setCity(city);
        setBranch(Branch);
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuname='" + stuname + '\'' +
                ", rno=" + rno +
                ", branch='" + branch + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
