import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class mysql{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://10.10.15.244/Databs", "null", "null");
        Statement st=conn.createStatement();
        int ch =0;
        boolean cont=true;
        while(cont){
            System.out.println("---------------------");
            
            String t="Ak";
            String ot="1. Add "+t;
            System.out.println(ot);
            System.out.println("2.Subs");
            System.out.print("Enter your choice: ");
            ch=sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:System.out.println("Added");
                break;
                case 2: System.out.println("Substracted");
                break;
                case 3: System.out.println("quited");
                cont=false;
                break;
                default:System.out.println("Wrong choice");
            }
        }
    }
}
