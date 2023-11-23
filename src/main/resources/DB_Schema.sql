DROP DATABASE IF EXISTS	ssafit;
CREATE DATABASE ssafit;
USE ssafit;

CREATE TABLE user(
user_seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(200) NOT NULL,
nickname VARCHAR(100) NOT NULL,
user_type INT NOT NULL CHECK (user_type >= 1 AND user_type <= 3)
)ENGINE = InnoDB;

CREATE TABLE user_article (
	article_id int not null auto_increment primary key,
    writer_seq int not null,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(10000) NOT NULL,
    view_cnt INT DEFAULT 0,
    created_at DATETIME default current_timestamp,
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
    writer_seq INT NOT NULL,
    created_at DATETIME default current_timestamp,
    content varchar(255),
    is_edited INT NOT NULL default 0,
    
    constraint fk_articleId
        foreign key (article_id)
        references user_article (article_id)
        on delete cascade
        on update cascade,
    constraint fk_user_seq
        foreign key (writer_seq)
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
ex_part VARCHAR(100) NOT NULL CHECK (ex_part IN ('leg', 'chest', 'back', 'shoulder', 'arm', 'abs')),
ex_name VARCHAR(100) NOT NULL
);

CREATE INDEX idx_ex_part ON exercise(ex_part);

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
(10, "chest", "pushup"), # 푸쉬업
(11, "back", "row"), # 덤벨, 바벨 로우
(12, "back", "pullup"), # 턱걸이
(13, "back", "letpulldown"), # 렛풀다운
(14, "shoulder", "overheadpress"), # 오버헤드 프레스
(15, "shoulder", "frontraise"), # 프론트레이즈
(16, "shoulder", "sidelateralraise"), # 사이드 레터럴 레이즈
(17, "arm", "armcurl"), # 덤벨 컬 바벨 컬
(18, "arm", "armkickback"), # 덤벨 킥 백
(19, "arm", "tricepsextension"), # 트라이셉 익스텐션
(20, "abs", "situp"), # 윗몸 일으키기
(21, "abs", "crunch"), # 크런치
(22, "abs", "regraise"), # 레그레이즈
(23, "abs", "airbike") # 하늘 자전거
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

CREATE TABLE video(
    video_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    writer_seq INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(10000) NOT NULL,
    part VARCHAR(100) NOT NULL,
    url VARCHAR(200) NOT NULL,
    video_key VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    view_cnt INT DEFAULT 0,
    is_edited INT NOT NULL DEFAULT 0,

    FOREIGN KEY (writer_seq)
        REFERENCES user (user_seq)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (part)
        REFERENCES exercise (ex_part)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE video_review (
    review_id int not null auto_increment primary key,
  	video_id int not null,
    writer_seq INT NOT NULL,
    created_at DATETIME default current_timestamp,
    view_cnt INT DEFAULT 0,
    title varchar(255) NOT NULL,
    content varchar(255) NOT NULL,
    is_edited INT NOT NULL default 0,

	foreign key (video_id)
	references video (video_id)
	on delete cascade
	on update cascade,

	foreign key (writer_seq)
	references user (user_seq)
	on delete cascade
	on update cascade
)ENGINE = InnoDB;

CREATE TABLE JJIM(
user_seq INT NOT NULL,
video_id INT NOT NULL,
PRIMARY KEY (user_seq, video_id),
FOREIGN KEY (user_seq) REFERENCES user(user_seq),
FOREIGN KEY (video_id) REFERENCES video(video_id)
)ENGINE = InnoDB;

commit;



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

