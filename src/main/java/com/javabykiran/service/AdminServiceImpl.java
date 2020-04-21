package com.javabykiran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabykiran.dao.AdminDAO;
import com.javabykiran.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Admin> getAdmins() {
		
		return adminDAO.getAdmins();
	}

	@Override
	@Transactional
	public List<Admin> checkLogin(String email, String pass) {
		
		return adminDAO.checkLogin(email,pass);
	}

	@Override
	@Transactional
	public Admin saveAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub
		return adminDAO.saveAdmin(theAdmin);
	}

	@Override
	@Transactional
	public boolean delete(int theId) {
		
		return adminDAO.delete(theId);
	}
}
