package ExceptionHandling;
class CountryNotvalidException extends Exception{
    public CountryNotvalidException(String message){
        super(message);
    }
}
class EmployeeNameInvalidException extends Exception{
    public EmployeeNameInvalidException(String message){
        super(message);
    }
}
class TaxNotEligibleException extends Exception{
    public TaxNotEligibleException(String message){
        super(message);
    }
}
class TaxCalculator{
   public double calculateTax(String name, boolean isindian, double empSal)throws CountryNotvalidException,EmployeeNameInvalidException,TaxNotEligibleException{
       double taxAmount;
       if(!isindian)
            throw new CountryNotvalidException("The employee should be an Indian citizen for calculating tax");
        if(name.isEmpty())
            throw new EmployeeNameInvalidException("The employee name cannot be empty");
        if(empSal>=100000 && isindian)
            taxAmount =empSal *8.0/100;
        else if(empSal>50000 && empSal<100000 &&isindian)
            taxAmount =empSal *6.0/100;
        else if(empSal>30000 && empSal<50000 &&isindian)
            taxAmount =empSal *5.0/100;
        else if(empSal>10000 && empSal<30000 &&isindian)
            taxAmount =empSal *4.0/100;
        else
            throw new TaxNotEligibleException("The employee does not need to pay tax");
       return taxAmount;
   }

}
public class CalculatorSimulator {
    public static void main(String[] args) {
        TaxCalculator t=new TaxCalculator();
        double tax;
        try{
            tax=t.calculateTax("",true,30000);
            System.out.println("Tax amount is:"+tax);
        }catch(CountryNotvalidException c){
            System.out.println(c.getMessage());
        }catch(EmployeeNameInvalidException e){
            System.out.println(e.getMessage());
        }catch(TaxNotEligibleException ex){
            System.out.println(ex.getMessage());
        }

    }

}
