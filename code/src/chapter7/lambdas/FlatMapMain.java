package chapter7.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 使用flatMap
 */
public class FlatMapMain {

    public static void main(String[] args) {
        System.out.println(newDeckByIterative());
        System.out.println(newDeckByStream());
    }

    /**
     * 迭代方法计算笛卡尔积，即生成一副扑克
     */
    static List<Card> newDeckByIterative(){
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    /**
     * 流式计算笛卡尔积，即生成一副扑克
     */
    static List<Card> newDeckByStream(){
        return Arrays.stream(Suit.values()).flatMap(suit ->
                Arrays.stream(Rank.values()).map(rank -> new Card(suit, rank))
        ).collect(Collectors.toList());
    }

    static final class Card{
        private final Suit suit;
        private final Rank rank;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit && Objects.equals(rank, card.rank);
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, rank);
        }

        @Override
        public String toString() {
            return suit.symbol + rank.symbol;
        }

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }

    /**
     * 花色
     */
    enum Suit {
        spade("♠"), heart("♥"), club("♣"), dianmond("♦"),
        ;
        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }
    }

    /**
     * 牌面
     */
    enum Rank{
        ace("A"),two("2"),three("3"),four("4"),
        five("5"),six("6"),seven("7"),eight("8"),nine("9"),
        ten("10"),jack("J"),queen("Q"),king("K")
        ;

        private final String symbol;

        Rank(String symbol) {
            this.symbol = symbol;
        }
    }
}
