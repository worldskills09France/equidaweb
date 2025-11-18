package database;

import model.Cheval;
import model.Proprietaire;
import model.Race;
import model.Robe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCheval {
	Connection cnx;
	/**
	 * Récupère tous les chevaux présents dans la base de données avec leurs races
	 * associées
	 * 
	 * @param cnx La connexion active à la base de données
	 * @return ArrayList<Cheval> La liste de tous les chevaux trouvés
	 */
	public static ArrayList<Cheval> getLesChevaux(Connection cnx) {
		ArrayList<Cheval> lesChevaux = new ArrayList<Cheval>();
		try {
			PreparedStatement requeteSql = cnx.prepareStatement(
					"SELECT c.id as c_id, c.nom as c_nom, c.date_naissance as c_bd, c.sire as c_sire, c.robe_id as c_robe_id, c.proprietaire_id as c_proprietaire_id, c.papa_id as c_papa_id, c.maman_id as c_maman_id, c.photo as c_photo, "
							+ "r.id as r_id, r.nom as r_nom " + "FROM cheval c "
							+ "INNER JOIN race r ON c.race_id = r.id");
			ResultSet resultatRequete = requeteSql.executeQuery();
			while (resultatRequete.next()) {
				Cheval c = setCheval(cnx, resultatRequete);
				lesChevaux.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La requête de getLesChevaux a généré une exception SQL");
		}
		return lesChevaux;
	}

	/**
	 * Récupère un cheval spécifique par son identifiant
	 * 
	 * @param cnx La connexion active à la base de données
	 * @param id  L'identifiant du cheval recherché
	 * @return Cheval Le cheval trouvé ou null si non trouvé
	 */
	public static Cheval getLeCheval(Connection cnx, int idCheval) {
		Cheval cheval = null;
		try {
			PreparedStatement requeteSql = cnx.prepareStatement(
					"SELECT c.id as c_id, c.nom as c_nom, c.date_naissance as c_bd, c.sire as c_sire, c.robe_id as c_robe_id, c.proprietaire_id as c_proprietaire_id, c.papa_id as c_papa_id, c.maman_id as c_maman_id, c.photo as c_photo, "
							+ "r.id as r_id, r.nom as r_nom " + "FROM cheval c "
							+ "INNER JOIN race r ON c.race_id = r.id " + "WHERE c.id = ?");
			requeteSql.setInt(1, idCheval);
			ResultSet resultatRequete = requeteSql.executeQuery();
			if (resultatRequete.next()) {
				cheval = setCheval(cnx, resultatRequete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La requête de getLeCheval a généré une exception SQL");
		}
		return cheval;
	}

	/**
	 * Ajoute un nouveau cheval dans la base de données
	 * 
	 * @param cnx    La connexion active à la base de données
	 * @param cheval Le cheval à ajouter
	 * @return boolean true si l'ajout a réussi, false sinon
	 */
	public static boolean ajouterCheval(Connection cnx, Cheval cheval) {
		try {
			PreparedStatement requeteSql = cnx.prepareStatement("INSERT INTO cheval (nom, date_naissance, race_id) VALUES (?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			requeteSql.setString(1, cheval.getNom());

			// Gestion de la date de naissance
			if (cheval.getDateNaissance() != null) {
				requeteSql.setDate(2, java.sql.Date.valueOf(cheval.getDateNaissance()));
			} else {
				requeteSql.setNull(2, java.sql.Types.DATE);
			}

			requeteSql.setInt(3, cheval.getRace().getId());

			int result = requeteSql.executeUpdate();

			if (result == 1) {
				// Récupération de l'id auto-généré
				ResultSet rs = requeteSql.getGeneratedKeys();
				if (rs.next()) {
					cheval.setId(rs.getInt(1));
				}
				return true;
			}
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur lors de l'ajout du cheval");
			return false;
		}
	}

	private static Cheval setCheval(Connection cnx, ResultSet resultatRequete) {
		Cheval cheval = null;
		try {
			cheval = new Cheval();
			cheval.setId(resultatRequete.getInt("c_id"));
			cheval.setNom(resultatRequete.getString("c_nom"));
			cheval.setDateNaissance(resultatRequete.getDate("c_bd").toLocalDate());
			cheval.setSire(resultatRequete.getString("c_sire"));

			Race race = new Race();
			race.setId(resultatRequete.getInt("r_id"));
			race.setNom(resultatRequete.getString("r_nom"));
			cheval.setRace(race);

			Robe robe = DaoRobe.getRobeById(cnx, resultatRequete.getInt("c_robe_id"));
			cheval.setRobe(robe);

			Proprietaire pro = DaoProprietaire.getProprietaireById(cnx, resultatRequete.getInt("c_proprietaire_id"));
			cheval.setProprietaire(pro);
			
			if(resultatRequete.getInt("c_papa_id") != 0) {
				cheval.setPapa(getLeCheval(cnx, resultatRequete.getInt("c_papa_id")));
			}
			if(resultatRequete.getInt("c_maman_id") != 0) {
				cheval.setMaman(getLeCheval(cnx, resultatRequete.getInt("c_maman_id")));
			}
			
			cheval.setPhoto(resultatRequete.getString("c_photo"));
			
			cheval.setCourse(DaoCourse.getCourseById(cnx, resultatRequete.getInt("c_id")));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cheval;
	}
}