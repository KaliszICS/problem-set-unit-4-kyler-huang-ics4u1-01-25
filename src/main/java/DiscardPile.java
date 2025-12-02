/**
 * Represents a discard pile where used cards are stored. A discard pile can be
 * created either by providing an array of Card objects or by creating an empty pile.
 *
 * The discard pile does adding cards, removing specific cards, removing all cards,
 *  returning a string representation, and getting its size.
 *
 * @author Kyler H.
 * @version 1.0
 */

import java.util.ArrayList;

class DiscardPile {

    /**
     * The list storing all discarded card objects currently in the pile.
     */
    private ArrayList<Card> pile;

    /**
     * Creates a discard pile using a provided array of cards. Only non-null cards are added.
     *
     * @param cards an array of card objects to add to the pile
     */
    public DiscardPile(Card[] cards){

        // Throw an exception if the number of elements in cards is less or equal to 0;
        if (cards.length <= 0){
            throw new IllegalArgumentException("The number of elements of cards must be more than 0");
        }
        this.pile = new ArrayList<>();

        for (int i = 0; i < cards.length; i++){
            if (cards[i] != null){
                this.pile.add(cards[i]);
            }
        }
    }

    /**
     * Creates an empty discard pile.
     */
    public DiscardPile(){
        this.pile = new ArrayList<>();
    }

    /**
     * Returns the number of discarded cards currently in the pile.
     *
     * @return the size of the pile
     */
    public int size(){
        return pile.size();
    }

    /**
     * Adds a non null card to the discard pile.
     *
     * @param card the card to add if card is not null
     */
    public void addCard(Card card){
        if (card == null){
            return;
        }
        pile.add(card);
    }

    /**
     * Removes the given card from the pile if it exists. Otherwise return null
     *
     * @param card the card to remove
     * @return the removed card, or null if the card is null or not found
     */
    public Card removeCard(Card card){
        if (card == null){
            return null;
        }

        for (int i = 0; i < pile.size(); i++){
            if (pile.get(i) != null && pile.get(i) == card){
                pile.remove(i);
                return card;
            }
        }

        return null;
    }

    /**
     * Removes all cards from the pile, but returns an empty array if the pile is empty. Otherwise returns an array containing all cards that were previously in the pile.
     *
     * @return an array of removed cards
     */
    public Card[] removeAll(){
        if (pile.isEmpty()){
            return new Card[0];
        }

        Card[] removeCards = pile.toArray(new Card[0]);
        pile.clear();
        return removeCards;
    }

    /**
     * Returns "pile is empty" if no cards are in the pile. Otherwise returns a string containing only the last card added to the pile in the format "NAME of SUIT.".
     *
     * @return a string representation of the pile
     */
    @Override
    public String toString(){
        String placeHolder = "pile is empty";

        if (pile.isEmpty()) {
            return placeHolder;
        }

        for (int i = 0; i < pile.size(); i++){
            Card currentCard = pile.get(i);
            placeHolder = currentCard.getName() + " of " + currentCard.getSuit();

            if (i < pile.size() - 1){
                placeHolder = placeHolder + ", ";
            } else {
                placeHolder = placeHolder + ".";
            }
        }
        return placeHolder;
    }

}
