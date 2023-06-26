package app.web.calendertodo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.web.calendertodo.dao.FormDAO;
import app.web.calendertodo.entity.FormDatas;
import app.web.calendertodo.model.PageModel;

@Controller
@SessionAttributes("pageModel")
public class formController {

	@Autowired
	private FormDAO formDAO;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String toForm(Model model) {

		model.addAttribute("formDatasModel", new FormDatas());
		return "formRegistration";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String form(@ModelAttribute FormDatas formDatas, Model model) {
		return "/top";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String toRegistration(Model model, HttpSession session) {
		PageModel pageModel =  (PageModel)session.getAttribute("pageModel");
		List<FormDatas> formDataList = formDAO.getListByDate(pageModel.getYear(), pageModel.getMonth(), pageModel.getDay());

		model.addAttribute("formDatas", formDataList);

		return "formConfirm";
	}

}
