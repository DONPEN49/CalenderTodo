package app.web.calendertodo.calender;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import app.web.calendertodo.model.DateDataModel;

@Component
public class CalenderView {

	public void CreateCalender(int _year, int _month, DateDataModel dataModel) {
		Calendar calendar = Calendar.getInstance();
		DateDataModel model = new DateDataModel();
		String[] weeks= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		//月のはじめの１
		final int firstDay = 1;

		int firstDayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


		int row = 0;
		int colume = 0;
		int[][] calenderMatrix = new int[6][7];
		for(int date = 1; date <= lastDay; date++) {
			calenderMatrix[row][colume] = date;
		}



		dataModel.setThisYear(calendar.get(Calendar.YEAR));
		dataModel.setThisMonth(calendar.get(Calendar.MONTH) + 1);
		dataModel.setThisDay(calendar.get(Calendar.DATE));
		dataModel.setThisWeek(weeks[firstDayWeek - 1]);

	}


}
