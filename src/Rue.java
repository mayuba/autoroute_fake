
public class Rue {

	public Voiture[] tabVoiture;
	public int rand;
	public int mx = 20, mn = 8;
	public int departX, departY, arriveeX, arriveeY;
	public Thread[] TabTh;
	Panneaux P1, P2;

	Rue() {
		// declaration des panneaux
		P1 = new Panneaux(1);
		P2 = new Panneaux(1);
		// positionnemt des panneaux
		P1.setBounds(97, 450, 15, 15);
		P2.setBounds(245, 450, 15, 15);

		// tableau des voitures
		rand = (int) (Math.random() * (mx - mn) + mn); // calcul nombre des
														// voitures
		this.tabVoiture = new Voiture[rand];
		TabTh = new Thread[tabVoiture.length];
		for (int i = 0; i < this.tabVoiture.length; i++) {
			this.tabVoiture[i] = new Voiture();
			System.out.println("Initialiser Voiture : " + i);
		}
	}

	public void initVoiture() {

		for (int i = 0; i < this.tabVoiture.length; i++) {
			this.tabVoiture[i].setY(this.departY); // point du depart Y
			this.tabVoiture[i].setX(this.departX); // point du depart X
			this.tabVoiture[i].setXY();
			TabTh[i] = new Thread(this.tabVoiture[i]); // remplir la table des
														// threads
			System.out.println("Initialiser X = " + this.tabVoiture[i].getX() + ",Y = " + this.tabVoiture[i].getY()
					+ " Voiture : " + i);
		}
	}

	synchronized public void demarrer() throws InterruptedException {

		for (int i = 0; i < this.tabVoiture.length; i++) {
			TabTh[i].start(); // demarrage des threads
		}
	}

	int getNbVoiture() {
		return this.tabVoiture.length; // retourne le nombre des voitures
	}

	public void setArrivee(int aX, int bY) // point d'arrivee
	{
		this.arriveeX = aX;
		this.arriveeY = bY;
	}

	public void setDepart(int aX, int bY) // point du depart
	{
		this.departX = aX;
		this.departY = bY;
	}

	Voiture getVoiture(int i) {
		return this.tabVoiture[i]; // retourne les voitures
	}

}