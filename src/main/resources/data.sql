INSERT INTO article(id, title, content) VALUES(1, '김동규', '삼성전자 DX 사업부');
INSERT INTO article(id, title, content) VALUES(2, '이솔비', '백석예술대학교');
INSERT INTO article(id, title, content) VALUES(3, '김동휘', '토스 뱅크 개발부');
INSERT INTO article(id, title, content) VALUES(4, '유더미', '한성대학교');

-- article 더미 데이터

INSERT INTO article(id, title, content) VALUES(5, '당신의 인생영화', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES(6, '당신의 인생음식', '댓긁ㄱ');
INSERT INTO article(id, title, content) VALUES(7, '당신의 취미', '댓긁ㄱㄱ');

---- comment 더미 데이터
---- 4번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 5, '이순신', '해리포터');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 5, '이 도', '기생충');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 5, '장영실', '최애의 아이');

---- 5번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 6, '이순신', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 6, '이 도', '피자');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 6, '장영실', '나시고랭');

---- 6번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 7, '이순신', '조깅');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 7, '이 도', '유튜브');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 7, '장영실', '축구');