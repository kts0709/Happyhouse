CREATE TABLE `HouseDeal` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `AptName` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `dealAmount` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `buildYear` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dealYear` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dealMonth` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dealDay` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `area` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `floor` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `jibun` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rentMoney` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=131350 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `MEMBER` (
  `memberid` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `membername` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `memberphone` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `memberage` int NOT NULL,
  `memberpswd` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Notice` (
  `noticeno` int NOT NULL AUTO_INCREMENT,
  `memberid` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `subject` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noticeno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `qna_board` (
  `qna_no` int NOT NULL AUTO_INCREMENT COMMENT '질문번호',
  `qna_title` varchar(300) COLLATE utf8mb4_general_ci NOT NULL COMMENT '질문제목',
  `qna_content` varchar(4000) COLLATE utf8mb4_general_ci NOT NULL COMMENT '질문내용',
  `qna_userid` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '질문자아이디',
  `qna_datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '질문일시',
  `reply_content` varchar(4000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '답변내용',
  `reply_datetime` timestamp NULL DEFAULT NULL COMMENT '답변일시',
  `reply_userid` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '답변자아이디',
  PRIMARY KEY (`qna_no`),
  KEY `qna_to_user_fk1` (`qna_userid`),
  KEY `qna_to_user_fk2` (`reply_userid`),
  CONSTRAINT `qna_to_user_fk1` FOREIGN KEY (`qna_userid`) REFERENCES `member` (`memberid`),
  CONSTRAINT `qna_to_user_fk2` FOREIGN KEY (`reply_userid`) REFERENCES `member` (`memberid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='질문게시판';


CREATE TABLE `school` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rate` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ispublic` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=560 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;