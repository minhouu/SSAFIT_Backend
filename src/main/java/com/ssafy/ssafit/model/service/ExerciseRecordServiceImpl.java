package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseRecordDao;
import com.ssafy.ssafit.model.dto.ExerciseDetail;
import com.ssafy.ssafit.model.dto.ExerciseRecord;
import com.ssafy.ssafit.model.dto.User;

@Service
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
	
	@Autowired
	private ExerciseRecordDao recordDao;
	
	//완료 손대지마셈
	@Override
	public void addRecord(ExerciseRecord exerciseRecord) {
		// record Table에 넣기
		recordDao.insertRecord(exerciseRecord); // 
		
		//넣은 record의 id 받아오기
		int userSeq = exerciseRecord.getUserSeq();
		int recordId = recordDao.selectRecordId(userSeq);
		// detail Table에 넣기
		List<ExerciseDetail> details = exerciseRecord.getDetails();
		
		System.out.println(exerciseRecord.toString());
		
		for(ExerciseDetail detail : details) {
			detail.setRecordId(recordId);
			recordDao.insertDetail(detail);
		}	
	}
	
	@Override
	public List<ExerciseRecord> selectAll(int userSeq){
		
		return recordDao.selectAll(userSeq);
	};
	
	@Override
	public List<ExerciseRecord> selectExercise(int userSeq, int exId) {
		
		return recordDao.selectExercise(userSeq, exId);
	}

	@Override
	public List<ExerciseRecord> selectPart(int userSeq, String exPart) {
		
		return recordDao.selectPart(userSeq, exPart);
	}

	
	
	@Override
	public List<ExerciseRecord> selectWeight(int userSeq) {
		
		return recordDao.selectWeight(userSeq);
	}
	
	@Override
	public void updateRecord(ExerciseRecord exerciseRecord) {
		
		recordDao.updateRecord(exerciseRecord);
	}

	@Override
	public void deleteAllRecord(int userSeq, int recordtId) {
		
		recordDao.deleteAllRecord(userSeq, recordtId);	
	}

	@Override
	public void deleteRecord(int userSeq, int detailId) {
		
		recordDao.deleteRecord(userSeq, detailId);
	}

	@Override
	public List<User> selectTrainner() {
		// TODO Auto-generated method stub
		return recordDao.selectTrainner();
	}



}
