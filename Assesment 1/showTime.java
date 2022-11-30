import java.util.*;
import java.text.*;

class showTime {
	public static void main(String args[]) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(today));
	}
}