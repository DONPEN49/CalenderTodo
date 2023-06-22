package app.web.calendertodo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.web.calendertodo.calender.CalenderView;
import app.web.calendertodo.model.CalendarModel;

@Controller
public class CalenderController {

	@Autowired
	private CalenderView calenderView;

	private int currentYear;
	private int currentMonth;

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendarTop(Model model) {

		CalendarModel calendarModel = new CalendarModel();
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
		currentMonth = Calendar.getInstance().get(Calendar.MONTH);

		//指定した年月のカレンダー生成
		List<ArrayList<CalendarModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, calendarModel);

		model.addAttribute("calendarModel", calendarModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}

	//前月ボタン
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String calendarBack(Model model) {
		CalendarModel calendarModel = new CalendarModel();

		if (currentMonth == 1) {
			currentMonth = 12;
			currentYear--;
		} else {
			currentMonth--;
		}

		//指定した年月のカレンダー生成
		List<ArrayList<CalendarModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, calendarModel);

		model.addAttribute("calendarModel", calendarModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}

	//翌月ボタン
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String calendarNext(Model model) {
		CalendarModel calendarModel = new CalendarModel();

		if (currentMonth == 12) {
			currentMonth = 1;
			currentYear++;
		} else {
			currentMonth++;
		}

		//指定した年月のカレンダー生成
		List<ArrayList<CalendarModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, calendarModel);

		model.addAttribute("calendarModel", calendarModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}
}
