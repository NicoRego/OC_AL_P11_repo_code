# Configuration du pipeline CI/CD

1. Installer [Jenkins](http://jenkins.io/download/)
2. Lancer le service Jenkins avec la commande `java -jar jenkins.war`
3. Se connecter sur http://127.0.0.1:8080 pour accèder au tableau de bord sur votre serrveur local (changer l'IP dans le cas d'un serveur distant)
4. Assurez-vous que les plugins et outils suivants sont bien installés, activés et/ou configurés:
   1. Docker Plugin
   2. GitHub plugin
   3. Maven 3.9.1 (minimum)
   4. JDK 17 (minimum)
5. Créer un nouveau job
   1. Cliquer sur **"Nouveau Item"**
   2. Saisir un nom pour le pipeline
   3. Cliquer sur l'option **"Pipeline"** puis sur le bouton **OK**
6. Configurer le pipeline
    1. Dans l'onglet **"General"**, aller sur la rubrique **"Pipeline"**
    2. Dans la liste déroulante **"Definition"**, sélectionner **"Pipeline script from SCM"**
    3. Dans la liste déroulante **"SCM"**, sélectionner **"Git"**
    4. Dans le champ **"Repository URL"**, saisir l'URL du projet sur Github ("https://github.com/NicoRego/OC_P11_repo_code.git")
    5. Dans le champ **"Branch Specifier (blank for 'any')"**, saisir la branche du projet ("*/master")
    6. Dans le champ **"Script Path"** saisir "Jenkinsfile"
    7. Cliquer sur le bouton **Sauver**
7. Lancer le pipeline en cliquer sur **"Lancer build"**
8. Cliquer sur le numéro du build pour consulter les détails sur résultat du build
9. Utiliser l'option **"Pipeline Steps"** pour avoir une visualisation ordonnancée et lisible des résultats de chaque étape du build

