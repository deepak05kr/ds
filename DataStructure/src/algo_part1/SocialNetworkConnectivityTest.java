package algo_part1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SocialNetworkConnectivityTest {
	@Test
	public void TestIsFriends() {
		int size = 10;
		SocialNetworkConnectivity socialNetwork = new SocialNetworkConnectivity(size);
		socialNetwork.makeFriends(0, 1);
		socialNetwork.makeFriends(1, 2);
		socialNetwork.makeFriends(2, 3);
		socialNetwork.makeFriends(3, 4);
		socialNetwork.makeFriends(4, 5);
		
		socialNetwork.makeFriends(6, 7);
		socialNetwork.makeFriends(7, 8);
		socialNetwork.makeFriends(8, 9);
		
		assertTrue(socialNetwork.isFriends(6, 2) == false);
		assertTrue(socialNetwork.isFriends(5, 3) == true);
		assertTrue(socialNetwork.isFriends(9, 2) == false);
		assertTrue(socialNetwork.isFriends(9, 6) == true);
	}
	@Test
	public void TestIsFriends2() {
		int size = 10;
		SocialNetworkConnectivity socialNetwork = new SocialNetworkConnectivity(size);
		socialNetwork.makeFriends(4, 5);
		socialNetwork.makeFriends(3, 4);
		socialNetwork.makeFriends(2, 3);
		socialNetwork.makeFriends(1, 2);
		socialNetwork.makeFriends(0, 1);

		socialNetwork.makeFriends(8, 9);
		socialNetwork.makeFriends(7, 8);
		socialNetwork.makeFriends(6, 7);
		
		assertTrue(socialNetwork.isFriends(6, 2) == false);
		assertTrue(socialNetwork.isFriends(5, 3) == true);
		assertTrue(socialNetwork.isFriends(9, 2) == false);
		assertTrue(socialNetwork.isFriends(9, 6) == true);
	}


}
