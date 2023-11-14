insert into user (id, password, nickname, user_type)
values 
('dlawhdfbf12@naver.com', 1234, '메카종율', 1),
('tortor1403@gmail.com', 1234, '고독한늑대최민호', 1);


insert into user_article (writer_seq, title, content)
values 
(1, "임종율의 오리아나", "공기 팡~"),
(1, "유광우 닐라", "유광우 찰~싹"),
(1, "고늑최", "레넥밴")
;

insert into user_article_comment (article_id, user_seq, title, content)
values 
(1, 1, "zzzz", "개추~!"),
(2, 1, "논란이 있겠는걸?", "과아아아앙우"),
(3, 1, "ㄹㅇㅋㅋㅋ", "접어라")
;

select * from user;
select * from user_article;
