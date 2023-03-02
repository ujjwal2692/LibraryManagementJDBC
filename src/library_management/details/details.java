package library_management.details;

import library_management.connection.connection;
import java.sql.*;
import java.io.*;

public class details extends connection {
    public void printdetails() {
        String query = "select book_available from book where book_id=?";

        try {
            Connection connection = connect();

            PreparedStatement ptm = connection.prepareStatement(query);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the book id :");
            String book_id = br.readLine();
            ptm.setString(1, book_id);
            ResultSet rs = ptm.executeQuery();

            rs.next();
            String book_available = rs.getString(1);
            System.out.println(book_available + " books are available in the stock\n ----------");
            ptm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Entered BOOK ID is not valid or not in databases:\n Kindly contact to administrator");
        }
    }

}
