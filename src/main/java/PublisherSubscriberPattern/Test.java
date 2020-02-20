package PublisherSubscriberPattern;

import ing.stockmarket.Transaction;

public class Test {

	public static void main(String[] args) {

		Transaction trans = new Transaction();
		trans.setId(1);
		trans.setAsk(100);
		trans.setBid(200);
		trans.setQty(200);

		// DatabaseConnection db = new DatabaseConnection();

		/*
		 * Thread thread = new Thread(db); thread.start();
		 */
	}
}
