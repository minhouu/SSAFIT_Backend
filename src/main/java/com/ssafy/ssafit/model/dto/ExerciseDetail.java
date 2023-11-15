package com.ssafy.ssafit.model.dto;

public class ExerciseDetail {
	
	// detail table의 변수	
	private int recordId;
	private int detailId; // 운동 상세정보 id 한 운동 프로그램의 하나의 세트를 기준으로 저장
	private String exerciseName; // 운동 이름
	private String part; // 운동 부위
	private int setNum; // 세트 번호 (ex) 1~5세트 같은 느낌)
	private int weight;// 운동 볼륨
	private int reps;// 운동 횟수	
	
	public ExerciseDetail() {
	}
	
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
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

	@Override
	public String toString() {
		return "ExerciseDetail [recordId=" + recordId + ", detailId=" + detailId + ", exerciseName=" + exerciseName
				+ ", part=" + part + ", setNum=" + setNum + ", weight=" + weight + ", reps=" + reps + "]";
	}



}
