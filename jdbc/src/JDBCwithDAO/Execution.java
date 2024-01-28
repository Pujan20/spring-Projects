package JDBCwithDAO;

import java.sql.SQLException;

import java.util.Scanner;

import org.xml.sax.ErrorHandler;






public class Execution {
	

	private static Scanner sc;

	public static void main(String args[]) throws SQLException {
		
		DAOinterface DAO=new DAOimplemen();
		
		
		sc = new Scanner(System.in);
		
		do {
			System.out.println("enter choice");
			int ch=sc.nextInt();
			switch(ch) {
			
			case 1:
				
				
			Sdetails Sd=new Sdetails(ch, null, null, ch, ch, ch, null, null);
				System.out.println("enter values");
				
     			int id=sc.nextInt();
     			DAO.CheckId(id);
				String Sname=sc.next(),result=sc.next();
				int maths=sc.nextInt(),science=sc.nextInt(),english=sc.nextInt();
				String Remarks=sc.next(),Division=sc.next();
				
				Sd.setId(id);
				Sd.setSname(Sname);
				Sd.setResult(result);
				Sd.setMaths(maths);
				Sd.setScience(science);
				Sd.setEnglish(english);
				Sd.setRemarks(Remarks);
				Sd.setDivision(Division);
			
				DAO.createSdetails(Sd);
				break;
				
			case 2:
				DAO.showAllDetails();
				break;
				
			case 3:
                 System.out.println("enter id");  
                 int id2=sc.nextInt();
				DAO.SHowOnId(id2);
				
				
				break;
				
			case 4:
				System.out.println("enter id");
				int id1=sc.nextInt();
				DAO.SHowOnId(id1);;
				System.out.println("enter Division");
				Division=sc.next();
				DAO.UpdateSdetails(id1,Division);
				
				break;
		
			default:
				System.out.println("Invalid choice");
				break;
			
				
				
			}
			
		}while(true);
	}

}
