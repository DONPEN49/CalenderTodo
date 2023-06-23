package app.web.calendertodo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.web.calendertodo.calender.CalenderView;
import app.web.calendertodo.model.CalendarModel;
import app.web.calendertodo.model.PageModel;

@Controller
@SessionAttributes("pageModel")
public class CalenderController {

	@Autowired
	private CalenderView calenderView;

	@ModelAttribute("pageModel")
	public PageModel setUpPageModel() {
		return new PageModel();
	}

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

	@RequestMapping(value = "/calendar", method = RequestMethod.POST)
	public String calendar(@ModelAttribute PageModel pageModel, Model model) {

		if (!pageModel.getToPage().equals("form")) {
			//前月
			if (pageModel.getToPage().equals("back")) {
				if (currentMonth == 1) {
					currentMonth = 12;
					currentYear--;
				} else {
					currentMonth--;
				}
			} //翌月
			else if (pageModel.getToPage().equals("next")) {
				if (currentMonth == 12) {
					currentMonth = 1;
					currentYear++;
				} else {
					currentMonth++;
				}
			}

			CalendarModel calendarModel = new CalendarModel();

			//指定した年月のカレンダー生成
			List<ArrayList<CalendarModel>> calendar = calenderView.CreateCalendar(currentYear, currentMonth, calendarModel);

			model.addAttribute("calendarModel", calendarModel);
			model.addAttribute("calendar", calendar);

			return "/top";
		} else {

			return "redirect:/form";
		}



	}

}
