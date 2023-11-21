# SSAFIT_Backend
싸피 관통프로젝트 SSAFIT 벡엔드 레포지토리입니다

# 프로젝트 소개
운동 정보 공유 및 기록관리 웹서비스 SSAFIT의 벡엔드 파트

# 개발 기간
23-11-15 ~ 23-11-24

# 개발 환경
JAVA 8
Spring 2.7 (with MyBatis)
MySql

# WITH
@[Jong-Youl](https://github.com/Jong-Youl)

# Features
1. User 관리 기능
   * JWT(only with access token)를 통한 로그인 컨트롤 
   * user CRUD

2. 게시판 기능
   * article, comment CRUD
   * Pagination with offset

3. 비디오 게시판 기능
   * 유튜브에 영상을 올리고, 해당 영상 링크를 통해 video 게시글 생성 가능
   * Video CRUD
   * 영상마다 videoReview(similar to article) CRUD
   * Pagination with offset

4. 운동 기록 기능
   * 운동 종류,.무게, reps 기록
   * 운동 종류별, 분류별(가슴, 등, 하체 등)로 최근 기록 조회
   * 신체데이터 변화 추이 확인
  
