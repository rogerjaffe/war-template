import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck Battlefield;
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        Deck mainDeck = new Deck();
        mainDeck.initializeNewDeck();
        mainDeck.shuffle();
        Deck[] bothDecks = mainDeck.dealDeck();
        Deck pl1 = bothDecks[0];
        Deck pl2 = bothDecks[1];
        steal(pl1, pl2);
        while(pl1.getDeckSize() > 0 && pl2.getDeckSize() > 0) {
            
        }
        
    }
    
    public void steal(Deck stealer, Deck giver) {
        stealer.addCardToDeck(giver.dealCardFromDeck());
    }
    
    public void war(Deck pl1, Deck pl2) {
        if(pl1.getDeckSize() >= 4 && pl2.getDeckSize() >= 4) {
            for(int i = 0; i < 3; i++) {
                Battlefield.addCardToDeck(pl1.dealCardFromDeck());
            }
            
            for(int i = 0; i < 3; i++) {
                Battlefield.addCardToDeck(pl2.dealCardFromDeck());
            }
            
            Card p1Top = pl1.dealCardFromDeck();
            Card p2Top = pl2.dealCardFromDeck();
            Battlefield.addCardToDeck(p1Top);
            Battlefield.addCardToDeck(p2Top);
            int size;
            if(p1Top.getRank() == p2Top.getRank()) {
                war(pl1, pl2);
            }
            if(p1Top.getRank() > p2Top.getRank()) {
                size = Battlefield.getDeckSize();
                for(int i = 0; i < size; i++) {
                    pl1.addCardToDeck(Battlefield.dealCardFromDeck());                   
                }
            } else {
                size = Battlefield.getDeckSize();
                for(int i = 0; i < size; i++) {
                    pl2.addCardToDeck(Battlefield.dealCardFromDeck());                   
                }
            }
        } else {
            if(pl1.getDeckSize() < 4) {
                for(int i = 0; i < pl1.getDeckSize(); i++ ) {
                    steal(pl1, pl2);
                }
            } else {
                for(int i = 0; i < pl2.getDeckSize(); i++ ) {
                    steal(pl2, pl1);
                }
            }
        }
    }
    
    public void isWinner(Deck pl1, Deck pl2) {
        if(pl1.getDeckSize() == 0){
            System.out.println("Player 2 wins");
        }
        if(pl2.getDeckSize() == 0){
            System.out.println("Player 1 wins");
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
