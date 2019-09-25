package bowling;

import java.util.ArrayList;
import sun.applet.Main;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */


public class SinglePlayerGame {
    
    int score ;
    int cptStrike;
    int cptSpare;
    int tour;
    int cpt;

	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            
            this.score = 0;
            this.cptStrike = 0;
            this.cptSpare = 0;
            this.tour = 0;
            this.cpt = 0;
            
            
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            this.tour ++;
            
            if (this.tour > 20) {
                if (this.cptStrike > 2) {
                    this.score += nombreDeQuillesAbattues;
                    this.cptStrike--;
                }
                this.score += nombreDeQuillesAbattues;
            }else{
                if (this.cptStrike>0) {
                    if (this.cptStrike >2) {
                        this.score += nombreDeQuillesAbattues*2;
                        this.score -= 2;
                    }else{
                        this.score += nombreDeQuillesAbattues;
                        this.score -= 1;
                    }
                }
                if (this.cptSpare>0) {
                    this.score += nombreDeQuillesAbattues;
                    this.cptSpare --;
                }
                
                
                
                
                if (this.tour%2!=0) {
                    if (nombreDeQuillesAbattues == 10) {
                        this.score += 10;
                        this.cptStrike +=2;
                        this.tour++;
                    }else{
                        this.cpt+=nombreDeQuillesAbattues;
                    }
                }
                
                
                else{
                    if (this.cpt + nombreDeQuillesAbattues == 10) {
                        this.score += this.cpt + nombreDeQuillesAbattues;
                        this.cpt = 0;
                        this.cptSpare +=1;
                    }
                    else{
                        this.cpt+= nombreDeQuillesAbattues;
                        this.score += this.cpt;
                        this.cpt = 0;
                    }
                }
            }
            


	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
                return this.score;
	}
        
        public static void main(String [] args)
	{
		SinglePlayerGame game = new SinglePlayerGame();
   
                game.lancer(10);game.lancer(3);game.lancer(4);
                
                System.out.println(game.score());
	}
}
