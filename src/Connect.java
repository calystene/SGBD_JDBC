import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	static Connection c=null;
	
	private Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora",
					"labbe", "sebastien");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static public Connection getInstance() {
		if(c!=null) {
			return c;
		}
		
		new Connect();
		return c;
	}
	
	static public ResultSet executeQuery (String sql) throws SQLException {
		Statement s;
		s = Connect.getInstance().createStatement();
		
		return s.executeQuery(sql);
	}

	
	/*
	public static void main(String[] args){
		Connection c = null;
		Statement statement_select = null;
		Statement statement_insert = null;
		
		try {

			statement_select = c.createStatement();
			statement_insert = c.createStatement();
			String sql = "SELECT PROF_EC.IDENS,PROF_EC.IDEC "
					+ " FROM PROF_EC " + "JOIN EC ON PROF_EC.IDEC = EC.IDEC "
					+ "JOIN UE ON EC.IDUE = UE.IDUE "
					+ "WHERE UE.formation = 'M1MIAGE14' "
					+ "AND UE.sem = 's1' ";
			System.out.println(sql);
			
			ResultSet resultat = statement_select.executeQuery(sql);

			while (resultat.next()) {

				String insertTableSQL = "INSERT INTO CC"
						+ "(IDENS,IDEC,TYPECC,SSTYPECC,NOTEMAX) " + "VALUES"
						+ "( " + resultat.getInt("IDENS") + ","
						+ resultat.getInt("IDEC") + ",'examen','s1',40)";
				statement_insert.executeUpdate(insertTableSQL);
				System.out.println(insertTableSQL);

				
				String insertTableSQL2 = "INSERT INTO CC" +
				 "(IDENS,IDEC,TYPECC,SSTYPECC,NOTEMAX) " + "VALUES" + "(" +
				 resultat.getInt("IDENS") + "," + resultat.getInt("IDEC") +
				 ",'examen','s2',40)";
				 statement_insert.executeUpdate(insertTableSQL2);
				
				 
				 System.out.println(insertTableSQL2);
			}

			resultat.close();

		} catch (ClassNotFoundException cnf) {

		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		
	}
	*/
}