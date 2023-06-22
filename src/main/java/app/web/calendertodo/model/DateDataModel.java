package app.web.calendertodo.model;

import java.io.Serializable;

public class DateDataModel implements Serializable {
	private String title;
	private String content;
	private String thisDate;

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
}
