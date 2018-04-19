package pokemon;

import java.util.Scanner;

public class Joueur extends Dresseur {
	protected int nbVictoire;
	
	public Joueur(String nom, int x, int y) {
		super(nom, x, y);
		// TODO Auto-generated constructor stub
	}

	public Joueur(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public Joueur(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Joueur() {
		// TODO Auto-generated constructor stub
	}
	//Lire les attaques à partir du clavier pour faire le combat
	public String lireAttaqueClavier(Pokemon attaquant){
		attaquant.afficheAttaques(); //Afficher les attaque de l'attaquant (pokemon du joueur)
		//saisie clavier
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez une attaque : ");
	    String str = sc.nextLine();      
	    if(attaquant.estAttaque(str)){
	    	System.out.println("Vous avez choisis: "+str);
	    	return str;
	    }
	    else{
	    	System.out.println("L'attaque n'existe pas dans la liste");
	    	return lireAttaqueClavier(attaquant);
	    }
	}
	//Combat Joueur vs Dressuer
	public boolean combat(Dresseur adversaire){
		System.out.println (this + " affronte " + adversaire);
		boolean termine = false;
		int pokemonNum = 0, pokemonNumAdv = 0;
		Dresseur vainqueur = null;
		while (!termine) {
			String attlu=lireAttaqueClavier(pokemons[pokemonNum]);
			Pokemon.combat(pokemons[pokemonNum], adversaire.pokemons[pokemonNumAdv],attlu, adversaire.pokemons[pokemonNumAdv].attaqueAleatoire());
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
				adversaire.vaincu=true;
				this.nbVictoire++;
				}
			}
			infirmerie();
			adversaire.infirmerie();
			if (vainqueur == null) {
				System.out.println ("Egalite !");
			}
			else {
				System.out.println ("Victoire de " + vainqueur + " !");
			}
			return vainqueur==this; //return true si le joueur a gagné false sinon
		}	
}
	
