package pokemon;

	public abstract class Pokemon {
		protected static int aleaNum = 1; //Pour la création d'un pokémon aleatoire
		protected String nom; //Nom du pokémon
		protected int pvmax; // points de vie max du pokémon 
		protected int niveau, pv, attaque; //niveau ,points de vie, degats de base du pokemon 
		protected String [] attaquesDisponibles; //Tableau dans lequel on stock les attaques d'un pokémon
		protected int nbAttaques; //Nombre d'attaque d'un pokémon
		protected double multiplicateur; //Sera utile quand on aura un type de pokemon plus fort / plus faible qu'un autre ou pour des attaques speciales
		protected int paralyse; //Nb de tours qd le pokémon est paralysé
		protected int x, y; // coordonnée du pokémon
		
		//Constructeurs de pokémons
		public Pokemon (String nom, int pvmax, int attaque, int x, int y) {
		this.nom = nom;
		this.pvmax = pvmax;
		pv = pvmax;
		niveau = 1;
		this.attaque = attaque;
		attaquesDisponibles = new String[5];
		attaquesDisponibles[0] = "defaut";
		nbAttaques = 1;
		multiplicateur = 1.0;
		paralyse = 0;
		}
		public Pokemon (String nom, int pvmax, int attaque) {
		this(nom, pvmax, attaque, 0, 0);
		}
		public Pokemon () { 
		this("Anonyme"+aleaNum, 100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
		aleaNum++;
		}
		
		/*Test pour capturer un pokémon aléatoire dans la classe dresseurs (pour la question 11)*/
		public static Pokemon pokemonAleatoire () {
			/*Pokemon p;
			p.nom = "Anonyme";
			p.pvmax = 100+(int)(Math.random()*100);
			p.attaque = 40+(int)(Math.random()*100);
			p.pv = p.pvmax;
			p.niveau = 1;
			p.attaquesDisponibles = new String[5];
			p.attaquesDisponibles[0] = "defaut";
			p.nbAttaques = 1;
			p.multiplicateur = 1.0;
			p.paralyse = 0;*/
			return null;
		}
		//Getter niveau du pokémon
		public int getNiveau() {
		return niveau;
		}
		//Return true si un pokémon est KO false sinon
		public boolean estKO () {
		return pv <= 0;
		}
		//Remet les pv à 0 (éviter les pv négatifs) et multiplicateur à 1
		public void perdu () {
		pv = 0;
		multiplicateur = 1;
		}
		//Soigner le pokémon (remettre ces pv à pvmax)
		public void soigner () {
		pv = pvmax;
		}
		//Dans les types des pokémons
		public boolean fortContre (Pokemon adversaire) {
			
			return false;
		}
		public boolean faibleContre (Pokemon adversaire) {
		
		return false;
		}
		//Getter du tableau d'attaques
		public String [] getAttaquesDisponibles() {
		return attaquesDisponibles.clone();
		}
		//Afficher les attaques d'un pokémon
		public void afficheAttaques () {
		String s = "";
		for (int i=0; i< this.nbAttaques; i++)
		s += i + "        \t";
		System.out.println (s);
		s = "";
		for (String attaque : attaquesDisponibles)
			if (attaque!=null){
				s += attaque + "\t";
			}
		System.out.println (s);
			
		}
		//M abstract : Dans les classes des pokémons 
		public abstract void talent ();
		
		//Recevoir une attaque et perdre des points de vies
		public void subire (Pokemon adversaire, int degats) {
		pv -= degats;
		if (pv < 0)
		pv = 0;
		System.out.println (this.nom + " subit " + degats + " ! ");
		}
		//Attaque un pokémon (mettre le multiplicateur a 2 si il est de type plus fort a 0.5 si il est de type plus faible et appeler la méthode subire)
		public void attaque (Pokemon adversaire) {
		double multiplicateurAvantage = 1;
		if (fortContre(adversaire)) {
		multiplicateurAvantage = 2;
		}
		else if (faibleContre(adversaire)) {
		multiplicateurAvantage = 0.5;
		}
		System.out.println ("\t\t" + this + " attaque avec un multiplicateur de " +  //Remettre sur 1 ligne
		multiplicateur*multiplicateurAvantage + " : " + attaque*multiplicateur*multiplicateurAvantage + " !");
		adversaire.subire(this, (int)(attaque * multiplicateur * multiplicateurAvantage));
		multiplicateur = 1;
		}
		/*
		* Methode pour le choix de l'attaque.
		* Dans les sous-classes, surcharger (en utilisant le mot-clef super),
		* puis rajouter les autres choix possibles.
		*/
		public void attaque (Pokemon adversaire, String choixAttaque) {
		System.out.print ("\t\t\t\tAttaque " + choixAttaque + " ! ");
		if (choixAttaque.equals("defaut"))
		attaque(adversaire);
		}
		//Si une attaque existe dans le tableau des attaques
		public boolean estAttaque(String attaque){
			for (int i=0;i<this.nbAttaques;i++)
				if (this.attaquesDisponibles[i].equals(attaque)){
					return true;
				}
			return false;
		}
		//Combat entre deux pokémons 
		public static void combat (Pokemon p1, Pokemon p2, String attaque1, String attaque2) {
		// Appliquer les talents
			p1.talent(); p2.talent();
		// Tester si tout le monde peut attaquer
		// Lancer les attaques simultanees
			boolean at1=p1.estAttaque(attaque1);
			boolean at2=p2.estAttaque(attaque2);
			
			if (p1.paralyse>0) {
				at1=false; p1.paralyse--;
			}
			if (p2.paralyse>0){
				at2=false; p2.paralyse--;
			}
			
			if (!at1){
				System.out.println(p1.getNom()+"ne peut pas attaquer");
			} else p1.attaque(p2, attaque1);
			if (!at2){
				System.out.println(p2.getNom()+"ne peut pas attaquer");
			} else p2.attaque(p1, attaque2);	
				
		
			
		// Tester les KO
		// Appliquer les resultats
			if (p1.estKO() && p2.estKO()){ 
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p1.perdu(); p2.perdu();
			}
			else{
				if(p1.estKO()){
					p2.gagnerNiveau();
					p1.perdu();
				}
				else{
					if (p2.estKO()){
						p1.gagnerNiveau();
						p2.perdu();
					}
				}
			}
		}
		//Gagner un niveau après avoir vaincu un pokémon
		public void gagnerNiveau() {
		niveau++;
		pvmax += 20;
		pv += pvmax/2;
		if (pv > pvmax) {
		pv = pvmax;
		}
		attaque += 10;
		System.out.println (this.nom + " passe au niveau " + niveau + " !");
		}
		//Changer le nom d'un pokémon
		public void changerNom (String nouveauNom) {
		nom = nouveauNom;
		}
		//Affiche les statistiques des pokémons
		public String toString() {
		return nom + " (" + pv + "/" + pvmax + "pv, " + attaque + " att)";
		}
		//Getter du nom;
		public String getNom() {
		return nom;
		}
		/*
		* Affichage du style : "Bulbizarre Jean-Claude".
		* A surcharger dans les sous-classes.
		*/
		public String getId() {
		return "Pas d'espece ! " + nom;
		}
		//retourne une attaque aléatoire dans le tableau d'attaques
		public String attaqueAleatoire(){
			int i=(int) (Math.random()*nbAttaques);
			return this.attaquesDisponibles[i];
		}
		// Ajouter une attaque au tableau
		public void ajouterAttaque(String attaque){
			if (this.nbAttaques<this.attaquesDisponibles.length){
				this.attaquesDisponibles[this.nbAttaques]=attaque;
				this.nbAttaques++;
			}
		}
	}

