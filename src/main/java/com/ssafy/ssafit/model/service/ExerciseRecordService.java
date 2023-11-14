package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.ExerciseRecord;

public interface ExerciseRecordService {

	// 1. 운동 기록 추가
	void addRecord(String userSeq, ExerciseRecord exerciseRecord);
	
	// 2. 운동 기록 조회 총 세션과 최근 10개 세션, 운동 추이
	List<ExerciseRecord> selectExercise(String userSeq, String exerciseName);
	// 2.1 운동 종목을 조건으로 주는 조회
	List<ExerciseRecord> selectPart(String userSeq, String part);
	
	// 2.2 운동 부위를 조건으로 주는 조회 
	// 아직
	// 3. 운동 기록 수정
	void updateRecord(String userSeq, ExerciseRecord exerciseRecord);
	
	// 4.1 전체 삭제
	void deleteAllRecord(String userSeq, int recordtId);
		
	// 4.2 상세 운동 삭제
	void deleteRecord(String userSeq, int detailId);
}
