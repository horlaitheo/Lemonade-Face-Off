--INSERER UNE VENTE
INSERT INTO sale VALUES 
	(@VAR_DAY, @VAR_QTY, @VAR_PRICE, @VAR_NAME, @VAR_RCP);

--INSERER UNE PRODUCTION
INSERT INTO production VALUES
	(@VAR_DAY, @VAR_QTY, @VAR_COST, @VAR_NAME, @VAR_RCP);

--INSERER UN NOUVEAU JOUEUR
INSERT INTO player VALUES
	(@VAR_NAME, '', @STARTING_CASH, 0);

--INSERER UNE PUB
INSERT INTO map_item VALUES
	(0, 'ad', @VAR_INF, @VAR_LONG, @VAR_LAT, @VAR_NAME, 0);