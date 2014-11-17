import java.sql.ResultSet;
import java.sql.SQLException;


public class CC {
	ResultSet rs;
	
	CC (int idCC) {
		String sql;
		
		try {
			sql = "Select IDCC, IDENS, IDEC, TYPECC, SSTYPECC, NOTEMAX FROM CC WHERE IDCC=" + idCC;
			
			rs = Connect.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("CC inconnue ou CC en équipe");
			System.exit(1);
		}
	}
	
	public ResultSet getCC() {
		return rs;
	}
	
	public boolean checkEnseignant (int idens) {
		try {
			System.out.println("CheckEns");
			/* Trouver le moyen de retourner au début du resultSet */
			
			while(rs.next()) {
				System.out.println(rs.getInt("IDENS"));
				if(rs.getInt("IDENS")==idens) 
					return true;
			}
		} catch (SQLException e) {
			System.out.println("Enseignant non reconnu par l'UE");
			System.exit(1);
		}
		
		return false;
	}
}
