/**
 * 
 * 
 * Representing a playing card with a String name, String suit and its int value
 * Cards are compared with eachother to see which has more value
 * the int value is used to determine that.
 * 
 * The card object has getters for its name, suit and value and a toString and equals method.
 * 
 * 
 * 
 * @author Kyler H.
 * @version 1.0
 * 
 */
class Card {
    
	/** name of the card. Ex. Ace, 2, 3, 4, 5, King */

	private String name;

	/** suit of the card. Ex. Club, Spade, Diamond, Heart */

	private String suit;

	/** the value of the card. Ex. Ace is worth 1, 2 is worth 2, King is worth 13 */

	private int value;
    
	/**
	 * 
	 * A contructor that creates a card class with a name, suit and value
	 * 
	 * @param name the name of the card, String
	 * @param suit the suit of the card, String
	 * @param value the value of the card, int
	 */

	public Card(String name, String suit, int value){

		// if name is a null value throw an exception
		if (name == null) {
        	throw new IllegalArgumentException("Card name cannot be null");
    	}

		// if suit is a null value throw an exception
    	if (suit == null) {
        	throw new IllegalArgumentException("Card suit cannot be null");
    	}

		// if value is not within the range of 1 to 13 throw an exception
    	if (value < 1 || value > 13) {
        	throw new IllegalArgumentException("Card value must be between 1 and 13");
   		}

	    this.name = name;
	    this.suit = suit;
	    this.value = value;
	}
	

	/**
	 * returns the name of the card.  Ex. "Ace"
	 * 
	 * @return the name of the card.
	 */

	public String getName(){
	    return this.name;
	}
	

	/**
	 * 
	 * returns the suit of the card.  Ex. "Hearts"
	 * 
	 * @return the suit of the card.
	 */


	public String getSuit(){
	    return this.suit;
	}

	/**
	 * returns the value of the card. Ex. "5"
	 * 
	 * @return the value of the card.
	 */
	
	public int getValue(){
	    return this.value;
	}
	/**
	 * 
	 * returns the name and suit of the card as a string in the format: "Name of Suit".
	 * 
	 * @return a string describing the card
	 * 
	 */

	@Override
	public String toString(){
	    return this.name + " of " + this.suit;
	}
	/**
	 * 
	 * compares the card with another card's name, suit and value and returning true is equal.
	 * 
	 * 
	 * @param othercard is another card object that is being compared with this object
	 * @return true if other card object has the same name, suit and value as this card object
	 * 
	 */
	
	@Override
	public boolean equals(Object otherCard){
	    if (otherCard == null){
	        return false;
	    }
	    
	    if (this == otherCard){
	        return true;
	    }

		Card other = (Card) otherCard;
	    
		//return true if it's equal
	    return this.name.equals(other.name) && 
		this.suit.equals(other.suit) && 
		this.value == other.value;
	}
}
