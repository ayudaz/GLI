*********************************************************************************************************************
*																													*
*													SOLITAIRE														*
*										TP GLI - Thomas LELIEVRE / Florian LELOUP									*
*																													*
*********************************************************************************************************************


====== LANCEMENT DU SOLITAIRE =========

Il suffit d'éxécuter la classe 'Lanceur.java' du package 'Main'.


====== FONCTIONNALITES DU SOLITAIRE ========

- Ce qui fonctionne :

	Drag And Drop avec rétroaction sémantique : 
		* 	Changement des curseurs au déplacement
		*	Changement de couleur au survol d'élément droppable	
				Draggable : Cartes du PSabot, des PColonne
				Droppable : PColonne et PTasDeCartesColorées
		*	Message d'erreur lors du relachement d'une carte sur une PColonne qui ne peut pas recevoir la carte (non empilable)

	Actions avec le clic souris:
		*	Simple clic gauche permettant de retourner une carte non visible de la PColonne
		*	Simple clic gauche sur le sabot retourne les cartes (3 par défaut)
		*	Double clic gauche sur une carte d'une PColonne permet de l'envoyer dans le TasDeCartesColorées si l'action est possible
		*	Simple clic droit sur le fond du solitaire permettant d'envoyer toutes les cartes possibles vers le TasDeCartesColorées


	Menu permettant:
		*	De démarrer un nouvelle partie (avec raccourci clavier Ctrl+ N)
		*	De selectionner le nombre de cartes à tirer du sabot à chaque clic (au choix entre 1 et 3 cartes)
		*	D'activer ou non l'affichage des messages d'erreur lors du relachement d'une carte non empilable (décrit ci dessus)
		*	D'activer ou non les sons lors d'une tirage des cartes du sabot
		*	Aide : Explique les actions possibles pour l'utilisateur 
		*	A propos : Informations sur l'éditeur du logiciel... 


- Ce qui fonctionne mal :

	Indiquer qu'il y a des choses qui fonctionnent mal sur Mac (genre le drag & drop qui fonctionne pas du tout... :S) ??? <-------- Est-ce vraiment utile??


========= CHOIX DE CONCEPTION ========

	Architecture
		* 	Respecte le modèle PAC
		* 	Classes réparties selon 7 packages :
			- controle : Relatif aux controlleurs des différentes classes
			- presentation : Relatif à la présentation des différentes classes
			- listener : Relatif aux interactions utilisateurs via le clic souris
			- main : Relatif au lancement et à l'initialisation de l'application
			- retroaction : Relatif aux retroactions utilisateurs
			- utilitaire : 

	Patterns

		Différents patterns ont été mis en place dans cette application :

			Observer : Mis en place entre le CSolitaire et le CTasDeCartesColorees pour vérifier à chaque empilement de cartes si le joueur à gagner sa partie
			Decorator : Mis en place pour la rétroaction utilisateur. Permet de jouer les différents sons de retournement des cartes du sabot et d'afficher les messages d'erreur
			Factory : Couplé avec les différents décorateur il est en charge de la création des différentes rétroactions