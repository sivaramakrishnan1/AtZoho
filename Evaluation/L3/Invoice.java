import java.util.*;

class Invoice {	
	int invoiceId, custId;
	Content[] contents;
	Date time;
	double grandTotal;

	Invoice(int invoiceId, int custId, Content[] contents, Date time, double grandTotal) {
		this.invoiceId = invoiceId;
		this.custId = custId;
		this.contents = contents;
		this.time = time;
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		String res = String.format("|%20s|%-20s|\n", invoiceId, custId);

		for (int i = 0; i < contents.length; i++) {
			res +=  (contents[i]).toString() + "\n";
		}

		res += String.format("%30s|%-10s", "|Grand Total ", grandTotal);
		
		return res;
	}

}