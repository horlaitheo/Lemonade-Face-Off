------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------

CREATE TYPE D_types AS ENUM ('ad','stand');

CREATE TYPE D_weather AS ENUM ('cloudy','sunny','rainny','thunderstorm','heatwave','');

------------------------------------------------------------
-- Table: Ingredient
------------------------------------------------------------
CREATE TABLE Ingredient(
	ing_name         VARCHAR (50) NOT NULL ,
	ing_current_cost FLOAT   ,
	ing_has_alcohol  BOOL   ,
	ing_is_cold      BOOL   ,
	CONSTRAINT prk_constraint_Ingredient PRIMARY KEY (ing_name)
);


------------------------------------------------------------
-- Table: Recipe
------------------------------------------------------------
CREATE TABLE Recipe(
	rcp_name    VARCHAR (50) NOT NULL ,
	rcp_is_cold BOOL   ,
	rcp_has_alcohol  BOOL	,
	CONSTRAINT prk_constraint_Recipe PRIMARY KEY (rcp_name)
);


------------------------------------------------------------
-- Table: Player
------------------------------------------------------------
CREATE TABLE Player(
	pla_name     VARCHAR (50) NOT NULL ,
	pla_password VARCHAR (50)  ,
	pla_cash     FLOAT   ,
	pla_sales    INT   ,
	CONSTRAINT prk_constraint_Player PRIMARY KEY (pla_name)
);


------------------------------------------------------------
-- Table: Map_Item
------------------------------------------------------------
CREATE TABLE Map_Item(
	mit_id        SERIAL NOT NULL ,
	mit_type      D_TYPES ,
	mit_influence  FLOAT   ,
	mit_longitude FLOAT   ,
	mit_latitude FLOAT   ,
	mit_pla_name      VARCHAR (50)  ,
	mit_map_id        INT   ,
	CONSTRAINT prk_constraint_Map_Item PRIMARY KEY (mit_id)
);


------------------------------------------------------------
-- Table: Map
------------------------------------------------------------
CREATE TABLE Map(
	map_id             		SERIAL NOT NULL ,
	map_day_nb		   		INT   ,
	map_time           		BIGINT   ,
	map_longitude      		FLOAT   ,
	map_latitude      		FLOAT   ,
	map_longitude_span 		FLOAT   ,
	map_latitude_span 		FLOAT   ,
	map_prevision_weather 	D_weather,
	map_current_weather 	D_weather,
	CONSTRAINT prk_constraint_Map PRIMARY KEY (map_id)
);


------------------------------------------------------------
-- Table: Preference
------------------------------------------------------------
CREATE TABLE Preference(
	pre_name  VARCHAR (25) NOT NULL ,
	pre_value FLOAT   ,
	pre_map_id    INT   ,
	CONSTRAINT prk_constraint_Preference PRIMARY KEY (pre_name)
);


------------------------------------------------------------
-- Table: Sale
------------------------------------------------------------
CREATE TABLE Sale(
	sal_day_nb	     INT   ,
	sal_qty          INT   ,
	sal_price        FLOAT   ,
	sal_pla_name  VARCHAR (50) NOT NULL ,
	sal_rcp_name  VARCHAR (50) NOT NULL ,
	CONSTRAINT prk_constraint_Sale PRIMARY KEY (sal_pla_name,sal_rcp_name,sal_day_nb)
);


------------------------------------------------------------
-- Table: Production
------------------------------------------------------------
CREATE TABLE Production(
	pro_day_nb            INT   ,
	pro_qty               INT   ,
	pro_cost_at_that_time FLOAT   ,
	pro_pla_name       VARCHAR (50) NOT NULL ,
	pro_rcp_name       VARCHAR (50) NOT NULL ,
	CONSTRAINT prk_constraint_Production PRIMARY KEY (pro_pla_name,pro_rcp_name,pro_day_nb )
);


------------------------------------------------------------
-- Table: Compose
------------------------------------------------------------
CREATE TABLE Compose(
	com_quantity INT   ,
	com_rcp_name VARCHAR (50) NOT NULL ,
	com_ing_name VARCHAR (50) NOT NULL ,
	CONSTRAINT prk_constraint_Compose PRIMARY KEY (com_rcp_name,com_ing_name)
);


------------------------------------------------------------
-- Table: Access
------------------------------------------------------------
CREATE TABLE Access(
	acc_rcp_name VARCHAR (50) NOT NULL ,
	acc_pla_name VARCHAR (50) NOT NULL ,
	CONSTRAINT prk_constraint_Access PRIMARY KEY (acc_rcp_name,acc_pla_name)
);


ALTER TABLE Map_Item ADD CONSTRAINT FK_Map_Item_pla_name FOREIGN KEY (mit_pla_name) REFERENCES Player(pla_name) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Map_Item ADD CONSTRAINT FK_Map_Item_map_id FOREIGN KEY (mit_map_id) REFERENCES Map(map_id);
ALTER TABLE Preference ADD CONSTRAINT FK_Preference_map_id FOREIGN KEY (pre_map_id) REFERENCES Map(map_id);
ALTER TABLE Compose ADD CONSTRAINT FK_Compose_rcp_name FOREIGN KEY (com_rcp_name) REFERENCES Recipe(rcp_name);
ALTER TABLE Compose ADD CONSTRAINT FK_Compose_ing_name FOREIGN KEY (com_ing_name) REFERENCES Ingredient(ing_name);
ALTER TABLE Access ADD CONSTRAINT FK_Access_rcp_name FOREIGN KEY (acc_rcp_name) REFERENCES Recipe(rcp_name);
ALTER TABLE Access ADD CONSTRAINT FK_Access_pla_name FOREIGN KEY (acc_pla_name) REFERENCES Player(pla_name) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Sale ADD CONSTRAINT FK_Sale_pla_name FOREIGN KEY (sal_pla_name) REFERENCES Player(pla_name) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Sale ADD CONSTRAINT FK_Sale_rcp_name FOREIGN KEY (sal_rcp_name) REFERENCES Recipe(rcp_name);
ALTER TABLE Production ADD CONSTRAINT FK_Production_pla_name FOREIGN KEY (pro_pla_name) REFERENCES Player(pla_name) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Production ADD CONSTRAINT FL_Production_rcp_name FOREIGN KEY (pro_rcp_name) REFERENCES Recipe(rcp_name);