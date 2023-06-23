package app.web.calendertodo.model;

import java.io.Serializable;

public class PageModel implements Serializable {
	private String toPage;
	private int date;

	public String getToPage() {
		return toPage;
	}
	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
}
