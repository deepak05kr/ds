package carrom;

public class DfunctCoin implements Command {

	CarromGame theDevice;

	public DfunctCoin(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute(Player player) {
		return theDevice.dfunctCoin(player);
	}

}
