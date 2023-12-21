
import java.sql.*;
import java.lang.String;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306//DBMS";
        String uname="root";
        String pass="root";
        System.out.println("Welcome to Patient Interface!!!");
        System.out.println("Enter your symptoms: ");
        String symptoms=sc.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS","root","root");
        if(symptoms.toLowerCase().contains("head")){
            String query = "select name from doctors where speciality like'%Head%'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("The Doctor assigned to you is: ");
            String name = rs.getString(1);
            System.out.println(name);
            st.close();
        }
        else if(symptoms.toLowerCase().contains("heart")) {
                String query;
                query = "select name from doctors where speciality like'%Heart%'";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                System.out.println("The Doctor assigned to you is: ");
                String name = rs.getString(1);
                System.out.println(name);
                st.close();
            }
        else if(symptoms.toLowerCase().contains("nose") ||
                symptoms.toLowerCase().contains("ear") ||
                symptoms.toLowerCase().contains("throat")) {
            String query;
            query = "select name from doctors where speciality like'%ENT%'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("The Doctor assigned to you is: ");
            String name = rs.getString(1);
            System.out.println(name);
            st.close();
        }


        connection.close();
    }

}