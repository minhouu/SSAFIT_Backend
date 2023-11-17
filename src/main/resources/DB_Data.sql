insert into user (id, password, nickname, user_type)
values 
('dlawhdfbf12', 1234, '메카종율', 2), #1
('totor1403', 1234, '고늑최', 2), #2
('pnlkc', 1234, '최지찬', 1), #3
('animus', 1234, '유동건', 1), #4
('kth32105', 1234, '김태훈', 1), #5
('smink95', 1234, '고승민', 1), #6
('hwasuk528', 1234, '오화석', 1), #7
('choyool123', 1234, '조성호', 1), #8
('godsun7892', 1234, '유광우', 1), #9
('weakprotos', 1234, '이승재', 3), #10
('dlawhdfbf12@naver.com', 1234, '메카종율', 1),
('tortor1403@gmail.com', 1234, '고독한늑대최민호', 1);
;

insert into user_article (writer_seq, title, content)
values 
(1, "회원 모집합니다.", "트레이너 메카종율 자세한 내용은 전화로 010xxxxxxx"), #1
(2, "윗집보다 맛있는 집", "트레이너 고늑최 회원 모집합니다. 자세한 내용은 전화로 010xxxxxxx"), #2
(4, "같이 운동하실분", "역삼역 저녁 6시에 XXGYM에서 하실분 두 명 구해요@@@@@!!"), #3
(1, "임종율의 오리아나", "공기 팡~"),
(1, "유광우 닐라", "유광우 찰~싹"),
(1, "고늑최", "레넥밴");

insert into user_article_comment (article_id, writer_seq, content)
values 
(1, 3, "저요저용~!"),
(1, 5, "나도..!"),
(1, 6, "마렵넹..."),
(2, 9, "과아아아앙우 합류한다아아아아"),
(2, 8, "전화를 안받는뎁쇼??"),
(3, 7, "저요저요"),
(3, 6, "같이하자 동건~"),
(1, 1, "개추~!"),
(2, 1, "과아아아앙우"),
(3, 1, "ㄹㅇㅋㅋㅋ");

# 트레이너와 함께 운동한 사람이 아니라면 trainner_seq는 0
# 시간도 다르게 넣을지는 생각 필요(작성당시 무지성)
# 사람을 왜 많이 하고 있는지 까먹음 ㅋㅋㅋ
# 그냥 대규모로 할지 -> 사람을 적게 횟수를 많게 고민중

# 수정필요 -> trainer_seq가 user_seq(1~3)를 fk로 가지고 있는데 0을 넣으면 에러남
INSERT INTO record (user_seq, trainner_seq, body_weight, body_fat_mass, skeletal_muscle_mass)
VALUES
(3, 1, 55, 6.3, 22.8), #1 종율 -> 지찬
(5, 1, 60, 6.1, 26.8), #2 종율 -> 태훈
(6, 1, 70, 9.4, 33.7), #3 종율 -> 승민이형
(9, 2, 68, 10.3, 31.2), #4 민호 -> 광우형
(8, 2, 72, 11.3, 35.8), #5 민호 -> 성호
(7, 0, 40, 8, 35.8), #6 화석 with 똥건이형
(6, 0, 69, 9.1, 33.8) #7 승민이형 with 똥건이형
;

commit;
