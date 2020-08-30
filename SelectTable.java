import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

public class SelectTable {

    private final String url = "jdbc:postgresql://localhost:5432/myDB";
    private final String user = "postgres";
    private final String password = "postgres";

    private static final String QUERY = "SELECT Emp_ID,First_Name,Email,Country,Salary FROM Employee WHERE Emp_ID =?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Employee";

    public void getEmpById() {

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("Emp_ID");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String Country = rs.getString("Country");
                String Salary = rs.getString("Salary");
                System.out.println(id + "," + Name + "," + Email + "," + Country + "," + Salary);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void getAllEmps(){
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int Emp_id = rs.getInt("Emp_id");
                String First_Name = rs.getString("First_name");
                String Middle_Name = rs.getString("Middle_name");
                String Last_Name = rs.getString("Last_name");
                String Date_of_Birth = rs.getString("Date_of_Birth");
                String Age_of_Emp = rs.getString("Age_of_Emp");
                String Start_Date = rs.getString("Start_Date");
                String End_Date = rs.getString("End_Date");
                String Salary = rs.getString("Salary");
                String Email = rs.getString("Email");
                String Phone_Number = rs.getString("Phone_Number");
                String Address = rs.getString("Address");
                String Description = rs.getString("Description");
                String Country = rs.getString("country");
                System.out.println(Emp_id + "," + First_Name + "," + Middle_Name + "," + Last_Name + "," + Date_of_Birth + "," + Age_of_Emp + "," + Start_Date + "," + End_Date + "," + Salary + "," + Email + "," + Phone_Number + "," + Address + "," + Description + "," + Country );
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void main(String[] args) {
        SelectTable example = new SelectTable();
        example.getEmpById();
        example.getAllEmps();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}