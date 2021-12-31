import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the final classification of the degree.
 * @author Manjot Kaur
 *@see Profile.java
 */
public class Degree {
	// Your additions/changes below this line

		private Profile level5, level6; // level 5 and level 6

		private Classification fail = Classification.Fail; // Classification fail
		private Classification discretion = Classification.Discretion;// Classification Discretion
		private List<Grade> year2AndYear3 = new ArrayList<Grade>(); // List having eight grades of both years
		

		/**
		 * 
		 * @param year2		list of grades in year2
		 * @param year3		list of grades  in year3
		 */
		public Degree(List<Grade> year2, List<Grade> year3) {

			if (year2 == null || year2.size() != 4 || containsFail(year2) || year3 == null || year3.size() != 4
					|| containsFail(year3)) {
				throw new IllegalArgumentException();
			} else {

				year2AndYear3.addAll(year2);
				year2AndYear3.addAll(year3);
				level5 = new Profile(year2AndYear3);
				level6 = new Profile(year3);

			}
		}
		
		/**
		 * this method will return false if the list contains fail grade
		 * @param year		list of grades
		 * @return			false
		 */
		private boolean containsFail(List<Grade> year) {
			for (Grade grade : year)
				if (grade.classify() == fail)
					return true;

			return false;
		}

		/**
		 * this method will return  the final  classification of the degree
		 * @return		classification of the degree
		 */
		public Classification classify() {
			Integer level5Class = level5.classify().ordinal();
			Integer level6Class = level6.classify().ordinal();
			Classification[] classifications = Classification.values();
			if (level5Class.equals(level6Class)) {
				return classifications[level5Class];
			} else if (level6Class == level5Class + 1) {
				return classifications[level6Class];
			} else if (level6Class ==  level5Class - 1) {
				return classifications[level5Class];
			} else
				return discretion;
		}
		
}
