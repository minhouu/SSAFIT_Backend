package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.ExerciseDetail;
import com.ssafy.ssafit.model.dto.ExerciseRecord;
import com.ssafy.ssafit.model.dto.User;

public interface ExerciseRecordDao {

	//운동 기록 주 동작
	// 1. 운동 기록 추가
	// 1.1 운동 사이클 생성
	void insertRecord(ExerciseRecord exerciseRecord);
	
	// 1.2 사이클 내의 세트 생성 
	void insertDetail(ExerciseDetail detail);
	
	// 2 모든 운동 기록 가져오기 몇 개 가져올지는 아직 미정
	List<ExerciseRecord> selectAll(int userSeq);
	// 2.1 운동 기록 조회 총 세션과 최근 10개 세션, 운동 추이
	List<ExerciseRecord> selectExercise(int userSeq, int exId);
	// 2.2 운동 종목을 조건으로 주는 조회
	List<ExerciseRecord> selectPart(int userSeq, String exPart);
	// 2.3 사용자의 체중 변화량을 조회
	List<ExerciseRecord> selectWeight(int userSeq);
	// 2.4 트레이너의 이름을 조회
	List<User> selectTrainner();
	
	// recordId를 조회
	int selectRecordId(int userSeq);
	
	// 3. 운동 기록 수정
	void updateRecord(ExerciseRecord exerciseRecord);
	
	// 4. 운동 기록 삭제 
	// 4.1 전체 삭제
	void deleteAllRecord(int userSeq, int recordId);
	
	// 4.2 상세 운동 삭제
	void deleteRecord(int userSeq, int detailId);

	
	
}
