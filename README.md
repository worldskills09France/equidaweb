Application de gestion de vente aux enchères de chevaux de courses pour la société Equida.
Développée en Java EE avec Mariadb, jdk 1.21, Tomcat 10, Eclipse

## Fonctionnalités
- 🔍 Liste des chevaux
- 🗂️ Consulter un cheval
- 📊 Ajouter un cheval

## Technologies
- Java 21
- JEE
- Mariadb
- Tomcat 10
- Maven

## Installation
- Cloner le projet EquidaWeb depuis https://github.com/worldskills09France/equidaweb.git
- Sous Mariadb, créer une base de données nommée equida
- Importer le script sql dans le dossier src/main/java/database et exécutez le dans la base créée précédemment
- Faites un build maven pour récupérer le .war
- Mettre le .war dans les webapps Tomcat version 10
- Lancez et testez l'application :     http://localhost:8080/equidaweb/
