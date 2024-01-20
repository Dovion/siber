package ru.dovion.model;

import lombok.Getter;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Getter
public class PokerHand implements Comparable<PokerHand> {

    private int rank;

    private LinkedList<Card> cards;

    public PokerHand(String hand) {
        cards = new LinkedList<>();
        var cardArray = hand.split(" ");
        for (int i = 0; i < cardArray.length; i++) {
            cards.add(new Card(cardArray[i]));
        }
        cards.sort(Comparator.comparingInt(Card::getRank));
        this.rank = calculateRank();
    }

    private int calculateRank() {
        if (cards.stream().map(Card::getSuit).toList().stream().distinct().count() == 1 &&
                cards.getLast().getRank() - cards.getFirst().getRank() == 4) {
            return 9;
        } else if (cards.stream()
                        .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                        .values()
                        .stream()
                        .anyMatch(count -> count == 4)) {
            return 8;
        } else if (cards.stream().map(Card::getRank).toList().stream().distinct().count() == 2 && cards.stream()
                                                                                                       .collect(
                                                                                                               Collectors.groupingBy(
                                                                                                                       Card::getRank,
                                                                                                                       Collectors.counting()))
                                                                                                       .values()
                                                                                                       .stream()
                                                                                                       .anyMatch(
                                                                                                               count ->
                                                                                                                       count ==
                                                                                                                               3)) {

            return 7;
        } else if (cards.stream().map(Card::getSuit).toList().stream().distinct().count() == 1) {
            return 6;
        } else if (cards.getLast().getRank() - cards.getFirst().getRank() == 4) {
            return 5;
        } else if (cards.stream()
                        .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                        .values()
                        .stream()
                        .anyMatch(count -> count == 3)) {
            return 4;
        } else if (cards.stream().map(Card::getRank).toList().stream().distinct().count() == 3 && cards.stream()
                                                                                                       .collect(
                                                                                                               Collectors.groupingBy(
                                                                                                                       Card::getRank,
                                                                                                                       Collectors.counting()))
                                                                                                       .values()
                                                                                                       .stream()
                                                                                                       .anyMatch(
                                                                                                               count ->
                                                                                                                       count ==
                                                                                                                               2)) {
            return 3;
        } else if (cards.stream()
                        .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                        .values()
                        .stream()
                        .anyMatch(count -> count == 2)) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int compareTo(PokerHand other) {
        var curHandRank = this.rank;
        var otherHandRank = other.rank;
        if (curHandRank == otherHandRank) {
            return Integer.compare(this.cards.getLast().getRank(), other.cards.getLast().getRank());
        }
        return Integer.compare(this.rank, other.rank);
    }
}
