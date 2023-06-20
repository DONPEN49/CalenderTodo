package app.web.calendertodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.web.calendertodo.calender.CalenderView;

@Controller
public class CalenderController {

	@Autowired
	private CalenderView calenderView;

	@RequestMapping(value = "/calender", method = RequestMethod.GET)
	public String calenderTop() {

		calenderView.CreateCalender(2023, 5);

		return "/top";
	}

}
