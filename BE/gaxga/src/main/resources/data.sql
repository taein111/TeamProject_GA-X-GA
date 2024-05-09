-- 가보자고 지역 테이블 더미 데이터
INSERT INTO GR(NAME)VALUES('강원');
INSERT INTO GR(NAME)VALUES('경기');
INSERT INTO GR(NAME)VALUES('경남');
INSERT INTO GR(NAME)VALUES('경북');
INSERT INTO GR(NAME)VALUES('광주');
INSERT INTO GR(NAME)VALUES('대구');
INSERT INTO GR(NAME)VALUES('대전');
INSERT INTO GR(NAME)VALUES('부산');
INSERT INTO GR(NAME)VALUES('서울');
INSERT INTO GR(NAME)VALUES('세종');
INSERT INTO GR(NAME)VALUES('울산');
INSERT INTO GR(NAME)VALUES('인천');
INSERT INTO GR(NAME)VALUES('전남');
INSERT INTO GR(NAME)VALUES('전북');
INSERT INTO GR(NAME)VALUES('제주');
INSERT INTO GR(NAME)VALUES('충남');
INSERT INTO GR(NAME)VALUES('충북');
-- 가보자고 테마 테이블 더미 데이터
INSERT INTO GT(NAME)VALUES('산');
INSERT INTO GT(NAME)VALUES('시장');
INSERT INTO GT(NAME)VALUES('테마파크');
INSERT INTO GT(NAME)VALUES('카페');
INSERT INTO GT(NAME)VALUES('문화');
-- 가보자고 지역 테마 연결 더미 데이터
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,3,'BTS-버스정류장','img/loc/강원/강원-BTS버스정류장.jpg', '강원도', '강원도 너무 좋아요~', 0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,2,'갈미조개', 'img/loc/강원/강원-갈미조개.jpg', '강원도', '갈미조개 너무 맛있어요~', 0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'검룡소', 'img/loc/강원/강원-검룡소.jpg', '강원도', '검룡소 경치가 죽여줘욧~', 0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,4,'꽃게집', 'img/loc/강원/강원-꽃게집.jpg', '강원도', '인생 맛집 꽃게집~', 0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,1,'설악산', 'img/loc/강원/강원-설악산.jpg', '강원도', '역시 설악산은~ 굿굿', 0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,3,'소양강스카이워크','img/loc/강원/강원-소양강스카이워크.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'아르떼뮤지엄','img/loc/강원/강원-아르떼뮤지엄.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'아바이마을','img/loc/강원/강원-아바이마을.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,2,'양양전통시장','img/loc/강원/강원-양양전통시장.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,2,'중앙시장','img/loc/강원/강원-중앙시장.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,3,'지지리골 자작나무숲','img/loc/강원/강원-지지리골 자작나무숲.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'직탕폭포','img/loc/강원/강원-직탕폭포.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'평창동계올림픽기념관','img/loc/강원/강원-평창동계올림픽기념관.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(1,5,'황지연못','img/loc/강원/강원-황지연못.jpg','강원도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(2,1,'감악산','img/loc/경기/경기-감악산.jpg','경기도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(2,2,'제일시장','img/loc/경기/경기-제일시장.jpg','경기도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(2,4,'카페 숨','img/loc/경기/경기-카페숨.jpg','경기도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(2,5,'한국민속촌','img/loc/경기/경기-한국민속촌.jpg','경기도','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(2,2,'경남시장','img/loc/경기/경기-경남시장.jpg','경기도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(3,5,'경남문화','img/loc/경남/경남문화.jpg','경상남도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(3,2,'경남시장','img/loc/경남/경남시장.jpg','경상남도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(3,4,'경남카페','img/loc/경남/경남카페.jpg','경상남도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(3,3,'경남테마','img/loc/경남/경남테마.jpg','경상남도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(3,1,'경남산','img/loc/경남/산 또는 바다.jpg','경상남도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(4,5,'경북문화','img/loc/경북/경북문화.jpg','경상북도','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(5,2,'서문시장','img/loc/대구/대구-서문시장.jpg','대구','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(5,5,'성당못','img/loc/대구/대구-성당못.jpg','대구','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(5,3,'이월드','img/loc/대구/대구-이월드.jpg','대구','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(5,1,'앞산','img/loc/대구/대구-앞산.jpg','대구','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(5,4,'포켓','img/loc/대구/대구-포켓.jpg','대구','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(6,1,'구봉산','img/loc/대전/대전-구봉산.jpg','대전','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(6,4,'두두당','img/loc/대전/대전-두두당.jpg','대전','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(6,5,'둔산선사','img/loc/대전/대전-둔산선사.jpg','대전','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(6,3,'오월드','img/loc/대전/대전-오월드.jpg','대전','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(6,2,'태평시장','img/loc/대전/대전-태평시장.jpg','대전','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(7,1,'하조대산','img/loc/부산/부산-하조대산.jpg','부산_산','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(7,2,'포장마차거리','img/loc/부산/부산-포장마차거리.jpg','부산_시장','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(7,3,'천문대','img/loc/부산/부산-천문대(테마파크).jpg','부산_테마파크','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(7,4,'블랙업커피','img/loc/부산/부산-블랙업커피.jpg','부산_카페','텍스트 영역',0);
INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(7,5,'죽도정','img/loc/부산/부산-죽도정.jpg','부산_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(9,1,'','img/loc/','서울_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(9,2,'','img/loc/','서울_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(9,3,'','img/loc/','서울_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(9,4,'','img/loc/','서울_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(9,5,'','img/loc/','서울_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(10,1,'img/loc/','세종_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(10,2,'img/loc/','세종_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(10,3,'img/loc/','세종_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(10,4,'img/loc/','세종_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(10,5,'img/loc/','세종_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(11,1,'img/loc/','울산_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(11,2,'img/loc/','울산_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(11,3,'img/loc/','울산_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(11,4,'img/loc/','울산_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(11,5,'img/loc/','울산_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(12,1,'img/loc/','인천_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(12,2,'img/loc/','인천_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(12,3,'img/loc/','인천_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(12,4,'img/loc/','인천_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(12,5,'img/loc/','인천_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(13,1,'img/loc/','전남_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(13,2,'img/loc/','전남_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(13,3,'img/loc/','전남_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(13,4,'img/loc/','전남_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(13,5,'img/loc/','전남_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(14,1,'img/loc/','전북_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(14,2,'img/loc/','전북_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(14,3,'img/loc/','전북_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(14,4,'img/loc/','전북_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(14,5,'img/loc/','전북_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(15,1,'img/loc/','제주_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(15,2,'img/loc/','제주_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(15,3,'img/loc/','제주_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(15,4,'img/loc/','제주_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(15,5,'img/loc/','제주_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(16,1,'img/loc/','충남_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(16,2,'img/loc/','충남_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(16,3,'img/loc/','충남_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(16,4,'img/loc/','충남_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(16,5,'img/loc/','충남_문화','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(17,1,'img/loc/','충북_산','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(17,2,'img/loc/','충북_시장','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(17,3,'img/loc/','충북_테마파크','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(17,4,'img/loc/','충북_카페','텍스트 영역',0);
-- INSERT INTO GP(GRID, GTID, NAME, IMG, STATE, TEXT, JJIMCOUNT)VALUES(17,5,'img/loc/','충북_문화','텍스트 영역',0);

-- 가봤다고 후기 게시판 더미데이터
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기1','서울','산','img/loc/강원/강원-설악산.jpg','1번후기게시글','서울시','서울시 강남구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기2','경기','시장','img/loc/강원/강원-설악산.jpg','2번후기게시글','경기','안산시 상록구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기3','인천','테마파크','img/loc/강원/강원-돼통령.jpg','3번후기게시글','인천','인천 연수구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기4','강원','카페','img/loc/강원/강원-돼통령.jpg','4번후기게시글','인천','인천 연수구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기5','경북','문화','img/loc/강원/강원-돼통령.jpg','5번후기게시글','인천','인천 연수구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기6','광주','산','img/loc/강원/강원-돼통령.jpg','6번후기게시글','인천','인천 연수구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기7','대구','시장','img/loc/강원/강원-돼통령.jpg','7번후기게시글','인천','인천 연수구');
INSERT INTO GABOWATDAGO(title, local, thema, image, content, address, de_address)
VALUES('후기8','부산','테마파크','img/loc/강원/강원-돼통령.jpg','8번후기게시글','인천','인천 연수구');
-- 가봤다고 후기 게시판 댓글 더미데이터
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(1,'KIM', '후기 너무 좋아요');
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(1,'JANG', '가보고싶어요');
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(2,'KIM', '후기 너무 좋아요2');
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(2,'JANG', '가보고싶어요2');
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(3,'KIM', '후기 너무 좋아요3');
INSERT INTO CMT(gabowatdago_id, nickname, body)VALUES(3,'JANG', '가보고싶어요3');