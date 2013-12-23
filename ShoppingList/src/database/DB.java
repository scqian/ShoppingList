package database;

import java.sql.*; 
 
public class DB { 
 
     static String host = "192.168.0.15"; 
     static String port = "3306"; 
     static String user = "scqian"; 
     static String password = "Chengkun321";
     static String database = "INVENTORY"; 
     
     public static void main(String[] args) { 
     
         try { 
             Class.forName("com.mysql.jdbc.Driver"); 

             
             /*Connection con = DriverManager.getConnection 
             ( "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&" + "password=" + password);*/ 
             
             Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.15?",user,password);
             System.out.println("Checkpoint");
             
             Statement stmt = con.createStatement(); 
             stmt.executeUpdate("USE " + database); 
             
             ResultSet rs = stmt.executeQuery("SELECT * FROM items");
             while(rs.next()) { 
                String item = rs.getString("item");
                String price = rs.getString("price");
                System.out.println(item + ": " + price);
            }   
         
            con.close(); 
            System.out.println("done");
         } catch (SQLException e) { 
             System.out.println("SQLException");
             e.printStackTrace(); 
         } 
         catch (ClassNotFoundException e) { 
             System.out.println("Class not found");
             e.printStackTrace(); 
         }
    } 
}