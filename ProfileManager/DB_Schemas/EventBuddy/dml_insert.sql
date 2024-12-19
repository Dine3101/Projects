--connect to database EVENTBUDDY_DB
\c eventbuddy_db


--insert data into table ROLE
INSERT INTO ROLE VALUES
(1,'EVENTBUDDY_ADMIN'),
(2,'EVENTBUDDY_VIEWER'),
(3,'EVENTBUDDY_MOVIE_DISTRIBUTOR'),
(4,'EVENTBUDDY_THEATRE_OWNER');


--insert data into table APPUSER
INSERT INTO APPUSER(EMAIL_ID,NAME,PHONE_NUMBER,ROLE_ID) VALUES
('ram@eventbuddy-qa.com','RAM','1234567890',1),
('krish@eventbuddy-qa.com','KRISH','0123456789',1),
('sri@eventbuddy-qa.com','SRI','9012345678',1);


--insert data into table MOVIE
INSERT INTO MOVIE(MOVIE_NAME,LANGUAGE,THEME,DISTRIBUTOR_ID) VALUES
('FRIENDS','ENGLISH','COMEDY','ram@eventbuddy-qa.com'),
('MISSION IMPOSSIBLE','ENGLISH','ACTION','krish@eventbuddy-qa.com');


--insert data into table THEATRE
INSERT INTO THEATRE(NAME,LOCATION,OWNER_ID) VALUES
('TAMILJAYA','MADURAI','sri@eventbuddy-qa.com'),
('INOX','CHENNAI','ram@eventbuddy-qa.com');


--insert data into table WATCHLIST
INSERT INTO WATCHLIST(MOVIE_NAME,VIEWER_ID) VALUES
('MISSION IMPOSSIBLE','sri@eventbuddy-qa.com'),
('MISSION IMPOSSIBLE','ram@eventbuddy-qa.com'),
('FRIENDS','krish@eventbuddy-qa.com');


--insert data into table SCREEN
INSERT INTO SCREEN(SCREEN_NAME,SEAT_COUNT,THEATRE_ID,MOVIE_NAME) VALUES
('SCREEN-1',100,1,'FRIENDS'),
('SCREEN-1',20,2,'FRIENDS'),
('SCREEN-2',100,1,'MISSION IMPOSSIBLE');


--insert data into table SESSION
INSERT INTO SESSION(SEAT_COUNT,START_TIME,END_TIME,SCREEN_ID) VALUES
(30,'2024-12-20 05:30:00','2024-12-20 07:30:00',1),
(5,'2024-12-21 07:10:00','2024-12-21 08:30:00',2),
(52,'2024-12-20 08:10:00','2024-12-20 10:20:00',3);


--insert data into table TICKET
