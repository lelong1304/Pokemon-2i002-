package pokemon;

public class Carapuce extends Eau {

	public Carapuce(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Carapuce(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Carapuce() {
		// TODO Auto-generated constructor stub
	}
	public void talent(){
		if((1.1*this.pv) <pvmax){
			// récupère 10% de ces pv sans dépasser pvmax à chaque tour
			this.pv *=1.1;
		}
	}
	

}
