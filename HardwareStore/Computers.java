package HardwareStore;

public class Computers extends Items implements Sortable {

	protected String CPU_brand;
	protected String CPU_speed;
	protected String Hard_Disk_capacity;
	protected String RAM_capacity;

	public Computers(String brand, double price) {
		super(brand, price);
	}

	public Computers(String brand, double price, String cpu_brand, String cpu_speed, String hard_Disk_capacity,
			String ram_capacity) {
		super(brand, price);
		CPU_brand = cpu_brand;
		CPU_speed = cpu_speed;
		Hard_Disk_capacity = hard_Disk_capacity;
		RAM_capacity = ram_capacity;
	}

	public String getCPU_brand() {
		return CPU_brand;
	}

	public void setCPU_brand(String cPU_brand) {
		CPU_brand = cPU_brand;
	}

	public String getCPU_speed() {
		return CPU_speed;
	}

	public void setCPU_speed(String cPU_speed) {
		CPU_speed = cPU_speed;
	}

	public String getHard_Disk_capacity() {
		return Hard_Disk_capacity;
	}

	public void setHard_Disk_capacity(String hard_Disk_capacity) {
		Hard_Disk_capacity = hard_Disk_capacity;
	}

	public String getRAM_capacity() {
		return RAM_capacity;
	}

	public void setRAM_capacity(String rAM_capacity) {
		RAM_capacity = rAM_capacity;
	}

	@Override
	public String toString() {
		return "Computers [CPU_brand=" + CPU_brand + ", CPU_speed=" + CPU_speed + ", Hard_Disk_capacity="
				+ Hard_Disk_capacity + ", RAM_capacity=" + RAM_capacity + ", Brand=" + Brand + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Object o) { //compares to computers
		if (o != null) {
			if (this.price == ((Items) o).getPrice())
				return 0;
			else if (this.price > ((Items) o).getPrice())
				return 1;
			else
				return -1;
		}
		return -1;
	}
}