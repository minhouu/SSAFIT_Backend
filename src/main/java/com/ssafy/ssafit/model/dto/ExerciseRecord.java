package com.ssafy.ssafit.model.dto;

public class ExerciseRecord {
	// record table의 변수
	private int recordId;//운동 기록 id
	private String recordDate;// 운동 일시 (시-분-초까지)// 하루에 두번 하는것을 구분하기 위해서
	private int userSeq;// 회원 no
	private int trainnerSeq;// 트레이너 no
	
	// detail table의 변수	
	private int detailId; // 운동 상세정보 id 한 운동 프로그램의 하나의 세트를 기준으로 저장
	private String exerciseName; // 운동 이름
	private String part; // 운동 부위
	private int setNum; // 세트 번호 (ex) 1~5세트 같은 느낌)
	private int weight;// 운동 볼륨
	private int reps;// 운동 횟수
	
	public ExerciseRecord() {
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getTrainnerSeq() {
		return trainnerSeq;
	}

	public void setTrainnerSeq(int trainnerSeq) {
		this.trainnerSeq = trainnerSeq;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}	
	
	
	
}
