package com.otekin.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otekin.Entity.User;
import com.otekin.Repository.UserRepository;
import com.otekin.VO.UserVo;

@RestController
public class HomeController {

	@Autowired
	UserRepository repository;

	@GetMapping({ "/", "/getcall" })
	public ResponseEntity<List<UserVo>> listAllUsers() {
		List<User> userList = new ArrayList<>();
		userList = (List<User>) repository.findAll();
		List<UserVo> vo = new ArrayList<>();
		for (User users : userList) {
			UserVo obj = new UserVo();
			obj.setId(users.getId());
			obj.setName(users.getName());
			vo.add(obj);
		}
		return new ResponseEntity<List<UserVo>>(vo, HttpStatus.OK);
	}
}
