package ru.dovion.model;

import lombok.Getter;

@Getter
public class Card {
    private int rank;

    private String suit;


    public Card(String card) {
        var result = card.split("");
        switch (result[0]) {
            case "2":
                rank = 2;
                break;
            case "3":
                rank = 3;
                break;
            case "4":
                rank = 4;
                break;
            case "5":
                rank = 5;
                break;
            case "6":
                rank = 6;
                break;
            case "7":
                rank = 7;
                break;
            case "8":
                rank = 8;
                break;
            case "9":
                rank = 9;
                break;
            case "T":
                rank = 10;
                break;
            case "J":
                rank = 11;
                break;
            case "Q":
                rank = 12;
                break;
            case "K":
                rank = 13;
                break;
            case "A":
                rank = 14;
        }
        suit = result[1];
    }


}
