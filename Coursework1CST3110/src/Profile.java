
import java.util.List;

/**
 * This class holds grades and proportion of each classification. This class also calculates the overall
 * classification for a profile.
 * @author Manjot Kaur
 * @see Grade.java
 */
public class Profile {
	private List<Grade> grades;  // list of grades
	private double firstClass = 0;  // first class profile counter
	private double upperSecondClass = 0; // upper second class profile counter
	private double lowerSecondClass = 0; // lower second class profile counter
	private double thirdClass = 0;       // third class profile counter
	private static Classification first = Classification.First; // Classification first
	private static Classification upperSecond = Classification.UpperSecond; // Classification upperSecond
	private static Classification lowerSecond = Classification.LowerSecond; //Classification lowerSecond
	private static Classification third = Classification.Third; //Classification third
	
        
	/**
	 * This method throws the illegalArgument exception if the list contains fail
	 * grades,null or empty
	 * 
	 * @param grade    List of grades
	 * 
	 */

	public Profile(List<Grade> grade) {
		if(grade == null || grade.isEmpty() || failGrade(grade)) {
			throw new IllegalArgumentException();
		}else {
		this.grades = grade;
		getAllClasses();
		}

	}
	

	/**
	 * this method will return false if the profile has fail grade
	 * @param grade		list of grades
	 * @return			false
	 */
	private boolean failGrade(List<Grade> grade) {
		for (int i = 0; i < grade.size(); i++) 
			if (grade.get(i).classify() == Classification.Fail)
				return true;
		return false;
	}


	/**
	 * this method will return the counter of every profile 
	 */
	private  void getAllClasses() {
		for (Grade grade : grades) {
			 if(grade.classify().toString() == "First") {
				firstClass += 1.0;
			}else if(grade.classify().toString() == "UpperSecond") {
				upperSecondClass += 1.0;
			}else if(grade.classify().toString() == "LowerSecond") {
				lowerSecondClass += 1.0;
			}else{
				thirdClass += 1.0;
			}
		
		}
	}
	
	/**
	 * this method will return the classification of the profile
	 * @return   classifications 
	 */
	public Classification classify() {
		double percentage = 0.5;
		if(!isClear()) {
			return Classification.Discretion;
		}else if (firstClass / grades.size() >= percentage){
            return first;
        } else if (upperSecondClass / grades.size()>= percentage) {
            return upperSecond;
        } else if (lowerSecondClass / grades.size() >= percentage) {
            return lowerSecond;
        } else {
	    return third;
        }
	}
	

/**
 * this method will return false if the profile is not clear 
 * @return			false
 */
	public boolean isClear() {
	if((upperSecondClass >= 0.50 && thirdClass > 0.25)
	  || (firstClass > 0.50 && thirdClass > 0.25))
			return false;
		else 
			return true;
	}
}

