
import java.util.*;
import java.sql.*;


class mysqljavaprachi {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("localhost", "root", "mysqlroot");
			Statement smt = conn.createStatement();
			
			if(conn!=null && !conn.isClosed())
			{
				System.out.println("Connected");
			}
			else
			{
				System.out.println("Not Connected");
			}
		
			System.out.println("1. Create Table \n2. Insert into table \n3. Update value \n4. Delete value from table \n5. Select");
			System.out.println("\nEnter your choice:");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
		
			switch(ch){
				case 1:
					String createQuery = "create table ";
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Enter the name of the table: ");
	                String name = sc1.nextLine();
	                System.out.println("Enter the attributes with the datatype: ");
	                String values = sc1.nextLine();
	                
	                createQuery = createQuery + name + "(" + values + ")";
	                
	                System.out.println(createQuery);
	                smt.executeUpdate(createQuery);
	                System.out.println("Table is created!");
	                sc1.close();
	                break;
	                
				case 2:
					String insertQuery = "insert into ";
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter the name of the table: ");
	                String name1 = sc2.nextLine();
	                System.out.println("Enter the values: ");
	                String values1 = sc2.nextLine();
	                insertQuery = insertQuery + name1 + " values(" + values1 + ")";
	                
	                System.out.println(insertQuery);
	                smt.executeUpdate(insertQuery);
	                System.out.println("Values inserted!");
	                sc2.close();
	                break;
	                
				case 3:
					String updateQuery = "update ";
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the name of the table: ");
	                String name2 = sc3.nextLine();
	                System.out.println("Enter rollno to update: ");
	                int roll = sc3.nextInt();
	                
	                sc3.nextLine();
	                
	                System.out.println("Enter new name: ");
	                String nameValue = sc3.nextLine();
	                
	                updateQuery = updateQuery + name2 + " set name = '" + nameValue + "' where id = " + roll;
	                System.out.println(updateQuery);
	                smt.executeUpdate(updateQuery);
	                System.out.println("Updated!");
	                sc3.close();
	                break;
	                
	                
				case 4:
					String deleteQuery = "delete from ";
					Scanner sc4 = new Scanner(System.in);
					System.out.println("Enter the name of the table: ");
	                String name3 = sc4.nextLine();
	                System.out.println("Enter rollno to delete: ");
	                int roll1 = sc4.nextInt();
	                
	                deleteQuery = deleteQuery + name3 + " where id = " + roll1;
	                System.out.println(deleteQuery);
	                smt.executeUpdate(deleteQuery);
	                System.out.println("Deleted!");
	                sc4.close();
	                break;
	                
				case 5:
					String selectQuery = "select * from ";
					Scanner sc5 = new Scanner(System.in);
					System.out.println("Enter the name of the table: ");
	                String name4 = sc5.nextLine();
	                
	                selectQuery = selectQuery + name4;
	                System.out.println(selectQuery);
	                ResultSet rs = smt.executeQuery(selectQuery);
	                
	                while(rs.next())
	                {
	                	int col1 = rs.getInt("id");
	                	String col2 = rs.getString("name");
	                	
	                	System.out.println("id: " +col1);
	                	System.out.println("name: " +col2+"\n");
	                }
	                
	                System.out.println("Displayed!");
	                sc5.close();
	                break;
					
				default:
					System.out.println("Wrong choice entered..!!");
					break;
			}
		} catch(Exception e) {System.out.println(e);}
	}
}