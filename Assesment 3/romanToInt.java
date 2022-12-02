import java.util.Scanner;

class romanToInt {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int val = 0;
		String rom = s.next();

		for (int i = 0; i < rom.length(); i++) {
			if(i < rom.length() - 1 && intValOfRom(rom.charAt(i)) < intValOfRom(rom.charAt(i+1))) {
				val += intValOfRom(rom.charAt(i+1)) - intValOfRom(rom.charAt(i));
				i++;
			}
			else {
				val += intValOfRom(rom.charAt(i));
			}
		}

		System.out.println(val);
		s.close();
	}

	public static int intValOfRom(char rom) {
		switch(rom) {
			case 'M' : return 1000;
			case 'D' : return 500;
			case 'C' : return 100;
			case 'L' : return 50;
			case 'X' : return 10;
			case 'V' : return 5;
			case 'I' : return 1;
		}
		return 0;
	}
}