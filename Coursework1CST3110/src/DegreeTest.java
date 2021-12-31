
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DegreeTest {
	List<Grade> year2 = new ArrayList<Grade>();
	List<Grade> year3 = new ArrayList<Grade>();

	@BeforeEach
	public void init() {
		year2 = new ArrayList<Grade>();
		year3 = new ArrayList<Grade>();
	}

	//test Constructor having fail grades, size is not 4 and null values
	@Test
	public void testConstrcutorWithNOValuesAndFailGrade() {
		year3.add(new Grade(17));
		year3.add(new Grade(17));
		year3.add(new Grade(17));
		year3.add(new Grade(17));
		year2.add(new Grade(20));
		year2.add(new Grade(20));
		year2.add(new Grade(20));
		year2.add(new Grade(20));

		assertThrows(IllegalArgumentException.class, () -> {
			new Degree(year2, year3);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			year2.add(Grade.fromPercentage(53));
			year3.add(Grade.fromPercentage(56));

			new Degree(year2, year3);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			year2 = null;
			year3 = null;
			new Degree(year2, year3);
		});
		
	}

	//test year3 having null values
	@Test
	public void testYear3Null() {
		year2.add(Grade.fromPercentage(90));
		year2.add(new Grade(1));
		year2.add(new Grade(1));
		year2.add(new Grade(1));
		year3 = null;
		assertThrows(IllegalArgumentException.class, () -> {
			new Degree(year2, year3);
		});

	}

	//test year3 contains fail
	@Test
	public void testYear3ContainsFail() {
		year3.add(Grade.fromPercentage(-1));
		year3.add(Grade.fromPercentage(22));
		year3.add(Grade.fromPercentage(31));
		year3.add(Grade.fromPercentage(36));
		year2.add(Grade.fromPercentage(76));
		year2.add(Grade.fromPercentage(76));
		year2.add(Grade.fromPercentage(80));
		year2.add(Grade.fromPercentage(76));

		assertThrows(IllegalArgumentException.class, () -> {
			new Degree(year2, year3);
		});
	}

	//Test First but more than 25% Third grades
	@Test
	public void testDiscretion() {
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		year3.add(new Grade(1));
		year3.add(new Grade(1));
		year3.add(new Grade(1));
		year3.add(new Grade(16));
		

		
		assertThrows(IllegalArgumentException.class, () -> {
			year3.add(new Grade(-1));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			year3.add(new Grade(21));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			year3.add(Grade.fromPercentage(101));
		});
		
		Degree degree = new Degree(year2,year3);
		Classification degreeClassification = Classification.Discretion;
		Classification degreeClass = degree.classify();
		assertEquals(degreeClassification,degreeClass);
	}
	
	//test for year 3 having less grades in profile
	@Test
	public void testYear3LessGrades() {
		// add 4 grades
		year2.add(Grade.fromPercentage(82)); 
		year2.add(Grade.fromPercentage(89)); 
		year2.add(Grade.fromPercentage(45)); 
		year2.add(Grade.fromPercentage(51)); 

		// add 3 grades
		year3.add(Grade.fromPercentage(71));
		year3.add(Grade.fromPercentage(48));
		year3.add(Grade.fromPercentage(74));
		assertThrows(IllegalArgumentException.class, () -> {
			Degree degree = new Degree(year2, year3);
		});
	}
	
	//test for upper second class with first 2:1
	@Test
	public void testUpperSecondWithFirst() {
		year2.add(new Grade(5));
		year2.add(new Grade(5));
		year2.add(new Grade(5));
		year2.add(new Grade(5));
		year3.add(new Grade(1));
		year3.add(new Grade(2));
		year3.add(new Grade(3));
		year3.add(new Grade(6));

		Degree degree = new Degree(year2, year3);
		Classification degreeClassification = Classification.First;
		Classification degreeClass = degree.classify();
		assertEquals(degreeClass, degreeClassification);
	}


	//test for level5 profile is greater than level6 returning uppersecond 
	@Test
	public void testLevel5ProfileHigherUpperSecond() {
		List<Grade> grades = new ArrayList<Grade>();
		// add 3 grades
		year2.add(new Grade(5));
		year2.add(new Grade(5));
		year2.add(new Grade(5));
		year2.add(new Grade(5));

		// add 3 grades
		year3.add(Grade.fromPercentage(58));
		year3.add(Grade.fromPercentage(58));
		year3.add(Grade.fromPercentage(58));
		year3.add(Grade.fromPercentage(58));
		
		
		Degree degree = new Degree(year2, year3);
		Classification expected = Classification.UpperSecond;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}

	//test for level5 profile is greater than level6
	@Test
	public void testLevel5ProfileHigher() {
		List<Grade> grades = new ArrayList<Grade>();
		
		 year2.add(Grade.fromPercentage(68));
		 year2.add(Grade.fromPercentage(66));
         year2.add(Grade.fromPercentage(63));
         year2.add(Grade.fromPercentage(60));
		// add 3 grades
		year3.add(Grade.fromPercentage(43));
		year3.add(Grade.fromPercentage(48));
		year3.add(Grade.fromPercentage(40));
		year3.add(Grade.fromPercentage(45));
		
		
		Degree degree = new Degree(year2, year3);
		Classification expected = Classification.Discretion;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}

}

