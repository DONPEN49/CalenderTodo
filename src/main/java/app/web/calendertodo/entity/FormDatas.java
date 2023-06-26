package app.web.calendertodo.entity;

import java.io.Serializable;

public class FormDatas implements Serializable {
	private Integer dataid;
	private Integer year;
	private Integer month;
	private Integer day;
	private String time;
	private String title;
	private String content;

	public Integer getDataid() {
		return dataid;
	}

	public void setDataid(Integer dataid) {
		this.dataid = dataid;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

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


}
