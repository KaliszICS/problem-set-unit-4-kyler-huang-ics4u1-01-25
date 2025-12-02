import java.util.ArrayList;

/**
 * Represents a player who has a name, an age, and a hand of cards.
 * A player can be created with a starting hand or with an empty hand.
 * A player can draw cards, discard cards, return cards to a deck, and show their hand.
 *
 * @author Kyler H
 * @version 1.0
 */
class Player {

    /** Age of the player. Ex. 10, 18, 12, 30 */
    private int age;

    /** Name of the player. Ex. John, Jane, Tom */
    private String name;

    /** The cards in the players hand. */
    private ArrayList<Card> hand;

    /**
     * Creates a player with a name, an age, and a starting hand of cards.
     * Only non null cards will be added to the hand.
     *
     * @param age the age of the player
     * @param name the name of the player
     * @param cards the starting cards for the player
     */
    public Player(int age, String name, Card[] cards){

        // Throw an exception if name is null
        if (name == null) {
        	throw new IllegalArgumentException("Name cannot be null");
    	}

		// Throw an exception if age is less or equal to 0
    	if (age <= 0) {
        	throw new IllegalArgumentException("Age cannot be less or equal to 0");
    	}

       // Throw an expection if the number of elements in cards is less or equal to 0;
        if (cards.length <= 0){
            throw new IllegalArgumentException("The number of elements of cards must be more than 0");
        }

        this.age = age;
        this.name = name;
        this.hand = new ArrayList<>();

        for (int i = 0; i < cards.length; i++){
            if (cards[i] != null){
                hand.add(cards[i]);
            }
        }

    }

    /**
     * Creates a player with a name and an age but no starting cards.
     *
     * @param age the age of the player
     * @param name the name of the player
     */
    public Player(int age, String name){
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the age of the player.
     *
     * @return the age of the player
     */
    public int getAge(){
        return age;
    }

    /**
     * Returns the cards in the players hand as an array.
     *
     * @return an array of cards the player is holding
     */
    public Card[] getHand(){
        return hand.toArray(new Card[0]);
    }

    /**
     * Returns how many cards the player is holding.
     *
     * @return the size of the players hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Draws one card from a deck and adds it to the players hand.
     * If the deck is null or empty nothing happens.
     *
     * @param deck the deck to draw from
     */
    public void draw(Deck deck){
        if (deck == null){
            return;
        }
        Card card = deck.draw();
        if (card != null){
            hand.add(card);
        }
    }

    /**
     * Removes a card from the players hand and adds it to a discard pile.
     * If the card is not in the hand nothing happens.
     *
     * @param card the card to discard
     * @param discardPile the pile to add the card to
     */
    public void discardCard(Card card, DiscardPile discardPile){

        // Throw an exception is card is null
        if (card == null){
            throw new IllegalArgumentException("Card cannot be null");
        }

        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).equals(card)){
                hand.remove(i);
                discardPile.addCard(card);
                break;
            }
        }
    }

    /**
     * Returns a card from the players hand back to a deck.
     *
     * @param card the card to return
     * @param deck the deck to add the card to
     * @return true if the card was removed and returned, false if not
     */
    public boolean returnCard(Card card, Deck deck) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i) == card) {
                hand.remove(i);
                deck.addCard(card);
                return true;
            }
        }
    return false;
}


    /**
     * Returns a string that shows the players name, age, and the cards in their hand in the format:
     * NAME, 18 CARDNAME of CARDSUIT.
     *
     * @return a string version of the player
     */
    @Override
    public String toString(){
        String placeHolder = "";
        placeHolder = name + ", " + age;

        for (int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            placeHolder = placeHolder + " " + currentCard.getName() + " of " + currentCard.getSuit();

            if (i < hand.size() - 1){
                placeHolder = placeHolder + ", ";
            }else{
                placeHolder = placeHolder + ".";
            }
        }

        return placeHolder;
    }

}
