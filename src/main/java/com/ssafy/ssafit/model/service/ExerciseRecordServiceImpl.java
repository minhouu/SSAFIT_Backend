package com.ssafy.ssafit.model.service;

import java.util.List;

import javax.xml.soap.Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseRecordDao;
import com.ssafy.ssafit.model.dao.UserArticleCommentDao;
import com.ssafy.ssafit.model.dto.ExerciseDetail;
import com.ssafy.ssafit.model.dto.ExerciseRecord;
import com.ssafy.ssafit.model.dto.UserArticleComment;

@Service
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
	
	@Autowired
	private ExerciseRecordDao recordDao;
	
	@Override
	public void addRecord(String userSeq, ExerciseRecord exerciseRecord) {
		// exerciseRecord (id x)
		exerciseRecord.setUserSeq(Integer.parseInt(userSeq));
		recordDao.insertRecord(exerciseRecord); // 
		// exerciseRecord (id o)
		
		List<ExerciseDetail> details = exerciseRecord.getDetails();
		for(ExerciseDetail detail : details) {
			detail.setRecordId(""+exerciseRecord.getRecordId());
			recordDao.insertDetail(detail);
		}
		// 아직 insertDetail(exerciseRecord);
		
	}

	@Override
	public List<ExerciseRecord> selectExercise(String userSeq, String exerciseName) {
		
		return recordDao.selectExercise(userSeq, exerciseName);
	}

	@Override
	public List<ExerciseRecord> selectPart(String userSeq, String part) {
		
		return recordDao.selectPart(userSeq, part);
	}

	@Override
	public void updateRecord(String userSeq, ExerciseRecord exerciseRecord) {
		
		recordDao.updateRecord(userSeq, exerciseRecord);
	}

	@Override
	public void deleteAllRecord(String userSeq, int recordtId) {
		
		recordDao.deleteAllRecord(userSeq, recordtId);	
	}

	@Override
	public void deleteRecord(String userSeq, int detailId) {
		
		recordDao.deleteRecord(userSeq, detailId);
	}

}
