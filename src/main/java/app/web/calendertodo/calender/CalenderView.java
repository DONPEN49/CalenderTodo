package app.web.calendertodo.calender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.web.calendertodo.dao.FormDAO;
import app.web.calendertodo.entity.FormDatas;
import app.web.calendertodo.model.CalendarModel;

@Component
public class CalenderView {

	@Autowired
	private FormDAO formDAO;

	private int[][] calenderMatrix;
	private Calendar calendar;

	public CalenderView() {
		// TODO 自動生成されたコンストラクター・スタブ
		calendar = Calendar.getInstance();
	}

	//カレンダーリスト作成
	public List<ArrayList<CalendarModel>> CreateCalendar(int year, int month, CalendarModel dataModel) {

		String[] weeks= {"日","月","火","水","木","金","土"};

		//カレンダーの年月を設定
		setCalenderDate(year, month);

		//行列に日代入
		calcFields();

		List<ArrayList<CalendarModel>> calenderList = new ArrayList<ArrayList<CalendarModel>>();

		//データベースから予定データ取得
		List<FormDatas> formDataList = formDAO.getListByDate(year, month + 1);

		//リストに代入
		for(int y = 0; y < calenderMatrix.length; y++) {
			ArrayList<CalendarModel> dateList = new ArrayList<CalendarModel>();
			for(int x = 0; x < calenderMatrix[y].length; x++) {
				CalendarModel model = new CalendarModel();
				model.setThisDay(calenderMatrix[y][x]);

				//日付が一致するなら予定データいれる
				for (FormDatas data : formDataList) {
					if (data.getDay() == calenderMatrix[y][x]) {
						model.setTitle(data.getTitle());
					}
				}

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

	//一日の曜日取得
	private int getFirstDay() {
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	//月の最終日取得
	private int getLastDay() {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	private void calcFields() {
		calenderMatrix = new int[6][7];
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
