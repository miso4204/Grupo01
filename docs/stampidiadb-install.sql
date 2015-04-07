-- Role: stampidia

-- DROP ROLE stampidia;

CREATE ROLE stampidia LOGIN
ENCRYPTED PASSWORD 'md58dbe35c3ea027ecd1004e6660d48d135'
SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;

  
  -- Database: stampidia

-- DROP DATABASE stampidia;

CREATE DATABASE stampidia
  WITH OWNER = stampidia
       ENCODING = 'UTF8'
       CONNECTION LIMIT = -1;
       
--REVOKE ALL ON DATABASE stampidia FROM public;
GRANT ALL ON DATABASE stampidia to stampidia; 

\connect stampidia;






--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2015-03-31 20:59:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


--
-- TOC entry 175 (class 1259 OID 16430)
-- Name: stmp_category; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_category (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_category OWNER TO stampidia;

--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 175
-- Name: TABLE stmp_category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE stmp_category IS 'category or theme';


--
-- TOC entry 174 (class 1259 OID 16428)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE category_id_seq OWNER TO stampidia;

--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 174
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE category_id_seq OWNED BY stmp_category.id;


--
-- TOC entry 189 (class 1259 OID 16520)
-- Name: stmp_color; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_color (
    id integer NOT NULL,
    name character(256) NOT NULL,
    hex_value character(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_color OWNER TO stampidia;

--
-- TOC entry 188 (class 1259 OID 16518)
-- Name: color_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE color_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE color_id_seq OWNER TO stampidia;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 188
-- Name: color_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE color_id_seq OWNED BY stmp_color.id;


--
-- TOC entry 187 (class 1259 OID 16507)
-- Name: stmp_order_detail; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_order_detail (
    id integer NOT NULL,
    id_order integer NOT NULL,
    id_shirt integer NOT NULL,
    quantity integer DEFAULT 0 NOT NULL,
    unit_value numeric DEFAULT 0 NOT NULL
);


ALTER TABLE stmp_order_detail OWNER TO stampidia;

--
-- TOC entry 186 (class 1259 OID 16505)
-- Name: det_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE det_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE det_order_id_seq OWNER TO stampidia;

--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 186
-- Name: det_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE det_order_id_seq OWNED BY stmp_order_detail.id;


--
-- TOC entry 193 (class 1259 OID 16548)
-- Name: stmp_payment_type; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_payment_type (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512),
    success_url character(512),
    error_url character(512),
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_payment_type OWNER TO stampidia;

--
-- TOC entry 192 (class 1259 OID 16546)
-- Name: id_type_payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_type_payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE id_type_payment_id_seq OWNER TO stampidia;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 192
-- Name: id_type_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE id_type_payment_id_seq OWNED BY stmp_payment_type.id;


--
-- TOC entry 185 (class 1259 OID 16490)
-- Name: stmp_order; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_order (
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_payment_type integer,
    id_shipping_type integer DEFAULT 1 NOT NULL,
    date date DEFAULT ('now'::text)::date NOT NULL,
    shipping_status boolean DEFAULT true NOT NULL,
    payment_status boolean DEFAULT true NOT NULL,
    order_status boolean DEFAULT true NOT NULL,
    total_amount numeric DEFAULT 0 NOT NULL
);


ALTER TABLE stmp_order OWNER TO stampidia;

--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 185
-- Name: TABLE stmp_order; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE stmp_order IS 'this order is created when shopping car has at least one item and user is login. It''s status is TRUE if order is open, FALSE if order is a place order.';


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN stmp_order.id_payment_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_order.id_payment_type IS 'PSE, CoD, CREDITCARD';


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN stmp_order.id_shipping_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_order.id_shipping_type IS 'CoD, Stampidia handles';


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN stmp_order.shipping_status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_order.shipping_status IS 'TRUE: WAS SHIPPED';


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN stmp_order.order_status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_order.order_status IS 'TRUE IF OPEN, FALSE IF IS A PLACE ORDER CLOSED';


--
-- TOC entry 184 (class 1259 OID 16488)
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE order_id_seq OWNER TO stampidia;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 184
-- Name: order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_id_seq OWNED BY stmp_order.id;


--
-- TOC entry 195 (class 1259 OID 16564)
-- Name: stmp_shipping_type; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_shipping_type (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_shipping_type OWNER TO stampidia;

--
-- TOC entry 194 (class 1259 OID 16562)
-- Name: shipping_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE shipping_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shipping_type_id_seq OWNER TO stampidia;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 194
-- Name: shipping_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shipping_type_id_seq OWNED BY stmp_shipping_type.id;


--
-- TOC entry 181 (class 1259 OID 16464)
-- Name: stmp_shirt; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_shirt (
    id integer NOT NULL,
    id_size integer NOT NULL,
    id_color integer NOT NULL,
    text character(512),
    id_style integer DEFAULT 1 NOT NULL,
    sales_number integer DEFAULT 0 NOT NULL,
    id_artist_user integer NOT NULL,
    id_stamp integer NOT NULL
);


ALTER TABLE stmp_shirt OWNER TO stampidia;

--
-- TOC entry 180 (class 1259 OID 16462)
-- Name: shirt_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE shirt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shirt_id_seq OWNER TO stampidia;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 180
-- Name: shirt_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shirt_id_seq OWNED BY stmp_shirt.id;


--
-- TOC entry 179 (class 1259 OID 16453)
-- Name: stmp_shirt_rating; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_shirt_rating (
    id integer NOT NULL,
    valoration integer NOT NULL,
    comment character(512),
    id_shirt integer NOT NULL,
    id_user integer NOT NULL
);


ALTER TABLE stmp_shirt_rating OWNER TO stampidia;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 179
-- Name: TABLE stmp_shirt_rating; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE stmp_shirt_rating IS 'user rating by shirt or product';


--
-- TOC entry 178 (class 1259 OID 16451)
-- Name: shirt_rating_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE shirt_rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shirt_rating_id_seq OWNER TO stampidia;

--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 178
-- Name: shirt_rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shirt_rating_id_seq OWNED BY stmp_shirt_rating.id;


--
-- TOC entry 183 (class 1259 OID 16478)
-- Name: stmp_shirt_style; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_shirt_style (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512) NOT NULL,
    price numeric NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_shirt_style OWNER TO stampidia;

--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 183
-- Name: TABLE stmp_shirt_style; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE stmp_shirt_style IS 'shirt type, round neck, v neck, etc';


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN stmp_shirt_style.price; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_shirt_style.price IS 'basic price shirt, this plus stamp price is the total shirt price';


--
-- TOC entry 182 (class 1259 OID 16476)
-- Name: shirt_style_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE shirt_style_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shirt_style_id_seq OWNER TO stampidia;

--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 182
-- Name: shirt_style_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shirt_style_id_seq OWNED BY stmp_shirt_style.id;


--
-- TOC entry 191 (class 1259 OID 16539)
-- Name: stmp_size; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_size (
    id integer NOT NULL,
    name character(256) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_size OWNER TO stampidia;

--
-- TOC entry 190 (class 1259 OID 16537)
-- Name: size_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE size_id_seq OWNER TO stampidia;

--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 190
-- Name: size_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE size_id_seq OWNED BY stmp_size.id;


--
-- TOC entry 199 (class 1259 OID 16690)
-- Name: smtp_plan; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE smtp_plan (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE smtp_plan OWNER TO stampidia;

--
-- TOC entry 198 (class 1259 OID 16688)
-- Name: smtp_plan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE smtp_plan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE smtp_plan_id_seq OWNER TO stampidia;

--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 198
-- Name: smtp_plan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE smtp_plan_id_seq OWNED BY smtp_plan.id;


--
-- TOC entry 173 (class 1259 OID 16417)
-- Name: stmp_stamp; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_stamp (
    id integer NOT NULL,
    name character(256) NOT NULL,
    description character(512) NOT NULL,
    image character(512) NOT NULL,
    tags character(512) NOT NULL,
    id_artist_user integer NOT NULL,
    sales_number integer DEFAULT 0 NOT NULL,
    id_category integer NOT NULL,
    price numeric NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_stamp OWNER TO stampidia;

--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN stmp_stamp.image; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_stamp.image IS 'image path';


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN stmp_stamp.tags; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN stmp_stamp.tags IS 'search tags';


--
-- TOC entry 172 (class 1259 OID 16415)
-- Name: stamp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stamp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stamp_id_seq OWNER TO stampidia;

--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 172
-- Name: stamp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stamp_id_seq OWNED BY stmp_stamp.id;


--
-- TOC entry 177 (class 1259 OID 16442)
-- Name: stmp_stamp_rating; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_stamp_rating (
    id integer NOT NULL,
    valoration integer NOT NULL,
    comment character(512),
    id_stamp integer NOT NULL,
    id_user integer NOT NULL
);


ALTER TABLE stmp_stamp_rating OWNER TO stampidia;

--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 177
-- Name: TABLE stmp_stamp_rating; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE stmp_stamp_rating IS 'user rating by stamp';


--
-- TOC entry 176 (class 1259 OID 16440)
-- Name: stamp_rating_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stamp_rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stamp_rating_id_seq OWNER TO stampidia;

--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 176
-- Name: stamp_rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stamp_rating_id_seq OWNED BY stmp_stamp_rating.id;


--
-- TOC entry 197 (class 1259 OID 16576)
-- Name: stmp_user; Type: TABLE; Schema: public; Owner: stampidia; Tablespace: 
--

CREATE TABLE stmp_user (
    id integer NOT NULL,
    username character(256) NOT NULL,
    password character(64) NOT NULL,
    email character(100) NOT NULL,
    facebook_email character(256),
    twitter_email character(256),
    is_seller boolean DEFAULT false NOT NULL,
    id_plan integer,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_user OWNER TO stampidia;

--
-- TOC entry 196 (class 1259 OID 16574)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO stampidia;

--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY stmp_user.id;


--
-- TOC entry 2006 (class 2604 OID 16693)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY smtp_plan ALTER COLUMN id SET DEFAULT nextval('smtp_plan_id_seq'::regclass);


--
-- TOC entry 1976 (class 2604 OID 16433)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- TOC entry 1995 (class 2604 OID 16523)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_color ALTER COLUMN id SET DEFAULT nextval('color_id_seq'::regclass);


--
-- TOC entry 1985 (class 2604 OID 16493)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order ALTER COLUMN id SET DEFAULT nextval('order_id_seq'::regclass);


--
-- TOC entry 1992 (class 2604 OID 16510)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order_detail ALTER COLUMN id SET DEFAULT nextval('det_order_id_seq'::regclass);


--
-- TOC entry 1999 (class 2604 OID 16551)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_payment_type ALTER COLUMN id SET DEFAULT nextval('id_type_payment_id_seq'::regclass);


--
-- TOC entry 2001 (class 2604 OID 16567)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shipping_type ALTER COLUMN id SET DEFAULT nextval('shipping_type_id_seq'::regclass);


--
-- TOC entry 1980 (class 2604 OID 16467)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt ALTER COLUMN id SET DEFAULT nextval('shirt_id_seq'::regclass);


--
-- TOC entry 1979 (class 2604 OID 16456)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt_rating ALTER COLUMN id SET DEFAULT nextval('shirt_rating_id_seq'::regclass);


--
-- TOC entry 1983 (class 2604 OID 16481)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt_style ALTER COLUMN id SET DEFAULT nextval('shirt_style_id_seq'::regclass);


--
-- TOC entry 1997 (class 2604 OID 16542)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_size ALTER COLUMN id SET DEFAULT nextval('size_id_seq'::regclass);


--
-- TOC entry 1973 (class 2604 OID 16420)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp ALTER COLUMN id SET DEFAULT nextval('stamp_id_seq'::regclass);


--
-- TOC entry 1978 (class 2604 OID 16445)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp_rating ALTER COLUMN id SET DEFAULT nextval('stamp_rating_id_seq'::regclass);


--
-- TOC entry 2003 (class 2604 OID 16579)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_user ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 174
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('category_id_seq', 4, true);


--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 188
-- Name: color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('color_id_seq', 5, true);


--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 186
-- Name: det_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('det_order_id_seq', 1, false);


--
-- TOC entry 2230 (class 0 OID 0)
-- Dependencies: 192
-- Name: id_type_payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('id_type_payment_id_seq', 3, true);


--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 184
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('order_id_seq', 1, false);


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 194
-- Name: shipping_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('shipping_type_id_seq', 1, true);


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 180
-- Name: shirt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('shirt_id_seq', 1, false);


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 178
-- Name: shirt_rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('shirt_rating_id_seq', 1, false);


--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 182
-- Name: shirt_style_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('shirt_style_id_seq', 2, true);


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 190
-- Name: size_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('size_id_seq', 5, true);


--
-- TOC entry 2191 (class 0 OID 16690)
-- Dependencies: 199
-- Data for Name: smtp_plan; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 198
-- Name: smtp_plan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('smtp_plan_id_seq', 1, false);


--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 172
-- Name: stamp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stamp_id_seq', 1, true);


--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 176
-- Name: stamp_rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stamp_rating_id_seq', 1, false);


--
-- TOC entry 2167 (class 0 OID 16430)
-- Dependencies: 175
-- Data for Name: stmp_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_category (id, name, description, status) VALUES (1, 'Geek                                                                                                                                                                                                                                                            ', 'Geek                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ', true);
INSERT INTO stmp_category (id, name, description, status) VALUES (2, 'Funny                                                                                                                                                                                                                                                           ', 'Funny                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ', true);
INSERT INTO stmp_category (id, name, description, status) VALUES (3, 'Love                                                                                                                                                                                                                                                            ', 'Love                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ', true);
INSERT INTO stmp_category (id, name, description, status) VALUES (4, 'Sports                                                                                                                                                                                                                                                          ', 'Sports                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);


--
-- TOC entry 2181 (class 0 OID 16520)
-- Dependencies: 189
-- Data for Name: stmp_color; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_color (id, name, hex_value, status) VALUES (1, 'Black                                                                                                                                                                                                                                                           ', '000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);
INSERT INTO stmp_color (id, name, hex_value, status) VALUES (2, 'Blue                                                                                                                                                                                                                                                            ', '0000FF                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);
INSERT INTO stmp_color (id, name, hex_value, status) VALUES (3, 'Red                                                                                                                                                                                                                                                             ', 'FF0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);
INSERT INTO stmp_color (id, name, hex_value, status) VALUES (4, 'Green                                                                                                                                                                                                                                                           ', '008000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);
INSERT INTO stmp_color (id, name, hex_value, status) VALUES (5, 'Yellow                                                                                                                                                                                                                                                          ', 'FFFF00                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', true);


--
-- TOC entry 2177 (class 0 OID 16490)
-- Dependencies: 185
-- Data for Name: stmp_order; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2179 (class 0 OID 16507)
-- Dependencies: 187
-- Data for Name: stmp_order_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2185 (class 0 OID 16548)
-- Dependencies: 193
-- Data for Name: stmp_payment_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_payment_type (id, name, description, status) VALUES (1, 'CoD                                                                                                                                                                                                                                                             ', 'Cash on Delivery                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ', true);
INSERT INTO stmp_payment_type (id, name, description, status) VALUES (2, 'PSE                                                                                                                                                                                                                                                             ', 'PSE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ', true);
INSERT INTO stmp_payment_type (id, name, description, status) VALUES (3, 'CREDIT CARD                                                                                                                                                                                                                                                     ', 'CREDIT CARD                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', true);


--
-- TOC entry 2187 (class 0 OID 16564)
-- Dependencies: 195
-- Data for Name: stmp_shipping_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_shipping_type (id, name, description, status) VALUES (1, 'CoD                                                                                                                                                                                                                                                             ', 'Cash on Delivery                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ', true);


--
-- TOC entry 2173 (class 0 OID 16464)
-- Dependencies: 181
-- Data for Name: stmp_shirt; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2171 (class 0 OID 16453)
-- Dependencies: 179
-- Data for Name: stmp_shirt_rating; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2175 (class 0 OID 16478)
-- Dependencies: 183
-- Data for Name: stmp_shirt_style; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_shirt_style (id, name, description, price, status) VALUES (1, 'ROUND NECK                                                                                                                                                                                                                                                      ', 'ROUND NECK                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ', 5, true);
INSERT INTO stmp_shirt_style (id, name, description, price, status) VALUES (2, 'V-NECK                                                                                                                                                                                                                                                          ', 'V-NECK                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ', 7, false);


--
-- TOC entry 2183 (class 0 OID 16539)
-- Dependencies: 191
-- Data for Name: stmp_size; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stmp_size (id, name, status) VALUES (1, 'S                                                                                                                                                                                                                                                               ', true);
INSERT INTO stmp_size (id, name, status) VALUES (2, 'M                                                                                                                                                                                                                                                               ', true);
INSERT INTO stmp_size (id, name, status) VALUES (3, 'L                                                                                                                                                                                                                                                               ', true);
INSERT INTO stmp_size (id, name, status) VALUES (4, 'XL                                                                                                                                                                                                                                                              ', true);
INSERT INTO stmp_size (id, name, status) VALUES (5, 'XXL                                                                                                                                                                                                                                                             ', true);


--
-- TOC entry 2165 (class 0 OID 16417)
-- Dependencies: 173
-- Data for Name: stmp_stamp; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2169 (class 0 OID 16442)
-- Dependencies: 177
-- Data for Name: stmp_stamp_rating; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2189 (class 0 OID 16576)
-- Dependencies: 197
-- Data for Name: stmp_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 1, false);


--
-- TOC entry 2011 (class 2606 OID 16439)
-- Name: category_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_category
    ADD CONSTRAINT category_pk PRIMARY KEY (id);


--
-- TOC entry 2025 (class 2606 OID 16529)
-- Name: color_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_color
    ADD CONSTRAINT color_pk PRIMARY KEY (id);


--
-- TOC entry 2023 (class 2606 OID 16517)
-- Name: det_order_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_order_pk PRIMARY KEY (id);


--
-- TOC entry 2027 (class 2606 OID 24790)
-- Name: name_uq; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_size
    ADD CONSTRAINT name_uq UNIQUE (name);


--
-- TOC entry 2021 (class 2606 OID 16504)
-- Name: order_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_pk PRIMARY KEY (id);


--
-- TOC entry 2037 (class 2606 OID 16699)
-- Name: plan_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY smtp_plan
    ADD CONSTRAINT plan_pk PRIMARY KEY (id);


--
-- TOC entry 2033 (class 2606 OID 16573)
-- Name: shipping_type_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_shipping_type
    ADD CONSTRAINT shipping_type_pk PRIMARY KEY (id);


--
-- TOC entry 2017 (class 2606 OID 16474)
-- Name: shirt_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_pk PRIMARY KEY (id);


--
-- TOC entry 2015 (class 2606 OID 16461)
-- Name: shirt_rating_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rating_pk PRIMARY KEY (id);


--
-- TOC entry 2019 (class 2606 OID 16487)
-- Name: shirt_style_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_shirt_style
    ADD CONSTRAINT shirt_style_pk PRIMARY KEY (id);


--
-- TOC entry 2029 (class 2606 OID 16545)
-- Name: size_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_size
    ADD CONSTRAINT size_pk PRIMARY KEY (id);


--
-- TOC entry 2009 (class 2606 OID 16427)
-- Name: stamp_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_pk PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 16450)
-- Name: stamp_rating_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_rating_pk PRIMARY KEY (id);


--
-- TOC entry 2031 (class 2606 OID 16557)
-- Name: type_payment_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_payment_type
    ADD CONSTRAINT type_payment_pk PRIMARY KEY (id);


--
-- TOC entry 2035 (class 2606 OID 16585)
-- Name: user_pk; Type: CONSTRAINT; Schema: public; Owner: stampidia; Tablespace: 
--

ALTER TABLE ONLY stmp_user
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2052 (class 2606 OID 16597)
-- Name: det_order_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_order_fk FOREIGN KEY (id_order) REFERENCES stmp_order(id);


--
-- TOC entry 2053 (class 2606 OID 16602)
-- Name: det_shirt_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_shirt_fk FOREIGN KEY (id_shirt) REFERENCES stmp_shirt(id);


--
-- TOC entry 2050 (class 2606 OID 16613)
-- Name: order_pay_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_pay_fk FOREIGN KEY (id_payment_type) REFERENCES stmp_payment_type(id);


--
-- TOC entry 2051 (class 2606 OID 16618)
-- Name: order_ship_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_ship_fk FOREIGN KEY (id_shipping_type) REFERENCES stmp_shipping_type(id);


--
-- TOC entry 2049 (class 2606 OID 16608)
-- Name: order_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);


--
-- TOC entry 2047 (class 2606 OID 16638)
-- Name: shirt_art_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_art_fk FOREIGN KEY (id_artist_user) REFERENCES stmp_user(id);


--
-- TOC entry 2045 (class 2606 OID 16628)
-- Name: shirt_color_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_color_fk FOREIGN KEY (id_color) REFERENCES stmp_color(id);


--
-- TOC entry 2042 (class 2606 OID 16648)
-- Name: shirt_rat_shirt_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rat_shirt_fk FOREIGN KEY (id_shirt) REFERENCES stmp_shirt(id);


--
-- TOC entry 2043 (class 2606 OID 16653)
-- Name: shirt_rat_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rat_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);


--
-- TOC entry 2044 (class 2606 OID 16623)
-- Name: shirt_size_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_size_fk FOREIGN KEY (id_size) REFERENCES stmp_size(id);


--
-- TOC entry 2048 (class 2606 OID 16643)
-- Name: shirt_stam_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_stam_fk FOREIGN KEY (id_stamp) REFERENCES stmp_stamp(id);


--
-- TOC entry 2046 (class 2606 OID 16633)
-- Name: shirt_style_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_style_fk FOREIGN KEY (id_style) REFERENCES stmp_shirt_style(id);


--
-- TOC entry 2039 (class 2606 OID 16673)
-- Name: stamp_art_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_art_fk FOREIGN KEY (id_artist_user) REFERENCES stmp_user(id);


--
-- TOC entry 2038 (class 2606 OID 16668)
-- Name: stamp_cate_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_cate_fk FOREIGN KEY (id_category) REFERENCES stmp_category(id);


--
-- TOC entry 2040 (class 2606 OID 16678)
-- Name: stamp_rat_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_rat_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);


--
-- TOC entry 2041 (class 2606 OID 16683)
-- Name: stamp_stamp_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_stamp_fk FOREIGN KEY (id_stamp) REFERENCES stmp_stamp(id);


--
-- TOC entry 2054 (class 2606 OID 16700)
-- Name: user_plan_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stmp_user
    ADD CONSTRAINT user_plan_fk FOREIGN KEY (id_plan) REFERENCES smtp_plan(id);

-- Completed on 2015-03-31 20:59:51

--
-- PostgreSQL database dump complete
--




  