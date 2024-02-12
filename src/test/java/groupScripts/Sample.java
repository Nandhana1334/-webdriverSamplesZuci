package groupScripts;

import org.testng.annotations.Test;

public class Sample {
  @Test
  public void testOne() {
	  System.out.println("Test 1 in sample");
  }
  @Test
  public void testTwo()
  {
	  System.out.println("Test 2 in sample");
  }
  @Test(groups="feature2")
  public void testThree()
  {
	  System.out.println("Test 3 in sample");
  }
  @Test
  public void testFour()
  {
	  System.out.println("Test 4 in sample");
  }


}
