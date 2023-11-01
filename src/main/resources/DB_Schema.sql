CREATE DATABASE ssafit;
USE ssafit;
# 영상정보 데이터 관리
# 1. 
CREATE TABLE video(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
part VARCHAR(100) NOT NULL,
channelName VARCHAR(100) NOT NULL,
url VARCHAR(100) NOT NULL,
created_at DATETIME default NOW(),
view_cnt INT DEFAULT 0
)ENGINE = InnoDB;


CREATE TABLE user(
user_seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL,
nickname VARCHAR(100) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE review (
    reviewId int not null auto_increment primary key,
    videoId int not null,
    user_seq INT NOT NULL,
    created_at DATETIME default NOW(),
    constraint fk_videoId
        foreign key (videoId)
        references video (id)
        on delete cascade
        on update cascade,
    title varchar(100),
    content varchar(255),
    constraint fk_user_seq
        foreign key (user_seq)
        references user (user_seq)
        on delete cascade
        on update cascade
)ENGINE = InnoDB;

CREATE TABLE followers (
    follower_id INT NOT NULL,
    user_seq INT NOT NULL,
    PRIMARY KEY (follower_id, user_seq),
    FOREIGN KEY (follower_id) REFERENCES user(user_seq),
    FOREIGN KEY (user_seq) REFERENCES user(user_seq)
)ENGINE = InnoDB;
	
CREATE TABLE followings (
    user_seq INT NOT NULL UNIQUE,
    following_id INT NOT NULL UNIQUE,
    PRIMARY KEY (user_seq, following_id),
    FOREIGN KEY (user_seq) REFERENCES user(user_seq),
    FOREIGN KEY (following_id) REFERENCES user(user_seq)
)ENGINE = InnoDB;

CREATE TABLE JJIM(
user_seq INT NOT NULL,
video_id INT NOT NULL,
PRIMARY KEY (user_seq, video_id),
FOREIGN KEY (user_seq) REFERENCES user(user_seq),
FOREIGN KEY (video_id) REFERENCES video(id)
)ENGINE = InnoDB;
