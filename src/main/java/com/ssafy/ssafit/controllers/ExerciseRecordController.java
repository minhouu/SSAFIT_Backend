package com.ssafy.ssafit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.ExerciseRecord;
import com.ssafy.ssafit.model.service.ExerciseRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/record")
@Api(tags = "운동기록 컨트롤러")
@CrossOrigin("*")
public class ExerciseRecordController {

	@Autowired
	private ExerciseRecordService recordService;
	
	
	//완료
	@PostMapping
	@ApiOperation(value = "기록 추가", notes = "새로운 운동기록을 추가합니다.\nParameter 나중에 채워 넣음")
	public ResponseEntity<String> addRecord(@RequestBody ExerciseRecord exerciseRecord) {
		System.out.println(exerciseRecord);
		int userSeq = 1;
		exerciseRecord.setUserSeq(userSeq);
		
		recordService.addRecord(exerciseRecord);
		
		return new ResponseEntity<String>("Record Added", HttpStatus.ACCEPTED);
	}
	
	//완료
	@GetMapping("/exerciseName/{exerciseName}")
	@ApiOperation(value = "해당 운동 종목 기록 가져오기", notes = "해당 운동 종목 기록을 최신 10개 가져옵니다.\\nParameter { exercise-name : exerciseName }")
	public ResponseEntity<List<ExerciseRecord>> selectExercise(@PathVariable("exerciseName") String exerciseName) {
		int userSeq = 1;
		
		List<ExerciseRecord> data = recordService.selectExercise(userSeq, exerciseName);
		return new ResponseEntity<List<ExerciseRecord>>(data, HttpStatus.OK);
	}
	
	//완료
	//파트에 관해서도 숫자로 구분하는것을 고려
	@GetMapping("/part/{part}")
	@ApiOperation(value = "해당 부위 운동 기록 가져오기", notes = "해당 부위 운동 기록을 모두 가져옵니다.\\nParameter { part : part }")
	public ResponseEntity<List<ExerciseRecord>> selectPart(@PathVariable("part") String part) {
		int userSeq = 1;
		
		List<ExerciseRecord> data = recordService.selectPart(userSeq, part);
		return new ResponseEntity<List<ExerciseRecord>>(data, HttpStatus.OK);
	}
	
	//완료
	//최근 체중관련 변화량 체크
	//10개를 가지고 오도록 설정 상세한 내용은 아직 미정
	@GetMapping("/weight")
	@ApiOperation(value = "해당 부위 운동 기록 가져오기", notes = "")
	public ResponseEntity<List<ExerciseRecord>> selectWeight() {
		int userSeq = 1;
		
		List<ExerciseRecord> data = recordService.selectWeight(userSeq);
		return new ResponseEntity<List<ExerciseRecord>>(data, HttpStatus.OK);
	}
	
	
	
//	@GetMapping("/{commentId}")
//	@ApiOperation(value="댓글 1개 가져오기", notes="댓글 1개를 가져옵니다.")
//	public UserArticleComment getcomment(@PathVariable int commentId) {
//		return commentService.getcomment(commentId);
//	}

	
	//userSeq를 숫자로 넣을건지 문자로 넣을건지 결정 필요
	@PutMapping("/{recordId}/{detailId}")
	@ApiOperation(value = "운동 기록 업데이트", notes = "기존 운동 기록을 업데이트합니다. request로 exerciseRecord의 온전한 객체를 보내줍니다.")
	public ResponseEntity<String> updateComment(@RequestBody ExerciseRecord exerciseRecord, @PathVariable int recordId,  @PathVariable int detailId) {
		int userSeq = 1;
		exerciseRecord.setUserSeq(userSeq);
		
		recordService.updateRecord(exerciseRecord);
		return new ResponseEntity<String>("Update Success", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{recordId}")
	@ApiOperation(value = "운동 기록 삭제", notes = "운동 기록을 삭제합니다.")
	public ResponseEntity<String> deleteAllRecord(@PathVariable int recordId) {
		int userSeq = 1;
		
		recordService.deleteAllRecord(userSeq, recordId);
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{recordId}/{detailId}")
	@ApiOperation(value = "운동 세트 기록 삭제", notes = "운동 세트 기록을 삭제합니다.")
	public ResponseEntity<String> deleteRecord(@PathVariable int detailId) {
		int userSeq = 1;
		
		recordService.deleteRecord(userSeq, detailId);
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
}