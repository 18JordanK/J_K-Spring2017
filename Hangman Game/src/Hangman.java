import java.util.Random;
import java.util.*;

public class Hangman {
	String[] words = {"OPEN", "DOOR", "ABLE", "TINT", "FOND", "RANT", "TEST", "PART", "FALL",
			"WORD", "STEM", "FLEM", "WALL", "RACE", "CARS", "FOUR", "YOUR", "EGGS", "PIES", "CAKE"};
	private String word;
	String userWord = "    ";
	private int numIncorrect = 6;
	List<Character> usedWords = new ArrayList<Character>();
			
	public Hangman(){
		Random rand = new Random();
		int index = rand.nextInt(20);
		
		this.word = words[index];
		System.out.println("You have " + numIncorrect + " incorrect guesses left.");
		
	}
	
	public String getWord(){
		return this.word;
	}
	
	public String getUserWord(){
		return this.userWord;
	}
	
	public void guessLetter(char letter){
		boolean contains = false;
		for(int i=0; i<this.word.length(); i++){
			if(this.word.charAt(i) == letter){
				contains = true;
			}
		}
		
		if(contains){
			fillLetters(userWord, letter);
		}else{
			System.out.println("The word does not contain a " + letter);
		}
		
		System.out.println(userWord);
	}
	
	public String fillLetters(String s, char letter){
		char[] chars = s.toCharArray();
		for(int i=0;i<s.length()-1;i++){
			if(this.word.charAt(i) == letter){
			    chars[i] = letter;
			}
		}
		return String.valueOf(chars);
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play Hangman?");
		String userInput = scanner.nextLine();
		
		while(!userInput.contains("no")){
			Hangman game = new Hangman();
			Scanner input = new Scanner(System.in);
			char guess;

			while(!game.getUserWord().equals(game.getWord())){
				System.out.println("Guess a letter.");
				guess = input.nextLine().charAt(0);
				game.guessLetter(guess);
			}
			
			System.out.println("Do you want to play Hangman?");
			userInput = scanner.nextLine();
		}
		System.out.print("Session terminated.");
	}
}
