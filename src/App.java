public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();

        deck.shuffle();

        for (int i = 0; i < 52; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        for (int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            System.out.println("Player 1 flips: " + card1.getName());
            System.out.println("Player 2 flips: " + card2.getName());

            if (card1.value > card2.value) {
                player1.incrementScore();
                System.out.println("Player 1 receives a point.");
            } else if (card1.value < card2.value) {
                player2.incrementScore();
                System.out.println("Player 2 receives a point.");
            } else {
                System.out.println("It's a tie. No point awarded.");
            }
        }

        System.out.println("\nFinal Score:");
        System.out.println("Player 1: " + player1.getScore() + " points");
        System.out.println("Player 2: " + player2.getScore() + " points");

        if (player1.getScore() > player2.getScore()) System.out.println("Player 1 wins!");
        else if (player1.getScore() < player2.getScore()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
