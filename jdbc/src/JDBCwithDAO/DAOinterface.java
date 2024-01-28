package JDBCwithDAO;

import java.sql.SQLException;

public interface DAOinterface {
	
	
	public void CheckId(int id) throws SQLException;
	
	public void showAllDetails() throws SQLException;
	
	public void SHowOnId(int id2) throws SQLException;
	
	public void UpdateSdetails(int id1,String Division) throws SQLException;

	public void createSdetails(Sdetails sd);

	
	
	
	
	
	

}
