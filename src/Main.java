import java.sql.SQLException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String saisie = new String();
		CC cc;
		int idEns;
		
		System.out.println("--------------- Début du programme -----------------");
		System.out.println("Saisir l'id d'un CC");
		
		saisie = scan.nextLine();
		
		/* la verif de l'existence du cc se fait à sa création */
		cc = new CC(Integer.parseInt(saisie));
		
		try {
			cc.getCC().next();
			System.out.println("Type CC : " + cc.getCC().getString("TYPECC"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		idEns = FactoryEnseignant.existEnseignant("Francis", "Bossut");
		
		System.out.println(cc.checkEnseignant(idEns));
		
	}

}
