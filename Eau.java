package pokemon;

public class Eau extends Pokemon {

	public Eau(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Eau(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Eau() {
		// TODO Auto-generated constructor stub
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if (choixAttaque.equals("Hydroblast")){
			//2% de chance que le pokémon rate l'attaque Hydroblast.
			if(Math.random()<=0.2){
				System.out.println("L'attaque Hydroblast a échoué T-T");
				return;
			}
			this.multiplicateur=2.2; // Si le pokémon ne la rate pas. Hydroblast fait 220% de dégats on augmente le multiplicateur.
			this.attaque(adversaire); //On attaque l'adversaire 
			this.paralyse=1; // L'attaque paralyse le pokémon pour un tour (il ne peut pas attaquer au tour suivant)
			System.out.println(adversaire.nom + "est paralysé pour 1 tour.");
		}
		else{
			//On fait une attaque normal si choixattaque!=Hydroblast (sans augmenter les degats)
			this.attaque(adversaire);
		}
		
	}
	
	public boolean fortContre (Pokemon adversaire) {
		return ( (adversaire instanceof Feu ) || (adversaire instanceof Terre )); //Eau fort contre feu et terre
	}
	public boolean faibleContre (Pokemon adversaire) {
		return ( (adversaire instanceof Eau ) || (adversaire instanceof Herbe ) || (adversaire instanceof Electricite )); //Eau faible contre electricite,eau et herbe
	}
	@Override
	public void talent() {
		// TODO Auto-generated method stub

	}

}
