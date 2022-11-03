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
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        List<Card> battlefield;
        battlefield = new ArrayList<Card>();
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
        Card p1; 
        Card p2;
        while(pl1.getDeckSize() > 0 && pl2.getDeckSize() > 0) {
            p1= pl1.dealCardFromDeck();
            p2= pl2.dealCardFromDeck();
            if(p1.getRank() == p2.getRank()){
                war(pl1, pl2);
            }
            if(p1.getRank() > p2.getRank()){
                pl1.addCardToDeck(p1);
                pl1.addCardToDeck(p2);
            }else{
                pl2.addCardToDeck(p1);
                pl2.addCardToDeck(p2);
            }
        }
        isWinner(pl1, pl2);
    }
    
    public void steal(Deck stealer, Deck giver) {
        
    }
    
    public void war(Deck pl1, Deck pl2) {
        
    }
    
    public void isWinner(Deck pl1, Deck pl2) {
        
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
