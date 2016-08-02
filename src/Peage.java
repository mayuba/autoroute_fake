import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Peage extends JFrame implements ActionListener {
	Voiture v = new Voiture();
	// JFrame frame = new JFrame();
	JLabel l1, l2;
	JButton b1;
	Rue R1, R2, R3, R4, R5;
	JPanel panel;
	public String str = "Cliquer sur le bouton";

	public Peage() throws IOException, InterruptedException {
		
		l1 = new JLabel(str);
		b1 = new JButton("Demarrer");
		b1.addActionListener(this);
		panel = new JPanel();
		
		
		
		// Background Frame
		/*
		 * try { this.setContentPane(new JLabel(new ImageIcon(ImageIO .read(new
		 * File("devoir 2.png"))))); this.setLayout(null);
		 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } catch
		 * (IOException e) { e.printStackTrace(); }//
		 */
		// Configuration label
		l2 = new JLabel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			ImageIcon image = new ImageIcon("devoir 2.png");

			public void paint(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null, null);
				super.paint(g);
			}
		};

		R1 = new Rue();
		R1.setDepart(2980, 40);
		R1.setArrivee(-100, 40);
		R1.initVoiture();
		for (int i = 0; i < R1.getNbVoiture(); i++) {
			this.panel.add(R1.getVoiture(i));

			System.out.println("R1 - Ajouter Voiture n :" + i);
		}

		R2 = new Rue();
		R2.setDepart(2980, 88);
		R2.setArrivee(-100, 88);
		R2.initVoiture();
		for (int j = 0; j < R2.getNbVoiture(); j++) {
			this.panel.add(R2.getVoiture(j));
			System.out.println("R2 - Ajouter Voiture n :" + j);
		}

		R3 = new Rue();
		R3.setDepart(-1980, 175);
		R3.setArrivee(1100, 175);
		R3.initVoiture();
		for (int k = 0; k < R3.getNbVoiture(); k++) {
			this.panel.add(R3.getVoiture(k));
			System.out.println("R3 - Ajouter Voiture n :" + k);
		}

		R4 = new Rue();
		R4.setDepart(140, 2650);
		R4.setArrivee(1000, 175);
		R4.initVoiture();
		for (int h = 0; h < R4.getNbVoiture(); h++) {
			this.panel.add(R4.getVoiture(h));
			System.out.println("R4 - Ajouter Voiture n :" + h);
		}

		R5 = new Rue();
		R5.setDepart(190, 2650);
		R5.setArrivee(1000, 175);
		R5.initVoiture();
		for (int l = 0; l < R5.getNbVoiture(); l++) {
			this.panel.add(R5.getVoiture(l));
			System.out.println("R5 - Ajouter Voiture n :" + l);
		}

		panel.setLayout(null);
		l2.setBounds(0, 0, 1000, 700);

		
		l1.setBounds(590, 460, 170, 33);
		l1.setForeground(Color.white);
		l1.setFont(new Font("Arial", Font.BOLD, 16));
		l1.setOpaque(true);
		l1.setBackground(Color.blue);

		// l1.setBorder(BorderFactory.createLineBorder(Color.black));

		// Configuration Bouton
		b1.setBounds(600, 500, 150, 40);
		R4.P1.setVisible(true);
		R5.P2.setVisible(true);
		// Configuration Frame
		panel.add(R4.P1);
		panel.add(R5.P2);
		panel.add(l1);
		panel.add(b1);
		// panel.add(R1);
		panel.add(this.l2);
		this.add(panel);
		// this.pack();
		// this.setVisible(true);
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Peage img = new Peage();
		// img.pack();
		img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img.setSize(1000, 700); // taille de la fenetre
		img.setResizable(false);// empeche de modifier la taille
		img.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			try {
				R1.demarrer();
			} catch (InterruptedException ex) {
				Logger.getLogger(Peage.class.getName()).log(Level.SEVERE, null,
						ex);
			}
			try {
				R2.demarrer();
			} catch (InterruptedException ex) {
				Logger.getLogger(Peage.class.getName()).log(Level.SEVERE, null,
						ex);
			}
			try {
				R3.demarrer();
			} catch (InterruptedException ex) {
				Logger.getLogger(Peage.class.getName()).log(Level.SEVERE, null,
						ex);
			}

		}
		try {
			R4.demarrer();
		} catch (InterruptedException ex) {
			Logger.getLogger(Peage.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			R5.demarrer();
		} catch (InterruptedException ex) {
			Logger.getLogger(Peage.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}