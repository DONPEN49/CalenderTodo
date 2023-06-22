package app.web.calendertodo.calender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import app.web.calendertodo.model.DateDataModel;

@Component
public class CalenderView {

	private int[][] calenderMatrix;
	private Calendar calendar;

	public CalenderView() {
		// TODO 自動生成されたコンストラクター・スタブ
		calendar = Calendar.getInstance();
	}

	//カレンダーリスト作成
	public List<ArrayList<DateDataModel>> CreateCalendar(int year, int month, DateDataModel dataModel) {

		String[] weeks= {"日","月","火","水","木","金","土"};

		//カレンダーの年月を設定
		setCalenderDate(year, month);

		//行列に日代入
		calcFields();

		List<ArrayList<DateDataModel>> calenderList = new ArrayList<ArrayList<DateDataModel>>();

		//リストに代入
		for(int y = 0; y < calenderMatrix.length; y++) {
			ArrayList<DateDataModel> dateList = new ArrayList<DateDataModel>();
			for(int x = 0; x < calenderMatrix[y].length; x++) {
				DateDataModel model = new DateDataModel();
				model.setThisDay(calenderMatrix[y][x]);
				if(y == 0) {
					model.setThisWeek(weeks[x]);
				}
				dateList.add(model);

			}
			calenderList.add(dateList);
		}

		dataModel.setThisYear(calendar.get(Calendar.YEAR));
		dataModel.setThisMonth(calendar.get(Calendar.MONTH) + 1);
		dataModel.setThisDay(calendar.get(Calendar.DATE));

		return calenderList;

	}

	//カレンダー年月設定
	private void setCalenderDate(int year, int month) {
		calendar.set(year, month, 1);
	}

	private int getFirstDay() {
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	private int getLastDay() {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	private void calcFields() {
		calenderMatrix = new int[5][7];
		int colume = getFirstDay();
		int row = 0;

		for(int date = 1; date <= getLastDay(); date++) {
			calenderMatrix[row][colume] = date;
			if (colume == 6) {
				colume = 0;
				row++;
			} else {
				colume++;
			}
		}
	}
}
