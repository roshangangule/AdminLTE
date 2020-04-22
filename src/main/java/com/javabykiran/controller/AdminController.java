package com.javabykiran.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javabykiran.model.Admin;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	public String loginPage() {

		return "login";
	}

	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout";
	}

	@PostMapping("/dashboard")
	public String showDashboard(@RequestParam("email") String email, @RequestParam("password") String pass,
			Model theModel, HttpServletRequest request) {

		System.out.println("email:" + email + " Password" + pass);

		String userName = null;

		List<RegisterAdmin> admin = adminService.checkLogin(email, pass);

		System.out.println(admin);

		for (RegisterAdmin tempAdmin : admin) {
			userName = tempAdmin.getName();
			userName = userName.toUpperCase();
		}

		if (userName == null) {
			return "redirect:login";
		} else {
			theModel.addAttribute("username", userName);
			request.setAttribute("username", userName);
			return "dashboard";
		}

	}

	@RequestMapping("/adduser")
	public String addUser(Model theModel) {

		Admin theAdmin = new Admin();
		theModel.addAttribute("admin", theAdmin);
		return "add_user";
	}

	@RequestMapping("/downloads")
	public String download() {
		return "downloads";
	}

	@RequestMapping("/links")
	public String showLink() {
		return "links";
	}

	@RequestMapping("/operator")
	public String operator() {
		return "operators";
	}

	@GetMapping("/list")
	public String showUsers(Model theModel, @ModelAttribute("admin") Admin theAdmin) {

		List<Admin> theAdmins = adminService.getAdmins();

		theModel.addAttribute("admins", theAdmins);

		System.out.println(theAdmin);

		return "users";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {

		boolean temp = adminService.delete(theId);

		return "redirect:list";
	}

	@PostMapping("/list")
	public String getAdmin(@ModelAttribute("admin") Admin theAdmin) {

		adminService.saveAdmin(theAdmin);

		return "redirect:list";
	}

	@GetMapping("/register")
	public String register(Model theModel) {

		RegisterAdmin registerAdmin = new RegisterAdmin();
		// System.out.println(111);
		theModel.addAttribute("registeradmin", registerAdmin);
		// System.out.println(222);
		return "register";
	}

	@PostMapping("/registerdata")
	public String processRegister(@ModelAttribute("admin") RegisterAdmin theAdmin) {

		System.out.println(theAdmin);
		adminService.saveRegisterAdmin(theAdmin);

		return "redirect:login";
	}

	@GetMapping("/dashboard")
	public String dashboard() {

		return "dashboard";
	}

	@GetMapping("/update")
	public String dashboard(@RequestParam("id") int theId, Model theModel, HttpServletRequest request) {
		System.out.println(theId);

		Admin theAdmin = adminService.getAdmin(theId);

		System.out.println(theAdmin);
		String username = theAdmin.getUsername();
		// System.out.println(username);

		request.setAttribute("username", username);
		request.setAttribute("mobile", theAdmin.getMobileNumber());
		request.setAttribute("email", theAdmin.getEmail());
		request.setAttribute("course", theAdmin.getCourse());
		request.setAttribute("gender", theAdmin.getGender());
		request.setAttribute("state", theAdmin.getState());
		request.setAttribute("password", theAdmin.getPassword());

		theModel.addAttribute("admin", theAdmin);

		return "add_user";
	}

}
