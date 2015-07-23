/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birth;

/**
 *
 * @author pc
 */
import java.sql.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;


public class backend {
    
    private static List<List<Object>> rowData = new ArrayList<List<Object>>();    
    public static Connection conn = null;
    public static Statement stmt = null;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/db";
    
    
    public boolean login(String user, char[] password) {
        
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);            
        }
        
        try {                        
            conn = DriverManager.getConnection(url, user, String.copyValueOf(password));
            stmt = conn.createStatement();
            return true;
        } catch(Exception e) {
            return false;            
        }
        
    }
    
    public void insert(String tag1, String tag2, int tag3, Calendar date) {          
        
        int year = Calendar.getInstance().get(date.YEAR);
        int month = Calendar.getInstance().get(date.MONTH);
        int day = Calendar.getInstance().get(date.DATE);
        String data = year + "-" + month + "-" + day;                
        String insert = "insert into db.info values( " +"'" + tag1 + "'" + 
                "," + "'" + tag2 + "'" + "," + tag3 + "," + "'" + data + "'" + " );";        
        
        try {            
            stmt.executeUpdate(insert);
        } catch(Exception e) {
            System.out.println("Error inserting to the table: " + e);                        
        }
        
    }
    
    //update has a bug: because table has no id column, all identical records will be updated at the same time
    //at the same time, in table view only one of many identical rows is affected, because model does not reloads. After .select() 
    //all identical rows are updated.
    //table need to be fixed and id column added    
    public void update(String tag1, String tag2, String tag3, String datas, String value, String column) {   
        
        String update = "update db.info set " + column + " = " + "'" + value + "'" + " where tag1 = " 
                + "'" + tag1 + "'" + " and tag2 = " + "'" 
                + tag2 + "'" + " and tag3 = " + "'" + tag3 + "'" + " and datas = " + "'" + datas + "'" +";";                
        try {
            stmt.executeUpdate(update);
        } catch(Exception e) {}
    }
    
    public void delete(String tag1, String tag2, String tag3, String datas) {
        
        String delete = "delete from db.info where tag1 = " + "'" + tag1 + "'" + " and tag2 = " 
                + "'" + tag2 + "'" + " and tag3 = " + "'" + tag3 + "'" + " and datas = " 
                + "'" + datas + "'" + ";";        
        //System.out.println(delete);
        try {
          //  System.out.println("here1");
            stmt.executeUpdate(delete);
            //System.out.println("here2");
        } catch(Exception e) {}
    }
    
    public List<List<Object>> select() {
        
        rowData.clear();
        ResultSet result;
        String select = "select * from db.info;";      
        
        try {            
            result = stmt.executeQuery(select);            
            
            while(result.next()) {
                List<Object> row = new ArrayList<Object>();                
                row.add(result.getString("tag1"));                
                row.add(result.getString("tag2"));
                row.add(result.getString("tag3"));                
                row.add((result.getDate("datas")).toString());                
                rowData.add(row);
            }
                                    
        } catch(Exception e) {}                
        
        return rowData;
    }
    
    public void disconnect() {
        try {
            if(conn != null)
                conn.close();
        } catch (Exception e) {}
        try {
            if(stmt != null)
                stmt.close();
        } catch(Exception e) {}    
    }
       
}
