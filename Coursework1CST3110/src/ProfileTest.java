import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class ProfileTest {

	//test if grades are  null and empty and contains fail Grade 
	@Test
	public void testNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			List<Grade> grade = new ArrayList<>();
			 grade = null;
		Profile profile =	new Profile(grade);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			List<Grade> grade = new ArrayList<>();
			 grade.isEmpty();
		Profile profile =	new Profile(grade);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			List<Grade> grade = new ArrayList<>();
			grade.add(Grade.fromPercentage(-1)); //fail grade
			grade.add(Grade.fromPercentage(22));
			grade.add(Grade.fromPercentage(31));
			grade.add(Grade.fromPercentage(35));
			
		Profile profile =	new Profile(grade);
		});
	}
	
	//Test classification first 

	@Test 
	public void testFirst() {
	
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(Grade.fromPercentage(90));
		grades.add(Grade.fromPercentage(74));
		grades.add(Grade.fromPercentage(77));
		grades.add(Grade.fromPercentage(71));
		
		assertThrows(IllegalArgumentException.class, () -> {
			grades.add(new Grade(-1));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			grades.add(new Grade(21));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			grades.add(Grade.fromPercentage(101));
		});
		
		Profile profile = new Profile(grades);
		Classification expectedProfile  = profile.classify();
		Classification actualProfile = Classification.First;
		
		assertEquals(expectedProfile,actualProfile);

		
	}
	
	
	//Test classification upperSecond
	@Test
	public void testUpperSecond() {
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(Grade.fromPercentage(68));
		grades.add(Grade.fromPercentage(66));
		grades.add(Grade.fromPercentage(63));
		grades.add(Grade.fromPercentage(61));
		
		Profile profile = new Profile(grades);
		Classification expectedProfile = profile.classify();
		Classification actualProfile = Classification.UpperSecond;
		
		assertEquals(expectedProfile,actualProfile);
		
		
	}
	
	//Test Classification LowerSecond
	@Test 
	public void testLowerSecond() {
		
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(Grade.fromPercentage(58));
		grades.add(Grade.fromPercentage(55));
		grades.add(Grade.fromPercentage(53));
		grades.add(Grade.fromPercentage(51));
		
		Profile profile = new Profile(grades);
		Classification expectedProfile = profile.classify();
		Classification actualProfile = Classification.LowerSecond;
		
		assertEquals(expectedProfile,actualProfile);
		
	}
	
	//Test Classification Third
	@Test 
	public void testThird() {
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(Grade.fromPercentage(48));
		grades.add(Grade.fromPercentage(45));
		grades.add(Grade.fromPercentage(43));
		grades.add(Grade.fromPercentage(40));
		
		Profile profile = new Profile(grades);
		Classification expectedProfile = profile.classify();
		Classification actualProfile = Classification.Third;
		
		assertEquals(expectedProfile,actualProfile);
		
	}

	//test if the profile is clear
	@Test
	public void testIsClearProfile() {
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(new Grade(1));//first
		grades.add(new Grade(1));//first
		grades.add(new Grade(5));//uppersecond
		grades.add(new Grade(6));//uppersecond
		
		Profile profile = new Profile(grades);
		boolean isClearProfile = true;
		boolean profileIsClear = profile.isClear();
		assertEquals(profileIsClear,isClearProfile);
		
	}
	

	// test profile is on borderline
	@Test
	public void testProfileNotClearFirst() {
		List<Grade> grades = new ArrayList<>();
		grades.add(Grade.fromPercentage(87)); //grade 1: 1
		grades.add(Grade.fromPercentage(77)); //grade 2: 2
		grades.add(Grade.fromPercentage(40)); //grade 3: 16
		grades.add(Grade.fromPercentage(42)); //grade 4: 15
		
		Profile profile = new Profile(grades);
		
		Classification expectedClassification = Classification.Discretion;
		Classification actualClassification = profile.classify();
		
		assertEquals(expectedClassification, actualClassification);
	}
	

	//test profile is not clear
	@Test 
	public void testIsNotClearProfile() {
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(new Grade(1));  // first
		grades.add(new Grade(1)); // first
		grades.add(new Grade(16)); //third
		grades.add(new Grade(16)); //third
		
		Profile profile = new Profile(grades);
		boolean isClearProfile = false;
		boolean profileIsClear = profile.isClear();
		
		assertEquals(profileIsClear,isClearProfile);
	}

	//test profile is not clear 
	@Test 
	public void testIsNotClear() {
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(new Grade(6));  // uppersecond
		grades.add(new Grade(6)); // uppersecond
		grades.add(new Grade(16)); //third
		grades.add(new Grade(16)); //third
		
		Profile profile = new Profile(grades);
		boolean isClearProfile = false;
		boolean profileIsClear = profile.isClear();
		
		assertEquals(profileIsClear,isClearProfile);
	}

}


