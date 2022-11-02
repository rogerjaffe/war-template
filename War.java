
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
        while(pl1.getDeckSize() > 0 && pl2.getDeckSize() > 0) {
            
        }
        
    }
    
    public void steal(Deck stealer, Deck giver) {
        
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
