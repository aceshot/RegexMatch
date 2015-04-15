package recursion;


import java.util.Scanner;

public class Main {
	
		public static void main(String[] args) {
		System.out.println("请输入模式字符串:");
		Scanner sc = new Scanner(System.in);
		String pattern = sc.next();

		System.out.println("请输入待匹配字符串:");
		String text = sc.next();
		
		
		boolean b = matches(pattern, text);
		System.out.println(b);
	}

	private static boolean matches(String pattern, String text) {
		char[] patternChar = pattern.toString().toCharArray();
		char[] textChar = text.toString().toCharArray();
		if (pattern.equals("") && text.equals(""))
			return true;
		if (patternChar[1] == '*'){
			try {
				return match_star(patternChar[0],
						pattern.substring(2), text);
			} catch (Exception e) {
			}
		}
		
		if (patternChar[0] == textChar[0] && !text.equals("")){
			try {
				return matches(pattern.substring(1),
						text.substring(1));
			} catch (Exception e) {
			}
		}
			
		return false;
	}

	private static boolean match_star(char c, String pattern,
			String text) {
		char[] textChar = text.toString().toCharArray();
		int i = 0;
		do {
			if (matches(pattern, text.substring(i))) return true;
		} 
		while (!text.equals("") && (textChar[i++] == c || c == '.'));
		return false;
	}

}
