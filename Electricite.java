package pokemon;

public class Electricite extends Pokemon {

	public Electricite(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Electricite(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Electricite() {
		// TODO Auto-generated constructor stub
	}
	public boolean fortContre (Pokemon adversaire) {
		return ( (adversaire instanceof Eau) ); //electricité fort contre eau
	}
	public boolean faibleContre (Pokemon adversaire) {
		return ( (adversaire instanceof Electricite ) || (adversaire instanceof Terre )); // Electericite faible contre Electricite et Terre
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if (choixAttaque.equals("Elecanon")) {
			//l'attaque fait 60% de degats et a 60% de chance de paralyser l'adversaire
			this.multiplicateur=0.6;
			this.attaque(adversaire);
			if (!(this instanceof Pikachu)){
				adversaire.paralyse=((int) Math.random()*10+1); //nb tours paralyse.
				if (adversaire.paralyse>6){
					adversaire.paralyse=0;
					System.out.println(adversaire.nom + " n'est pas paralysé.");
				}
				System.out.println(adversaire.nom + "est parlaysé pour:"+adversaire.paralyse+" tours.");
			}
		}
		else{
			this.attaque(adversaire); // autre attaque que elecanon.
		}
	}

	@Override
	public void talent() {
		// TODO Auto-generated method stub

	}

}
