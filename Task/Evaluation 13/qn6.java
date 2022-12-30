import java.util.Scanner;

class qn6 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();

		if (str2.length() < str1.length()) {
			int count = 0;

			for (int i = 0; i < str2.length(); i++) {
				if (str2.charAt(i) == str1.charAt(i))
					count++;
				else {
					str1 = setChar(str1, str2.charAt(i), i);
					System.out.println(str1);
				}
			}

			for (int i = str2.length(); i < str1.length(); i++) {
				str2 = removeChar(str1, i);
				System.out.println(str2);
			}

			System.out.println("\nResult : " + (str1.length() - count));
			s.close();
			return;
		}

		int count = 0;
		String str = "";

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i))
				count++;
			else {
				str1 = setChar(str1, str2.charAt(i), i);
				System.out.println(str1);
			}
		}

		for (int i = str1.length(); i < str2.length(); i++) {
			str1 += str2.charAt(i);
			System.out.println(str1);
		}

		System.out.println("\nResult : " + (str2.length() - count));
		s.close();
	}

	public static String setChar(String str, char c, int pos) {
		String copy = "";

		for (int i = 0; i < str.length(); i++) {
			if (i == pos) {
				copy += c + "";
				continue;
			}
			copy += str.charAt(i);
		}

		return copy;
	}

	public static String removeChar(String str, int pos) {
		String copy = "";

		for (int i = 0; i < str.length(); i++) {
			if (i == pos) {
				continue;
			}
			copy += str.charAt(i);
		}

		return copy;
	}
}