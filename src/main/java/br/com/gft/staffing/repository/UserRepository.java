package br.com.gft.staffing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.staffing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
