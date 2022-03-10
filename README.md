# Compte-rendu


## Base de donnée
Nous avons d'abord crée une base de donnée simple comprenant matricule, login, mot de passe, nom, prénom dans une table, les secteurs donc les régions dans une autre et type agent qui défini si l'agent est visiteur ou comptable.



## Répartition des tâches:
Grâce à cette base, nous nous sommes réparti les tâches par fenêtre plutôt que par logiciel pour que chacun puisse utiliser chaque logiciel.

Hugo a effetcué la page d'authentification, pour se faire, il a utilisé Java avec Visual Studio Code, javaFX avec SceneBuilder et la base de donnée crée au dessus.
Il a donc d'abord crée un lien entre la base de données et le projet java afin de pouvoir en utiliser les informations (ligne 23-33 AuthentificationController.java). Il a ensuite crée sur JavaFx un fichier FXML qui servira d'interface graphique au système d'authentification. Il y a donc relié les zones de texte et le bouton à java (ligne 35-39 AuthentificationController.Java) afin d'en récuperer le contenu qui est entré et le fait coïncider avec la base de donnée. Si les données entrées sont mauvaise, il ne se passe rien, si elles correspondent à un visiteur, il est dirigé vers une page visiteur et si elles correspondent à un comptable il est dirigé vers une page comptable. (ligne 39-44 AuthentificationController.java). Il a ensuite crée des boutons pour se déplacer entre les fenêtres plus facilement (exemple ligne 10-16 VisiteurControlleur.java)
[- Authentification -](https://github.com/hugobaras/ap/blob/master/authentification.png)  [- Visiteur -](https://github.com/hugobaras/ap/blob/master/visiteur.png) [- Comptable -](https://github.com/hugobaras/ap/blob/master/camptable.png)

Ndoumbe a travaillé sur la fiche de remboursement de frais engagés, elle a utilisé Java, JavaFX, la base de donnée crée préalablement et également le dico de donnée réalisé afin de clarifier les données. Elle a d'abord crée un lien entre la base de données et le projet java puis a travaillé majoritairement sur l'aspect graphique de la fiche afin d'avoir une base propre pour pouvoir ensuite relier les champs de texte et les boutons aux champs associés dans la base de données aux actions qu'ils réalisent. 

De la même façon, Hiba a travaillé sur la fiche d'état des frais en utilisant le même procédé que Ndoumbe 


## Tableau Kanban
Nous avons réalisé un tableau Kanban simple composé de quatres parties comprennant: 
| Tâches | En cours | Test | Terminé |
|:-------|:---------|:----:|--------:|


[Tableau Kanban](https://trello.com/invite/b/rVH7JqII/04bb297fe96b548a5946309ef309775c/mod%C3%A8le-kanban)


## Conception et développement
* Java (VSCode)
* JavaFX (SceneBuilder)
* Mysql (MySQL Workbench)
* Gitbush
* GitHub
* Excel [- Dico de données FDR -](https://github.com/hugobaras/ap/blob/master/Dico%20de%20données.xlsx)
* 
### Difficulté rencontrée
Hiba et Ndoumbe ont eu des diffuculté avec la prise en main de SceneBuilder, celui-ci ayant une interface peu intuitive. Elles ont réussi à les surmonter à force de recherche par elles-mêmes ainsi que sur internet. 
Hugo a éprouvé des difficulté au début avec la connexion de la BDD, ce qu'il a reussi à résoudre par la suite. Il a également stagné pendant un moment sur la réalisation du code pour synchroniser les champs texte avec les données entrées, ce qu'il a reussi à faire grâce à des recherches et de l'aide extérieure.


## Annexe
[- MySQL -](https://github.com/hugobaras/ap/blob/master/gsb.sql)


## Bilan
Après avoir eu du mal à démarrer, dû aux lacunes de chacun, nous avons réussi à trouver notre rythme qui nous permettra d'aller au bout du projet. La prise en main des logiciels a été bien prise par tous. 

# Compte-rendu

## Répartition des tâches:
Hiba et Ndoumbe ont terminé la fiche de remboursement de frais engagées et la fiche d'état des frais.

Hugo, sur la page [- Visiteur -](https://github.com/hugobaras/ap/blob/master/visiteur.png), a réalisé le processus permettant de calculer le total des frais forfaitaires en récuprant le montant unitaire dans une base de donnée. Il a également intégré le nom du visiteur afin d'être sur qu'il soit connecté sur le bon compte. 
Il avance maintenant sur la base de données afin de créer une table "fiche" qui contiendra les données entrées dans les champs de frais forfaitaires afin que pouvoir les afficher lorsque le comptable sélectionnera un visiteur. 
