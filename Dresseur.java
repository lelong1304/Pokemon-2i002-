package pokemon;


	public class Dresseur {
		protected int x,y; //coordonnées du dresseur dans le monde
		protected String nom; //nom du dresseur
		protected Pokemon [] pokemons; //Les pokémons du dresseur
		protected int nbPokeballs; // Nb Pokeballs du dresseur
		protected int nbPokemons; // Nb pokémons du dresseur
		protected static int nbDresseurs = 0; // Nb de dresseur 
		protected boolean vaincu; //True si on l'a déjà vaincu false sinon
		protected int nbValides; //
		public Dresseur (String nom, int x, int y) {
			this.nom = nom;
			pokemons = new Pokemon[10];
			nbPokeballs = 10;
			nbPokemons = 0;
			this.x = x;
			this.y = y;
			nbDresseurs++;
			vaincu = false;
			//capturePokemons(3);
			nbValides = nbPokemons;
		}
		/*public Dresseur (int x, int y, int niveau) {
		this("Dresseur"+(nbDresseif (vainqueur==this) return false;urs), x, y);
		}*/
		
		//Constructeurs de Dresseurs
		public Dresseur (String nom) {
		this(nom, 0, 0);
		}
		public Dresseur (int x, int y) {
		this("Dresseur"+(nbDresseurs), x, y);
		}
		public Dresseur () {
		this("Dresseur"+(nbDresseurs));
		}
		//Methode pour ajouter un pokémon à un dresseur
		public void ajouterPokemon(Pokemon p){ 
			if (this.nbPokemons<this.pokemons.length){
				this.pokemons[this.nbPokemons]=p;
				this.nbPokemons++;
			}
		}
		//Capture tableau de pokémon 
		public void capturePokemons (Pokemon [] nouveauxPokemons) {
		for (int pokemonNum=0; pokemonNum<nouveauxPokemons.length; pokemonNum++) {
		if (nbPokemons == 10 || nbPokeballs == 0) {
		break;
		}
		pokemons[nbPokemons] = nouveauxPokemons[pokemonNum];
		nbPokemons++;
		nbValides++;
		}
		}
		//Capture un nb de pokemons 
		public void capturePokemons (int nbPokemons) {
		Pokemon [] nouveauxPokemons = new Pokemon[nbPokemons];
		for (int n=0; n<nbPokemons; n++) {
			
		nouveauxPokemons[n] = Pokemon.pokemonAleatoire(); /*Pokemon.pokemonAleatoire();*/
		}
		capturePokemons(nouveauxPokemons);
		}
		//Methode infirmerie pour soigner un pokémon
		public void infirmerie () {
		for (int pokemonNum=0; pokemonNum<nbPokemons; pokemonNum++) {
			if (pokemons[pokemonNum]!=null) {
				pokemons[pokemonNum].soigner();
			}
		}
		nbValides = nbPokemons;
		}
		// Getter du nom du joueur
		public String toString () {
		return nom;
		}
		
		//La methode combat n'est plus une méthode de dresseur mais elle est dans joueur
		
		/*public void combat (Dresseur adversaire) {
			System.out.println (this + " affronte " + adversaire);
			boolean termine = false;
			int pokemonNum = 0, pokemonNumAdv = 0;
			Dresseur vainqueur = null;
			while (!termine) {
				Pokemon.combat(pokemons[pokemonNum], adversaire.pokemons[pokemonNumAdv],pokemons[pokemonNum].attaqueAleatoire(), adversaire.pokemons[pokemonNumAdv].attaqueAleatoire());
				if (pokemons[pokemonNum].estKO()) {
					pokemonNum++;
				}
				if (adversaire.pokemons[pokemonNumAdv].estKO()) {
					pokemonNumAdv++;
				}
				if (pokemonNum == nbPokemons) {
					termine = true;
					if (pokemonNumAdv != adversaire.nbPokemons) {
						vainqueur = adversaire;
					}
				}
				else if (pokemonNumAdv == adversaire.nbPokemons) {
					termine = true;
					vainqueur = this;
					}
				}
				infirmerie();
				adversaire.infirmerie();
				if (vainqueur == null) {
					System.out.println ("Egalite !");
				}
				else {
					System.out.println ("Victoire de " + vainqueur + " !");
				}
		}*/	

}
