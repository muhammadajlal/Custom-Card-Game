
package mycardgame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class CardGameTest {

    @Test
    void testNewDeckContains40Cards() {
        // Arrange
        int[] deck = CardGame.createShuffledDeck();

        // Act
        int numCards = deck.length;

        // Assert
        assertEquals(40, numCards);
    }

    @Test
    void testShuffleFunctionShufflesDeck() {
        // Arrange
        int[] originalDeck = new int[40];
        for (int i = 0; i < originalDeck.length; i++) {
            originalDeck[i] = i + 1; // Assigning unique values to cards
        }
        int[] shuffledDeck = CardGame.createShuffledDeck();

        // Act
        boolean isShuffled = false;
        for (int i = 0; i < originalDeck.length; i++) {
            if (originalDeck[i] != shuffledDeck[i]) {
                isShuffled = true;
                break;
            }
        }

        // Assert
        assertTrue(isShuffled); // Cehcking if Pile is shuffled or not
    }

    @Test
    public void testPlayerDrawWithEmptyDrawPile() {
        // Arrange
        int[] drawPile = {}; // Some cards in discard pile
        int[] oldDiscardPile = {5,6,7,2,1}; // Expected draw pile after shuffle //
        int[] discardPile = {5,6,7,2,1}; // Expected draw pile after shuffle //


        // Act
        drawPile = CardGame.SendDiscardPileToDrawPile(discardPile, drawPile);
       
        // Assert
        boolean notEqual = false;
        for(int i=0; i<discardPile.length; i++) //checking if any of the element of array is conflicting
        {
            if(drawPile[i] != oldDiscardPile[i]){ //if there is even a one element which is not equal means that the array is shuffled
                notEqual = true;
                break;
        }
      
        }
        assertTrue (notEqual); //pile is shuffled

        Arrays.sort(oldDiscardPile);
        Arrays.sort(drawPile);
        assertArrayEquals(drawPile, oldDiscardPile); //Checking if drawPile is populated with shuffled cards from discardPile
      
    }

    @Test
    public void testHigherCardWins() {
        // Arrange
        int player1Card = 8;
        int player2Card = 3;

        // Act
        int result = CardGame.compareCards(player1Card, player2Card);

        // Assert
        assertTrue(result > 0, "Player 1 wins this round!"); // Checking if higher card win or not
    }

    @Test
    void testWinnerOfNextRoundWinsTiedCards() {
        // Arrange
        int player1Card = 10; // Player 1's draw pile round 2
        int player2Card = 7; // Player 1's draw pile round 2


        int[] reservedPile ={6,6};

        int[] expectedplayer1DiscardPile = {10,7,6,6};

        int[] player1DiscardPile ={};

        
        // Act
        player1DiscardPile = CardGame.playerWins(player1DiscardPile, player1Card, player2Card, reservedPile);
        
        // Assert
        assertArrayEquals(expectedplayer1DiscardPile,  player1DiscardPile);
    }

}


