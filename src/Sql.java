import java.sql.*; 
class Sql {
   String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   String DB_URL = "jdbc:mysql://localhost/movieticket";
   String USER = "root";
   String PASS = "root";
   
   public Connection getConnection(){       
       Connection conn=null;
       try{           
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           //System.out.println(conn.isClosed());

       }
       catch(Exception e){
          System.out.println(e);
       }
       return conn;
   }

    public Statement fetchStatement(){
        Statement x=null;
        try{
           x = getConnection().createStatement();
        }        
        catch(Exception e){
             System.out.println(e);
        }
        return x;
    }
    
    public void closeConn(Statement st){
        try{
            st.getConnection().close();
        }
        catch(Exception e){
            System.out.println(e);
        }        
    }   
}
