package app.web.calendertodo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.web.calendertodo.model.CalendarModel;
import app.web.calendertodo.model.DateDataModel;

@Controller
public class formController {


	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String toForm(Model model) {

		CalendarModel calendarModel = new CalendarModel();
		calendarModel.setThisYear(Calendar.getInstance().get(Calendar.YEAR));
		calendarModel.setThisMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);

		model.addAttribute("calendarModel", calendarModel);

		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String form(@ModelAttribute DateDataModel dataModel, Model model) {
		return "/top";
	}

}
