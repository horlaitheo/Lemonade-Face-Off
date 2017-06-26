------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------

INSERT INTO ingredient VALUES 
	('citron', 20, FALSE, FALSE),
	('glace', 2, FALSE, TRUE),
	('sucre', 20, FALSE, FALSE),
	('eau petillante', 20, FALSE, FALSE),
	('rhum', 100, FALSE, FALSE),
	('menthe', 30, FALSE, FALSE),
	('epice vin chaud', 10, FALSE, FALSE),
	('vin', 100, TRUE, FALSE),
	('feuilles de thé', 20, FALSE, FALSE),
	('grains de café', 30, FALSE, FALSE);

INSERT INTO recipe VALUES
	('limonade', TRUE),
	('mojito', TRUE),
	('vin chaud', FALSE),
	('café', FALSE),
	('thé', FALSE);

INSERT INTO compose VALUES
	(1,'limonade','citron'),
	(1,'limonade','sucre'),
	(1,'limonade','glace'),
	(2,'limonade','eau petillante'),
	(1,'mojito','citron'),
	(2,'mojito','sucre'),
	(2,'mojito','glace'),
	(1,'mojito','eau petillante'),
	(1,'mojito','rhum'),
	(2,'mojito','menthe'),
	(1,'vin chaud','epice vin chaud'),
	(1,'vin chaud','vin'),
	(1,'café','grains de café'),
	(1,'café','sucre'),
	(1,'thé','feuilles de thé'),
	(1,'thé','sucre'),
	(1,'thé','menthe');