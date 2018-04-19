package pokemon;

public class Raichu extends Electricite {

	public Raichu(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Raichu(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Raichu() {
		// TODO Auto-generated constructor stub
	}
	public void subire(Pokemon adversaire,int degats){
		super.subire(adversaire,degats);
		if(Math.random()<=0.3){
			//30% de chance de paralyser l'adversaire pendant 1tours lorsqu'il subit des degats
			adversaire.paralyse=1;
			System.out.println(adversaire.nom+ " est paralysé pour "+adversaire.paralyse+" tours");
		}
		
	}
}
