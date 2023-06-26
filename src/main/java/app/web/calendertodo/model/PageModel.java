package app.web.calendertodo.model;

import java.io.Serializable;

public class PageModel implements Serializable {
	private String toPage;
	private int year;
	private int month;
	private int day;
	private boolean inData;

	public boolean isInData() {
		return inData;
	}
	public void setInData(boolean inData) {
		this.inData = inData;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}

	public String getToPage() {
		return toPage;
	}
	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
}
