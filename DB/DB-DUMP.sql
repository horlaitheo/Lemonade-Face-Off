--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: d_types; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE d_types AS ENUM (
    'ad',
    'stand'
);


ALTER TYPE d_types OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: access; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE access (
    rcp_name character varying(50) NOT NULL,
    pla_name character varying(50) NOT NULL
);


ALTER TABLE access OWNER TO postgres;

--
-- Name: compose; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE compose (
    quantity integer,
    rcp_name character varying(50) NOT NULL,
    ing_name character varying(50) NOT NULL
);


ALTER TABLE compose OWNER TO postgres;

--
-- Name: ingredient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ingredient (
    ing_name character varying(50) NOT NULL,
    ing_current_cost double precision,
    ing_has_alcohol boolean,
    ing_is_cold boolean
);


ALTER TABLE ingredient OWNER TO postgres;

--
-- Name: map; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE map (
    map_id integer NOT NULL,
    map_elapsed_days integer,
    map_time time with time zone,
    map_longitude double precision,
    map_lattitude double precision,
    map_longitude_span double precision,
    map_lattitude_span double precision
);


ALTER TABLE map OWNER TO postgres;

--
-- Name: map_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE map_item (
    mit_id integer NOT NULL,
    mit_type d_types,
    mit_influence double precision,
    mit_longitude double precision,
    mit_lattitude double precision,
    pla_name character varying(50),
    map_id integer
);


ALTER TABLE map_item OWNER TO postgres;

--
-- Name: map_item_mit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE map_item_mit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE map_item_mit_id_seq OWNER TO postgres;

--
-- Name: map_item_mit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE map_item_mit_id_seq OWNED BY map_item.mit_id;


--
-- Name: map_map_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE map_map_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE map_map_id_seq OWNER TO postgres;

--
-- Name: map_map_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE map_map_id_seq OWNED BY map.map_id;


--
-- Name: player; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE player (
    pla_name character varying(50) NOT NULL,
    pla_password character varying(50),
    pla_cash double precision,
    pla_sales integer
);


ALTER TABLE player OWNER TO postgres;

--
-- Name: preference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE preference (
    par_name character varying(25) NOT NULL,
    par_value double precision,
    map_id integer
);


ALTER TABLE preference OWNER TO postgres;

--
-- Name: production; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE production (
    pro_day_nb integer,
    pro_qty integer,
    pro_cost_at_that_time double precision,
    pro_player character varying(50) NOT NULL,
    pro_recipe_name character varying(50) NOT NULL
);


ALTER TABLE production OWNER TO postgres;

--
-- Name: recipe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE recipe (
    rcp_name character varying(50) NOT NULL,
    rcp_is_cold boolean
);


ALTER TABLE recipe OWNER TO postgres;

--
-- Name: sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sale (
    sal_day_number integer,
    sal_qty integer,
    sal_price double precision,
    sal_player character varying(50) NOT NULL,
    sal_recipe_name character varying(50) NOT NULL
);


ALTER TABLE sale OWNER TO postgres;

--
-- Name: map map_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map ALTER COLUMN map_id SET DEFAULT nextval('map_map_id_seq'::regclass);


--
-- Name: map_item mit_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map_item ALTER COLUMN mit_id SET DEFAULT nextval('map_item_mit_id_seq'::regclass);


--
-- Data for Name: access; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY access (rcp_name, pla_name) FROM stdin;
\.


--
-- Data for Name: compose; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY compose (quantity, rcp_name, ing_name) FROM stdin;
\.


--
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ingredient (ing_name, ing_current_cost, ing_has_alcohol, ing_is_cold) FROM stdin;
\.


--
-- Data for Name: map; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY map (map_id, map_elapsed_days, map_time, map_longitude, map_lattitude, map_longitude_span, map_lattitude_span) FROM stdin;
\.


--
-- Data for Name: map_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY map_item (mit_id, mit_type, mit_infuence, mit_longitude, mit_lattitude, pla_name, map_id) FROM stdin;
\.


--
-- Name: map_item_mit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('map_item_mit_id_seq', 1, false);


--
-- Name: map_map_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('map_map_id_seq', 1, false);


--
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY player (pla_name, pla_password, pla_cash, pla_sales) FROM stdin;
\.


