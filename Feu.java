package pokemon;

public class Feu extends Pokemon {

	public Feu(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Feu(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Feu() {
		// TODO Auto-generated constructor stub
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if (choixAttaque.equals("boutefeu")) {
			//boutefeu:  On fait 120% de degats et on perd 10% de nos pv
			this.multiplicateur = 1.2;
			this.attaque(adversaire);
			this.pv-=this.attaque*0.1;
			System.out.println("Effet: " +choixAttaque+" vous perdez "+this.attaque*0.1+" PV.");
		}
		else{
			if(choixAttaque.equals("surchauffe")){
				//Surchauffe : Elle a 20% de chance qu'elle echoue si elle n'echoue pas on fait 130% de degats à l'adversaire
				if(Math.random()<=0.2){
					System.out.println("L'attaque de "+this.nom+" surchauffe a échoué T-T");
					return;
				}
				this.multiplicateur = 1.3;
				this.attaque(adversaire);
			}
			else{
				this.attaque(adversaire); // autre attaque que Surchauffe et boutefeu.
			}
		}
	}
		
	public boolean fortContre (Pokemon adversaire) {
		return (adversaire instanceof Herbe ); // Feu fort contre herbe
	}
	
	public boolean faibleContre (Pokemon adversaire) {
		return ( (adversaire instanceof Eau ) || (adversaire instanceof Terre )); //Feu faible contre Eau,Terre.
	}

	@Override
	public void talent() {
		// TODO Auto-generated method stub

	}

}
