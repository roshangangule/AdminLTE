package com.javabykiran.service;

import java.util.List;

import com.javabykiran.model.Admin;
import com.javabykiran.model.RegisterAdmin;

public interface AdminService {

	public List<Admin> getAdmins();

	public List<RegisterAdmin> checkLogin(String email, String pass);

	public Admin saveAdmin(Admin theAdmin);

	public boolean delete(int theId);

	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin);

}
