------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------

INSERT INTO ingredient VALUES 
	('citron', 0.2, FALSE, FALSE),
	('glace', 0.02, FALSE, TRUE),
	('sucre', 0.2, FALSE, FALSE),
	('eau petillante', 0.2, FALSE, FALSE),
	('rhum', 1, TRUE, FALSE),
	('menthe', 0.3, FALSE, FALSE),
	('epice vin chaud', 0.1, FALSE, FALSE),
	('vin', 1, TRUE, FALSE),
	('feuilles de thé', 0.2, FALSE, FALSE),
	('grains de café', 0.3, FALSE, FALSE);

INSERT INTO recipe VALUES
	('limonade', TRUE, FALSE),
	('mojito', TRUE, TRUE),
	('vin chaud', FALSE, TRUE),
	('café', FALSE, FALSE),
	('thé', FALSE, FALSE);

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