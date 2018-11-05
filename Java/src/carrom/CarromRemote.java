package carrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumMap;

public class CarromRemote {
	public final static int INVALID_INPUT = -1;
	EnumMap<Events, RemoteButton> commandMap = new EnumMap<Events, RemoteButton>(Events.class);

	public static CarromGame getCarromBoard() {
		return new CarromBoard(Constants.MAX_BLACK_COIN_COUNT, Constants.MAX_RED_COIN_COUNT);
	}

	protected boolean pressRemoteButton(Player player, int input) throws IOException {
		Events event = Events.values()[input];
		switch (event) {
		case STRIKE:
			return pressStrikeButton(player);
		case MULTISTRIKE:
			return pressMultiStrikeButton(player);
		case REDSTRIKE:
			return pressRedStrikeButton(player);
		case STRIKERSTRIKE:
			return pressStrikerStrikeButton(player);
		case DFUNCTCOIN:
			return pressDfunctCoinButton(player);
		case NONE:
			return pressNoneButton(player);
		default:
			return true;
		}
	}

	private boolean pressNoneButton(Player player) throws IOException {
		boolean none = commandMap.get(Events.NONE).press(player);
		while (!none) {
			return pressRemoteButton(player, getUserSelection());
		}
		return none;
	}

	private boolean pressDfunctCoinButton(Player player) throws IOException {
		boolean dfunctCoin = commandMap.get(Events.DFUNCTCOIN).press(player);
		while (!dfunctCoin) {
			return pressRemoteButton(player, getUserSelection());
		}
		return dfunctCoin;
	}

	private boolean pressStrikerStrikeButton(Player player) throws IOException {
		boolean strikerStrike = commandMap.get(Events.STRIKERSTRIKE).press(player);
		while (!strikerStrike) {
			return pressRemoteButton(player, getUserSelection());
		}
		return strikerStrike;
	}

	private boolean pressRedStrikeButton(Player player) throws IOException {
		boolean redStrike = commandMap.get(Events.REDSTRIKE).press(player);
		while (!redStrike) {
			return pressRemoteButton(player, getUserSelection());
		}
		return redStrike;
	}

	private boolean pressMultiStrikeButton(Player player) throws IOException {
		boolean multiStrike = commandMap.get(Events.MULTISTRIKE).press(player);
		while (!multiStrike) {
			return pressRemoteButton(player, getUserSelection());
		}
		return multiStrike;
	}

	private boolean pressStrikeButton(Player player) throws IOException {
		boolean strike = commandMap.get(Events.STRIKE).press(player);
		while (!strike) {
			return pressRemoteButton(player, getUserSelection());
		}
		return strike;
	}

	protected int getUserSelection() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Strike");
		System.out.println("2. Multistrike");
		System.out.println("3. Red strike");
		System.out.println("4. Striker strike");
		System.out.println("5. Defunct coin");
		System.out.println("6. None");
		System.out.print(">");
		int input = getInputFromCommandLine(br);
		while (input < 1 || input > 6) {
			System.out.println("invalid input");
			input = getInputFromCommandLine(br);
		}
		return input - 1;
	}

	private static int getInputFromCommandLine(BufferedReader br) throws IOException {

		String line;
		int input;
		try {
			line = br.readLine();
			input = Integer.parseInt(line);

		} catch (NumberFormatException ex) {
			return INVALID_INPUT;
		}
		return input;
	}

	public CarromRemote(CarromGame carromBoard) {

		Strike strikeCommand = new Strike(carromBoard);
		RemoteButton strikeButton = new RemoteButton(strikeCommand);

		MultiStrkike multiStrikeCommand = new MultiStrkike(carromBoard);
		RemoteButton multiStrikeButton = new RemoteButton(multiStrikeCommand);

		RedStrike redStrikeCommand = new RedStrike(carromBoard);
		RemoteButton redStrikeButton = new RemoteButton(redStrikeCommand);

		StrikerStrike strikerStrikeCommand = new StrikerStrike(carromBoard);
		RemoteButton strikerStrikeButton = new RemoteButton(strikerStrikeCommand);

		DfunctCoin dfunctCoinCommand = new DfunctCoin(carromBoard);
		RemoteButton dfunctCointButton = new RemoteButton(dfunctCoinCommand);

		None noneCommand = new None(carromBoard);
		RemoteButton noneButton = new RemoteButton(noneCommand);

		commandMap.put(Events.STRIKE, strikeButton);
		commandMap.put(Events.MULTISTRIKE, multiStrikeButton);
		commandMap.put(Events.REDSTRIKE, redStrikeButton);
		commandMap.put(Events.STRIKERSTRIKE, strikerStrikeButton);
		commandMap.put(Events.DFUNCTCOIN, dfunctCointButton);
		commandMap.put(Events.NONE, noneButton);
	}

}
