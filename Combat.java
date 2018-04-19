package pokemon;

import java.io.IOException;

public class Combat {

	public static void main(String[] args) throws IOException {
		Pokemon b = new Bulbizarre ("Patrick",190,50); //Creation bublizarre
		Pokemon s = new Salameche("Kawaii",180,40); // Creation Salameche
		Pokemon t = new Pikachu("Pika",200,50); // Creation d'un pikachu
		Pokemon v = new Carapuce("Carapuce",180,40); // Creation Carapuce
		Pokemon m = new Triopikeur("Triopikeur",230,80); // Creation Triopikeur
		Pokemon r = new Raichu("Raichu",250,80); //Creation Raichu
		Pokemon c = new Racaillou("Racaillou",150,40); // Creation Racaillou
		b.ajouterAttaque("tranche-herbe"); //Ajouter l'attaque tranche-herbe aux attaques de bulbizarre.
		b.ajouterAttaque("v�g�-attaque"); // Ajouter l'attaque végé-attaque aux attaques de bulbizarre.
		s.ajouterAttaque("surchauffe"); //Ajouter l'attaque surchauffe aux attaques de Salameche
		s.ajouterAttaque("boutefeu"); // Ajouter boutefeu aux attaques de Salameche
		t.ajouterAttaque("Elecanon"); // Ajouter Elecanon à pikachu
		r.ajouterAttaque("Elecanon"); // Ajouter Elecanon à Raichu
		v.ajouterAttaque("Hydroblast"); // Ajouter Hydroblast à Carapuce
		m.ajouterAttaque("Ampleur"); // Ajouter Ampleur à Triopikeur
		c.ajouterAttaque("Ampleur"); // Ajouter Ampleur à Racaillou
		
		//Test pour ajouter des tableaux de pokémons aux dresseurs pour pouvoir faire la question 11)
		Pokemon[] p = new Pokemon[3];
		p[0]=new Pikachu();
		p[1]=new Bulbizarre();
		Pokemon[] q = new Pokemon[3];
		q[0]=new Salameche();
		q[1]=new Bulbizarre();
		
		Dresseur d1 = new Dresseur ("Anne"); // Création dresseur Anne
		Dresseur d2 = new Dresseur ("Basile"); // Création dresseur Basile
		Joueur j = new Joueur("Me"); // Création Joueur Me. 
		d1.ajouterPokemon(b); // Ajouter bulbizarre aux pokémons d'Anne
		d1.ajouterPokemon(t); // Ajouter Pikachu aux pokémons d'Anne
		d1.ajouterPokemon(v); // Ajouter Carapuce aux pokémons d'Anne
		d2.ajouterPokemon(s); // Ajouter Salameche aux pokémons de Basile
		d2.ajouterPokemon(m); // Ajouter triopikeur aux pokémons de Basile
		d2.ajouterPokemon(c); // Ajouter racaillou aux pokémons de Basile
		
		j.ajouterPokemon(c); //Ajouter racaillou aux pokémons du joueur
		j.ajouterPokemon(v); // Ajouter Carapuce aux pokémons du joueur.
		j.ajouterPokemon(r); // Ajouter Raichu aux pokémons du joueur.
		j.ajouterPokemon(s); // Ajouter Salameche aux pokémons du joueur.
		j.ajouterPokemon(b); // Ajouter Bulbizarre aux pokémons du joueur.
		
		//d1.combat(d2); // Combat entre Anne et Basile
		
		boolean test =j.combat(d1); // Combat entre Joueur et un dresseur Anne.
		System.out.println(test); //affiche true si on a gagné false sinon
		
		boolean test2 = j.combat(d2); //Combat entre Joueur et Basile
		System.out.println(test2); //affiche true si on gagne false sinon
		
		Monde monde=new Monde(7,6,0.3); // Création d'un monde Xmax =7, Ymax=6 , Probabilité =0.3
		System.out.println(monde.toString()); // Affichage des coordonnées du monde
		monde.afficheMondeTerminal(); // Affichage du monde.
		//test question (11) pour ajouter des pokemons aux dresseurs du monde 
		monde.ajouter_Pokemon_dans_Dresseur(0,p);
		monde.ajouter_Pokemon_dans_Dresseur(1, q);
		
		monde.jouer(); //appelle a la méthode jouer
		
	}

}
