package pokemon;

public class Racaillou extends Terre {

	public Racaillou(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Racaillou(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Racaillou() {
		// TODO Auto-generated constructor stub
	}
	//surcharge subire
	public void subire(Pokemon adversaire,int degats){
		super.subire(adversaire,degats-(int)(degats*0.15)); //on réduit les dégats subi de 15%
		//30% de chance d'esquiver 
		if(Math.random()<=0.3){
			System.out.println(this.nom+ " a esquivé!");
			return;
		}
		
		
		
	}

}
