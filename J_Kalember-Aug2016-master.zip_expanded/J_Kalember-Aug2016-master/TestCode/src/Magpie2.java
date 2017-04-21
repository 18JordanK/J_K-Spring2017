
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	
	public String getResponse(String statement) {
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		}else if (statement.indexOf("Mr.") >= 0){
			response = "He sounds like a good man.";
		}else if (statement.indexOf("Ms.") >=0 || statement.indexOf("Mrs.") >=0 ){
			response = "She sounds like a good woman";		
		}else if(statement == ""){
			response = "Say something I'm giving up on you.";
		}else if(statement.indexOf("apple") >= 0 
				|| statement.indexOf("banana") >= 0
				|| statement.indexOf("pineapple") >= 0
				|| statement.indexOf("orange") >= 0
				|| statement.indexOf("lemon") >= 0) {
			response = "Fruit is always healthy.";
		}else if(statement.indexOf("vegetable") >= 0
				|| statement.indexOf("broccoli") >= 0
				|| statement.indexOf("carrot") >= 0
				|| statement.indexOf("eggplant") >= 0
				|| statement.indexOf("lettuce") >= 0){
			response = "Vegetables are the key to lonegevity.";
		}else if(statement.indexOf("eat") >= 0
				|| statement.indexOf("breakfast") >= 0
				|| statement.indexOf("lunch") >= 0
				|| statement.indexOf("dinner") >= 0
				|| statement.indexOf("brunch") >= 0
				|| statement.indexOf("meal") >= 0
				|| statement.indexOf("supper") >= 0){
					response = "... Oh boy, I am starving";
		}else{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}else if(whichResponse == 4){
			response = "Can you say that again, I couldn't understand.";
		}else if(whichResponse == 5){
			response = "I was thinking the same thing.";
		}else if(whichResponse == 6){
			response = "Can you eat that?";
		}

		return response;
	}
}
