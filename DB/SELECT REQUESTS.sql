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
	(SELECT SUM (sal_qty * sal_price) AS profit
	FROM sale
	INNER JOIN player ON player.pla_name = sale.sal_pla_name
	WHERE sal_day_nb = @VAR_DAY - 1
	AND sal_pla_name = @VAR_NAME
	)
	-
	--DEPENSE
	(SELECT SUM (pro_qty * pro_cost_at_that_time) AS cost
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

--LISTE DES INGREDIENT + PRIX
SELECT ing_name, ing_current_cost, compose.com_quantity
FROM ingredient
INNER JOIN compose ON compose.com_ing_name = ingredient.ing_name
INNER JOIN recipe ON compose.com_rcp_name = recipe.rcp_name
WHERE recipe.rcp_name = @VAR_RCP;

--COUT TOTAL D'UNE RECETTE
SELECT SUM (ing_current_cost * compose.com_quantity) as cost
FROM ingredient
INNER JOIN compose ON compose.com_ing_name = ingredient.ing_name
INNER JOIN recipe ON compose.com_rcp_name = recipe.rcp_name
WHERE recipe.rcp_name = @VAR_RCP;

--RECUP DAY
SELECT map_day_nb
FROM map;


--RECUP TEMPS
SELECT map_time
FROM map;