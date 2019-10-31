# Projet OpenClassrooms n°3 : Mettez votre logique à l'épreuve

L'objectif est de réaliser une fonctionnalité d'un escape game : trouver une combinaison secrète.
Il y a 3 modes de jeu : 
- Le mode challenger
- Le mode defender
- Le mode duel

### Mode challenger 

L'intelligence artificielle jour le rôle de défenseur : elle définit une combinaison de X chiffres aléatoirement.
Le joueur joue le rôle d'attaquant et a donc pour objectif de trouver la combinaison de l'IA.
Pour chaque chiffre de la combinaison proposée par le joueur, l'IA indique si le chiffre de la combinaisons secrète
est plus grand, plus petit ou si c'est le bon. 

### Mode defender

Le joueur joue le rôle du défenseur et définit une combinaison secrète.
L'intelligence artificielle joue le rôle d'attaquant et doit faire des propositions de combinaisons.
Le joueur indique pour chaque chiffre proposé par l'IA si le chiffre de sa combinaison est plus petit, plus grand 
ou égal.

### Mode duel

Le joueur et l'IA sont à la fois attaquant et défenseur. Le premier qui trouve la combinaison de l'autre à gagné.
## 
## Spécifications 

- Interface console
- Au démarrage l'utilisateur choisit un mode
- L'utilisateur joue. S'il perd, l'application affiche la solution
- A la fin de la partie, l'utilisateur peut choisir de rejouer au même mode, de lancer un autre mode ou de 
quitter l'application
- Utiliser la POO
- Un fichier de configuration doit contenir les paramètres de l'application (nombre de chiffres dans la combinaison, 
nombre d'essais, mode développeur activé ou non)
- Un mode développeur doit pouvoir être activé via un paramètre et permet d'afficher la solution dès le début du jeu.
- Un fichier de configuration (log4j.xml) permettra de paramétrer les logs de l'application. Gestion des logs avec Apache Log4j
- Le code doit être disponible sur GitHub, il doit être indenté et commenté. 
## 
## Compiler et lancer l'application
