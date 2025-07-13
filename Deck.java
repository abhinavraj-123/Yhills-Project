import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                                    "Jack", "Queen", "King", "Ace"};

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cards.clear();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Deck shuffled.");
    }

    public void sortDeck() {
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                int suitOrder = getSuitOrder(c1.getSuit()) - getSuitOrder(c2.getSuit());
                if (suitOrder != 0) return suitOrder;
                return getRankOrder(c1.getRank()) - getRankOrder(c2.getRank());
            }

            private int getSuitOrder(String suit) {
                switch (suit) {
                    case "Hearts": return 1;
                    case "Diamonds": return 2;
                    case "Spades": return 3;
                    case "Clubs": return 4;
                    default: return 5;
                }
            }

            private int getRankOrder(String rank) {
                switch (rank) {
                    case "2": return 2;
                    case "3": return 3;
                    case "4": return 4;
                    case "5": return 5;
                    case "6": return 6;
                    case "7": return 7;
                    case "8": return 8;
                    case "9": return 9;
                    case "10": return 10;
                    case "Jack": return 11;
                    case "Queen": return 12;
                    case "King": return 13;
                    case "Ace": return 14;
                    default: return 0;
                }
            }
        });
        System.out.println("Deck sorted by suit and rank.");
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. No cards to draw.");
            return null;
        }
        Card drawn = cards.remove(new Random().nextInt(cards.size()));
        System.out.println("You drew: " + drawn);
        return drawn;
    }

    public List<Card> drawMultipleCards(int count) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Card c = drawCard();
            if (c != null) drawnCards.add(c);
            else break;
        }
        return drawnCards;
    }

    public void printDeck() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty.");
            return;
        }
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void resetDeck() {
        initializeDeck();
        System.out.println("Deck reset to original 52 cards.");
    }

    public int getRemainingCards() {
        return cards.size();
    }
}
