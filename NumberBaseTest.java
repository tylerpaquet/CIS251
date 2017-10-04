import org.junit.Assert;
import org.junit.Test;

public class NumberBaseTest {

	 @Test
	   public void decimal_to_binary() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 10, 2));
	      Assert.assertEquals("1", NumberBase.convert("1", 10, 2));
	      Assert.assertEquals("1010", NumberBase.convert("10", 10, 2));
	      Assert.assertEquals("1000011110001", NumberBase.convert("4337", 10, 2));
	   }

	   @Test
	   public void binary_to_decimal() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 2, 10));
	      Assert.assertEquals("1", NumberBase.convert("1", 2, 10));
	      Assert.assertEquals("2", NumberBase.convert("10", 2, 10));
	      Assert.assertEquals("3", NumberBase.convert("11", 2, 10));
	      Assert.assertEquals("10", NumberBase.convert("1010", 2, 10));
	      Assert.assertEquals("4337", NumberBase.convert("1000011110001", 2, 10));
	   }

	   @Test
	   public void decimal_to_hex() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 10, 16));
	      Assert.assertEquals("1", NumberBase.convert("1", 10, 16));
	      Assert.assertEquals("a", NumberBase.convert("10", 10, 16));
	      Assert.assertEquals("64", NumberBase.convert("100", 10, 16));
	      Assert.assertEquals("dead", NumberBase.convert("57005", 10, 16));
	   }
	   
	   @Test
	   public void ternary_to_hex() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 3, 16));
	      Assert.assertEquals("1", NumberBase.convert("1", 3, 16));
	      Assert.assertEquals("3", NumberBase.convert("10", 3, 16));
	      Assert.assertEquals("9", NumberBase.convert("100", 3, 16));
	      Assert.assertEquals("10", NumberBase.convert("0121", 3, 16));
	   }
	   
	   @Test
	   public void octal_to_hex() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 8, 16));
	      Assert.assertEquals("1", NumberBase.convert("1", 8, 16));
	      Assert.assertEquals("8", NumberBase.convert("10", 8, 16));
	      Assert.assertEquals("40", NumberBase.convert("100", 8, 16));
	      Assert.assertEquals("51", NumberBase.convert("0121", 8, 16));
	   }
	   
	   @Test
	   public void base36_to_quintal() throws Throwable {
	      Assert.assertEquals("0", NumberBase.convert("0", 36, 5));
	      Assert.assertEquals("1", NumberBase.convert("1", 36, 5));
	      Assert.assertEquals("121", NumberBase.convert("10", 36, 5));
	      Assert.assertEquals("411433", NumberBase.convert("abc", 36, 5));
	      Assert.assertEquals("1041303013", NumberBase.convert("1d3r4", 36, 5));
	   }
	   
	   @Test(expected = IllegalArgumentException.class)
	   public void input_is_valid1() {
	      NumberBase.convert("14d", 10, 2);
	   }
	   
	   @Test(expected = IllegalArgumentException.class)
	   public void input_is_valid2() {
	      NumberBase.convert("010101012", 2, 2);
	   }
	   
	   @Test(expected = IllegalArgumentException.class)
	   public void input_is_valid3() {
	      NumberBase.convert("134529", 8, 2);
	   }
	   
	   @Test(expected = IllegalArgumentException.class)
	   public void input_is_valid4() {
	      NumberBase.convert("673621abcg", 16, 2);
	   }
	   
	   @Test(expected = IllegalArgumentException.class)
	   public void input_is_valid5() {
	      NumberBase.convert("z", 35, 2);
	   }

}