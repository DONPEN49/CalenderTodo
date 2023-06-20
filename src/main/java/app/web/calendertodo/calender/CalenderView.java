package app.web.calendertodo.calender;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class CalenderView {

	public void CreateCalender(int _year, int _month) {
		Calendar calendar = Calendar.getInstance();
		//月のはじめの１
		final int firstDay = 1;
		calendar.set(_year, _month, firstDay);
		int firstDayWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


		int row = 0;
		int colume = 0;
		int[][] calenderMatrix = new int[6][7];
		for(int date = 1; date <= lastDay; date++) {
			calenderMatrix[row][colume] = date;
		}

	}


}
