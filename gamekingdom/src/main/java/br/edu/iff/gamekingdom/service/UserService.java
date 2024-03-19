package br.edu.iff.gamekingdom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.gamekingdom.entities.User;
import br.edu.iff.gamekingdom.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}

}
