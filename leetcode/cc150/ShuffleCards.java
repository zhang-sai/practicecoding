import java.util.Random;


public class ShuffleCards {
	Random r = new Random();
	public void shuffle(int[] cards) {
		
		for(int i = 0; i < cards.length; i++) {
			int index = r.nextInt(i);
			//swap index with i
			//image (0, i-1) has already been shuffled
			//so randomly picking a card from (0, i-1) and exchange that with i
			int tmp = cards[index];
			cards[index] = cards[i];
			cards[i] = tmp;
		}
	}
	
	//randomly select m cards
	public void randomSelectCards(int[] cards, int m) {
		int[] result = new int[m];
		for(int i = 0; i < m; i ++) {
			result[i] = cards[i];
		}
		for(int i = m ; i < cards.length; i++) {
			//swap the ith card with some card before
			int randomIndex = r.nextInt(i);
			if(randomIndex < m) {
				//do swapping
				int tmp = cards[i];
				cards[i] = result[randomIndex];
				result[randomIndex] = tmp; 
			}
		}
	}
	
}
