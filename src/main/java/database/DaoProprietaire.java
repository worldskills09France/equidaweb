package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Proprietaire;

public class DaoProprietaire {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère un propriétaire spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la robe recherchée
     * @return Proprietaire Le Proprietaire trouvé ou null si non trouvé
     */
    public static Proprietaire getProprietaireById(Connection cnx, int id) {
    	Proprietaire race = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, nom FROM proprietaire WHERE id = ?"
            );
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                race = new Proprietaire();
                race.setId(resultatRequete.getInt("id"));
                race.setNom(resultatRequete.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getProprietaireById a généré une exception SQL");
        }
        return race;
    }
}
