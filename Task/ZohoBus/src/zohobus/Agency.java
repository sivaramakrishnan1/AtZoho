package zohobus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agency implements Serializable{
	String username, password;
	List<Bus> busses = new ArrayList<>();

	public Agency(String name, String password) {
		this.username = name;
		this.password = encryptPassword(password);
	}
	
	public String getUsername() {
		return username;
	}

	public boolean authenticate(String password) {
		password = encryptPassword(password);
		return password.equals(this.password);
	}

	public String encryptPassword(String password) {
		String encrypted = "";

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == 'z')
				encrypted += "a";
			else if (password.charAt(i) == 'Z')
				encrypted += "A";
			else if (password.charAt(i) == '9')
				encrypted += "0";
			else
				encrypted += (char) (password.charAt(i) + 1);
		}

		return encrypted;
	}

	public void addBus(Bus b) {
		busses.add(b);
	}

	public boolean removeBus(String busname) {
		for (int i = 0; i < busses.size(); i++) {
			if (busses.get(i).getBusName().equals(busname)) {
				busses.remove(i);
				return true;
			}
		}

		return false;
	}
}
