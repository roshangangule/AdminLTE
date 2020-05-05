package com.javabykiran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabykiran.dao.AdminDAO;
import com.javabykiran.model.Admin;
import com.javabykiran.model.Admin2;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.model.State;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Admin2> getAdmins() {
		
		return adminDAO.getAdmins();
	}

	@Override
	@Transactional
	public List<RegisterAdmin> checkLogin(String email, String pass) {
		
		return adminDAO.checkLogin(email,pass);
	}

	@Override
	@Transactional
	public Admin2 saveAdmin(Admin2 theAdmin) {
		// TODO Auto-generated method stub
		return adminDAO.saveAdmin(theAdmin);
	}

	@Override
	@Transactional
	public boolean delete(int theId) {
		
		return adminDAO.delete(theId);
	}

	@Override
	@Transactional
	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin) {
		
		return adminDAO.saveRegisterAdmin(theAdmin);
	}

	@Override
	@Transactional
	public Admin2 getAdmin(int theId) {
		return adminDAO.getAdmin(theId);
	}

	@Override
	@Transactional
	public List<State> getState() {
		
		return adminDAO.getState();
	}
}
