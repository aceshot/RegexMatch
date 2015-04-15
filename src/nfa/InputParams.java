package nfa;

import java.util.ArrayList;
import java.util.List;

public class InputParams {

	private List<Pair> pairs = new ArrayList<Pair>();

	public List<Pair> getPairs() {
		return pairs;
	}

	public void setPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	public InputParams(String inputStr) {
		buildPairs(inputStr);
	}

	private void buildPairs(String input) {
		int len = input.length();
		for(int i=0; i<len; i++){
			if(Character.isLetterOrDigit(input.charAt(i)) || input.charAt(i) == '.'){
				if(i+1<len && !Character.isLetterOrDigit(input.charAt(i+1)) && input.charAt(i+1) != '.'){
					add(input.charAt(i), input.charAt(i+1));
				}else{
					add(input.charAt(i), ' ');
				}
			}
		}
	}

	private void add(char ch, char op) {
		pairs.add(new Pair(ch, op));
	}

	public static class Pair {
		private char character;
		private char opCode;

		public Pair(char character, char opCode) {
			this.character = character;
			this.opCode = opCode;
		}

		public char getCharacter() {
			return character;
		}

		public void setCharacter(char character) {
			this.character = character;
		}

		public char getOpCode() {
			return opCode;
		}

		public void setOpCode(char opCode) {
			this.opCode = opCode;
		}
		@Override
		public String toString() {
			return "["+character+","+opCode+"]";
		}
	}
}
