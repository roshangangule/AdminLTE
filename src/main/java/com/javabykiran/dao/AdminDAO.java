package com.javabykiran.dao;

import java.util.List;

import com.javabykiran.model.Admin;
import com.javabykiran.model.Admin2;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.model.State;

public interface AdminDAO {

	public List<Admin2> getAdmins();

	public List<RegisterAdmin> checkLogin(String email, String pass);

	public Admin2 saveAdmin(Admin2 theAdmin);

	public boolean delete(int theId);

	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin);

	public Admin2 getAdmin(int theId);

	public List<State> getState();

}
