package br.com.gft.staffing.service;

import java.util.List;

import br.com.gft.staffing.model.User;

public interface UserService {
	List<User> findAll();
	User save(User user);
}
