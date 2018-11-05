package carrom;

public class MultiStrkike implements Command {

	CarromGame theDevice;

	public MultiStrkike(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute( Player player) {
		return theDevice.multiStrike(player);
		
	}

}
