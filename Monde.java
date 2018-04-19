package pokemon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Monde {
	private final int max_dresseur=20; //max dresseurs dans le monde
	private int [][] cases; // 1 si il y a un dresseur 0 sinon
	private double probabilite; // probabilité pour qu'un dresseur existe
	private Joueur joueur; //Le joueur
	private Dresseur [] dresseur;//Tableau des dresseurs présents dans le monde
	private int nbDresseurs=0, nbDresseursActifs; //nbDresseur et Dresseur non vaincu
	
	//Constructeur du monde
	public Monde(int taille_x, int taille_y, double proba){
		cases=new int[taille_x][taille_y];
		this.probabilite=proba;
		this.dresseur=new Dresseur[this.max_dresseur];
		for (int i=0;i<taille_x;i++){
			for (int j=0;j<taille_y;j++){
				if (Math.random()<=proba){
					cases[i][j]=1;
					if(this.nbDresseurs<max_dresseur) {
						dresseur[this.nbDresseurs++]=new Dresseur(i,j);
					}
					
				}
				else cases[i][j]=0;
			}
		}
		this.nbDresseursActifs=this.nbDresseurs;
		//Pour placer le joueur dans une case 0 au début
		int idx,idy;
		do {
			idx=(int)(Math.random()*taille_x);
			idy=(int)(Math.random()*taille_y);
		} while (cases[idx][idy]==1);
		this.joueur=new Joueur(idx,idy); 
	}
	//Test Question 11) pour ajouter un tableau de pokémons dans dresseurs
	public void ajouter_Pokemon_dans_Dresseur(int k,Pokemon [] p){
		for (int i=0;i<p.length;i++)
			if (p[i]!=null){
				this.dresseur[k].ajouterPokemon(p[i]);
			}
	}
	//Affiche la taille du monde , le nb de dresseur non vaincu et le nb de victoires du joueur
	public String toString(){
		return "taille du Monde: ("+cases.length+" , " +cases[0].length+") le nombre Dresseur restants:"+this.nbDresseursActifs+" le nombre de Joueur victoire "+this.joueur.nbVictoire;
	}
	//Affichage du monde
	public void afficheMondeTerminal(){
		for (int i=0;i<cases.length;i++){
			for (int j=0;j<cases[i].length;j++){
				if (cases[i][j]==1) System.out.print('D'); //D dresseur 
				if (cases[i][j]==2) System.out.print('X'); //X dresseur vaincu
				if (cases[i][j]==0) {
					if(i==this.joueur.x && j==this.joueur.y) System.out.print('J'); //J joueur
					else System.out.print('.'); //case vide
				}
			}
			System.out.println();
		}
	}
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	//deplacer le joueur en appuyant sur les touches
	public void deplacer(char c){
		if (c=='Z') this.joueur.y=(this.joueur.y+1)%this.cases[0].length;
		if (c=='S') this.joueur.y=(this.joueur.y-1)%this.cases[0].length;
		if (c=='Q') this.joueur.x=(this.joueur.x-1)%this.cases.length;
		if (c=='D') this.joueur.x=(this.joueur.x+1)%this.cases.length;
	}
	//Methode jouer pour faire deplacer le joueur pourqu'il combatte des dresseursactif sur la map
	public void jouer() throws IOException{
		while (this.nbDresseursActifs>0){
			for(int i=0;i<this.nbDresseurs;i++){
				if ((!this.dresseur[i].vaincu) && (this.joueur.x==this.dresseur[i].x && this.joueur.y==this.dresseur[i].y)){
				//if (cases[this.dresseur[i].x][this.dresseur[i].y]==1)
					System.out.println("zzzzz");
					boolean victoire = this.joueur.combat(this.dresseur[i]);
					if(victoire){
						cases[this.dresseur[i].x][this.dresseur[i].y]=2;
						this.dresseur[i].vaincu=true;
						this.nbDresseursActifs--;
					}
				}
				else{
					System.out.println("Joueur ("+this.joueur.x+", "+this.joueur.y+")");
					System.out.println("l'appui sur Z augmentera le y de 1, S le diminuera de 1, Q diminuera le x de 1, D l'augmentera de 1"); 
					Reader reader = new InputStreamReader(System.in);
					char c = (char)(reader.read());
					deplacer(c);
					afficheMondeTerminal();
					
				}
			}
		}
	}
}
