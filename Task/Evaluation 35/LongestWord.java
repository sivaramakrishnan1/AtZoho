import java.util.Scanner;

class LongestWord
{
	int maxlen = -1;
	String answer = "";
	int count = 0;
	
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String[] arr = (s.nextLine()).split(" ");
		s.close();
		
				LongestWord obj = new LongestWord();

		for(String str : arr)
		{
			if(obj.maxlen < str.length())
				obj.maxlen = str.length();
		}
		
		for(String w : arr)	
			obj.createWords(arr, w, true);
		
		System.out.println(obj.answer);
		System.out.println(obj.count);
	}
	
	void createWords(String[] words, String word, boolean purelyString)
	{
		count++;
		for(String w : words)
			if((word + w).length() <= maxlen)	
				createWords(words, word + w, false);
		
		for(String w : words)
			if(word.equals(w) && word.length() > answer.length() && !purelyString) {
				answer = word;
			}
	}
}