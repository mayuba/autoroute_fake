import java.awt.Color;

import javax.swing.JLabel;


public class Panneaux extends JLabel {
	
	 
		int etat=1; //etat rue
	public Panneaux(int e){
		etat=e;
		if (etat==1){
			setBackground(Color.green); //etat equilibre
		}else if(etat==2){
				setBackground(Color.orange); //risque congestion
		}else if(etat==3){
				setBackground(Color.red); //congestion
		}
		
		setOpaque(true);
		
		
	}
	
}
	
