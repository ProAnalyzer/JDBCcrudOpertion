import com.sun.jndi.cosnaming.IiopUrl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class Emp {

    private Integer Emp_ID;
    private String First_Name;
    private String Middle_Name;
    private String Last_Name;
    private Date Date_of_Birth;
    private Integer Age_of_Emp;
    private Date Start_Date;
    private Date End_Date;
    private String Salary;
    private String Email;
    private String Phone_Number;
    private String Address;
    private String Description;
    private String Country;

    public Emp(Integer Emp_ID, String First_Name, String Middle_Name, String Last_Name,
               Date Date_of_Birth, Integer Age_of_Emp, Date Start_Date, Date End_Date,
               String Salary, String Email, String Phone_Number, String Address,
               String Description, String Country) {
        this.Emp_ID = Emp_ID ;
        this.First_Name = First_Name ;
        this.Middle_Name = Middle_Name ;
        this.Last_Name = Last_Name ;
        this.Date_of_Birth = Date_of_Birth ;
        this.Age_of_Emp = Age_of_Emp ;
        this.Start_Date = Start_Date ;
        this.End_Date = End_Date ;
        this.Salary = Salary ;
        this.Email = Email ;
        this.Phone_Number = Phone_Number ;
        this.Address = Address ;
        this.Description = Description ;
        this.Country = Country ;
    }


    public Integer getEmp_ID() {
        return Emp_ID;
    }
    public void setEmp_ID(Integer Emp_ID) {
        this.Emp_ID = Emp_ID;
    }


    public String getFirst_Name() {
        return First_Name;
    }
    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }


    public String getMiddle_Name() {
        return Middle_Name;
    }
    public void setMiddle_Name(String Middle_Name) {
        this.Middle_Name = Middle_Name;
    }


    public String getLast_Name() {
        return Last_Name;
    }
    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }


    public Date getDate_of_Birth() {
        return Date_of_Birth;
    }
    public void setDate_of_Birth(Date Date_of_Birth) {
        this.Date_of_Birth = Date_of_Birth;
    }


    public Integer getAge_of_Emp() {
        return Age_of_Emp;
    }
    public void setAge_of_Emp(Integer Age_of_Emp) {
        this.Age_of_Emp = Age_of_Emp;
    }


    public Date getStart_Date() {
        return Start_Date;
    }
    public void setStart_Date(Date Start_Date) {
        this.Start_Date = Start_Date ;
    }


    public Date getEnd_Date() {
        return End_Date;
    }
    public void setEnd_Date(Date End_Date) {
        this.End_Date = End_Date;
    }


    public String getSalary() {
        return Salary;
    }
    public void setSalary(String Salary) {
        try {
            int i = Integer.parseInt((Salary.trim()));
        }
        catch (NumberFormatException e ){
            System.out.println("Salary Format not Correct");
        }
        this.Salary = Salary;
    }


    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String getPhone_Number () {
        return Phone_Number;
    }
    public void setPhone_Number(String Phone_Number) {
        try {
            int i = Integer.parseInt((Phone_Number.trim()));
        }
        catch (NumberFormatException e ){
            System.out.println("Phone Number Format not Correct");
        }
        this.Phone_Number = Phone_Number;
    }


    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }


    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }


    public String getCountry() {
        return Country;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }
}