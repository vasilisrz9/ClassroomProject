/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroomproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NB_VAIO
 */
public class ClassroomProject {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/catalogue";
    
    static final String USER ="root";
    static final String PASS ="razer91f";
    public static void main(String[] args) throws SQLException, ParseException {
        // TODO code application logic here
   
    
     Connection conn =null;
    // Statement stmt =null;
        
        
         while(true){
             conn = DriverManager.getConnection(DB_URL,USER,PASS);
             
             
        Scanner scan = new Scanner(System.in);
       System.out.println("Dwse 1: Gia insert 5 records\n Dwse 2a: Gia exist of record\n Dwse 2b: Gia update thlefonou \n Dwse 3: To show total numbers of rows of table\n Dwse 4:Gia emfanish olwn twn xrhstwn\n Dwse 5:Gia create bithdays\n Dwse 6: Gia insert se kathe xrhsth\n Dwse 7: Ektypwsh xrhstwn gia mia hmeromhnia\n Dwse 8:Gia dhmiourgia members2\n Dwse kati allo gia termatismo");
        String epilogh= scan.nextLine();
       // createTable(conn);
        if(epilogh.equals("1")){
            insert(conn);
        }else if(epilogh.equals("2a")){
            exist(conn);
        }else if(epilogh.equals("2b")){
            update(conn);
        }else if(epilogh.equals("3")){
                numberofrows(conn);
        }else if(epilogh.equals("4")){
                first(conn);        
                }else if(epilogh.equals("5")){
                   createTable(conn);
                }else if(epilogh.equals("6")){
                    insertBirthdays(conn);
                }else if(epilogh.equals("7")){  
                    printHlikia(conn);
                }else if(epilogh.equals("8")){
                    copytable(conn);
                }else{
                break;
                }
        conn.close();
         }
         conn.close();

     
     
    
    }
    
    public static void createTable(Connection conn) throws SQLException{
        Statement stmt =null;
         stmt = conn.createStatement();
         String sql;
         sql="CREATE TABLE IF NOT EXISTS `catalogue`.`birthdays` (\n" +
"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
"  `birthday` DATE NOT NULL,\n" +
"  `members_id` INT(100) NOT NULL,\n" +
"  PRIMARY KEY (`id`),\n" +
"  INDEX `fk_birthdays_members_idx` (`members_id` ASC),\n" +
"  CONSTRAINT `fk_birthdays_members`\n" +
"    FOREIGN KEY (`members_id`)\n" +
"    REFERENCES `catalogue`.`members` (`id`))";
         int rs =stmt.executeUpdate(sql);
         stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close(); 
    }
    
    public static void insertBirthdays(Connection conn) throws SQLException, ParseException{
        Statement stmt =null;
         stmt = conn.createStatement();
            String sql;
            sql= "SELECT * FROM members";
            ResultSet rs5 =stmt.executeQuery(sql);
            while(rs5.next()){
               Statement stmt2 =null;
               stmt2 = conn.createStatement();
                String sql2 = null;
                int ide =rs5.getInt(1);
                System.out.println(ide);
         String firstname =rs5.getString("FName");
                String lastname =rs5.getString("LName");
                            
                System.out.println(", First name: " + firstname);
                System.out.println(", Last name: " + lastname);
                System.out.println("Dwse imeromhnia genhshs: yyyy-mm-dd");
                Scanner scan = new Scanner(System.in);
               String hmeromhnia= scan.nextLine();
               SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
               Date parsed = format.parse(hmeromhnia);
                java.sql.Date sql3 = new java.sql.Date(parsed.getTime());
               sql2="insert into birthdays (`birthday`,`members_id`) values ('"+sql3+"','"+ide+"')";
               int rs2 =stmt2.executeUpdate(sql2);
              
               stmt2.close();
               
            
             if(stmt2!=null);
                stmt2.close();
            
            }
            rs5.close();
            stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close(); 
        
    }
    
    public static void printHlikia(Connection conn) throws SQLException, ParseException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Dwse hmerominia: yyyy-mm-dd");
        String hmeromhnia=scan.nextLine();
         SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
               Date parsed = format.parse(hmeromhnia);
                java.sql.Date sql3 = new java.sql.Date(parsed.getTime());
        
        Statement stmt =null;
         stmt = conn.createStatement();
         String sql;
         sql="select members_id  from birthdays where birthday='"+sql3+"'";
         ResultSet rs =stmt.executeQuery(sql);
         
