package app.web.calendertodo.model;

import java.io.Serializable;

public class DateDataModel implements Serializable {
	private String title;
	private String content;
	private String thisDate;
	private int thisYear;
	private int thisMonth;
	private int thisDay;


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThisDate() {
		return thisDate;
	}
	public void setThisDate(String thisDate) {
		this.thisDate = thisDate;
	}

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
}
