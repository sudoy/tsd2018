package sudo.porker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokerGame {
	public static final int NUMBER_MAX = 13;

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();

		for(Mark mark : Mark.values()) {
			for(int number = 1; number <= NUMBER_MAX; number++) {
				cards.add(new Card(mark, number));
			}
		}

		List<Card> pickup = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			int x = new Random().nextInt(cards.size());
			pickup.add(cards.get(x));
			cards.remove(x);
		}

//		スリーカード
//		pickup = new ArrayList<>();
//		pickup.add(new Card("ダイヤ", 11));
//		pickup.add(new Card("ハート", 11));
//		pickup.add(new Card("クラブ", 11));
//		pickup.add(new Card("ハート", 1));
//		pickup.add(new Card("クラブ", 2));

//		ストレート
		pickup = new ArrayList<>();
		pickup.add(new Card(Mark.DIAMOND, 5));
		pickup.add(new Card(Mark.HEART, 5));
		pickup.add(new Card(Mark.CLUB, 9));
		pickup.add(new Card(Mark.SPADE, 2));
		pickup.add(new Card(Mark.HEART, 2));

		for(Card c : pickup) {
			System.out.println("{" + c.getMark() + ", " + c.getNumber() +"}");
		}

		PokerGame poker = new PokerGame();
		System.out.println(poker.judge(pickup));
	}

	private Hand handChain = null;

	public PokerGame() {
		handChain = new StraightFlush();
		handChain
			.setNext(new FourOfAKind())
			.setNext(new FullHouse())
			.setNext(new Flush())
			.setNext(new Straight())
			.setNext(new ThreeOfAKind())
			.setNext(new TwoPair())
			.setNext(new OnePair())
			.setNext(new NoPair());
	}

	public String judge(List<Card> cards) {
		return handChain.judge(cards);
	}
}
