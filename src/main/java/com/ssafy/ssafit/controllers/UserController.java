package com.ssafy.ssafit.controllers;

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

	@PostMapping("/join")
	@ApiOperation(value = "유저 추가", notes = "RequestData : id, password, nickname, userType")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User Added", HttpStatus.OK);
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "RequestData : id, password")
	public ResponseEntity<Map<String, String>> logIn(@RequestBody User user, HttpSession session) {
		// 로그인에 실패하면 userType == 0
		// 로그인 성공시 userType == 1 or 2 or 3
		int userType = userService.logIn(user);
		Map<String, String> userMap = new HashMap<String, String>();

		if (userType != 0) {
			System.out.println("로그인 성공");
			// 로그인시 session에 seq, id, type 저장
			// 해당 정보를 바탕으로 게시글, 댓글 update, delete시에 유저정보 확인
			User dbUser = userService.getUser(user.getId());
			session.setAttribute("user_id", dbUser.getId());
			session.setAttribute("user_type", dbUser.getUserType());
			session.setAttribute("user_seq", dbUser.getUserSeq());
			String nickname = dbUser.getNickname();
			int seq = dbUser.getUserSeq();
			userMap.put("nickname", nickname);
			userMap.put("userSeq", "" + seq);
			return new ResponseEntity<Map<String, String>>(userMap, HttpStatus.ACCEPTED);
		} else {
			System.out.println("로그인 실패");
			session.invalidate();
			return new ResponseEntity<Map<String, String>>(userMap, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/status")
	@ApiOperation(value = "로그인 상태 확인", notes = "로그인 상태를 확인하고, 로그인이 되어있을 때 200을 반환합니다.")
	public ResponseEntity<String> checkLoginStatus(HttpSession session) {
		// 세션에서 사용자 정보를 가져와 로그인 상태를 확인합니다.
		HttpHeaders header = new HttpHeaders();
		if (session.getAttribute("user_id") != null) {
			header.add("login_status", "true");
			header.add("user_type", session.getAttribute("user_type").toString());
			return new ResponseEntity<String>("User is logged in", header, HttpStatus.ACCEPTED);
		} else {
			header.add("login_status", "false");
			return new ResponseEntity<String>("User is not logged in", header, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃합니다.")
	public ResponseEntity<String> logout(HttpSession session) {
		// 로그아웃 시 세션에서 사용자 정보를 제거합니다.
		session.invalidate();
		return ResponseEntity.ok("Logged out successfully");
	}

}
