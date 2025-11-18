package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Robe;

public class DaoRobe {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère toutes les robes présentes dans la base de données
     * @param cnx La connexion active à la base de données
     * @return ArrayList<Robe> La liste de toutes les robes trouvées
     */
    public static ArrayList<Robe> getLesRaces(Connection cnx) {
        ArrayList<Robe> lesRaces = new ArrayList<Robe>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle FROM robe ORDER BY libelle"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
            	Robe race = new Robe();
                race.setId(resultatRequete.getInt("id"));
                race.setLibelle(resultatRequete.getString("libelle"));
                lesRaces.add(race);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesRobes a généré une exception SQL");
        }
        return lesRaces;
    }

    /**
     * Récupère une robe spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la robe recherchée
     * @return Robe La robe trouvée ou null si non trouvée
     */
    public static Robe getRobeById(Connection cnx, int id) {
    	Robe race = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle FROM robe WHERE id = ?"
            );
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                race = new Robe();
                race.setId(resultatRequete.getInt("id"));
                race.setLibelle(resultatRequete.getString("libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getRobeById a généré une exception SQL");
        }
        return race;
    }
}
