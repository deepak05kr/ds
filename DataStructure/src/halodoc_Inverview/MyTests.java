package halodoc_Inverview;

import org.junit.Assert;
import org.junit.Test;

public class MyTests {

	@Test
	public void storeBooleanTest() {

		Solution tester = new Solution();
		boolean keyAvailable = false;
		Assert.assertEquals(false, Solution.inputMap.containsKey("newkey22"));

		tester.store("newkey22", Solution.POLLUTION_LEVEL, Solution.VERY_HIGH);

		Assert.assertEquals(true, Solution.inputMap.containsKey("newkey22"));
	}

	@Test
	public void storeDelhiTest() {

		Solution tester = new Solution();
		boolean keyAvailable = false;
		Assert.assertEquals(false, Solution.inputMap.containsKey("newkey2"));

		tester.store("newkey2", Solution.POLLUTION_LEVEL, Solution.VERY_HIGH);

		Assert.assertEquals(true, Solution.inputMap.containsKey("newkey2"));
	}

	@Test
	public void getTest() {
		Solution tester = new Solution();

		Assert.assertNull(Solution.inputMap.get("newkey3"));

		tester.store("newkey3", Solution.POLLUTION_LEVEL, Solution.VERY_HIGH);

		Assert.assertNotNull(Solution.inputMap.get("newkey3"));
	}

	@Test
	public void DeleteTest() {
		Solution tester = new Solution();
		tester.store("newkey4", Solution.POLLUTION_LEVEL, Solution.VERY_HIGH);
		Assert.assertNotNull(Solution.inputMap.get("newkey4"));
		tester.delete("newKey4");
		Assert.assertNull(Solution.inputMap.get("newkey4"));
	}

}
