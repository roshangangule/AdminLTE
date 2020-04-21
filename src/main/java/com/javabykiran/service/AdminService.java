package com.javabykiran.service;

import java.util.List;

import com.javabykiran.model.Admin;

public interface AdminService {

	public List<Admin> getAdmins();

	public List<Admin> checkLogin(String email, String pass);

	public Admin saveAdmin(Admin theAdmin);

	public boolean delete(int theId);

}
