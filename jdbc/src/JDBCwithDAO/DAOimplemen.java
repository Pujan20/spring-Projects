package JDBCwithDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DAOimplemen implements DAOinterface{
	
    static Connection con=DatabaseConnection.getConnection();
	
   
    public void createSdetails(Sdetails Sd) {
		try {
			
				String sql1="insert into Sdetails values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement p=con.prepareStatement(sql1);
				
				p.setInt(1, Sd.getId());
				p.setString(2,Sdetails.getSname());
				p.setString(3,Sd.getResult());
				p.setInt(4,Sd.getMaths());
				p.setInt(5,Sd.getScience());
				p.setInt(6,Sd.getEnglish());
				p.setString(7,Sd.getRemarks());
				p.setString(8,Sd.getDivision());
				
				int rs=p.executeUpdate();
			
				if(rs>0) {
					System.out.println("update Successfull");
				}
			}
			
			
		catch(Exception e) {
				System.out.println(e);
			}
			
		
	}

	public void showAllDetails() throws SQLException {

		try {
		String sql="select*from Sdetails";
		PreparedStatement p=con.prepareStatement(sql);
		ResultSet result=p.executeQuery(sql);
		
		while(result.next()) {
			System.out.format("%d\t%s\t%s\t%d\t%d\t%d\t%s\t%s\n",result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8));
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	
public void SHowOnId(int id2) throws SQLException {
		
		
		String sql="select*from Sdetails where id="+id2;
		
		try {
			
			PreparedStatement s=con.prepareStatement(sql);
			ResultSet result=s.executeQuery(sql);
			
			if(result.next()) {
			
				System.out.format("%d\t%s\t%s\t%d\t%d\t%d\t%s\t%s",result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8));
				}
			else {
				System.out.println("id doesnt exist");
				System.exit(id2);
				
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		
	

	public void UpdateSdetails(int id1,String Division) throws SQLException {
		
		
		String sql="update Sdetails set Division=? where id=?";
		try {
			PreparedStatement p=con.prepareStatement(sql);	
		    p.setString(1, Division);
			p.setInt(2, id1);
		
			int r=p.executeUpdate();
			if(r!=0) {
				System.out.println("update Successfull");
			}
			else {
				System.out.println("can not update");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void CheckId(int id) throws SQLException {
    String sql="select*from Sdetails where id="+id;
		
		try {
			
			PreparedStatement s=con.prepareStatement(sql);
			ResultSet result=s.executeQuery(sql);
			
			if(result.next()) {
			
				System.out.format("id exists");
				System.exit(id);
				}
			}catch(Exception e) {
			e.printStackTrace();
			}
		
	}

	
	

	

	


	

	

	}
