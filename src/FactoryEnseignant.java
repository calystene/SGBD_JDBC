import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class FactoryEnseignant {

	
	public FactoryEnseignant(int i, String n, String p) {
		
	}

	public static int existEnseignant(String prenom, String nom) {
		String sql = "SELECT IDENS, NOMENS, PRENOMENS FROM ENSEIGNANTS WHERE NOMENS='"+nom+"' AND PRENOMENS='"+prenom+"'";
		try {
			ResultSet rs = Connect.executeQuery(sql);
			
			rs.next();
			
			return rs.getInt("IDENS");
		} catch (SQLException e) {
			System.out.println("Erreur recherche enseignant " + prenom + " " + nom);
			System.exit(1);
		}
		return (Integer) null;
	}
}