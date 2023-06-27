package app.web.calendertodo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import app.web.calendertodo.model.FormModel;
import app.web.calendertodo.model.PageModel;

@Controller
@SessionAttributes("pageModel")
public class formController {

	@Autowired
	private FormDAO formDAO;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String toForm(Model model) {

		model.addAttribute("formModel", new FormModel());
		return "formRegistration";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String form(@ModelAttribute FormModel formModel, Model model) {

		FormDatas formDatas = new FormDatas();
		formDatas.setDataid(formModel.getDataid());
		formDatas.setYear(formModel.getYear());
		formDatas.setMonth(formModel.getMonth());
		formDatas.setDay(formModel.getDay());
		formDatas.setTime(FormDatas.parseDate(formModel.getTime()));
		formDatas.setTitle(formModel.getTitle());
		formDatas.setContent(formModel.getContent());


		formDAO.insert(formDatas);
		return "redirect:/calendar";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String toRegistration(Model model, HttpSession session) {
		PageModel pageModel = (PageModel) session.getAttribute("pageModel");
		List<FormDatas> formDataList = formDAO.getListByDate(pageModel.getYear(), pageModel.getMonth(),
				pageModel.getDay());

		model.addAttribute("formDatas", formDataList);

		return "formConfirm";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String registration(@ModelAttribute PageModel pageModel, HttpServletRequest request, Model model) {

		if (pageModel.getToPage().equals("delete")) {
			int id = Integer.parseInt(request.getParameter("dataid"));
			formDAO.delete(id);
		} else if (pageModel.getToPage().equals("add")){
			return "redirect:/regist";
		}

		return "redirect:/calendar";
	}

}
