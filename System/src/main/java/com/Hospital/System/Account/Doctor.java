package com.Hospital.System.Account;

class Doctor {
	private String name, username, encpassword;

	Doctor(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.encpassword = encrypt(password);
	}

	private String encrypt(String password) {
		String str = "";

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == 'z')
				str += 'a';
			else if (password.charAt(i) == 'Z')
				str += 'A';
			else if (password.charAt(i) == '9')
				str += '0';
			else
				str += (char) (password.charAt(i) + 1);
		}

		return str;
	}

	
}
