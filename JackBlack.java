import java.util.Scanner;



public class JackBlack {
 //setting the player/dealer wins to 0
	static public int playerCounter = 0 ; 

	static public int dealerCounter = 0 ; 

	static public int numHands = 1 ; 
    //setting the number of hands to 1
 
	

	public static void main(String[] args) {

		System.out.println("Let's play some JackBlack!");

		System.out.println();

		int numInput = 1 ; 

		

		while (numInput == 1 ) {

			play() ; 



			System.out.println(roundWinner()); //shows either if the dealer or user wins the hand

			System.out.println();



			System.out.println( "Would like to continue playing? Type 0 for no or 1 for yes."); 
            //asks if the user wants to play again using a scanner, 0 for no and 1 for yes

			Scanner in = new Scanner(System.in) ; 

			 numInput = in.nextInt() ; //true or false using number values



		}

		

		

		

		if(numInput == 1 ) { //starts the game as the user wanting to play is true

			play() ; 

			System.out.println(roundWinner()); //shows either if the dealer or user wins the hand

			System.out.println();

			System.out.println( "Thanks for playing. Bye bye."); 

			

			

		}

		

		

		if(numInput == 0) {

			System.out.println( "See you later. Please play again soon!"); 
            // goodbye message if player doesn't want to continue playing

		}



	}

	

	public static int dealer() {

		// generate a random number from 0 to 12 for the dealer 

		// this will be the set dealer's hand; dealer will not hit anymore

		int random = (int) (Math.random() * 12) ; 

		// return the value

		return random ; 

	}

	

	public static int player() {

		// lowest possible value for a card is 1 aka ace 

		int firstCard = (int) (Math.random() * 13) + 1 ; 
        //generates the first random card value from 1 to 13 mocking the cards in a deck

		int secondCard = (int) (Math.random() * 13) + 1 ; 
        //generates the second random card value from 1 to 13 mocking the cards in a deck

		

		

		int difference = Math.abs(secondCard - firstCard) ; 
        //finds the difference between the two cards, uses the absolute value to make sure it is positive
		return difference ; 

	}

	

	public static String winner() {

		

		if( player() < dealer() ) {

			playerCounter++ ;

			return("You win this hand!" );
            //if the player's hand is less than the dealer's hand, the player wins
		} 

		

		else if( player() == dealer() ) {

			return( "Draw!" ) ;
            //if the player's hand is equal to the dealer's hand, it is a draw
		}

		

		else {

			dealerCounter++ ; 

			return( "You lose this hand. Better luck next time!" );
            //if the player's hand is greater than the dealer's hand, the dealer wins
		}

	}

	

	public static String roundWinner() {

		if (playerCounter > dealerCounter) {

			return("Results: You win!") ; 
            //if the player wins more hands than the dealer, the player wins
		}

		

		else if(playerCounter < dealerCounter) {

			return("Results: You lose!") ; 
            //if the player loses more hands than the dealer, the dealer wins.
		}

		

		else { return ("Results: Tie!") ; }
        //if the player and dealer have the same number of wins, it is a tie

		

	}

	

	public static void play() {

		System.out.println();

		System.out.println("Hand " + numHands); //shows the number of hands the user and dealer have played

		System.out.println("-------------------------");

		System.out.println( "Dealer's hand is: " + dealer() ); //shows the dealer's hand

		System.out.println( "Your hand is: " + player() ) ; //shows the player's hand

		System.out.println(winner()); //shows the winner of the hand

		System.out.println();

		numHands++ ; //adds the number of hands played to the number of hands played

	}



	



}

