package com.javabykiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javabykiran.model.Admin;
import com.javabykiran.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout";
	}

	@PostMapping("/dashboard")
	public String showDashboard(@RequestParam("email") String email, @RequestParam("password") String pass,
			Model theModel) {

		System.out.println("email:" + email + " Password" + pass);

		String userName = null;

		List<Admin> admin = adminService.checkLogin(email, pass);

		System.out.println(admin);

		for (Admin tempAdmin : admin) {
			userName = tempAdmin.getUsername();
			userName = userName.toUpperCase();
		}

		if (userName == null) {
			return "redirect:login";
		} else {
			theModel.addAttribute("username", userName);
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

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/list")
	public String showUsers(Model theModel, @ModelAttribute("admin") Admin theAdmin) {

		List<Admin> theAdmins = adminService.getAdmins();

		theModel.addAttribute("admins", theAdmins);

		System.out.println(theAdmin);

		adminService.saveAdmin(theAdmin);

		return "users";
	}

	@GetMapping("delete")
	public String delete(@RequestParam("id") int theId) {

		boolean temp = adminService.delete(theId);

		return "redirect:list";
	}

}
