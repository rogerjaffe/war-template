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
    Deck Battlefield = new Deck();
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        Deck mainDeck = new Deck();
        mainDeck.initializeNewDeck();
        mainDeck.shuffle();
        Deck[] bothDecks = mainDeck.dealDeck();
        Deck pl1 = bothDecks[1];
        Deck pl2 = bothDecks[0];
        this.runEventLoop(pl1, pl2);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck pl1, Deck pl2) {
        Card p1; 
        Card p2;
        int turnCount = 1;
        while(pl1.getDeckSize() > 0 && pl2.getDeckSize() > 0 && turnCount <= 300) {
            System.out.printf("Turn Count: %d\n", turnCount);
            System.out.printf("Pl1 DECK SIZE: " + pl1.getDeckSize() + "\n");
            System.out.printf("Pl2 DECK SIZE: " + pl2.getDeckSize() + "\n");
            p1 = pl1.dealCardFromDeck();
            p2 = pl2.dealCardFromDeck();
            System.out.printf("P1 Top Card: %s of %s\nP2 Top Card: %s of %s\n\n", 
                p1.getFace(), p1.getSuit(), p2.getFace(), p2.getSuit());

            if(p1.getRank() == p2.getRank()){
                war(pl1, pl2, p1, p2);
            } else if(p1.getRank() > p2.getRank()){
                pl1.addCardToDeck(p1);
                pl1.addCardToDeck(p2);
            } else {
                pl2.addCardToDeck(p1);
                pl2.addCardToDeck(p2);
            }
            turnCount++;
        }
        isWinner(pl1, pl2);
    }

    public void steal(Deck stealer, Deck giver) {
        stealer.addCardToDeck(giver.dealCardFromDeck());
    }

    /*public void printBattlefield(int bSize) {
    for(int i = 0; i < bSize; i++) {
    System.out.printf("%d ", Battlefield.revealCardAtIndex(i).getRank());
    }
    System.out.println();
    } */

    public void war(Deck pl1, Deck pl2, Card p1, Card p2) {
        System.out.printf("--------WAR TIME--------\n\n");
        if(pl1.getDeckSize() >= 4 && pl2.getDeckSize() >= 4) {
            Battlefield.addCardToDeck(p1);
            Battlefield.addCardToDeck(p2);
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
            int bSize = Battlefield.getDeckSize();
            System.out.println("Battlefield Size: " + bSize);
            //printBattlefield(bSize);
            System.out.printf("P1 Top Card: %s of %s\nP2 Top Card: %s of %s\n\n", 
                p1Top.getFace(), p1Top.getSuit(), p2Top.getFace(), p2Top.getSuit());
            int size;
            if(p1Top.getRank() == p2Top.getRank()) {
                war(pl1, pl2, p1, p2);
            } else if (p1Top.getRank() > p2Top.getRank()) {
                size = Battlefield.getDeckSize();
                System.out.printf("--------P1  WINS--------\n\n");
                for(int i = 0; i < size; i++) {
                    pl1.addCardToDeck(Battlefield.dealCardFromDeck());                   
                }
                size = Battlefield.getDeckSize();
                System.out.println("Battlefield Size: " + size);
            } else {
                size = Battlefield.getDeckSize();
                System.out.printf("--------P2  WINS--------\n\n");
                for(int i = 0; i < size; i++) {
                    pl2.addCardToDeck(Battlefield.dealCardFromDeck());                   
                }
                size = Battlefield.getDeckSize();
                System.out.println("Battlefield Size: " + size);
            }
        } else {
            if(pl2.getDeckSize() > 4) {
                int size = pl1.getDeckSize();
                for(int i = 0; i < size; i++ ) {
                    steal(pl2, pl1);
                }
            } else {
                int size = pl2.getDeckSize();
                for(int i = 0; i < size; i++ ) {
                    steal(pl1, pl2);
                }
            }
        }

    }

    public void isWinner(Deck pl1, Deck pl2) {
        if(pl1.getDeckSize() <= pl2.getDeckSize()){
            System.out.printf("\n-----Player 2 wins-----");
        } else {
            System.out.printf("\n-----Player 1 wins-----");
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
