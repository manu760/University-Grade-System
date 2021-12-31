/**
 * This class holds the grades and percentage of the grades.
 * @author Manjot Kaur
 */
public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	/**
	 * Constructor throwing IllegalArgumentException
	 * 
	 * @param p points between 1 to 20
	 * @throws IllegalArgumentException
	 */
	public Grade(int p) throws IllegalArgumentException {
		if (p < 1 || p > 20)
			throw new IllegalArgumentException();
		points = p;
	}

	/**
	 * 
	 * @return Classification of Grades
	 */

	public Classification classify() {

		if (getPoints() >= 1 && getPoints() <= 4) {
			return Classification.First;
		} else if (points >= 5 && points <= 8) {
			return Classification.UpperSecond;
		} else if (points >= 9 && points <= 12) {
			return Classification.LowerSecond;
		} else if (points >= 13 && points <= 16) {
			return Classification.Third;
		} else {
			return Classification.Fail;
		}

	}

	/**
	 * 
	 * @param percentage fromPercentage 1 to 100
	 * @return grades 1 to 20
	 * @throws IllegalArgumentException
	 */
	public static Grade fromPercentage(int percentage) {

		if (percentage == -1)
			return new Grade(20);
		else if (percentage >= 0 && percentage <= 29)
			return new Grade(19);
		else if (percentage >= 30 && percentage <= 34)
			return new Grade(18);
		else if (percentage >= 35 && percentage <= 39)
			return new Grade(17);
		else if (percentage >= 40 && percentage <= 41)
			return new Grade(16);
		else if (percentage >= 42 && percentage <= 44)
			return new Grade(15);
		else if (percentage >= 45 && percentage <= 46)
			return new Grade(14);
		else if (percentage >= 47 && percentage <= 49)
			return new Grade(13);
		else if (percentage >= 50 && percentage <= 51)
			return new Grade(12);
		else if (percentage >= 52 && percentage <= 54)
			return new Grade(11);
		else if (percentage >= 55 && percentage <= 56)
			return new Grade(10);
		else if (percentage >= 57 && percentage <= 59)
			return new Grade(9);
		else if (percentage >= 60 && percentage <= 61)
			return new Grade(8);
		else if (percentage >= 62 && percentage <= 64)
			return new Grade(7);
		else if (percentage >= 65 && percentage <= 66)
			return new Grade(6);
		else if (percentage >= 67 && percentage <= 69)
			return new Grade(5);
		else if (percentage >= 70 && percentage <= 72)
			return new Grade(4);
		else if (percentage >= 73 && percentage <= 75)
			return new Grade(3);
		else if (percentage >= 76 && percentage <= 78)
			return new Grade(2);
		else if (percentage >= 79 && percentage <= 100)
			return new Grade(1);

		throw new IllegalArgumentException();

	}
}
