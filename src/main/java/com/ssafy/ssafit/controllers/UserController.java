package com.ssafy.ssafit.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.JwtUtil;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/join")
	@ApiOperation(value = "유저 추가", notes = "RequestData : id, password, nickname, userType")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User Added", HttpStatus.OK);
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "RequestData : id, password")
	public ResponseEntity<Map<String, Object>> logIn(@RequestBody User user) {
		// 로그인에 실패하면 userType == 0
		// 로그인 성공시 userType == 1 or 2 or 3
		int userType = userService.logIn(user);
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;
		
		try {
			if (userType != 0) {
				User dbUser = userService.getUser(user.getId());
				result.put("message", "SUCCESS");
				result.put("nickname", dbUser.getNickname());
				result.put("userSeq", dbUser.getUserSeq());
				result.put("access-token", jwtUtil.createToken("id", dbUser.getId()));
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", "FAIL");
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(result, status);
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃합니다.")
	public ResponseEntity<String> logout() {
		return ResponseEntity.ok("Logged out successfully");
	}

}
