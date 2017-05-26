import java.util.*;

public class Hangman {
	String[] words = {"OPEN", "DOOR", "ABLE", "TINT", "FOND", "RANT", "TEST", "PART", "FALL",
			"WORD", "STEM", "FLEM", "WALL", "RACE", "CARS", "FOUR", "YOUR", "EGGS", "PIES", "CAKE"};
	private String word;
	String userWord = "";
	private int numIncorrect = 6;
	private ArrayList<Character> usedWords = new ArrayList<Character>();
			
	public Hangman(){
		Random rand = new Random();
		int index = 0 + (int)(Math.random() * ((words.length-1 - 0) + 1));
		
		this.word = words[index];
		for(int i=0; i < this.word.length();i++){
			userWord += "_";
		}
		System.out.println("You have " + numIncorrect + " incorrect guesses left.");
		
	}
	
	public int getNumIncorrect(){
		return this.numIncorrect;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public String getUserWord(){
		return this.userWord;
	}
	
	public ArrayList<Character> getUsedWords(){
		return this.usedWords;
	}
	
	public void guessLetter(char letter){
		if(letter > 'Z'){
			letter -= ' ';
		}
		
		boolean contains = false;
		for(int i=0; i<this.word.length(); i++){
			if(this.word.charAt(i) == letter){
				contains = true;
			}
		}
		
		if(contains){
			userWord = fillLetters(userWord, letter);
		}else{
			System.out.println("The word does not contain \"" + letter + "\"");
			this.numIncorrect--;
			if(this.numIncorrect>0){
				System.out.println("You have " + numIncorrect + " incorrect guesses left.");
			}
		}
		System.out.println(userWord);
		if(this.numIncorrect == 0){
			System.out.println("You lost.");
		}
		this.usedWords.add(letter);
	}
	
	public String fillLetters(String s, char letter){
		char[] chars = s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(this.word.charAt(i) == letter){
			    chars[i] = letter;
			}
		}
		return String.valueOf(chars);
	}
	
	public static void main(String[] args){
		//Asks user if they want to play.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play Hangman?");
		String userInput = scanner.nextLine();
		
		//
		while(!userInput.toUpperCase().contains("NO")){
			Hangman game = new Hangman();
			System.out.println(game.getUserWord());
			Scanner userScanner = new Scanner(System.in);
			String input = userScanner.nextLine();
			char guess;
			
			while(game.getNumIncorrect() > 0 && !game.getUserWord().equals(game.getWord())){
				System.out.println("Guess a letter.");
				while(!validInput(input, game)){
					System.out.println("Invalid guess \n Guess Again.");
					input = userScanner.nextLine();
				}
				guess = input.charAt(0);
				game.guessLetter(guess);
				if(game.getUserWord().equals(game.getWord())){
					System.out.println("You won!");
				}else{
					input = userScanner.nextLine();
				}
			}
			
			System.out.println("Do you want to play Hangman?");
			userInput = scanner.nextLine();
		}
		System.out.print("Session terminated.");
	}

	private static boolean validInput(String input, Hangman game) {
		boolean valid = true;
		if(input.length() > 2 || input.length() == 0){
			return false;
		}
		
		for(int i=0;i<game.getUsedWords().size();i++){
			if(game.getUsedWords().get(i) == (input.charAt(0) + ' ')){
				valid = false;
			}
		}
		return valid;
	}
}
