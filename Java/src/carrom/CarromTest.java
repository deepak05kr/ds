package carrom;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class CarromTest {
	CarromGame carromGame = CarromRemote.getCarromBoard();

	Strike strikeCommand = new Strike(carromGame);
	RemoteButton strikeButton = new RemoteButton(strikeCommand);

	MultiStrkike multiStrikeCommand = new MultiStrkike(carromGame);
	RemoteButton multiStrikeButton = new RemoteButton(multiStrikeCommand);

	RedStrike redStrikeCommand = new RedStrike(carromGame);
	RemoteButton redStrikeButton = new RemoteButton(redStrikeCommand);

	StrikerStrike strikerStrikeCommand = new StrikerStrike(carromGame);
	RemoteButton strikerStrikeButton = new RemoteButton(strikerStrikeCommand);

	DfunctCoin dfunctCoinCommand = new DfunctCoin(carromGame);
	RemoteButton dfunctCointButton = new RemoteButton(dfunctCoinCommand);

	None noneCommand = new None(carromGame);
	RemoteButton noneButton = new RemoteButton(noneCommand);

	private void resetPoints(Player player1, Player player2) {
		if (player1 != null) {
			player1.reset();
		}
		if (player2 != null) {
			player2.reset();
		}
	}

	@Test
	public void StrikeBasicTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		strikeButton.press(player1);
		strikeButton.press(player2);
		Assert.assertEquals(1, player1.getPoint());
		Assert.assertEquals(1, player2.getPoint());
		resetPoints(player1, player2);
	}

	@Test
	public void StrikeBoundaryTest() {
		Player player1 = Player.getPlayer1();
		Assert.assertEquals(0, player1.getPoint());
		for (int i = 0; i < Constants.MINIMUM_POINTS_CRIETERIA; i++) {

			Assert.assertEquals(true, strikeButton.press(player1));
			Assert.assertEquals(i + 1, player1.getPoint());

		}
// can't press strike becasue game is over
		Assert.assertEquals(false, strikeButton.press(player1));
		Assert.assertEquals(false, strikeButton.press(player1));
		resetPoints(player1, null);
	}

	@Test
	public void StrikeTestForBlackCoin() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();

		for (int i = 0; i < Constants.MAX_BLACK_COIN_COUNT / 2; i++) {

			strikeButton.press(player1);
			Assert.assertEquals(i + 1, player1.getPoint());

			strikeButton.press(player2);
			Assert.assertEquals(i + 1, player2.getPoint());
		}

		Assert.assertEquals(true, strikeButton.press(player1));
		// can't press strike becasue black coin is over
		Assert.assertEquals(false, strikeButton.press(player2));
		resetPoints(player1, player2);
	}

	@Test
	public void MultiStrikeBasicTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		multiStrikeButton.press(player1);
		multiStrikeButton.press(player2);
		Assert.assertEquals(2, player1.getPoint());
		Assert.assertEquals(2, player2.getPoint());
		resetPoints(player1, player2);
	}

	// black coin count should not decrease in Multi Strike event
	@Test
	public void MultiStrikeTestForBlackCointCountCheck() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		for (int i = 0; i < Constants.MAX_BLACK_COIN_COUNT * 3; i++) {
			assertEquals(true, multiStrikeButton.press(player1));
			Assert.assertEquals(2 * i + 2, player1.getPoint());
			assertEquals(true, multiStrikeButton.press(player2));
			Assert.assertEquals(2 * i + 2, player2.getPoint());
		}
		resetPoints(player1, player2);
	}

// Multi Strike event is applicable only when atleast 2 coin is available
	@Test
	public void MultiStrikeBoundaryConditionTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		for (int i = 0; i < Constants.MAX_BLACK_COIN_COUNT / 2; i++) {
			assertEquals(true, strikeButton.press(player1));
			Assert.assertEquals(i + 1, player1.getPoint());
			assertEquals(true, strikeButton.press(player2));
			Assert.assertEquals(i + 1, player2.getPoint());

		}
		assertEquals(true, multiStrikeButton.press(player1));
		Assert.assertEquals(6, player1.getPoint());
		assertEquals(true, multiStrikeButton.press(player2));
		Assert.assertEquals(6, player2.getPoint());

		assertEquals(true, strikeButton.press(player1));

		assertEquals(false, multiStrikeButton.press(player1));
		assertEquals(false, multiStrikeButton.press(player2));

		resetPoints(player1, player2);
	}

