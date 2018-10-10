package designPattern_factory;

public class Server extends Computer {
	private String ram;
	private String hdd;
	private String cpu;

	public Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.getRAM();
	}

	@Override
	public String getHDD() {
		return this.getHDD();
	}

	@Override
	public String getCPU() {
		return this.getCPU();
	}

}
