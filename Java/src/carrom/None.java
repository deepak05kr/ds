package carrom;

public class None implements Command {

	CarromGame theDevice;

	public None(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute(Player player) {
		return theDevice.none(player);
	}

}
