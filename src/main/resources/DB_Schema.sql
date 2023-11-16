DROP DATABASE IF EXISTS	ssafit;
CREATE DATABASE ssafit;
USE ssafit;

CREATE TABLE user(
user_seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL,
nickname VARCHAR(100) NOT NULL,
user_type INT NOT NULL CHECK (user_type >= 1 AND user_type <= 3)
)ENGINE = InnoDB;

CREATE TABLE user_article (
	article_id int not null auto_increment primary key,
    writer_seq int not null,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(10000) NOT NULL,
    view_cnt INT DEFAULT 0,
    created_at DATETIME default current_timestamp ON UPDATE current_timestamp,
    is_edited INT NOT NULL default 0,
    
    constraint fk_writer_seq
        foreign key (writer_seq)
        references user (user_seq)
        on delete cascade
        on update cascade
)ENGINE = InnoDB;

CREATE TABLE user_article_comment (
    comment_id int not null auto_increment primary key,
	article_id int not null,
    user_seq INT NOT NULL,
    created_at DATETIME default current_timestamp ON UPDATE current_timestamp,
    content varchar(255),
    is_edited INT NOT NULL default 0,
    
    constraint fk_articleId
        foreign key (article_id)
        references user_article (article_id)
        on delete cascade
        on update cascade,
    constraint fk_user_seq
        foreign key (user_seq)
        references user (user_seq)
        on delete cascade
        on update cascade
)ENGINE = InnoDB;

CREATE TABLE record(
record_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
record_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
user_seq INT NOT NULL,
trainner_seq INT NOT NULL,
body_weight float NOT NULL,
body_fat_mass float NOT NULL,
skeletal_muscle_mass float NOT NULL,
FOREIGN KEY (user_seq) REFERENCES user(user_seq),
FOREIGN KEY (trainner_seq) REFERENCES user(user_seq)
);

CREATE TABLE exercise(
ex_id INT NOT NULL UNIQUE PRIMARY KEY,
ex_part VARCHAR(100) NOT NULL,
ex_name VARCHAR(100) NOT NULL
);

# 하체 가승 등 어깨 팔 복근 유산소 순서
# 미리 넣어야 하는 데이터임
INSERT INTO exercise (ex_id, ex_part, ex_name)
VALUES
(1, "leg", "squat"), # 스쿼트 (백, 프론트, 케틀벨, 덤벨 등등)
(2, "leg", "jumpsquat"), # 점프 스쿼트
(3, "leg", "deadlift"), # 데드리프트 (스모, 컨벤)
(4, "leg", "legpress"),
(5, "leg", "lunge"), # 맨몸 런지
(6, "leg", "legcurl"), # 레그 컬
(7, "leg", "legextension"), # 레그 익스텐션
(8, "chest", "benchpress"), # 인클라인 포함, 덤벨, 바벨 통합
(9, "chest", "dips"), # 딥스
(11, "chest", "pushup"), # 푸쉬업
(12, "back", "row"), # 덤벨, 바벨 로우
(13, "back", "pullup"), # 턱걸이
(14, "back", "letpulldown"), # 렛풀다운
(15, "shoulder", "overheadpress"), # 렛풀다운
(16, "shoulder", "frontraise"), # 프론트레이즈
(17, "shoulder", "sidelateralraise"), # 사이드 레터럴 레이즈
(18, "arm", "armcurl"), # 덤벨 컬 바벨 컬
(19, "arm", "armkickback"), # 덤벨 킥 백
(20, "arm", "tricepsextension"), # 트라이셉 익스텐션
(21, "abs", "situp"), # 윗몸 일으키기
(22, "abs", "crunch"), # 크런치
(23, "abs", "regraise"), # 레그레이즈
(24, "abs", "airbike"), # 하늘 자전거
(25, "cardio", "cardio") # 모든 유산소 운동
;


CREATE TABLE detail(
detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
record_id INT NOT NULL,
ex_id int NOT NULL,
set_num INT NOT NULL,
weight INT NOT NULL,
reps INT NOT NULL,
FOREIGN KEY (ex_id) REFERENCES exercise(ex_id),
FOREIGN KEY (record_id) REFERENCES record(record_id)
);

commit;



-- CREATE TABLE video(
-- id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- title VARCHAR(100) NOT NULL,
-- part VARCHAR(100) NOT NULL,
-- channel_name VARCHAR(100) NOT NULL,
-- url VARCHAR(100) NOT NULL,
-- created_at DATETIME default NOW(),
-- view_cnt INT DEFAULT 0
-- )ENGINE = InnoDB;

-- CREATE TABLE followers (
--     follower_id INT NOT NULL,
--     user_seq INT NOT NULL,
--     PRIMARY KEY (follower_id, user_seq),
--     FOREIGN KEY (follower_id) REFERENCES user(user_seq),
--     FOREIGN KEY (user_seq) REFERENCES user(user_seq)
-- )ENGINE = InnoDB;
-- 	
-- CREATE TABLE followings (
--     user_seq INT NOT NULL UNIQUE,
--     following_id INT NOT NULL UNIQUE,
--     PRIMARY KEY (user_seq, following_id),
--     FOREIGN KEY (user_seq) REFERENCES user(user_seq),
--     FOREIGN KEY (following_id) REFERENCES user(user_seq)
-- )ENGINE = InnoDB;

-- CREATE TABLE JJIM(
-- user_seq INT NOT NULL,
-- article_id INT NOT NULL,
-- PRIMARY KEY (user_seq, article_id),
-- FOREIGN KEY (user_seq) REFERENCES user(user_seq),
-- FOREIGN KEY (article_id) REFERENCES article(id)
-- )ENGINE = InnoDB;