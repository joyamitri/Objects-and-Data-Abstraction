package HardwareStore;

public class Printers extends Items {
	protected boolean isColored;
	protected boolean isInkjet;

	public Printers(String brand, double price) {
		super(brand, price);
	}

	public boolean isColored() {
		return isColored;
	}

	public Printers(String brand, double price, boolean isColored, boolean isInkjet) {
		super(brand, price);
		this.isColored = isColored;
		this.isInkjet = isInkjet;
	}

	public void setColored(boolean isColored) {
		this.isColored = isColored;
	}

	public boolean isInkjet() {
		return isInkjet;
	}

	public void setInkjet(boolean isInkjet) {
		this.isInkjet = isInkjet;
	}

	@Override
	public String toString() {
		return "Printers [isColored=" + isColored + ", isInkjet=" + isInkjet + ", Brand=" + Brand + ", price=" + price
				+ "]";
	}

}
