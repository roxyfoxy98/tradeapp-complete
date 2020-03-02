package YahooStockData;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class SingleStockFetch {
    public static void GetSingleStockPrice(String quotedStock) {
        Stock stock=null;

        {
            try {
                stock = YahooFinance.get(quotedStock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        System.out.println(price);
        //stock.print();
    }
}
