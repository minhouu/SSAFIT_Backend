package com.ssafy.ssafit.model.dto;

import java.util.List;

public class ExerciseRecord {
	// record table의 변수
	private int recordId;//운동 기록 id
	private String recordDate;// 운동 일시 (시-분-초까지)// 하루에 두번 하는것을 구분하기 위해서
	private int userSeq;// 회원 no
	private int trainnerSeq;// 트레이너 no
	private float bodyWeight;//몸무게
	private float bodyFatMass;//체지방량
	private float skeletalMuscleMass;//골격근량	
	
	private List<ExerciseDetail> details;
	
	// detail table의 변수
	private int detailId; // 운동 상세정보 id 한 운동 프로그램의 하나의 세트를 기준으로 저장
	private int exId;// 운동 아이디
	private String exName; // 운동 이름
	private String exPart; // 운동 부위
	private int setNum; // 세트 번호 (ex) 1~5세트 같은 느낌)
	private int weight;// 운동 볼륨
	private int reps;// 운동 횟수	
	
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

	public ExerciseRecord() {
	}

	public float getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(float bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public float getBodyFatMass() {
		return bodyFatMass;
	}

	public void setBodyFatMass(float bodyFatMass) {
		this.bodyFatMass = bodyFatMass;
	}

	public float getSkeletalMuscleMass() {
		return skeletalMuscleMass;
	}

	public void setSkeletalMuscleMass(float skeletalMuscleMass) {
		this.skeletalMuscleMass = skeletalMuscleMass;
	}


	public List<ExerciseDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ExerciseDetail> details) {
		this.details = details;
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

	@Override
	public String toString() {
		return "ExerciseRecord [recordId=" + recordId + ", recordDate=" + recordDate + ", userSeq=" + userSeq
				+ ", trainnerSeq=" + trainnerSeq + ", bodyWeight=" + bodyWeight + ", bodyFatMass=" + bodyFatMass
				+ ", skeletalMuscleMass=" + skeletalMuscleMass + ", details=" + details + ", detailId=" + detailId
				+ ", exId=" + exId + ", exName=" + exName + ", exPart=" + exPart + ", setNum=" + setNum + ", weight="
				+ weight + ", reps=" + reps + "]";
	}

}
