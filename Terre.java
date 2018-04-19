package pokemon;

public class Terre extends Pokemon {

	public Terre(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Terre(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Terre() {
		// TODO Auto-generated constructor stub
	}
	public boolean fortContre (Pokemon adversaire) {
		return ( (adversaire instanceof Feu) || (adversaire instanceof Electricite )); //Terre fort contre Feu et Electricite
	}
	public boolean faibleContre (Pokemon adversaire) {
		return ( (adversaire instanceof Eau ) || (adversaire instanceof Herbe ) || (adversaire instanceof Terre )); //Terre faible contre Eau,Herbe,Terre
	}
	public void attaque(Pokemon adversaire, String choixAttaque){
		if (choixAttaque.equals("Ampleur")) { //fait des degats entre 80% et 150%
			multiplicateur = Math.random()*0.7+0.8;
			this.attaque(adversaire);
		}
		else{
			this.attaque(adversaire); //autre attaque que Ampleur.
		}
	}
	@Override
	public void talent() {
		// TODO Auto-generated method stub

	}

}
