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
	title varchar(100),
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
