package ing.stockmarket;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class GenerateInstrumentsThread implements Runnable {

	static Logger logger = Logger.getLogger(GenerateInstrumentsThread.class);

	InstrumentResourcesLock lock;

	BlockingQueue<Instruments> generateInstruments;

	public static int k = 0;

	public static int y = 0;

	public GenerateInstrumentsThread(InstrumentResourcesLock lock, BlockingQueue<Instruments> generateInstruments) {

		this.lock = lock;

		this.generateInstruments = generateInstruments;

	}

	@Override
	public void run() {

		logger.info("Start generating a random array of instruments!");

		Random rand = new Random(47);
		synchronized (lock) {
			try {

				for (int j = 0; j < 10; j++) {

					while (lock.getSwitchingInstrumentFlag() != 1 || !lock.getInstrumentFlag().get()) {

						try {
							lock.wait();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}

					if (j == 9) {
						lock.getShutDownInstrument().set(false);
					}

					Instruments instrument = new Instruments();

					instrument.setSymbol(++k);

					instrument.setDescription("Some_description" + (k));

					instrument.setMarginRate(rand.nextInt(1));

					instrument.setMinTradeVolume(rand.nextDouble());

					instrument.setMaxTradeVolume(rand.nextDouble());

					instrument.setNominalValueOf1Lot(k);

					instrument.setPipValue(rand.nextDouble());

					instrument.setTradingHours(24);

					generateInstruments.put(instrument);

					Thread.sleep(15);

				}

			} catch (Exception e) {

				logger.error("Error inside of GenerateInstrumentsThread.class");
			}
		}

	}

}
