
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import  java.sql.PreparedStatement;

import java.util.Arrays;
import java.util.List;


public class InsertTable {

    private final String url = "jdbc:postgresql://localhost:5432/myDB";
    private final String user = "postgres";
    private final String password = "postgres";

    private static final String INSERT_USERS_SQL = "INSERT INTO Employee" +
            "  (Emp_ID, First_Name, Middle_Name, Last_Name, Date_of_Birth, " +
            "Age_of_Emp, Start_Date, End_Date, Salary, Email, Phone_Number, Address, Description, Country) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    /**
     * insert multiple users
     */
    public void insertUsers(List <Emp> list) {
        try (
                Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement statement = conn.prepareStatement(INSERT_USERS_SQL)) {
            int count = 0;

            for (Emp Employee: list) {
                statement.setInt(1, Employee.getEmp_ID());
                statement.setString(2, Employee.getFirst_Name());
                statement.setString(3, Employee.getMiddle_Name());
                statement.setString(4, Employee.getLast_Name());
                statement.setDate(5, Employee.getDate_of_Birth());
                statement.setInt(6, Employee.getAge_of_Emp());
                statement.setDate(7, Employee.getStart_Date());
                statement.setDate(8, Employee.getEnd_Date());
                statement.setString(9, Employee.getSalary());
                statement.setString(10, Employee.getEmail());
                statement.setString(11, Employee.getPhone_Number());
                statement.setString(12, Employee.getAddress());
                statement.setString(13, Employee.getDescription());
                statement.setString(14, Employee.getCountry());


                statement.addBatch();
                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == list.size()) {
                    statement.executeBatch();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertTable example = new InsertTable();
                example.insertUsers(Arrays.asList(
                        new Emp(1,
                                "Pronay",
                                "Kumar",
                                "Ghosh",
                                Date.valueOf("1998-04-16"),
                                21,
                                Date.valueOf("2020-03-16"),
                                Date.valueOf("2029-04-16"),
                                "15740.77",
                                "utdhfx@gmail.com",
                                "6291081728",
                                "Kolkata",
                                "Analyst",
                                "India" ),
                        new Emp(2,
                                "Ayan",
                                "Roy",
                                "Gupta",
                                Date.valueOf("19960411"),
                                23,
                                Date.valueOf("2017-03-19"),
                                Date.valueOf("2020-06-19"),
                                "23369.88",
                                "exfcgvjh@hotmail.com",
                                "9674546047",
                                "DumDum",
                                "Developer",
                                "India"),
                        new Emp(3,
                                "Pratap",
                                "Sen",
                                "Sharma",
                                Date.valueOf("1997-03-01"),
                                22,
                                Date.valueOf("2017-05-26"),
                                Date.valueOf("2027-05-26"),
                                "13580.88",
                                "ihukhjgc@gmail.com",
                                "9433472441",
                                "RajaBazar",
                                "Area Sales Manager",
                                "India"),
                        new Emp(1,
                                "Anuv",
                                "Kumar",
                                "Jain",
                                Date.valueOf("1992-05-05"),
                                27,
                                Date.valueOf("2010-01-01"),
                                Date.valueOf("2030-01-01"),
                                "39999.99",
                                "tuycghvhj@email.com",
                                "9136460586",
                                "Park Street",
                                "Managind Director",
                                "India"),
                        new Emp(5,
                                "Kashi",
                                "Nath",
                                "Dutta",
                                Date.valueOf("1988-03-19"),
                                31,
                                Date.valueOf("2009-08-11"),
                                Date.valueOf("2029-08-11"),
                                "55740.77",
                                "cyckhgl@yahoo.com",
                                "9874563210",
                                "Esplaned",
                                "Chief Exeutive Officer",
                                "India")));
    }
}