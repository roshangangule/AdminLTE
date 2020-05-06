package com.javabykiran.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Admin;
import com.javabykiran.model.Admin2;
import com.javabykiran.model.Links;
import com.javabykiran.model.Operator;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.model.State;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Admin2> getAdmins() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Admin2");
		List<Admin2> admins = query.list();
		return admins;
	}

	@Override
	public List<RegisterAdmin> checkLogin(String email, String pass) {
		Session currentSession = sessionFactory.getCurrentSession();

		List<RegisterAdmin> admin = currentSession
				.createQuery("from RegisterAdmin where " + "email='" + email + "' and password='" + pass + "'").list();

		return admin;
	}

	@Override
	public Admin2 saveAdmin(Admin2 theAdmin) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(theAdmin);
		currentSession.saveOrUpdate(theAdmin);

		return theAdmin;
	}

	@Override
	public boolean delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Admin2 admin = (Admin2) currentSession.get(Admin2.class, theId);
		String isDefault = admin.getIsDefault();

		if (isDefault.equals("Y")) {
			return false;
		} else {
			currentSession.delete(admin);
			return true;

		}
	}

	@Override
	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(theAdmin);

		return theAdmin;
	}

	@Override
	public Admin2 getAdmin(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Admin2 admin = (Admin2) currentSession.get(Admin2.class, theId);
		System.out.println(admin);

		return admin;
	}

	@Override
	public List<State> getState() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from State");
		List<State> theStates = query.list();
		State theState = new State();

		return theStates;
	}

	@Override
	public List<Links> getLinks() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Links");

		List<Links> links = query.list();

		return links;
	}

	@Override
	public List<Operator> getOperators() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Operator");

		List<Operator> operators = query.list();
		return operators;
	}

}
