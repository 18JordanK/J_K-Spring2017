import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
public class hangman {

	public static void main(String[] args) {
		Scanner playerInput = new Scanner(System.in);

		//intro message
		String playerName = "";
		System.out.println("Hello there, What is your name?");
		playerName = playerInput.nextLine();
		System.out.println("Hello " + playerName + ". Consider captial letters"
				+ "and pick ONE letter. Now"
				+ "get ready to play hangman!");
		System.out.println("                ");

		//dictionary of words being used
		String [] words = {"the","of","and","a","to","in","is","you",
				"that","it","he","was","for","on","are","as","with","his",
				"they","I","at","be","this","have","from","or","one","had",
				"by","word","but","not","what","all","were","we","when","your",
				"can","said","there","use","an","each","which","she","do","how",
				"their","if","will","up","other","about","out","many","then","them",
				"these","so","some","her","would","make","like","him","into","time","has",
				"look","two","more","write","go","see","number","no","way","could","people",
				"my","than","first","water","been","call","who","oil","its","now","find",
				"long","down","day","did","get","come","made","may","part"};

		//Generation of a random number
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(words.length-1);

		String secretWord =  words[randomInt];
		String[] toShow = new String[secretWord.length()];
		System.out.println(randomInt + "1xEFO 084then342use33may39"+ secretWord+ "X2on...Loading");
		System.out.println("");
		int numGuesses = 10;
		System.out.println(playerName + ", you have " + numGuesses + 
				" guesses, use them wisely." );
		String guess = "";
		System.out.println("[Trial 1], Guess a letter, only ONE!" );

		ArrayList<String> Letters = new ArrayList<String>();

		for(int i=0; i<= numGuesses; i++){
			guess = playerInput.nextLine();
			while(guess.equals("")||guess.length()>1){
			}


			if(secretWord.contains(guess)){
				for(int k = 0 ; k < secretWord.length() ; k++)
				{
					if(Character.toString(secretWord.charAt(k)).equals(guess))
					{
						Letters.add(guess);

					}
				}
			}

			if(secretWord.length()==Letters.size()){	
				System.out.println("You guessed the word,"+secretWord+", Well done " + playerName + ".");
				break;
			}else if(secretWord.contains(guess)){
				System.out.println("Good guess.");
				System.out.println("[Trial "+  ((10-numGuesses)+1)+ "], Guess a letter, only ONE!");
			}else{
				numGuesses-=1;
				System.out.println("Guess again. ");
				System.out.println("[Trial "+  ((10-numGuesses)+1)+ "], Guess a letter, only ONE!");
			}

			for(String w: Letters){
				for(int e = 0 ; e < secretWord.length();e++){
					if(w.equals(Character.toString(secretWord.charAt(e))))
					{
						toShow[e] = w;
					}
				}
			}
			System.out.println(Arrays.toString(toShow));
		}

	}
}