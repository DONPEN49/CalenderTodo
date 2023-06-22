package app.web.calendertodo.controller;

import java.util.ArrayList;
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

	@RequestMapping(value = "/calender", method = RequestMethod.GET)
	public String calenderTop(Model model) {

		DateDataModel dataModel = new DateDataModel();

		List<ArrayList<DateDataModel>> calendar = calenderView.CreateCalendar(2023, 5, dataModel);

		model.addAttribute("dateDataModel", dataModel);
		model.addAttribute("calendar", calendar);

		return "/top";
	}

}
