package designPattern_factory;

public abstract class Computer {
	private String ram;
	private String hdd;
	private String cpu;
	
	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}

}
