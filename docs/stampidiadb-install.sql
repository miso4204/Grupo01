-- Role: stampidia clave: 1234567890

-- DROP ROLE stampidia;

CREATE ROLE stampidia LOGIN ENCRYPTED PASSWORD 'md58dbe35c3ea027ecd1004e6660d48d135' 
VALID UNTIL 'infinity';
   
--Database: stampidia

CREATE DATABASE stampidia
  WITH OWNER = stampidia
       ENCODING = 'UTF8'
       CONNECTION LIMIT = -1;
       
REVOKE ALL ON DATABASE stampidia FROM public;
GRANT ALL ON DATABASE stampidia to stampidia; 

-- CONEXION CON LA NUEVA BASE DE DATOS

\connect stampidia;


-- SMTP-PLAN
CREATE TABLE smtp_plan (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE smtp_plan OWNER TO stampidia;
CREATE SEQUENCE smtp_plan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE smtp_plan_id_seq OWNER TO stampidia;
ALTER SEQUENCE smtp_plan_id_seq OWNED BY smtp_plan.id;


-- SMTP-CATEGORY

CREATE TABLE stmp_category (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);


ALTER TABLE stmp_category OWNER TO stampidia;
COMMENT ON TABLE stmp_category IS 'category or theme';
CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE category_id_seq OWNER TO stampidia;
ALTER SEQUENCE category_id_seq OWNED BY stmp_category.id;


-- SMTP-COLOR
CREATE TABLE stmp_color (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    hex_value character varying(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_color OWNER TO stampidia;
CREATE SEQUENCE color_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE color_id_seq OWNER TO stampidia;
ALTER SEQUENCE color_id_seq OWNED BY stmp_color.id;


--STMP-ORDER
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
COMMENT ON TABLE stmp_order IS 'this order is created when shopping car has at least one item and user is login. It''s status is TRUE if order is open, FALSE if order is a place order.';
COMMENT ON COLUMN stmp_order.id_payment_type IS 'PSE, CoD, CREDITCARD';
COMMENT ON COLUMN stmp_order.id_shipping_type IS 'CoD, Stampidia handles';
COMMENT ON COLUMN stmp_order.shipping_status IS 'TRUE: WAS SHIPPED';
COMMENT ON COLUMN stmp_order.order_status IS 'TRUE IF OPEN, FALSE IF IS A PLACE ORDER CLOSED';
CREATE SEQUENCE order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE order_id_seq OWNER TO stampidia;

--STMP-ORDER-DETAIL
CREATE TABLE stmp_order_detail (
    id integer NOT NULL,
    id_order integer NOT NULL,
    id_shirt integer NOT NULL,
    quantity integer DEFAULT 0 NOT NULL,
    unit_value numeric DEFAULT 0 NOT NULL
);
ALTER TABLE stmp_order_detail OWNER TO stampidia;
CREATE SEQUENCE det_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE det_order_id_seq OWNER TO stampidia;
ALTER SEQUENCE det_order_id_seq OWNED BY stmp_order_detail.id;

--STMP-PAYMENT-TYPE
CREATE TABLE stmp_payment_type (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512),
    success_url character varying(512),
    error_url character varying(512),
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_payment_type OWNER TO stampidia;
CREATE SEQUENCE id_type_payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE id_type_payment_id_seq OWNER TO stampidia;
ALTER SEQUENCE id_type_payment_id_seq OWNED BY stmp_payment_type.id;
ALTER SEQUENCE order_id_seq OWNED BY stmp_order.id;

--STMP-SHIPPING-TYPE
CREATE TABLE stmp_shipping_type (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512) NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_shipping_type OWNER TO stampidia;
CREATE SEQUENCE shipping_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE shipping_type_id_seq OWNER TO stampidia;
ALTER SEQUENCE shipping_type_id_seq OWNED BY stmp_shipping_type.id;


--STMP-SHIRT
CREATE TABLE stmp_shirt (
    id integer NOT NULL,
    id_size integer NOT NULL,
    id_color integer NOT NULL,
    text character varying(512),
    id_style integer DEFAULT 1 NOT NULL,
    sales_number integer DEFAULT 0 NOT NULL,
    id_artist_user integer NOT NULL,
    id_stamp integer NOT NULL
);
ALTER TABLE stmp_shirt OWNER TO stampidia;
CREATE SEQUENCE shirt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE shirt_id_seq OWNER TO stampidia;
ALTER SEQUENCE shirt_id_seq OWNED BY stmp_shirt.id;

--STMP-SHIRT-RATING
CREATE TABLE stmp_shirt_rating (
    id integer NOT NULL,
    valoration integer NOT NULL,
    comment character varying(512),
    id_shirt integer NOT NULL,
    id_user integer NOT NULL
);
ALTER TABLE stmp_shirt_rating OWNER TO stampidia;
COMMENT ON TABLE stmp_shirt_rating IS 'user rating by shirt or product';
CREATE SEQUENCE shirt_rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE shirt_rating_id_seq OWNER TO stampidia;
ALTER SEQUENCE shirt_rating_id_seq OWNED BY stmp_shirt_rating.id;



--STMP-SHIRT-STYLE
CREATE TABLE stmp_shirt_style (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512) NOT NULL,
    price numeric NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_shirt_style OWNER TO stampidia;
COMMENT ON TABLE stmp_shirt_style IS 'shirt type, round neck, v neck, etc';
COMMENT ON COLUMN stmp_shirt_style.price IS 'basic price shirt, this plus stamp price is the total shirt price';
CREATE SEQUENCE shirt_style_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE shirt_style_id_seq OWNER TO stampidia;
ALTER SEQUENCE shirt_style_id_seq OWNED BY stmp_shirt_style.id;


--STMP-SIZE
CREATE TABLE stmp_size (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_size OWNER TO stampidia;
CREATE SEQUENCE size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE size_id_seq OWNER TO stampidia;
ALTER SEQUENCE size_id_seq OWNED BY stmp_size.id;

--STMP-STAMP
CREATE TABLE stmp_stamp (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(512) NOT NULL,
    image character varying(512) NOT NULL,
    tags character varying(512) NOT NULL,
    id_artist_user integer NOT NULL,
    sales_number integer DEFAULT 0 NOT NULL,
    id_category integer NOT NULL,
    price numeric NOT NULL,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_stamp OWNER TO stampidia;
COMMENT ON COLUMN stmp_stamp.image IS 'image path';
COMMENT ON COLUMN stmp_stamp.tags IS 'search tags';
CREATE SEQUENCE stamp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE stamp_id_seq OWNER TO stampidia;
ALTER SEQUENCE stamp_id_seq OWNED BY stmp_stamp.id;

--STMP-STAMP-RATING
CREATE TABLE stmp_stamp_rating (
    id integer NOT NULL,
    valoration integer NOT NULL,
    comment character varying(512),
    id_stamp integer NOT NULL,
    id_user integer NOT NULL
);
ALTER TABLE stmp_stamp_rating OWNER TO stampidia;
COMMENT ON TABLE stmp_stamp_rating IS 'user rating by stamp';
CREATE SEQUENCE stamp_rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE stamp_rating_id_seq OWNER TO stampidia;
ALTER SEQUENCE stamp_rating_id_seq OWNED BY stmp_stamp_rating.id;

--STMP-USER
CREATE TABLE stmp_user (
    id integer NOT NULL,
    username character varying(256) NOT NULL,
    password character varying(64) NOT NULL,
    email character varying(100) NOT NULL,
    facebook_email character varying(256),
    twitter_email character varying(256),
    is_seller boolean DEFAULT false NOT NULL,
    id_plan integer,
    status boolean DEFAULT true NOT NULL
);
ALTER TABLE stmp_user OWNER TO stampidia;
CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE user_id_seq OWNER TO stampidia;
ALTER SEQUENCE user_id_seq OWNED BY stmp_user.id;
ALTER TABLE ONLY smtp_plan ALTER COLUMN id SET DEFAULT nextval('smtp_plan_id_seq'::regclass);
ALTER TABLE ONLY stmp_category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);
ALTER TABLE ONLY stmp_color ALTER COLUMN id SET DEFAULT nextval('color_id_seq'::regclass);
ALTER TABLE ONLY stmp_order ALTER COLUMN id SET DEFAULT nextval('order_id_seq'::regclass);
ALTER TABLE ONLY stmp_order_detail ALTER COLUMN id SET DEFAULT nextval('det_order_id_seq'::regclass);
ALTER TABLE ONLY stmp_payment_type ALTER COLUMN id SET DEFAULT nextval('id_type_payment_id_seq'::regclass);
ALTER TABLE ONLY stmp_shipping_type ALTER COLUMN id SET DEFAULT nextval('shipping_type_id_seq'::regclass);
ALTER TABLE ONLY stmp_shirt ALTER COLUMN id SET DEFAULT nextval('shirt_id_seq'::regclass);
ALTER TABLE ONLY stmp_shirt_rating ALTER COLUMN id SET DEFAULT nextval('shirt_rating_id_seq'::regclass);
ALTER TABLE ONLY stmp_shirt_style ALTER COLUMN id SET DEFAULT nextval('shirt_style_id_seq'::regclass);
ALTER TABLE ONLY stmp_size ALTER COLUMN id SET DEFAULT nextval('size_id_seq'::regclass);
ALTER TABLE ONLY stmp_stamp ALTER COLUMN id SET DEFAULT nextval('stamp_id_seq'::regclass);
ALTER TABLE ONLY stmp_stamp_rating ALTER COLUMN id SET DEFAULT nextval('stamp_rating_id_seq'::regclass);
ALTER TABLE ONLY stmp_user ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);
SELECT pg_catalog.setval('category_id_seq', 4, true);
SELECT pg_catalog.setval('color_id_seq', 5, true);
SELECT pg_catalog.setval('det_order_id_seq', 1, false);
SELECT pg_catalog.setval('id_type_payment_id_seq', 3, true);
SELECT pg_catalog.setval('order_id_seq', 1, false);
SELECT pg_catalog.setval('shipping_type_id_seq', 1, true);
SELECT pg_catalog.setval('shirt_id_seq', 1, false);
SELECT pg_catalog.setval('shirt_rating_id_seq', 1, false);
SELECT pg_catalog.setval('shirt_style_id_seq', 2, true);
SELECT pg_catalog.setval('size_id_seq', 5, true);
SELECT pg_catalog.setval('smtp_plan_id_seq', 1, false);
SELECT pg_catalog.setval('stamp_id_seq', 1, true);
SELECT pg_catalog.setval('stamp_rating_id_seq', 1, false);
SELECT pg_catalog.setval('user_id_seq', 1, false);


ALTER TABLE ONLY stmp_category
    ADD CONSTRAINT category_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_color
    ADD CONSTRAINT color_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_order_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_size
    ADD CONSTRAINT name_uq UNIQUE (name);

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_pk PRIMARY KEY (id);

ALTER TABLE ONLY smtp_plan
    ADD CONSTRAINT plan_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_shipping_type
    ADD CONSTRAINT shipping_type_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rating_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_shirt_style
    ADD CONSTRAINT shirt_style_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_size
    ADD CONSTRAINT size_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_rating_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_payment_type
    ADD CONSTRAINT type_payment_pk PRIMARY KEY (id);

ALTER TABLE ONLY stmp_user
    ADD CONSTRAINT user_pk PRIMARY KEY (id);



ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_order_fk FOREIGN KEY (id_order) REFERENCES stmp_order(id);

ALTER TABLE ONLY stmp_order_detail
    ADD CONSTRAINT det_shirt_fk FOREIGN KEY (id_shirt) REFERENCES stmp_shirt(id);

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_pay_fk FOREIGN KEY (id_payment_type) REFERENCES stmp_payment_type(id);

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_ship_fk FOREIGN KEY (id_shipping_type) REFERENCES stmp_shipping_type(id);

ALTER TABLE ONLY stmp_order
    ADD CONSTRAINT order_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_art_fk FOREIGN KEY (id_artist_user) REFERENCES stmp_user(id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_color_fk FOREIGN KEY (id_color) REFERENCES stmp_color(id);

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rat_shirt_fk FOREIGN KEY (id_shirt) REFERENCES stmp_shirt(id);

ALTER TABLE ONLY stmp_shirt_rating
    ADD CONSTRAINT shirt_rat_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_size_fk FOREIGN KEY (id_size) REFERENCES stmp_size(id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_stam_fk FOREIGN KEY (id_stamp) REFERENCES stmp_stamp(id);

ALTER TABLE ONLY stmp_shirt
    ADD CONSTRAINT shirt_style_fk FOREIGN KEY (id_style) REFERENCES stmp_shirt_style(id);

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_art_fk FOREIGN KEY (id_artist_user) REFERENCES stmp_user(id);

ALTER TABLE ONLY stmp_stamp
    ADD CONSTRAINT stamp_cate_fk FOREIGN KEY (id_category) REFERENCES stmp_category(id);

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_rat_user_fk FOREIGN KEY (id_user) REFERENCES stmp_user(id);

ALTER TABLE ONLY stmp_stamp_rating
    ADD CONSTRAINT stamp_stamp_fk FOREIGN KEY (id_stamp) REFERENCES stmp_stamp(id);

ALTER TABLE ONLY stmp_user
    ADD CONSTRAINT user_plan_fk FOREIGN KEY (id_plan) REFERENCES smtp_plan(id);