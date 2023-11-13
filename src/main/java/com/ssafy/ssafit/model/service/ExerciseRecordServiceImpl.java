package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseRecordDao;
import com.ssafy.ssafit.model.dao.UserArticleCommentDao;
import com.ssafy.ssafit.model.dto.ExerciseRecord;
import com.ssafy.ssafit.model.dto.UserArticleComment;

@Service
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
	
	@Autowired
	private ExerciseRecordDao recordDao;
	
	@Override
	public void addRecord(ExerciseRecord exerciseRecord) {
		
		recordDao.insertRecord(exerciseRecord);
	}

	@Override
	public List<ExerciseRecord> selectExercise(String exerciseName) {
		
		return recordDao.selectExercise(exerciseName);
	}

	@Override
	public List<ExerciseRecord> selectPart(String part) {
		
		return recordDao.selectPart(part);
	}

	@Override
	public void updateRecord(ExerciseRecord exerciseRecord) {
		
		recordDao.updateRecord(exerciseRecord);
	}

	@Override
	public void deleteAllRecord(int recordtId) {
		
		recordDao.deleteAllRecord(recordtId);
	}

	@Override
	public void deleteRecord(int detailId) {
		
		recordDao.deleteRecord(detailId);
	}

}