//
	@Test
	public void RedStrikeBasicTest() {
		Player player1 = Player.getPlayer1();
		redStrikeButton.press(player1);
		Assert.assertEquals(3, player1.getPoint());
		resetPoints(player1, null);
	}

	@Test
	public void RedStrikeBoundaryTest() {
		Player player1 = Player.getPlayer1();
		Assert.assertEquals(true, redStrikeButton.press(player1));
		Assert.assertEquals(3, player1.getPoint());
		Assert.assertEquals(false, redStrikeButton.press(player1));
		resetPoints(player1, null);
	}

	@Test
	public void StrikerStrikeBasicTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		strikerStrikeButton.press(player1);
		strikerStrikeButton.press(player2);
		Assert.assertEquals(-1, player1.getPoint());
		Assert.assertEquals(-1, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(1, player2.getFaulCount());
		resetPoints(player1, player2);
	}

	@Test
	public void DfunctBlackCoinTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		for (int i = 0; i < Constants.MAX_BLACK_COIN_COUNT / 2; i++) {
			assertEquals(true, strikeButton.press(player1));
			Assert.assertEquals(i + 1, player1.getPoint());
			assertEquals(true, strikeButton.press(player2));
			Assert.assertEquals(i + 1, player2.getPoint());

		}
		Assert.assertEquals(true, multiStrikeButton.press(player2));
		Assert.assertEquals(true, redStrikeButton.press(player1));

// now only 1 black coin is remaining		
		Assert.assertEquals(true, dfunctCointButton.press(player1));
		Assert.assertEquals(5, player1.getPoint());
		Assert.assertEquals(6, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(1, player1.getMissedPocketCount());
		resetPoints(player1, player2);
	}

	@Test
	public void DfunctRedCoinTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		for (int i = 0; i < Constants.MAX_BLACK_COIN_COUNT / 2; i++) {
			assertEquals(true, strikeButton.press(player1));
			Assert.assertEquals(i + 1, player1.getPoint());
			assertEquals(true, strikeButton.press(player2));
			Assert.assertEquals(i + 1, player2.getPoint());

		}
		Assert.assertEquals(true, strikeButton.press(player1));

// now only 1 red coin is remaining		
		Assert.assertEquals(true, dfunctCointButton.press(player1));
		Assert.assertEquals(3, player1.getPoint());
		Assert.assertEquals(4, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(1, player1.getMissedPocketCount());
		resetPoints(player1, player2);
	}

	@Test
	public void missedPocketTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		for (int i = 0; i < 50; i++) {
			Assert.assertEquals(true, noneButton.press(player1));
			Assert.assertEquals(true, noneButton.press(player2));

			if (i % 3 == 0) {
				if (i / 9 >= 1) {
					Assert.assertEquals(-1 * (i / 3) - 1 * (i / 9), player1.getPoint());
					Assert.assertEquals(-1 * (i / 3) - 1 * (i / 9), player2.getPoint());
				}
				if (i / 9 == 0) {
					Assert.assertEquals(-1 * (i / 3), player1.getPoint());
					Assert.assertEquals(-1 * (i / 3), player2.getPoint());
				}
			}

		}
		resetPoints(player1, player2);
	}

	@Test
	public void faulTest() {
		Player player1 = Player.getPlayer1();
		Assert.assertEquals(true, strikerStrikeButton.press(player1));
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(true, dfunctCointButton.press(player1));
		Assert.assertEquals(2, player1.getFaulCount());
		Assert.assertEquals(true, noneButton.press(player1));
		Assert.assertEquals(true, noneButton.press(player1));
		Assert.assertEquals(true, noneButton.press(player1));
		Assert.assertEquals(0, player1.getFaulCount());
		Assert.assertEquals(true, strikerStrikeButton.press(player1));
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(-6, player1.getPoint());
		resetPoints(player1, null);
	}

	@Test
	public void GameOverTest() {
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();
		Assert.assertEquals(true, redStrikeButton.press(player1));
		Assert.assertEquals(true, multiStrikeButton.press(player1));

		Assert.assertEquals(false, strikeButton.press(player1));
		Assert.assertEquals(false, dfunctCointButton.press(player1));
		Assert.assertEquals(false, noneButton.press(player1));
		resetPoints(player1, null);
	}
}
