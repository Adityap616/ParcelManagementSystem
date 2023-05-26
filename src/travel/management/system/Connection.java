package travel.management.system;
import java.sql.*;

public class Connection {
    Connection(){
        //5 steps of database connectivity
        //1. Register the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
