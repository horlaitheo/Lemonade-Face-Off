--LISTE DES JOUEURS
SELECT pla_name
FROM player;

----------------

--GET THAT PLAYER ITEM
SELECT mit_type, mit_pla_name, mit_longitude, mit_lattitude, mit_influence 
FROM map_item
WHERE mit_pla_name = @VAR_NAME;

----------------
--GET THAT PLAYER INFO

--GET THAT PLAYER CASH
SELECT pla_cash
FROM player
WHERE pla_name = @VAR_NAME
	
--QTE VENDU
SELECT SUM (sal_qty) 
	FROM sale
	INNER JOIN player ON player.pla_name = sale.sal_pla_name
	WHERE sal_day_nb = @VAR_DAY
	AND sal_pla_name = @VAR_NAME
		
--PROFIT
SELECT
	--GAIN
	(SELECT SUM (sal_qty * sal_price) 
	FROM sale
	INNER JOIN player ON player.pla_name = sale.sal_pla_name
	WHERE sal_day_nb = @VAR_DAY - 1
	AND sal_pla_name = @VAR_NAME
	)
	-
	--DEPENSE
	(SELECT SUM (pro_qty * pro_cost_at_that_time)
	FROM production
	INNER JOIN player ON player.pla_name = production.pro_pla_name
	WHERE pro_day_nb = @VAR_DAY - 1
	AND pro_pla_name = @VAR_NAME
	);

--LISTE DES TYPES DE BOISSONS PREPAREE
SELECT pro_recipe_name
FROM production
INNER JOIN player ON player.pla_name = production.pro_pla_name
WHERE pro_day_nb = @VAR_DAY
AND pro_pla_name = @VAR_NAME;

----------------

--GET THAT PLAYER RECIPES

SELECT rcp_name
FROM recipe
INNER JOIN access ON access.acc_rcp_name = recipe.rcp_name
INNER JOIN player ON player.pla_name = access.acc_pla_name
WHERE player.pla_name = @VAR_NAME;