--
-- Data for Name: preference; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preference (par_name, par_value, map_id) FROM stdin;
\.


--
-- Data for Name: production; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY production (pro_day_nb, pro_qty, pro_cost_at_that_time, pro_player, pro_recipe_name) FROM stdin;
\.


--
-- Data for Name: recipe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recipe (rcp_name, rcp_is_cold) FROM stdin;
\.


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sale (sal_day_number, sal_qty, sal_price, sal_player, sal_recipe_name) FROM stdin;
\.


--
-- Name: access prk_constraint_access; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY access
    ADD CONSTRAINT prk_constraint_access PRIMARY KEY (rcp_name, pla_name);


--
-- Name: compose prk_constraint_compose; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY compose
    ADD CONSTRAINT prk_constraint_compose PRIMARY KEY (rcp_name, ing_name);


--
-- Name: ingredient prk_constraint_ingredient; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingredient
    ADD CONSTRAINT prk_constraint_ingredient PRIMARY KEY (ing_name);


--
-- Name: map prk_constraint_map; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map
    ADD CONSTRAINT prk_constraint_map PRIMARY KEY (map_id);


--
-- Name: map_item prk_constraint_map_item; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map_item
    ADD CONSTRAINT prk_constraint_map_item PRIMARY KEY (mit_id);


--
-- Name: player prk_constraint_player; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY player
    ADD CONSTRAINT prk_constraint_player PRIMARY KEY (pla_name);


--
-- Name: preference prk_constraint_preference; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preference
    ADD CONSTRAINT prk_constraint_preference PRIMARY KEY (par_name);


--
-- Name: production prk_constraint_production; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY production
    ADD CONSTRAINT prk_constraint_production PRIMARY KEY (pro_player, pro_recipe_name, pro_day_nb);


--
-- Name: recipe prk_constraint_recipe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recipe
    ADD CONSTRAINT prk_constraint_recipe PRIMARY KEY (rcp_name);


--
-- Name: sale prk_constraint_sale; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT prk_constraint_sale PRIMARY KEY (sal_player, sal_recipe_name);


--
-- Name: access fk_access_pla_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY access
    ADD CONSTRAINT fk_access_pla_name FOREIGN KEY (pla_name) REFERENCES player(pla_name);


--
-- Name: access fk_access_rcp_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY access
    ADD CONSTRAINT fk_access_rcp_name FOREIGN KEY (rcp_name) REFERENCES recipe(rcp_name);


--
-- Name: compose fk_compose_ing_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY compose
    ADD CONSTRAINT fk_compose_ing_name FOREIGN KEY (ing_name) REFERENCES ingredient(ing_name);


--
-- Name: compose fk_compose_rcp_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY compose
    ADD CONSTRAINT fk_compose_rcp_name FOREIGN KEY (rcp_name) REFERENCES recipe(rcp_name);


--
-- Name: map_item fk_map_item_map_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map_item
    ADD CONSTRAINT fk_map_item_map_id FOREIGN KEY (map_id) REFERENCES map(map_id);


--
-- Name: map_item fk_map_item_pla_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY map_item
    ADD CONSTRAINT fk_map_item_pla_name FOREIGN KEY (pla_name) REFERENCES player(pla_name);


--
-- Name: preference fk_preference_map_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preference
    ADD CONSTRAINT fk_preference_map_id FOREIGN KEY (map_id) REFERENCES map(map_id);


--
-- Name: production fk_production_pla_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY production
    ADD CONSTRAINT fk_production_pla_name FOREIGN KEY (pro_player) REFERENCES player(pla_name);


--
-- Name: sale fk_sale_pla_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT fk_sale_pla_name FOREIGN KEY (sal_player) REFERENCES player(pla_name);


--
-- Name: sale fk_sale_rcp_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT fk_sale_rcp_name FOREIGN KEY (sal_recipe_name) REFERENCES recipe(rcp_name);


--
-- Name: production fl_production_rcp_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY production
    ADD CONSTRAINT fl_production_rcp_name FOREIGN KEY (pro_recipe_name) REFERENCES recipe(rcp_name);


--
-- PostgreSQL database dump complete
--
