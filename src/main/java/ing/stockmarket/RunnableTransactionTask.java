package ing.stockmarket;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class RunnableTransactionTask implements Runnable {

	static Logger logger = Logger.getLogger(RunnableTransactionTask.class);

	TransactionResourcesLock lock;

	BlockingQueue<Transaction> generateTransaction;

	private String threadName;

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public RunnableTransactionTask(String name, TransactionResourcesLock lock,
			BlockingQueue<Transaction> generateTransaction) {

		threadName = name;
		this.lock = lock;
		this.generateTransaction = generateTransaction;

	}

	public void run() {

		logger.info("Inside of duplication thread!");

		System.out.println("The time is: " + new Date());

		int z = TransactionResourcesLock.getTransactionLinkedList().size();

		lock.setSwitchingTransactionFlag(2);

		synchronized (lock) {
			try {

				if (lock.getTransactionFlag().compareAndSet(true, false)) {

					if (z != 0 && lock.getShutDownTransaction().get()) {

						Transaction transaction = TransactionResourcesLock.getTransactionLinkedList().getLast();

						int valueOfQTY = transaction.getQty();

						transaction.setBid(valueOfQTY);

						try {

							generateTransaction.put(transaction);

						} catch (InterruptedException e) {

							logger.error(e.getMessage());
						}

						logger.info(
								"Start writing into file: " + Configuration.getSCHEDULER_RECORDS_PATH() + "111.csv");

						logger.info("The duplicated transaction is: " + "\t ID:  " + transaction.getId() + "\t BID:  "
								+ transaction.getBid() + "\t ASK:  " + transaction.getAsk() + "\t QTY:  "
								+ transaction.getQty());

					} else {

						logger.info("The execution of the generator has been done!");
					}

				}

			} catch (Exception e) {

				logger.info("Error arised from Transaction Duplicator!");

				logger.error(e.getMessage());

			} finally {

				lock.setSwitchingTransactionFlag(1);

				lock.getTransactionFlag().set(true);

				lock.notifyAll();
			}
		}
	}

}
