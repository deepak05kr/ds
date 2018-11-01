package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;

public class CarromTest {
	@Test
	public void StrikeBoundaryTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		
		Assert.assertEquals(0, player1.getPoint());
		Assert.assertEquals(9, carrom.getBlackCoinCount());
		for (int i = 0; i < 5; i++) {
			
			Assert.assertEquals(true, carrom.strike(carrom, player1));
			Assert.assertEquals(i + 1, player1.getPoint());
			Assert.assertEquals(9 - i - 1, carrom.getBlackCoinCount());
		}

		Assert.assertEquals(false, carrom.strike(carrom, player1));
		Assert.assertEquals(false, carrom.strike(carrom, player1));
		Assert.assertEquals(1, carrom.getRedCoinCount());

	}

	@Test
	public void StrikeBasicTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		carrom.strike(carrom, player1);
		carrom.strike(carrom, player2);
		Assert.assertEquals(1, player1.getPoint());
		Assert.assertEquals(1, player2.getPoint());
		Assert.assertEquals(7, carrom.getBlackCoinCount());
		Assert.assertEquals(1, carrom.getRedCoinCount());
	}

	@Test
	public void StrikeTestFor8Iteration() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();

		for (int i = 0; i < 4; i++) {

			carrom.strike(carrom, player1);
			Assert.assertEquals(i + 1, player1.getPoint());
			Assert.assertEquals(9 - 2 * i - 1, carrom.getBlackCoinCount());

			carrom.strike(carrom, player2);
			Assert.assertEquals(i + 1, player2.getPoint());
			Assert.assertEquals(9 - 2 * i - 2, carrom.getBlackCoinCount());
		}
		Assert.assertEquals(1, carrom.getRedCoinCount());
	}

	@Test
	public void MultiStrikeBasicTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		carrom.multiStrike(carrom, player1);
		carrom.multiStrike(carrom, player2);
		Assert.assertEquals(2, player1.getPoint());
		Assert.assertEquals(2, player2.getPoint());
		Assert.assertEquals(9, carrom.getBlackCoinCount());
		Assert.assertEquals(1, carrom.getRedCoinCount());
	}

	@Test
	public void MultiStrikeTestFor20Iteration() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		for (int i = 0; i < 10; i++) {
			assertEquals(true, carrom.multiStrike(carrom, player1));
			Assert.assertEquals(2 * i + 2, player1.getPoint());
			assertEquals(true, carrom.multiStrike(carrom, player2));
			Assert.assertEquals(2 * i + 2, player2.getPoint());
			Assert.assertEquals(9, carrom.getBlackCoinCount());
			Assert.assertEquals(1, carrom.getRedCoinCount());
		}
	}

	@Test
	public void MultiStrikeBoundaryConditionTest() {
		Carrom carrom = new Carrom(0, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		assertEquals(false, carrom.multiStrike(carrom, player1));
		Assert.assertEquals(0, player1.getPoint());
		assertEquals(false, carrom.multiStrike(carrom, player2));
		Assert.assertEquals(0, player2.getPoint());
		Assert.assertEquals(0, carrom.getBlackCoinCount());
		Assert.assertEquals(1, carrom.getRedCoinCount());

		Carrom carrom2 = new Carrom(1, 0);
		player1 = carrom2.getPlayer1();
		player2 = carrom2.getPlayer2();
		assertEquals(false, carrom2.multiStrike(carrom2, player1));
		Assert.assertEquals(0, carrom2.getPlayer1().getPoint());
		assertEquals(false, carrom2.multiStrike(carrom2, player2));
		Assert.assertEquals(0, carrom2.getPlayer2().getPoint());
		Assert.assertEquals(1, carrom2.getBlackCoinCount());
		Assert.assertEquals(0, carrom2.getRedCoinCount());
	}

	@Test
	public void RedStrikeBasicTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		carrom.redStrike(carrom, player1);
		Assert.assertEquals(3, player1.getPoint());
		Assert.assertEquals(9, carrom.getBlackCoinCount());
		Assert.assertEquals(0, carrom.getRedCoinCount());
	}

	@Test
	public void RedStrikeBoundaryTest() {
		Carrom carrom = new Carrom(9, 0);
		Player player1 = carrom.getPlayer1();
		Assert.assertEquals(false, carrom.redStrike(carrom, player1));
		Assert.assertEquals(0, player1.getPoint());
		Assert.assertEquals(9, carrom.getBlackCoinCount());
		Assert.assertEquals(0, carrom.getRedCoinCount());
	}

	@Test
	public void StrikerStrikeBasicTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		carrom.strikerStrike(carrom, player1);
		carrom.strikerStrike(carrom, player2);
		Assert.assertEquals(-1, player1.getPoint());
		Assert.assertEquals(-1, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(1, player2.getFaulCount());
		Assert.assertEquals(9, carrom.getBlackCoinCount());
		Assert.assertEquals(1, carrom.getRedCoinCount());
	}

	@Test
	public void DfunctBlackCoinTest() {
		Carrom carrom = new Carrom(2, 0);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		Assert.assertEquals(true, carrom.dfunctCoin(carrom, player1));
		Assert.assertEquals(true, carrom.dfunctCoin(carrom, player2));
		Assert.assertEquals(-2, player1.getPoint());
		Assert.assertEquals(-2, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(1, player2.getFaulCount());
		Assert.assertEquals(1, player1.getMissedPocketCount());
		Assert.assertEquals(1, player2.getMissedPocketCount());
		Assert.assertEquals(0, carrom.getBlackCoinCount());
		Assert.assertEquals(0, carrom.getRedCoinCount());

		Assert.assertEquals(false, carrom.dfunctCoin(carrom, player1));
		Assert.assertEquals(false, carrom.dfunctCoin(carrom, player2));
	}

	@Test
	public void DfunctRedCoinTest() {
		Carrom carrom = new Carrom(0, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		Assert.assertEquals(true, carrom.dfunctCoin(carrom, player1));
		Assert.assertEquals(-2, player1.getPoint());
		Assert.assertEquals(0, player2.getPoint());
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(0, player2.getFaulCount());
		Assert.assertEquals(1, player1.getMissedPocketCount());
		Assert.assertEquals(0, player2.getMissedPocketCount());
		Assert.assertEquals(0, carrom.getBlackCoinCount());
		Assert.assertEquals(0, carrom.getRedCoinCount());

		Assert.assertEquals(false, carrom.dfunctCoin(carrom, player1));
	}

	@Test
	public void missedPocketTest() {
		Carrom carrom = new Carrom(1, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		for (int i = 0; i < 50; i++) {
			Assert.assertEquals(true, carrom.none(carrom, player1));
			Assert.assertEquals(true, carrom.none(carrom, player2));

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
	}

	@Test
	public void faulTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Assert.assertEquals(true, carrom.strikerStrike(carrom, player1));
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(true, carrom.dfunctCoin(carrom, player1));
		Assert.assertEquals(2, player1.getFaulCount());
		Assert.assertEquals(true, carrom.none(carrom, player1));
		Assert.assertEquals(true, carrom.none(carrom, player1));
		Assert.assertEquals(true, carrom.none(carrom, player1));
		Assert.assertEquals(0, player1.getFaulCount());
		Assert.assertEquals(true, carrom.strikerStrike(carrom, player1));
		Assert.assertEquals(1, player1.getFaulCount());
		Assert.assertEquals(-6, player1.getPoint());
	}
	@Test
	public void GameOverTest() {
		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		Assert.assertEquals(true, carrom.redStrike(carrom, player1));
		Assert.assertEquals(true, carrom.multiStrike(carrom, player1));
		
		Assert.assertEquals(false, carrom.strike(carrom, player1));
		Assert.assertEquals(false,carrom.dfunctCoin(carrom, player1));
		Assert.assertEquals(false, carrom.none(carrom, player1));
	}
}
