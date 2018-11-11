package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import development.Question2;

public final class Test2 {
	
	private Question2 q2;

	@BeforeEach
	public void setUp() {
		q2 = new Question2();
	}

	@AfterEach
	public void tearDown() {
		q2 = null;
	}

	@Test
	public void prime_int_test() {
		final int expected = 541;
        final int actual = q2.primes_int(100, false);
        assertEquals(actual, expected);
	}
	
	@Test
	public void prime_long_test() {
		final long expected = 104729;
        final long actual = q2.primes_long(10000, false);
        assertEquals(actual, expected);
	}
	
	@Test
	public void time_int_test() {
		final double expected = 0.002;
        final double actual = q2.time_int();
        assertEquals(actual, expected, 0.001);
	}
	
	@Test
	public void time_long_test() {
		final double expected = 100.0;
        final double actual = q2.time_long() / (24.0*60.0*60.0);
        assertEquals(actual, expected, 30.0);
	}
}
