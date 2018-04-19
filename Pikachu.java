package pokemon;

public class Pikachu extends Electricite {

	public Pikachu(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Pikachu(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Pikachu() {
		// TODO Auto-generated constructor stub
	}
	
	//surchager la méthode attaque(Pokemon adversaire)
	public void attaque(Pokemon adversaire){
		super.attaque(adversaire);
		if (Math.random()<=0.2){ 
			//20% de chance de paralyser l'adversaire pendant 2tours.
			adversaire.paralyse=2;
			System.out.println(adversaire.nom+" est parlaysé pour "+adversaire.paralyse+" tours");
		}
		
	}

}
