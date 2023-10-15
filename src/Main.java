import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    int value;
    private final String name;

    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                String name = getCardName(value, suit);
                Card card = new Card(value, name);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            System.out.println("The deck is empty.");
            return null;
        }
    }

    private String getCardName(int value, String suit) {
        if (value == 11) {
            return "Jack of " + suit;
        } else if (value == 12) {
            return "Queen of " + suit;
        } else if (value == 13) {
            return "King of " + suit;
        } else if (value == 14) {
            return "Ace of " + suit;
        } else {
            return value + " of " + suit;
        }
    }
}

class Player {
    private final List<Card> hand = new ArrayList<>();
    private int score = 0;

    public Player() {
    }

    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        } else {
            System.out.println("Player's hand is empty.");
            return null;
        }
    }

    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}

