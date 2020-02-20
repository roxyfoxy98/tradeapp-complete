package ing.stockmarket;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class GenerateCustomerThread implements Runnable {

	static Logger logger = Logger.getLogger(GenerateCustomerThread.class);

	CustomerResourcesLock lock;

	BlockingQueue<Customers> generateCustomers;

	public static int n = 0;
	public static int m = 0;
	public static int e = 0;

	public GenerateCustomerThread(CustomerResourcesLock lock, BlockingQueue<Customers> generateCustomers) {

		this.lock = lock;

		this.generateCustomers = generateCustomers;

	}

	@Override
	public void run() {

		logger.info("Start generating a random array of customers!");

		synchronized (lock) {
			try {

				for (int j = 0; j < 50; j++) {

					while (lock.getSwitchingCustomerFlag() != 1 && lock.getCustomerFlag().get()) {

						try {
							lock.wait();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}

					if (j == 49) {
						lock.getShutDownCustomer().set(false);
					}

					Customers customer = new Customers();

					customer.setID(++n);

					customer.setAddress("Street" + n);

					customer.setAge(18 + (int) (Math.random() * ((64 - 18) + 1)));

					customer.setName("Name" + (n));

					customer.setPhone(223443 + (n));

					customer.setSex('M');

					generateCustomers.put(customer);

					Thread.sleep(15);

				}

				Thread.sleep(2000);

			} catch (Exception e) {

				logger.error("Error inside of GenerateCustomersThread.class");
			}
		}

	}

}
