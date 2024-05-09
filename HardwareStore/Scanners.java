package HardwareStore;

public class Scanners extends Items{
    public Scanners(String brand, double price, boolean isColored, boolean isMultiFeed) {
		super(brand, price);
		this.isColored = isColored;
		this.isMultiFeed = isMultiFeed;
	}
	protected boolean isColored;
	protected boolean isMultiFeed;
	
	public Scanners(String brand, double price) {
		super(brand, price);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the isColored
	 */
	public boolean isColored() {
		return isColored;
	}
	/**
	 * @param isColored the isColored to set
	 */
	public void setColored(boolean isColored) {
		this.isColored = isColored;
	}
	/**
	 * @return the isMultiFeed
	 */
	public boolean isMultiFeed() {
		return isMultiFeed;
	}
	/**
	 * @param isMultiFeed the isMultiFeed to set
	 */
	public void setMultiFeed(boolean isMultiFeed) {
		this.isMultiFeed = isMultiFeed;
	}



	@Override
	public String toString() {
		return "Scanners [isColored=" + isColored + ", isMultiFeed=" + isMultiFeed + ", Brand=" + Brand + ", price="
				+ price + "]";
	}
}
