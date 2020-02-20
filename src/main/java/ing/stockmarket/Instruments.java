package ing.stockmarket;

public class Instruments {

	private int symbol;
	private String description;
	private int nominalValueOf1Lot;
	private double pipValue;
	private double minTradeVolume;
	private double maxTradeVolume;
	private double marginRate;
	private float tradingHours;



	public Instruments(int symbol, String description, int nominalValueOf1Lot, double pipValue, double minTradeVolume, double maxTradeVolume, double marginRate, float tradingHours) {
		this.symbol = symbol;
		this.description = description;
		this.nominalValueOf1Lot = nominalValueOf1Lot;
		this.pipValue = pipValue;
		this.minTradeVolume = minTradeVolume;
		this.maxTradeVolume = maxTradeVolume;
		this.marginRate = marginRate;
		this.tradingHours = tradingHours;
	}

	public Instruments  ()
	{

	}
	public int getSymbol() {
		return symbol;
	}

	public void setSymbol(int symbol) {

		this.symbol = symbol;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;

	}

	public int getNominalValueOf1Lot() {

		return nominalValueOf1Lot;
	}

	public void setNominalValueOf1Lot(int nominalValueOf1Lot) {

		this.nominalValueOf1Lot = nominalValueOf1Lot;

	}

	public double getPipValue() {

		return pipValue;

	}

	public void setPipValue(double pipValue) {

		this.pipValue = pipValue;

	}

	public double getMinTradeVolume() {

		return minTradeVolume;

	}

	public void setMinTradeVolume(double minTradeVolume) {

		this.minTradeVolume = minTradeVolume;
	}

	public double getMaxTradeVolume() {

		return maxTradeVolume;
	}

	public void setMaxTradeVolume(double maxTradeVolume) {

		this.maxTradeVolume = maxTradeVolume;
	}

	public double getMarginRate() {

		return marginRate;
	}

	public void setMarginRate(double marginRate) {

		this.marginRate = marginRate;

	}

	public float getTradingHours() {

		return tradingHours;
	}

	public void setTradingHours(float tradingHours) {

		this.tradingHours = tradingHours;
	}

}
