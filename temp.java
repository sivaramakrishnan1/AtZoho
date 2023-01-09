import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class temp {

	public static void main(String[] args) throws ParseException {
		String strDate = "29/12/96";
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(strDate);
		System.out.print(strDate + " " + date);
	}
}