         while(rs.next()){
         String sql1;
        sql1="select * from members where id= ?";
        PreparedStatement stmt2=conn.prepareStatement(sql1);
        stmt2.setString(1, rs.getString(1));
        ResultSet rs2=stmt2.executeQuery();
        
        while(rs2.next()){
            String firstname =rs2.getString(3);
                String lastname =rs2.getString(2);
                
                
                System.out.println(", First name: " + firstname);
                System.out.println(", Last name: " + lastname);
                System.out.println(", hmeromhnia: " + sql3);
                
        }
        rs2.close();
            stmt2.close();
           // conn.close();
            
             if(stmt2!=null);
                stmt2.close();
           //  if(conn!=null)
             //       conn.close();
     }
         rs.close();
            stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close();
        
    }
    
    public static void copytable(Connection conn) throws SQLException{
        Statement stmt =null;
         stmt = conn.createStatement();
         String sql;
         sql="CREATE TABLE IF NOT EXISTS `catalogue`.`members2` (\n" +
"  `id` INT(100) NOT NULL AUTO_INCREMENT,\n" +
"  `LName` VARCHAR(20) NOT NULL,\n" +
"  `FName` VARCHAR(20) NOT NULL,\n" +
"  `Tel1` VARCHAR(20) NOT NULL,\n" +
"  `Tel2` VARCHAR(20) NOT NULL,\n" +
"  PRIMARY KEY (`id`))";
         
         int rs =stmt.executeUpdate(sql);
         stmt.close();
         if(stmt!=null);
                stmt.close();
         Statement stmt2=null;
         stmt2=conn.createStatement();
         String sql2;
          
         
         sql2="select * from members";
         ResultSet rs9 =stmt2.executeQuery(sql2);
            while(rs9.next()){
                
                PreparedStatement preparedStatement = null;
                String insertTableSQL = "INSERT INTO members2"
				+ "(id,LName, FName, Tel1, Tel2) VALUES"
				+ "(?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(insertTableSQL);
                preparedStatement.setInt(1, rs9.getInt(1));
                preparedStatement.setString(2, rs9.getString(2));
			preparedStatement.setString(3, rs9.getString(3));
			preparedStatement.setString(4, rs9.getString(4));
			preparedStatement.setString(5, rs9.getString(5));
			preparedStatement.addBatch();
                        preparedStatement.executeBatch();
                        
                        preparedStatement.close();
                        if (preparedStatement != null) {
				preparedStatement.close();
			}
                       
            }
            rs9.close();
            stmt2.close();
            conn.close();
            if(stmt2!=null);
                stmt2.close();
            if(conn!=null)
                 conn.close(); 
            

    }
    
    public static void numberofrows(Connection conn) throws SQLException{
        Statement stmt =null;
         stmt = conn.createStatement();
         String sql;
         sql="select count(*)  from members as number";
         ResultSet rs =stmt.executeQuery(sql);
         
            rs.first();
            int id =rs.getInt(1);
            System.out.println("Rows are: "+id);
       
         stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                 conn.close(); 
    }
    
    public static void insert(Connection conn) throws SQLException{
        Statement stmt =null;
         stmt = conn.createStatement();
         String sql;
         sql="insert into members (LName,FName,Tel1,Tel2) values ('basilis','nikos','2142424','433535'), ('viky','mixalis','324424','335355'), ('georgiou','nikos','24245452','464264'), ('faih','skorda','253255','52525632'), ('tatiana','stefanidou','52524','64264')";
         int rs =stmt.executeUpdate(sql);
          stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close();   
    }
    
    public static void exist(Connection conn) throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Dwse lname");
        String lnam=scan.nextLine();
        System.out.println("Dwse fname");
        String fnam=scan.nextLine();
        String sql1;
        sql1="select * from members where LName= ? and FName =?";
        PreparedStatement stmt=conn.prepareStatement(sql1);
        stmt.setString(1, lnam);
        stmt.setString(2, fnam);
        ResultSet rs=stmt.executeQuery();
        
        while(rs.next()){
            String firstname =rs.getString(3);
                String lastname =rs.getString(2);
                String tel1=rs.getString(4);
                  String tel2=rs.getString(5);
                
                System.out.println(", First name: " + firstname);
                System.out.println(", Last name: " + lastname);
                System.out.println(", tel1: " + tel1);
                System.out.println(", tel2: " + tel2);
        
        }
        rs.close();
            stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close();
    }
    
    
    public static void update(Connection conn) throws SQLException{
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Dwse lname");
        String lnam=scan.nextLine();
        System.out.println("thlefono");
        String tel=scan.nextLine();
        
        PreparedStatement stmt=conn.prepareStatement("update members set Tel1=? where LName=?"); 
        stmt.setString(1,tel);
        stmt.setString(2,lnam);  
  
        int i=stmt.executeUpdate();  
        System.out.println(" records updated"); 
        stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                 conn.close();  
    }
    
    
    public static void first(Connection conn) throws SQLException{
        Statement stmt =null;
         stmt = conn.createStatement();
            String sql;
            sql= "SELECT * FROM members";
            ResultSet rs =stmt.executeQuery(sql);
            while(rs.next()){
                int id =rs.getInt("id");
                String firstname =rs.getString("FName");
                String lastname =rs.getString("LName");
                String tel1=rs.getString("Tel1");
                  String tel2=rs.getString("Tel2");
                System.out.println("ID: "+id);
                System.out.println(", First name: " + firstname);
                System.out.println(", Last name: " + lastname);
                System.out.println(", tel1: " + tel1);
                System.out.println(", tel2: " + tel2);
            }
            rs.close();
            stmt.close();
            conn.close();
            
             if(stmt!=null);
                stmt.close();
             if(conn!=null)
                    conn.close();   
    }
    
}

