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
             
             Connection con = DriverManager.getConnection 
             ( "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&" + "password=" + password); 
             
             Statement stmt = con.createStatement(); 
             stmt.executeUpdate("USE " + database); 
             
             ResultSet rs = stmt.executeQuery("SELECT * FROM clothing");
             while(rs.next()) { 
                String item = rs.getString("Item");
                String price = rs.getString("Price");
                System.out.println(item + ": " + price);
            }   
         
            con.close(); 
         } catch (SQLException e) { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         } 
         catch (ClassNotFoundException e) { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         }
    } 
}