package pokemon;

public class Bulbizarre extends Herbe {

	public Bulbizarre(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Bulbizarre(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Bulbizarre() {
		// TODO Auto-generated constructor stub
	}
	
	public void talent(){
		if (this.pv < this.pvmax/3){ 
			//Lorsque  ses pv sont inf à un tiers des pvmax son attaque augmente de 50%
			System.out.println(this.nom + ": Application du talent!!");
			this.multiplicateur = this.multiplicateur + 1/2*this.multiplicateur;
		}
	}
}
