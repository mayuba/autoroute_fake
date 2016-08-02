

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Voiture extends JLabel implements Runnable{
        Thread T=new Thread();
	int mx = 6, mn = 0, mm = 3;
        
	int random,randVitesse;
	

		int voieX, voieY;
        Thread Th = new Thread();
        
	public Voiture() {
        randVitesse = (int) (Math.random() * (20-5)+5); // calcul du vitesse
		random = (int) (Math.random() * (mx - mn) + mn);
		setOpaque(true);
		setBackground(Color.white);
               
		//this.setText((100-randVitesse)+"km/h");

	}

	public void setX(int a) {
		this.voieX = a;
	}

	public void setY(int b) {
		this.voieY = b;
	}

	public int getX() {
		return voieX;
	}

	public int getY() {
		return voieY;
	}
        
        public void setXY()
        {
           this.setBounds(voieX, voieY, 30, 30);
        }
        

// deplacement des voitures

        synchronized void deplacer(int x,int y) throws InterruptedException
        {
            voieX=x;
            voieY=y;
            
            T.sleep(randVitesse);
            this.setBounds(voieX, voieY, 30, 30);
            
        }
	@Override
	public void run() {
            while(true)
            {
                //deplacement x du R1 et R2
                if(voieX==2980)
                {
                    for(int i=2980;i>-100;i--)
                    {
                        try {
                            deplacer(i,voieY);
                            
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 

                }else if(voieX==-1980) //deplacement x du R3
                {
                    for(int j=-1980;j<1100;j++)
                    {
                        try {
                            deplacer(j,voieY);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                }else if(voieY==2650) //deplacement Y du R4 et R5
                {
                    for(int k=2650;k>450;k--)
                    {
                        try {
                            deplacer(voieX,k);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                }
              
            }

	}

}

