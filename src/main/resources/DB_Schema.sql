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

CREATE TABLE detail(
detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
record_id INT NOT NULL,
exercise_name VARCHAR(200),
part VARCHAR(200),
set_num INT NOT NULL,
weight INT NOT NULL,
reps INT NOT NULL,
FOREIGN KEY (record_id) REFERENCES record(record_id)
);

commit;