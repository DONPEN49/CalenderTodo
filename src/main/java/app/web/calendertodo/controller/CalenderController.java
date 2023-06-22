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
import app.web.calendertodo.model.DateDataModel;

@Controller
public class CalenderController {

	@Autowired
	private CalenderView calenderView;

	private int currentYear;
	private int currentMonth;


	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendarTop(Model model) {

		DateDataModel dataModel = new DateDataModel();
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
		currentMonth = Calendar.getInstance().get(Calendar.MONTH);


		List<ArrayList<DateDataModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, dataModel);

		model.addAttribute("dateDataModel", dataModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}

	//前月ボタン
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String calendarBack(Model model) {
		DateDataModel dataModel = new DateDataModel();

		if (currentMonth == 1) {
			currentMonth = 12;
			currentYear--;
		} else {
			currentMonth--;
		}

		List<ArrayList<DateDataModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, dataModel);

		model.addAttribute("dateDataModel", dataModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}

	//前月ボタン
		@RequestMapping(value = "/next", method = RequestMethod.GET)
		public String calendarNext(Model model) {
			DateDataModel dataModel = new DateDataModel();

			if (currentMonth == 12) {
				currentMonth = 1;
				currentYear++;
			} else {
				currentMonth++;
			}

			List<ArrayList<DateDataModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, dataModel);

			model.addAttribute("dateDataModel", dataModel);
			model.addAttribute("calendar", calendar);

			return "/top";
		}
}
