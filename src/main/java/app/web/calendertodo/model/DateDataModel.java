package app.web.calendertodo.model;

import java.io.Serializable;

public class DateDataModel implements Serializable {
	private int thisYear;
	private int thisMonth;
	private int thisDay;
	private String thisWeek;


	public int getThisYear() {
		return thisYear;
	}
	public void setThisYear(int thisYear) {
		this.thisYear = thisYear;
	}
	public int getThisMonth() {
		return thisMonth;
	}
	public void setThisMonth(int thisMonth) {
		this.thisMonth = thisMonth;
	}
	public int getThisDay() {
		return thisDay;
	}
	public void setThisDay(int thisDay) {
		this.thisDay = thisDay;
	}
	public String getThisWeek() {
		return thisWeek;
	}
	public void setThisWeek(String thisWeek) {
		this.thisWeek = thisWeek;
	}
}
