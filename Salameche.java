package pokemon;

public class Salameche extends Feu {

	public Salameche(String nom, int pvmax, int attaque, int x, int y) {
		super(nom, pvmax, attaque, x, y);
		// TODO Auto-generated constructor stub
	}

	public Salameche(String nom, int pvmax, int attaque) {
		super(nom, pvmax, attaque);
		// TODO Auto-generated constructor stub
	}

	public Salameche() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void talent(){
		//Lorsque  ses pv sont inf à un tiers des pvmax son attaque augmente de 50%
		if (this.pv < this.pvmax/3){
			System.out.println(this.nom + ": Application du talent!!");
			this.multiplicateur = this.multiplicateur + 1/2*this.multiplicateur;
		}
	}
}
