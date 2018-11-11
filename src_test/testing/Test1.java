package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import development.Question1;

class Test1 {
	
	Question1 Q1;
	int[] testList1;
	int[] testList2;
	String[] testList3;
	String[] testList4;
	String[] testList5;
	
	@BeforeEach
	void setUp() {
		Q1 = new Question1();
		testList1 = new int[] {1,2,3,4,5,6,7,8,9};
		testList2 = new int[] {-20,-10,0,10,20};
		testList3 = new String[] {"9999999999999999999999999999999999999999999999999999999999999999999999","-10","0","10","20"};
		testList4 = new String[] {"h","e","1","1","0"};
		testList5 = new String[] {"1","2","3","4","5","6","7","8","9"};
	}

	@AfterEach
	void tearDown() {
		Q1 = null;
		testList1 = null;
		testList2 = null;
		testList3 = null;
		testList4 = null;
		testList5 = null;
	}
	
	@Test
	void user_input_test1() {
		assertThrows(NumberFormatException.class, () -> Q1.user_input("101",null));
	}
	
	@Test
	void user_input_test2() {
		assertThrows(NumberFormatException.class, () -> Q1.user_input("-1",null));
	}
	
	@Test
	void user_input_test3() {
		assertThrows(NumberFormatException.class, () -> Q1.user_input("s",null));
	}
	
	@Test
	void user_input_test4() {
		assertEquals(50,Q1.user_input("50",null));
	}
	
	@Test
	void list_integers_test1() {
		assertThrows(NumberFormatException.class, () -> Q1.list_integers(testList3,5,null));
	}
	
	@Test
	void list_integers_test2() {
		assertThrows(NumberFormatException.class, () -> Q1.list_integers(testList4,5,null));
	}
	
	@Test
	void list_integers_test3() {
		assertArrayEquals(testList1,Q1.list_integers(testList5,9,null));
	}

	@Test
	void summation_test() {
		assertEquals(45,Q1.summation(testList1));	
		assertEquals(0,Q1.summation(testList2));	
	}
	
	@Test
	void product_test() {
		assertEquals(362880,Q1.product(testList1));	
		assertEquals(0,Q1.product(testList2));
	}
	
	@Test
	void average_test() {
		assertEquals(5,Q1.average(testList1));	
		assertEquals(0,Q1.average(testList2));
	}
	
	@Test
	void variance_test() {
		assertEquals((20.0/3),Q1.variance(testList1),0.001);	
		assertEquals(200,Q1.variance(testList2));	
	}
	
	@Test
	void smallest_int_test() {
		assertEquals(1,Q1.smallest_int(testList1));	
		assertEquals(-20,Q1.smallest_int(testList2));	
	}
	
	@Test
	void largest_int_test() {
		assertEquals(9,Q1.largest_int(testList1));	
		assertEquals(20,Q1.largest_int(testList2));	
	}	
}
