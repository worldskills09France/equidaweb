package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.CourseCheval;

public class DaoCourse {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère un propriétaire spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la robe recherchée
     * @return Proprietaire Le Proprietaire trouvé ou null si non trouvé
     */
    public static List<CourseCheval> getCourseById(Connection cnx, int id) {
    	List<CourseCheval> races = new ArrayList<CourseCheval>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, prix, date, classement, ville, temps FROM course INNER JOIN course_cheval ON course_cheval.id_course = course.id WHERE course_cheval.id_cheval = ?"
            );
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Course race = new Course();
                race.setId(resultatRequete.getInt("id"));
                race.setPrix(resultatRequete.getString("prix"));
                race.setDate(resultatRequete.getDate("date").toLocalDate());
                race.setVille(resultatRequete.getString("ville"));
                race.setTemps(resultatRequete.getString("temps"));
                
                CourseCheval cc = new CourseCheval();
                cc.setCourse(race);
                cc.setClassement(resultatRequete.getInt("classement"));
                races.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getCourseById a généré une exception SQL");
        }
        return races;
    }
}
