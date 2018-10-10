package designPattern_factory;

public class FactoryPatternDemo {
	public static void main(String args[]) {
		Computer pc = Factory.getComputer("pc", "ram=8gb", "hdd=128Gb", "1.8 gz i5");
		Computer server = Factory.getComputer("Server", "ram=128gb", "hdd=1024Gb", "1.8 gz i7");
		System.out.println(pc);
		System.out.println(server);
	}
}
