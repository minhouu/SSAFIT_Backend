package com.ssafy.ssafit.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags="유저 컨트롤러")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ApiOperation(value="유저 추가", notes="새로운 유저를 추가합니다.")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@PostMapping("/login")
	@ApiOperation(value="로그인", notes="로그인을 시도합니다.")
	public ResponseEntity<String> logIn(@RequestBody User user, HttpSession session) {
		int isChecked = userService.logIn(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		if (isChecked == 1) {
			session.setAttribute("loggedInUser", user.getId());
			return new ResponseEntity<String>("login success", headers, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("login failed", headers, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/login/status")
	@ApiOperation(value="로그인 상태 확인", notes="로그인 상태를 확인하고, 로그인이 되어있을 때 200을 반환합니다.")
	public ResponseEntity<String> checkLoginStatus(HttpSession session) {
		// 세션에서 사용자 정보를 가져와 로그인 상태를 확인합니다.
		if (session.getAttribute("loggedInUser") != null) {
			return ResponseEntity.ok("User is logged in");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
		}
	}

	@GetMapping("/logout")
	@ApiOperation(value="로그아웃", notes="로그아웃합니다.")
	public ResponseEntity<String> logout(HttpSession session) {
		// 로그아웃 시 세션에서 사용자 정보를 제거합니다.
		session.invalidate();
		return ResponseEntity.ok("Logged out successfully");
	}

}
