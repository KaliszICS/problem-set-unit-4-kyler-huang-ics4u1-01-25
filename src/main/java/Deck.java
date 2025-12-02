/**
 * Represents a deck of playing cards. A deck can be created in two ways
 * Providing an array of card objects
 * Automatically generating a 52 card deck
 * 
 *
 * The deck object does shuffling, drawing cards, adding cards, and reshuffling
 * additional cards into the deck.
 *
 * @author Kyler H.
 * @version 1.0
 */

import java.util.ArrayList;

class Deck {

    /**
     * The list storing all cards currently in the deck.
     */
    private ArrayList<Card> cards;

    /**
     * Creates a deck using a provided array of card objects. Only non null cards are added to the deck.
     *
     * @param givenCards the array of cards to add to the deck
     */
    public Deck(Card[] givenCards) {

        // Throw an expection if the number of elements in the provided array is less or equal to 0
        
        if (givenCards.length <= 0){
            throw new IllegalArgumentException("The provided array of cards must have an element greater than 0");
        }


        this.cards = new ArrayList<>();
        for (int i = 0; i < givenCards.length; i++) {
            if (givenCards[i] != null) {
                this.cards.add(givenCards[i]);
            }
        }
    }

    /**
     * Creates a 52 card deck with suits and ranks
     */
    public Deck() {
        this.cards = new ArrayList<>();

        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++) {
                int value = j + 1;
                this.cards.add(new Card(names[j], suits[i], value));
            }
        }
    }

    /**
     * Returns the number of cards in the deck
     *
     * @return the number of cards in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * return the drawn card, or null if the deck is empty. The top of the deck is at the end of the array
     *
     * @return the drawn card, or null if the deck is empty
     */
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    /**
     * Randomly shuffles the deck by swapping the current card a card at the random index
     */
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int)(Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    /**
     * Adds a card to the deck.
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    /**
     * Adds all cards from the array into the deck then shuffles the deck.
     *
     * @param cards the array of cards to add
     */
    public void reshuffle(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                addCard(cards[i]);
            }
        }
        shuffle();
    }
}
