import java.util.Scanner;

class qn3 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();

		int pos = -1, count = 0, maxcount = 0;

		for (int i = 0; i < str1.length(); i++) {
			if (isIn(str2, pos + 1, str1.charAt(i)) != -1) {
				pos = isIn(str2, pos + 1, str1.charAt(i));
				count++;
			}
			if (maxcount < count) {
				maxcount = count;
			}
		}

		System.out.println(maxcount);
	}

	public static int isIn(String str, int pos, char c) {
		for (int i = pos; i < str.length(); i++) {
			if (str.charAt(i) == c)
				return i;
		}

		return -1;
	}
}