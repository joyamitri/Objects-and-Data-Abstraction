package HardwareStore;

public class Items {
    protected String Brand;
	protected double price;

	public Items(String brand, double price) {
		// constructors with parameters
		Brand = brand;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	@Override
	public String toString() {
		return "Items [Brand=" + Brand + ", price=" + price + "]";
	}
}
