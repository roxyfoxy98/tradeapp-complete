package ing.testing;

import ing.stockmarket.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MarketMakerTesting {

	private static final String FILE_PATH="C:\\Users\\MH90UT\\GeneratedFile\\RandGenTransactions.csv";
	private static final Queue<Transaction> transaction = Utils.readCsv(FILE_PATH, 100, TypeOfReading.GREATER);


	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void publishingSharesOnStockMarket() {

		MarketMaker mockMarketMaker = mock(MarketMaker.class);
		
		when(mockMarketMaker.readTransaction(any(String.class))).thenReturn(transaction);

		assertEquals("The expected value must be the same with the real value!",transaction,mockMarketMaker.readTransaction(FILE_PATH));
		
		verify(mockMarketMaker).readTransaction(any(String.class));
		
		assertEquals("The real value must be 100!", 100, Configuration.getQTY());

	}

	
	@Test
	public void integrityOfDataInConfigFile() {

		boolean typeOfMinAsk = (Integer) Configuration.getMin_Ask() instanceof Integer;
		boolean typeOfMaxAsk = (Integer) Configuration.getMax_Ask() instanceof Integer;

		boolean typeOfMinBid = (Integer) Configuration.getMin_Bid() instanceof Integer;
		boolean typeOfMaxBid = (Integer) Configuration.getMax_Bid() instanceof Integer;

		boolean typeOfQty = (Integer) Configuration.getQTY() instanceof Integer;
		boolean typeOfPath = Configuration.getPath() instanceof String;
		
		assertTrue(typeOfMinAsk);
		assertTrue(typeOfMaxAsk);
		assertTrue(typeOfMinBid);
		assertTrue(typeOfMaxBid);
		assertTrue(typeOfQty);
		assertTrue(typeOfPath);
	}

}
