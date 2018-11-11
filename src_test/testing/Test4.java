package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import development.Question4;

public final class Test4 {
	
	private Question4 q4;
	
	@BeforeEach
	public void setUp() {
		q4 = new Question4();
	}
	
	@AfterEach
	public void tearDown() {
		q4 = null;
	}

	@Test
	public void user_diameter_test1_ThrowsNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> q4.user_diameter_check(" 1",null));
	}
	
	@Test
	public void user_diameter_test2_ThrowsNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> q4.user_diameter_check("0",null));
	}
	
	@Test
	public void user_diameter_test3_ThrowsNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> q4.user_diameter_check("999999999999999999999999999999999999999999999999",null));
	}

	@Test
	public void user_precision_test1_ThrowsNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> q4.user_precision_check(" 1",null));
	}
	
	@Test
	public void user_precision_test2_ThrowsNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> q4.user_precision_check("999999999999999999999999999999999999999999999999",null));
	}
	
	@Test
	public void pi_approx_test() {
		final double expected = 3;
        final double actual = q4.pi_approx(0);
        assertEquals(actual, expected);
	}
	
	@Test
	public void circumference_test() {
		final double expected = 6.28;
        final double actual = q4.circumference(2.0, 3.14);
        assertEquals(actual, expected);
	}
	
	@Test
	public void area_test() {
		final double expected = 3.14;
        final double actual = q4.area(2.0, 3.14);
        assertEquals(actual, expected);
	}
	
	@Test
	public void percentage_increase_diameter_test() {
		final double[] expected = {3.333333333333336, 1.2903225806451624, 0.03184713375795827};
        final double[] actual = q4.percentage_increase_circumference(2, 3);
        assertArrayEquals(actual, expected);
	}
	
	@Test
	public void percentage_increase_area_test() {
		final double[] expected = {3.333333333333336, 1.2903225806451624, 0.03184713375795827};
        final double[] actual = q4.percentage_increase_circumference(2, 3);
        assertArrayEquals(actual, expected);
	}
}
