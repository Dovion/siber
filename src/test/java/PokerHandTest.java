import org.junit.Test;
import ru.dovion.model.PokerHand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokerHandTest {

    @Test
    public void testCalculateRankForStraightFlush() {
        PokerHand hand = new PokerHand("2H 3H 4H 5H 6H");
        assertEquals(9, hand.getRank());
    }

    @Test
    public void testCalculateRankForFourOfAKind() {
        PokerHand hand = new PokerHand("2H 2D 6H 2C 2S");
        assertEquals(8, hand.getRank());
    }

    @Test
    public void testCalculateRankForFullHouse() {
        PokerHand hand = new PokerHand("2H 3H 2D 2C 3S");
        assertEquals(7, hand.getRank());
    }

    @Test
    public void testCalculateRankForFlush() {
        PokerHand hand = new PokerHand("2H 7H 3H 4H 5H");
        assertEquals(6, hand.getRank());
    }

    @Test
    public void testCalculateRankForStraight() {
        PokerHand hand = new PokerHand("2H 3D 6H 4C 5S");
        assertEquals(5, hand.getRank());
    }

    @Test
    public void testCalculateRankForThreeOfAKind() {
        PokerHand hand = new PokerHand("2H 2D 4H 2C 3S");
        assertEquals(4, hand.getRank());
    }

    @Test
    public void testCalculateRankForTwoPair() {
        PokerHand hand = new PokerHand("2H 4H 2D 3C 3S");
        assertEquals(3, hand.getRank());
    }

    @Test
    public void testCalculateRankForOnePair() {
        PokerHand hand = new PokerHand("2H 2D 5H 3C 4S");
        assertEquals(2, hand.getRank());
    }

    @Test
    public void testCalculateRankForHighCard() {
        PokerHand hand = new PokerHand("2H 7H 3D 4C 5S");
        assertEquals(1, hand.getRank());
    }

    @Test
    public void testCompareToForHand1Greater() {
        PokerHand hand1 = new PokerHand("2H 3H 4H 5H 6H");
        PokerHand hand2 = new PokerHand("2H 3H 4H 5H 7H");
        assertTrue(hand1.compareTo(hand2) > 0);
    }

    @Test
    public void testCompareToForHandsEqual() {
        PokerHand hand1 = new PokerHand("2H 3H 4H 5H 6H");
        PokerHand hand2 = new PokerHand("2H 3H 4H 5H 6H");
        assertEquals(0, hand1.compareTo(hand2));
    }

    @Test
    public void testCompareToForHand1Less() {
        PokerHand hand1 = new PokerHand("2H 3H 4H 5H 7H");
        PokerHand hand2 = new PokerHand("2H 3H 4H 5H 6H");
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test
    public void testCompareToForHand1GreaterWithHighCard() {
        PokerHand hand1 = new PokerHand("2H JD 4H 7S AC");
        PokerHand hand2 = new PokerHand("2H JD 4H 7S KC");
        assertTrue(hand1.compareTo(hand2) > 0);
    }
}