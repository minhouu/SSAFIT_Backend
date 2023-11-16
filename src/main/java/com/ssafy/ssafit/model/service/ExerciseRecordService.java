package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.ExerciseRecord;

public interface ExerciseRecordService {

	// 1. 운동 기록 추가
	void addRecord(ExerciseRecord exerciseRecord);
	
	// 2. 운동 기록 조회
	List<ExerciseRecord> selectAll(int userSeq);
	// 2.1 운동 종목을 조건으로  최근 10개 세션을 주는 조회
	List<ExerciseRecord> selectExercise(int userSeq, int exId);
	// 2.2 운동 부위를 조건으로 주는 조회 
	List<ExerciseRecord> selectPart(int userSeq, String exPart);
	// 2.3 회원 신체 정보 조회
	List<ExerciseRecord> selectWeight(int userSeq);
	// 아직
	// 3. 운동 기록 수정
	void updateRecord(ExerciseRecord exerciseRecord);
	
	// 4.1 전체 삭제
	void deleteAllRecord(int userSeq, int recordtId);
		
	// 4.2 상세 운동 삭제
	void deleteRecord(int userSeq, int detailId);
}
