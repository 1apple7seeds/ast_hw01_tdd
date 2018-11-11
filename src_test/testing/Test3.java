package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import development.Question3;

class Test3 {

	Question3 Q3;

	@BeforeEach
	void setUp() throws Exception {
		Q3 = new Question3();
	}

	@AfterEach
	void tearDown() throws Exception {
		Q3 = null;
	}
	
	@Test
	void func_2n_test() {
		assertEquals(0,Q3.func_2n()[0]);
		assertEquals(100,Q3.func_2n()[50]);
		assertEquals(200,Q3.func_2n()[100]);
	}
	
	@Test
	void func_sqrt_test() {
		assertEquals(0,Q3.func_sqrt()[0]);
		assertEquals(7,Q3.func_sqrt()[49]);
		assertEquals(9,Q3.func_sqrt()[81]);
	}

	@Test
	void func_10_pow_n_test() {
		assertEquals("1",Q3.func_10_pow_n()[0]);
		assertEquals("10",Q3.func_10_pow_n()[1]);
		assertEquals("1000000",Q3.func_10_pow_n()[6]);
		assertEquals("10...0 (99 zeros)",Q3.func_10_pow_n()[99]);
	}
	
	@Test
	void func_cubed_test() {
		assertEquals(0,Q3.func_cubed()[0]);
		assertEquals(125000,Q3.func_cubed()[50]);
		assertEquals(1000000,Q3.func_cubed()[100]);
	}
	
	@Test
	void func_2_pow_1_over_n_test() {
		assertEquals("Inf",Q3.func_2_pow_1_over_n()[0]);
		assertEquals("2",Q3.func_2_pow_1_over_n()[1]);
		assertEquals("1",Q3.func_2_pow_1_over_n()[100]);
	}
	
	@Test
	void func_e_pow_ntest() {
		assertEquals("1",Q3.func_e_pow_n()[0]);
		assertEquals("2",Q3.func_e_pow_n()[1]);
		assertEquals("485165195",Q3.func_e_pow_n()[20]);
		assertEquals("e^99",Q3.func_e_pow_n()[99]);	}
}
