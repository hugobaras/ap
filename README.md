# Compte-rendu


## Base de donnée
Nous avons d'abord crée une base de donnée simple comprenant matricule, login, mot de passe, nom, prénom dans une table, les secteurs donc les régions dans une autre et type agent qui défini si l'agent est visiteur ou comptable.



## Répartition des tâches:
Grâce à cette base, nous nous sommes réparti les tâches par fenêtre plutôt que par logiciel pour que chacun puisse utiliser chaque logiciel.

Hugo a effetcué la page d'authentification, pour se faire, il a utilisé Java avec Visual Studio Code, javaFX avec SceneBuilder et la base de donnée crée au dessus.
Il a donc d'abord crée un lien entre la base de données et le projet java afin de pouvoir en utiliser les informations (ligne 23-33 AuthentificationController.java). Il a ensuite crée sur JavaFx un fichier FXML qui servira d'interface graphique au système d'authentification. Il y a donc relié les zones de texte et le bouton à java (ligne 35-39 AuthentificationController.Java) afin d'en récuperer le contenu qui est entré et le fait coïncider avec la base de donnée. Si les données entrées sont mauvaise, il ne se passe rien, si elles correspondent à un visiteur, il est dirigé vers une page visiteur et si elles correspondent à un comptable il est dirigé vers une page comptable. (ligne 39-44 AuthentificationController.java). Il a ensuite crée des boutons pour se déplacer entre les fenêtres plus facilement (exemple ligne 10-16 VisiteurControlleur.java)
[authentification](https://github.com/hugobaras/ap/blob/master/authentification.png)  [visiteur](https://github.com/hugobaras/ap/blob/master/visiteur.png) [comptable](https://github.com/hugobaras/ap/blob/master/camptable.png)

Ndoumbe a travaillé sur la fiche de remboursement de frais engagés, elle a utilisé Java, JavaFX, la base de donnée crée préalablement et également le dico de donnée réalisé afin de clarifier les données. Elle a d'abord crée un lien entre la base de données et le projet java puis a travaillé majoritairement sur l'aspect graphique de la fiche afin d'avoir une base propre pour pouvoir ensuite relier les champs de texte et les boutons aux champs associés dans la base de données aux actions qu'ils réalisent. 

De la même façon, Hiba a travaillé sur la fiche d'état des frais en utilisant le même procédé que Ndoumbe 
