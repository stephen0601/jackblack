import java.util.Scanner;
public class JackBlack {

	static public int playerCounter = 0 ; 
	static public int dealerCounter = 0 ; 
	static public int numHands = 1 ; 
	//sets the round to 1 and player and dealer wins to 0
	public static void main(String[] args) {
		System.out.println("Let's play some jackblack!");
		
		System.out.println();
		
		int numInput = 1 ; 
		//starts the game
		while (numInput == 1 ) {
			play() ; 
			System.out.println(roundWinner());

			System.out.println();

			System.out.println( "Would like to continue playing? Type 0 for no or 1 for yes.");

			Scanner scanner = new Scanner(System.in) ; 

			numInput = scanner.nextInt() ; 
			//asks the user if they want to continue playing
		}
		// goodbye message if player doesn't want to continue playing
		if(numInput == 0) {
			System.out.println( "See you later. Please play again soon!");
			//prints the goodbye message if the user doesn't want to continue playing
		}
	}
	public static int dealerTopCard() {
		int dealerFirstCard = (int) (Math.random() * 13) + 1 ; 

		return dealerFirstCard;
		//deals the first card of the dealer and reveals to user
	}
	public static int dealerSecCard() {
		int dealerSecondCard = (int) (Math.random() * 13) + 1 ; 

		return dealerSecondCard ; 
		//deals the second card of the dealer and is hidden to the user

	}
	public static int playerTopCard() {
		int playerFirstCard = (int) (Math.random() * 13) + 1 ; 

		return playerFirstCard;
		//deals the first card of the player and returns the card
	}
	public static int playerSecCard() {
		int secCard = (int) (Math.random() * 13) + 1 ; 

		return secCard ; 
		//deals the second card of the player and returns the card
	} 
	public static String winner() {int player = difference( playerTopCard(), playerSecCard()) ; 

		int dealer = difference( dealerTopCard(), dealerSecCard()) ; 
		//finds the difference between the cards of the player and dealer
		

		if( player < dealer ) {
			playerCounter++ ;

			return("You win this hand!" );
			//if the player has a lower difference than the dealer, the player wins the hand 
		}
		else if( player == dealer ) {

			return( "Draw!" ) ;
			//if the player and dealer have the same difference, it is a draw
		}
		else {
			dealerCounter++ ; 
			return( "You lose this hand. Better luck next time!" );
			//if the player has a higher difference than the dealer, the player loses the hand 
		}
	}

	

	public static String winner( int player, int dealer ) {
		if( player < dealer ) {

			playerCounter++ ;

			return("You win this hand!" );
			//if the player has a lower difference than the dealer, the player wins the hand and counters goes up by 1
		}

		else if( player == dealer ) {
			return( "Draw!" ) ;
			//if the player and dealer have the same difference, it is a draw
		}

		else {
			dealerCounter++ ; 

			return( "You lose this hand. Better luck next time!" );
			//if the player has a higher difference than the dealer, the player loses the hand and counters goes up by 1
		}
	}
	public static String roundWinner() {
		if (playerCounter > dealerCounter) {

			return("Overall Results: You win!") ; 
			//if the player has more wins than the dealer, the player wins the game
		}
		else if(playerCounter < dealerCounter) {

			return("Overall Results: You lose!") ; 
			//if the player has less wins than the dealer, the player loses the game
		}
		else { return ("Overall Results: Tie!") ; }
		//if the player and dealer have the same number of wins, it is a tie
	}
	public static void play() {
		System.out.println();

		System.out.println("Hand " + numHands);
		//prints the number of the hands played
		System.out.println("-------------------------");

		int d1 = dealerTopCard() ;

		int d2 = dealerSecCard() ;

		int p1 = playerTopCard() ;

		int p2 = playerSecCard() ;
		//deals the cards to the player and dealer
		int dealerDiff = difference( d1, d2 ) ;

		int playerDiff = difference( p1, p2 ) ;
		//finds the difference between the cards of the player   
		//prints the difference between the cards of the dealer
		System.out.println( "Your first card is: " + p1 );

		System.out.println( "Your second card is: " + p2 );

		System.out.println( "Your hand is: " + difference( p1, p2 ) ) ;

		System.out.println("Dealer's top card: " + d1 );

		System.out.println();

		System.out.println("Would you like to hit? Type 0 for no or 1 for yes.");

		Scanner scanner = new Scanner(System.in) ; 

		int hitOrNot = scanner.nextInt() ; 

		if( hitOrNot == 1 ) { 
			int playerNew = hit( playerDiff ) ;  // new diff is returned 

			// compare   

			System.out.println("Player's new hand: " + playerNew);
			
			System.out.println( winner( playerNew, dealerDiff ) ); 

			

		}
		else {
			System.out.println(winner( playerDiff, dealerDiff));

			System.out.println();

		}
		numHands++ ; 
	}
	public static int hit( int oldDiff ) {

		int card = (int) (Math.random() * 13) + 1 ;

		int newDiff = Math.abs(oldDiff - card) ;

		System.out.println( "Your hit card is: " + card );

		return newDiff ; 

	}
	public static int difference( int card1, int card2) {
		int difference = Math.abs( card1 - card2 )  ; 

		return difference ; 

	}
}
