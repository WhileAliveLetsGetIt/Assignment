/**
 * A programme to store loadShedding objects
 * Load shedding objects store stage, date, and time as their id.
 * Affected areas for the corresponding object are stored in an array of the same name 
 * 
 * @author Calvin Nyoni
 * @date February 24, 2020
 */

public class loadShedding implements Comparable<loadShedding> {
	private String id;
	private String[] affectedAreas;
	
	/**
	 * construtor to build a loadShedding object using a given id and array of areas
	 * @param an id storing the stage, date, and time of loadshedding in the format stage_date_time
	 * @param an array storing the corresponding areas as integers
	 */
	public loadShedding(String id, String[] affectedAreas) {
		this.id = id;
		this.affectedAreas = affectedAreas;	
	}

	/** 
	 * toString
	 * @return the string representation of the loadShedding object
	 */
	public String toString() {

		String[] loadShedDetails = id.split("_");

		String returnString = "Stage " + loadShedDetails[0] + ", day " + loadShedDetails[1] + " of the month, "
				+ "starting time of " + loadShedDetails[2] + ":00 " + "affecting areas: ";

		int i = 0;

		while (i < affectedAreas.length) {
			returnString = returnString + affectedAreas[i] + " ";
			i = i + 1;
		}

		return returnString;
	}

	/**
	 * getId
	 * @return the loadShedding object's id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * getAreas
	 * @return an array of the areas ;oadShedding object affects
	 */
	public String[] getAreas() {
		return this.affectedAreas;
	}

	/**
	 * equals
	 * @param any another object
	 * @return true if one loadShedding object equals another loadShedding other
	 * Note comparison for simplicity is only made by examining object's ids
	 * @bug uncommenting line 78 for true comparison may cause issues with compareTo method
	 */
	public boolean equals(Object other) {

		if (other == null) {
			return false;
		}

		if (getClass() == other.getClass()) {
			loadShedding otherLoadShed = (loadShedding) other;
			if (this.id.equals(otherLoadShed.getId())) {
				return true;
				/*
				if (this.affectedAreas.equals(otherLoadShed.getAreas())) {
					return true;
				}
				*/
			}
		}

		return false;
	}

	/**
	 * 
	 */
	public int compareTo(loadShedding other) {

		if (this.equals(other)) {
			return 0;
		}
		
		if (getClass() == other.getClass()) {
			loadShedding otherLoadShed = (loadShedding) other;
			return this.id.compareTo(otherLoadShed.getId());
		}

		return 3333;
	}
  
}
