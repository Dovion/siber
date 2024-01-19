package ru.dovion;

import ru.dovion.model.PokerHand;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<PokerHand> hands = new ArrayList<PokerHand>();
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        hands.add(new PokerHand("2C 3H 5D 6S 7H"));
        Collections.sort(hands);
        System.out.println(hands);
    }
}