import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class GradeTest {

	// Tests for if the input is below the valid range for constructor
	@ParameterizedTest
	@ValueSource(ints= {-1,-2,-3,-4,-5,-6})
	public void testBelowRange1(int grade) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Grade(grade);
		});

	}

	// Tests for if the input is above the valid range for constructor
	@ParameterizedTest
	@ValueSource(ints = {30,40,50,60,70})
	public void testAboveRange(int grade) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Grade(grade);
		});
	}

	// Test for valid input for constructor and getPoints() method
	@Test
	public void validInput1() {
		Grade g = new Grade(6);
		assertEquals(g.getPoints(), 6);
	}

	// Test for below range for fromPercentage
	@ParameterizedTest
	@ValueSource(ints= {-9,-4,-3,-2,-18})
	public void testBelowPercentage(int grade) {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade.fromPercentage(grade);
		});

	}

	// test for above range for fromPercentage
	@ParameterizedTest
	@ValueSource(ints = {200,150,300,250,400})
	public void testAbovePercentage(int grade) {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade.fromPercentage(grade);
		});

	}

	// FIVE tests for classify, using Classifications as equivalence classes.

	// test for first
	@Test
	public void testFirst() {
		Grade grade1 = new Grade(1);
		Grade grade2 = new Grade(2);
		Grade grade3 = new Grade(3);
		Grade grade4 = new Grade(4);
		assertEquals(grade1.classify(), Classification.First);
		assertEquals(grade2.classify(), Classification.First);
		assertEquals(grade3.classify(), Classification.First);
		assertEquals(grade4.classify(), Classification.First);
	}
	
	

	// test for uppersecond
	@Test
	public void testUpperSecond() {
		Grade g1 = new Grade(5);
		Grade g2 = new Grade(6);
		Grade g3 = new Grade(7);
		Grade g4 = new Grade(8);
		assertEquals(g1.classify(), Classification.UpperSecond);
		assertEquals(g2.classify(), Classification.UpperSecond);
		assertEquals(g3.classify(), Classification.UpperSecond);
		assertEquals(g4.classify(), Classification.UpperSecond);

	
	
	
	}

	// test for lowersecond
	@Test
	public void testLowerSecond() {
		
		Grade g1 = new Grade(9);
		Grade g2 = new Grade(10);
		Grade g3 = new Grade(11);
		Grade g4 = new Grade(12);

		assertEquals(g1.classify(), Classification.LowerSecond);
		assertEquals(g2.classify(), Classification.LowerSecond);
		assertEquals(g3.classify(), Classification.LowerSecond);
		assertEquals(g4.classify(), Classification.LowerSecond);

	}

	// test for third
	@Test
	public void testThird() {
		Grade g1 = new Grade(13);
		Grade g2 = new Grade(14);
		Grade g3 = new Grade(15);
		Grade g4 = new Grade(16);
		assertEquals(g1.classify(), Classification.Third);
		assertEquals(g2.classify(), Classification.Third);
		assertEquals(g3.classify(), Classification.Third);
		assertEquals(g4.classify(), Classification.Third);

	}

	// test for fail
	@Test
	public void testFail() {
		Grade g1 = new Grade(17);
		Grade g2 = new Grade(18);
		Grade g3 = new Grade(19);
		Grade g4 = new Grade(20);
		assertEquals(g1.classify(), Classification.Fail);
		assertEquals(g2.classify(), Classification.Fail);
		assertEquals(g3.classify(), Classification.Fail);
		assertEquals(g4.classify(), Classification.Fail);

	
	
	
	}

	// twenty tests for fromPercentage using each point in the 20-point scale

	@Test
	public void testTwentyGrade() {
		Grade percentage = Grade.fromPercentage(-1);
		int expectedGrade = 20;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testNineteenGrade() {
		Grade percentage = Grade.fromPercentage(20);
		int expectedGrade = 19;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testEighteenGrade() {
		Grade percentage = Grade.fromPercentage(32);
		int expectedGrade = 18;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testSeventeenGrade() {
		Grade percentage = Grade.fromPercentage(37);
		int expectedGrade = 17;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testSixteenGrade() {
		Grade percentage = Grade.fromPercentage(41);
		int expectedGrade = 16;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testFifteenGrade() {
		Grade percentage = Grade.fromPercentage(43);
		int expectedGrade = 15;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testFourteenGrade() {
		Grade percentage = Grade.fromPercentage(45);
		int expectedGrade = 14;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testThirteenGrade() {
		Grade percentage = Grade.fromPercentage(48);
		int expectedGrade = 13;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testTweleveGrade() {
		Grade percentage = Grade.fromPercentage(50);
		int expectedGrade = 12;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testElevenGrade() {
		Grade percentage = Grade.fromPercentage(53);
		int expectedGrade = 11;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testTenthGrade() {
		Grade percentage = Grade.fromPercentage(56);
		int expectedGrade = 10;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testNinthGrade() {
		Grade percentage = Grade.fromPercentage(58);
		int expectedGrade = 9;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testEightGrade() {
		Grade percentage = Grade.fromPercentage(60);
		int expectedGrade = 8;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testSevenGrade() {
		Grade percentage = Grade.fromPercentage(63);
		int expectedGrade = 7;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testSixthGrade() {
		Grade percentage = Grade.fromPercentage(66);
		int expectedGrade = 6;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testFifthGrade() {
		Grade percentage = Grade.fromPercentage(68);
		int expectedGrade = 5;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testFourthGrade() {
		Grade percentage = Grade.fromPercentage(71);
		int expectedGrade = 4;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testThirdGrade() {
		Grade percentage = Grade.fromPercentage(74);
		int expectedGrade = 3;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testSecondGrade() {
		Grade percentage = Grade.fromPercentage(77);
		int expectedGrade = 2;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

	@Test
	public void testIstGrade() {
		Grade percentage = Grade.fromPercentage(90);
		int expectedGrade = 1;
		assertEquals(percentage.getPoints(), expectedGrade);

	}

}
