# MEDHEAD - PoC - PROJET DU SYSTÈME D'INTERVENTION D'URGENCE

Cette PoC a été développée en **Java** en s'appuyant sur le framework **Spring**. Elle est fonctionnelle et peut-être testée manuellement sur **Postman**.

Les données sont stockées dans une base de données **MySql** et sont persistantes grâce à **JPA**.
Le schéma de la base de donnée ainsi que les données de base sont définies dans les fichiers [schema.sql](https://github.com/NicoRego/OC_P11_code/blob/main/src/main/resources/schema.sql) et [data.sql](hhttps://github.com/NicoRego/OC_P11_code/blob/main/src/main/resources/data.sql) et sont à exécuter avec utilisation des requêtes Postman. 
L'ensemble des requêtes de base utilisables avec Postman sont définies dans [POC API.postman_collection.json](https://github.com/NicoRego/OC_P11_code/blob/main/POC%20API.postman_collection.json). Ce fichier peut être importé dans Postman et nécessite Postman Agent sur le serveur où l'applicaiton est exécutée.

L'intégration continue est inclue dans le projet et s'appuie sur un pipeline **Jenkins** dont la descrption et la configuration se trouvent ici : décrit dans [configuration_pipeline_cicd.md](https://github.com/NicoRego/OC_P11_code/blob/main/configuration_pipeline_cicd.md).

Les tests sont inclus dans le projet et génèrent un rapport d'exécution **Jacoco** (à retrouver sur le serveur où Jenkins est exécuté : /target/site/jacoco/index.html).
