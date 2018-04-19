package pokemon;

public class Herbe extends Pokemon {
	private static int cpt =0; //compteur pour Végé-attaque
	public Herbe(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Herbe(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque); 
		// TODO Auto-generated constructor stub
	}

	public Herbe() {
		// TODO Auto-generated constructor stub
	}
	public void attaque(Pokemon adversaire, String choixAttaque){
		if (choixAttaque.equals("végé-attaque") && cpt==0){ 
			//cpt=0 quand on appelle vegeattaque la première fois (on augmente juste le multiplicateur)
			multiplicateur = 2.5;
			System.out.println("l'attaque au prochain tour de " +this.nom+ " a augmenté!");
			cpt++;
			return;
		}
		if (cpt==1){ //?
			//cpt=1 quand on appelle attaque juste après vegeattaque (on attaque avec les degats qui ont augmenté)
			this.attaque(adversaire);
			cpt=0; //On remet cpt=0 pour pouvoir passer une autre fois par vege-attaque si on le souhaire. 
			return;
		}
		if (!choixAttaque.equals("végé-attaque")){
			this.attaque(adversaire);
			// On attaque sans augmenté les degats dans le cas ou c'est une autre attaque que vege-attaque.
		}
	}
	public boolean fortContre (Pokemon adversaire) {
		return ( (adversaire instanceof Eau ) || (adversaire instanceof Terre )); //Herbe fort contre Eau et Terre
	}
	public boolean faibleContre (Pokemon adversaire) {
		return ( (adversaire instanceof Feu ) || (adversaire instanceof Herbe )); //Herbe faible contre Feu et Herbe 
	}
	
	@Override
	public void talent() {
		// TODO Auto-generated method stub

	}

}
