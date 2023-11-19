package com.ssafy.ssafit.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{userId}")
	@ApiOperation(value = "기존유저 확인", notes = "기존 유저가 존재하는지 확인합니다")
	public ResponseEntity<String> isExist(@PathVariable String userId) {
		User dbUser = userService.getUser(userId);
		String result;
		HttpStatus status = null;
		if (dbUser != null) {
			result = "FAIL";
			status = HttpStatus.BAD_REQUEST;
		} else {
			result = "SUCCESS";
			status = HttpStatus.OK;
		}
		return new ResponseEntity<String>(result, status);
	}

	@PostMapping("/join")
	@ApiOperation(value = "유저 추가", notes = "RequestData : id, password, nickname, userType")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User Added", HttpStatus.OK);
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "RequestData : id, password")
	public ResponseEntity<Map<String, Object>> logIn(@RequestBody User user) {
		User dbUser = userService.getUser(user.getId());
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;

		// id가 틀려서 db에서 user를 가져올 수 없거나(null)
		// dbUser와 user의 비밀번호가 서로 다를 때
		if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
			result.put("message", "FAIL");
			status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<Map<String, Object>>(result, status);
		}

		// 로그인 성공시
		try {
			result.put("access-token", jwtUtil.createToken("id", dbUser.getId()));
			result.put("message", "SUCCESS");
			result.put("nickname", dbUser.getNickname());
			result.put("userSeq", dbUser.getUserSeq());
			status = HttpStatus.ACCEPTED;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃합니다.")
	public ResponseEntity<String> logout() {
		return ResponseEntity.ok("Logged out successfully");
	}

}
