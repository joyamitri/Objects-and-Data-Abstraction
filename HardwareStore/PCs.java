package HardwareStore;

public class PCs extends Computers {

	public PCs(String brand, double price, String cpu_brand, String cpu_speed, String hard_Disk_capacity,
			String ram_capacity) {
		super(brand, price, cpu_brand, cpu_speed, hard_Disk_capacity, ram_capacity);
	}


	@Override
	public String toString() {
		return "PC [CPU_brand=" + CPU_brand + ", CPU_speed=" + CPU_speed + ", Hard_Disk_capacity=" + Hard_Disk_capacity
				+ ", RAM_capacity=" + RAM_capacity + ", Brand=" + Brand + ", price=" + price + "]";
	}
	

}
