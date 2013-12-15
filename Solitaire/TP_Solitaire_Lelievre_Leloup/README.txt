*********************************************************************************************************************
*														    *														*
*							SOLITAIRE						    *							*
*					TP GLI - Thomas LELIEVRE / Florian LELOUP				    *					*
*														    *															*
*********************************************************************************************************************


========= LANCEMENT DU SOLITAIRE ===========

Il suffit d'exécuter la classe 'Lanceur.java' du package 'Main' ou de lancer le jar.


====== FONCTIONNALITES DU SOLITAIRE ========

- Ce qui fonctionne :

	Drag And Drop avec rétroaction sémantique : 
		* 	Changement des curseurs au déplacement
		*	Changement de couleur au survol d'élément droppable	
				Draggable : Cartes du PSabot, des PColonne
				Droppable : PColonne et PTasDeCartesColorées
		*	Message d'erreur lors du relâchement d'une carte sur une PColonne qui ne peut pas 
				recevoir la carte (non empilable)

	Actions avec le clic souris:
		*	Simple clic gauche permettant de retourner une carte non visible de la PColonne
		*	Simple clic gauche sur le sabot retourne les cartes (3 par défaut)
		*	Double clic gauche sur une carte d'une Colonne ou du sabot permet de l'envoyer dans 
				le TasDeCartesColorées si l'action est possible
		*	Simple clic droit sur le fond du solitaire permettant d'envoyer toutes les cartes 
				possibles vers le TasDeCartesColorées


	Menu permettant:
		*	De démarrer une nouvelle partie (avec raccourci clavier Ctrl+ N)
		*	De sélectionner le nombre de cartes à tirer du sabot à chaque clic (au choix entre 1 	
				et 3 cartes)
		*	D'activer ou non l'affichage des messages d'erreur lors du relâchement d'une 
				carte non empilable (décrit ci dessus)
		*	D'activer ou non les sons lors des déplacements des cartes sur le jeu
		*	Aide : Explique les actions possibles pour l'utilisateur 
		*	A propos : Informations sur l'éditeur du logiciel 


- Ce qui fonctionne mal :
	Le dragExit sur le PTasDeCartesColorées n'est pas déclanché lorsque l'on drop une mauvaise carte 
		sur le PTasDeCartesColorées du coup le fond de celui-ci reste rouge.



========= CHOIX DE CONCEPTION ========

	Architecture
		* 	Respecte le modèle PAC
		* 	Classes réparties selon 7 packages :
			- controle : Relatif aux contrôleurs des différentes classes
			- presentation : Relatif à la présentation des différentes classes
			- listener : Relatif aux linsteners pour les interactions utilisateurs
			- main : Relatif au lancement et à l'initialisation de l'application
			- retroaction : Relatif aux rétroactions utilisateurs au niveau du son et du message d'erreur
			- utilitaire : Relatif aux utilitaires permettant certains comportements

	Patterns

		Différents patterns ont été mis en place dans cette application :

			Observer : Mis en place entre le CSolitaire et le CTasDeCartesColorees pour vérifier 
				à chaque empilement de cartes si le joueur a gagné sa partie.
			Decorator : Mis en place pour la rétroaction utilisateur. Permet de jouer les différents 
				sons de retournement des cartes du sabot et d'afficher les messages d'erreur en les cumulant et sans avoir à toucher aux classes de présentations.
			Factory : Couplé avec les différents décorateurs, il est en charge de la création des 
				différentes rétroactions.

	Factorisation
		- Nous avons décidé de ne pas faire de classes internes pour les listeners afin de rendre le 
			code plus lisible, de plus cela permet de réutiliser ces listeners à d'autres endroits
		- Nous avons factorisé le code de gestion du Drag and Drop dans une classe dédié dont héritent 
			PColonne et PSabot afin d'éviter la duplication de code. Malheureusement, nous n'avons 
			pas pu faire hériter PTasDeCartesColorées de cette classe car nous avions besoin d'hérité 
			de PTasDeCartes, du coup nous avons du code dupliqué entre DrapAndDrop et PTasDeCartesColorees.