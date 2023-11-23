package com.ssafy.ssafit.model.dto;

public class ExerciseDetail {
	
	// detail table의 변수	
	private int recordId;
	private int detailId; // 운동 상세정보 id 한 운동 프로그램의 하나의 세트를 기준으로 저장
	private int exId;// 운동 아이디
	private String exName; // 운동 이름
	private String exPart; // 운동 부위
	private int setNum; // 세트 번호 (ex) 1~5세트 같은 느낌)
	private float weight;// 운동 볼륨
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
	
	public int getExId() {
		return exId;
	}

	public void setExId(int exId) {
		this.exId = exId;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getExPart() {
		return exPart;
	}

	public void setExPart(String exPart) {
		this.exPart = exPart;
	}

	public int getSetNum() {
		return setNum;
	}
	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
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
		return "ExerciseDetail [recordId=" + recordId + ", detailId=" + detailId + ", exId=" + exId + ", exName="
				+ exName + ", exPart=" + exPart + ", setNum=" + setNum + ", weight=" + weight + ", reps=" + reps + "]";
	}

}
