/* 테이블명 : board
 *	컬럼 :
 * 게시글 번호 : idx, 숫자, pk, 자동으로 1 증가
 * 제목 : title, 문자, not null
 * 작성자 : writer, 문자, not null
 * 작성일 : indate ,날짜, 기본값으로 오늘 날짜
 * 내용 : content, 문자, not null 
 */
CREATE TABLE BOARD(
	IDX INT AUTO_INCREMENT,
	TITLE VARCHAR(100) NOT NULL,
	WRITER VARCHAR(100) NOT NULL,
	CONTENT VARCHAR(2000) NOT NULL,
	INDATE DATETIME DEFAULT NOW(),
	PRIMARY KEY(IDX)
);
SELECT * FROM BOARD;

INSERT INTO BOARD(TITLE, WRITER,CONTENT)
VALUE("오늘 저녁 뭐먹지", "이도현", "냉삼먹어야쥐");
INSERT INTO BOARD(TITLE, WRITER,CONTENT)
VALUE("내 퍼스널 컬러는 그린", "이도현", "그린그린해");
INSERT INTO BOARD(TITLE, WRITER,CONTENT)
VALUE("나도 맥북 써야쥐", "조인혁", "JAVA때는 사용안한 맥북 사왔다");
INSERT INTO BOARD(TITLE, WRITER,CONTENT)
VALUE("야호 스프링 너무 재밌다", "황진우", "스프링이 제일 재밌어~");
INSERT INTO BOARD(TITLE, WRITER,CONTENT)
VALUE("스프링 식은죽먹기자나", "차주한", "완전 럭키비키자나");


 