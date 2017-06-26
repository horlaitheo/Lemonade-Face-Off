------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------

INSERT INTO map VALUES
	(0,0,NULL,40,55,112,120); 

INSERT INTO player VALUES
	('Toto','',10000,0),
	('Paul','',10000,0),
	('Henry','',10000,0); 

INSERT INTO access VALUES
	('limonade','Toto'),
	('limonade','Paul'),
	('limonade','Henry'),
	('mojito','Toto');

INSERT INTO production VALUES
	(0,20,5.3,'Toto','limonade'),
	(0,5,8.5,'Toto','mojito'),
	(0,15,6,'Paul','limonade'),
	(0,33,13.2,'Henry','limonade'),
	
	(1,12,3.5,'Toto','limonade'),
	(1,9,9.5,'Toto','mojito'),
	(1,10,8,'Paul','limonade'),
	(1,20,10.2,'Henry','limonade');

INSERT INTO sale VALUES
	(0,10,12,'Toto','limonade'),
	(0,9,5,'Paul','limonade'),
	(0,7,3,'Henry','limonade');

INSERT INTO map_item VALUES
	(0,'stand',10,0,0,'Toto',0),
	(1,'stand',10,10,10,'Paul',0),
	(2,'stand',10,5,5,'Henry',0);
