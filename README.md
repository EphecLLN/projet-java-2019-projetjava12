# CAHIER DE CHARGES   
*PROJET :  Réalisation du jeu Motus* 
      

## Membres du groupe ProjetJava12 :
* Patrick Tchoupe 
* Souhaïb Azzouz 
* Léon Servais 
  
## Présentation du projet  
### Contexte  
Pour le cours de Développement informatique avancé il nous a été demandé de réaliser comme projet soit une application utilitaire, soit un jeu en groupe de 3. 
Notre choix s’est porté sur la réalisation d’un jeu inspiré du célèbre jeu Motus. 
 
### Objectifs du projet  
Notre version de jeu proposera deux modes de jeu, partie solo ou multijoueur(1 vs 1 ). Le but du jeu reste le même que celui du jeu de base, deviner un mot à partir de sa première lettre et du nombre de lettres que comporte le mot. Le mode multijoueur devra pouvoir s’effectuer sur deux ordinateurs distants et le premier des deux joueurs qui atteint 5 points remportent la manche.  
 
## Contraintes du projet  
### Contrainte Technique  
* Le jeu doit pouvoir s’exécuter sur une interface console et une interface graphique 
* Le jeu doit comporter une communication réseau pour le mode multijoueur 
* Le jeu doit utiliser une structure de données du Framework Java Collection 

## Déroulement du projet   
### Planification   
* spécification : Durant cette étape nous allons redéfinir toutes les fonctionnalités attendues par notre jeu 
* Programmation : Ecriture du code des différents modules du jeu 
* Test Unitaire : Les tests unitaires devront être effectués pendant le développement pour s’assurer du bon fonctionnement de chaque module du jeu 
* L’intégration : Regroupement des différents modules du jeu après leurs validations par les membres de l’équipe  
* Test Global : Cette partie permet de s’assurer que toutes les fonctionnalités du jeu sont valides après l’intégration  

### Règles de jeu 
* Le joueur choisit au préalable son mode de jeu 
* La présence de deux joueurs pour le mode multijoueur est requise 
* Le mot proposé par le joueur doit être de même longueur que le mot à deviner 
* Le joueur a cinq tentatives pour trouver le bon mot 
* Lorsqu’une lettre du mot proposé par le joueur se trouve dans le mot à deviner, celle-ci est coloriée en Jaune, si la lettre est à la bonne place dans le mot à deviner, elle est coloriée en rouge et se trouve dans la proposition suivante. 
* Le nombre de points marqués est égale au nombre de tentatives restantes 
* Le premier des deux joueurs à atteindre 5 points remporte la partie. 
 
## Description des besoins fonctionnels 
### Interface graphique 
* Un champ de saisie pour récupérer la proposition du joueur et un bouton de soumission  
* Message d’erreur au cas où la longueur du mot proposé par le joueur est inférieure ou supérieure à la longueur du mot à deviner  
* Coloration des bonnes lettres se trouvant dans le mot à deviner. 
 
### Interface console 
Récupération de la proposition du joueur 
Message d’erreur au cas où la longueur du mot proposé par le joueur est inférieure ou supérieure à la longueur du mot à deviner
