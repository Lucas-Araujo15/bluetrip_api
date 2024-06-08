DROP TABLE t_bt_address CASCADE CONSTRAINTS;

DROP TABLE t_bt_administrator CASCADE CONSTRAINTS;

DROP TABLE t_bt_booking CASCADE CONSTRAINTS;

DROP TABLE t_bt_event CASCADE CONSTRAINTS;

DROP TABLE t_bt_local_business CASCADE CONSTRAINTS;

DROP TABLE t_bt_payment CASCADE CONSTRAINTS;

DROP TABLE t_bt_service CASCADE CONSTRAINTS;

DROP TABLE t_bt_service_usage CASCADE CONSTRAINTS;

DROP TABLE t_bt_tourist CASCADE CONSTRAINTS;

DROP TABLE t_bt_tourist_spot CASCADE CONSTRAINTS;

DROP TABLE t_bt_user CASCADE CONSTRAINTS;

DROP TABLE t_log_errors CASCADE CONSTRAINTS;

CREATE TABLE t_bt_address (
    id_address      INTEGER NOT NULL,
    ds_street       VARCHAR2(100) NOT NULL,
    ds_city         VARCHAR2(100) NOT NULL,
    nr_zip_code     CHAR(8) NOT NULL,
    ds_state        CHAR(2) NOT NULL,
    ds_neighborhood VARCHAR2(100) NOT NULL,
    nr_building     INTEGER,
    ds_complement   VARCHAR2(100)
);

ALTER TABLE t_bt_address ADD CONSTRAINT t_bt_address_pk PRIMARY KEY ( id_address );

CREATE TABLE t_bt_administrator (
    id_administrator  INTEGER NOT NULL,
    ds_name           VARCHAR2(100) NOT NULL,
    nr_phone          CHAR(11) NOT NULL,
    ds_role           VARCHAR2(50),
    t_bt_user_id_user INTEGER NOT NULL
);

CREATE UNIQUE INDEX t_bt_administrator__idx ON t_bt_administrator ( t_bt_user_id_user ASC );

ALTER TABLE t_bt_administrator ADD CONSTRAINT t_bt_administrator_pk PRIMARY KEY ( id_administrator );

CREATE TABLE t_bt_booking (
    id_booking        INTEGER NOT NULL,
    dt_booking        DATE NOT NULL,
    st_booking        VARCHAR2(50) NOT NULL,
    nr_quantity       INTEGER NOT NULL,
    t_bt_payment_id_payment INTEGER NOT NULL,
    t_bt_tourist_spot_id_tourist_spot INTEGER,
    t_bt_tourist_id_tourist INTEGER
);

CREATE UNIQUE INDEX t_bt_booking__idx ON t_bt_booking ( t_bt_payment_id_payment ASC );

ALTER TABLE t_bt_booking ADD CONSTRAINT t_bt_booking_pk PRIMARY KEY ( id_booking );

CREATE TABLE t_bt_event (
    id_event          INTEGER NOT NULL,
    ds_name           VARCHAR2(100) NOT NULL,
    tx_description    CLOB NOT NULL,
    vl_price          NUMBER(7, 2) NOT NULL,
    url_image         VARCHAR2(100) NOT NULL,
    dt_start          DATE NOT NULL,
    dt_end            DATE,
    t_bt_tourist_spot_id_tourist_spot INTEGER
);

ALTER TABLE t_bt_event ADD CONSTRAINT t_bt_event_pk PRIMARY KEY ( id_event );

CREATE TABLE t_bt_local_business (
    id_local_business INTEGER NOT NULL,
    ds_trade_name     VARCHAR2(100) NOT NULL,
    tx_description    VARCHAR2(200) NOT NULL,
    nr_average_rating NUMBER(2, 1),
    url_website       VARCHAR2(100) NOT NULL,
    url_image         VARCHAR2(100) NOT NULL,
    ds_open_hour      DATE NOT NULL,
    ds_close_hour     DATE NOT NULL,
    nr_phone          CHAR(11) NOT NULL,
    ds_business_category VARCHAR2(100) NOT NULL,
    t_bt_user_id_user INTEGER NOT NULL,
    t_bt_address_id_address INTEGER NOT NULL
);

CREATE UNIQUE INDEX t_bt_local_business__idx ON t_bt_local_business ( t_bt_user_id_user ASC );

CREATE UNIQUE INDEX t_bt_local_business__idxv1 ON t_bt_local_business ( t_bt_address_id_address ASC );

ALTER TABLE t_bt_local_business ADD CONSTRAINT t_bt_local_business_pk PRIMARY KEY ( id_local_business );

CREATE TABLE t_bt_payment (
    id_payment        INTEGER NOT NULL,
    ds_payment_method VARCHAR2(100) NOT NULL,
    vl_total_price    NUMBER(10, 2) NOT NULL,
    st_payment        VARCHAR2(50) NOT NULL,
    dt_payment        DATE
);

ALTER TABLE t_bt_payment ADD CONSTRAINT t_bt_payment_pk PRIMARY KEY ( id_payment );

CREATE TABLE t_bt_service (
    id_service        INTEGER NOT NULL,
    ds_name           VARCHAR2(100) NOT NULL,
    tx_description    CLOB NOT NULL,
    vl_price          NUMBER(10, 2) NOT NULL,
    ds_category       VARCHAR2(50) NOT NULL,
    t_bt_local_business_id_local_business INTEGER
);


ALTER TABLE t_bt_service ADD CONSTRAINT t_bt_service_pk PRIMARY KEY ( id_service );

CREATE TABLE t_bt_service_usage (
    t_bt_payment_id_payment INTEGER NOT NULL,
    t_bt_service_id_service INTEGER,
    t_bt_tourist_id_tourist INTEGER,
    id_service_usage        INTEGER NOT NULL,
    dt_usage                DATE NOT NULL,
    nr_rate                 NUMBER(2, 1),
    tx_comment              CLOB
);

CREATE UNIQUE INDEX t_bt_service_usage__idx ON t_bt_service_usage ( t_bt_payment_id_payment ASC );

ALTER TABLE t_bt_service_usage ADD CONSTRAINT t_bt_service_usage_pk PRIMARY KEY ( id_service_usage );

CREATE TABLE t_bt_tourist (
    id_tourist        INTEGER NOT NULL,
    ds_name           VARCHAR2(100) NOT NULL,
    ds_nationality    VARCHAR2(20) NOT NULL,
    nr_phone          CHAR(11) NOT NULL,
    dt_birth          TIMESTAMP NOT NULL,
    ds_gender         VARCHAR2(10) NOT NULL,
    ds_language       VARCHAR2(50) NOT NULL,
    t_bt_user_id_user INTEGER NOT NULL
);

CREATE UNIQUE INDEX t_bt_tourist__idx ON t_bt_tourist ( t_bt_user_id_user ASC );

ALTER TABLE t_bt_tourist ADD CONSTRAINT t_bt_tourist_pk PRIMARY KEY ( id_tourist );

CREATE TABLE t_bt_tourist_spot (
    id_tourist_spot   INTEGER NOT NULL,
    ds_name           VARCHAR2(150) NOT NULL,
    tx_description    CLOB NOT NULL,
    nr_average_rate   NUMBER(2, 1) NOT NULL,
    vl_price          NUMBER(7, 2) NOT NULL,
    nr_phone          CHAR(11),
    url_image         VARCHAR2(100) NOT NULL,
    ds_category       VARCHAR2(100) NOT NULL,
    t_bt_address_id_address INTEGER NOT NULL
);

CREATE UNIQUE INDEX t_bt_tourist_spot__idx ON t_bt_tourist_spot ( t_bt_address_id_address ASC );

ALTER TABLE t_bt_tourist_spot ADD CONSTRAINT t_bt_tourist_spot_pk PRIMARY KEY ( id_tourist_spot );

CREATE TABLE t_bt_user (
    id_user       INTEGER NOT NULL,
    ds_email      VARCHAR2(100) NOT NULL UNIQUE,
    ds_password   VARCHAR2(100) NOT NULL,
    dt_created_at DATE NOT NULL,
    ds_user_type  VARCHAR2(100) NOT NULL
);

ALTER TABLE t_bt_user ADD CONSTRAINT t_bt_user_pk PRIMARY KEY ( id_user );

CREATE TABLE t_log_errors (
    log_id         NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    procedure_name VARCHAR2(100),
    user_name      VARCHAR2(100),
    error_date     TIMESTAMP,
    error_code     NUMBER,
    error_message  VARCHAR2(4000),
    CONSTRAINT t_log_errors_pk PRIMARY KEY (log_id)
);

ALTER TABLE t_bt_administrator
    ADD CONSTRAINT t_bt_administrator_fk FOREIGN KEY ( t_bt_user_id_user )
        REFERENCES t_bt_user ( id_user );

ALTER TABLE t_bt_booking
    ADD CONSTRAINT t_bt_booking_payment_fk FOREIGN KEY ( t_bt_payment_id_payment )
        REFERENCES t_bt_payment ( id_payment );

ALTER TABLE t_bt_booking
    ADD CONSTRAINT t_bt_booking_tourist_fk FOREIGN KEY ( t_bt_tourist_id_tourist )
        REFERENCES t_bt_tourist ( id_tourist );

ALTER TABLE t_bt_booking
    ADD CONSTRAINT t_bt_booking_tourist_spot_fk FOREIGN KEY ( t_bt_tourist_spot_id_tourist_spot )
        REFERENCES t_bt_tourist_spot ( id_tourist_spot );

ALTER TABLE t_bt_event
    ADD CONSTRAINT t_bt_event_tourist_spot_fk FOREIGN KEY ( t_bt_tourist_spot_id_tourist_spot )
        REFERENCES t_bt_tourist_spot ( id_tourist_spot );

ALTER TABLE t_bt_local_business
    ADD CONSTRAINT t_bt_local_business_address_fk FOREIGN KEY ( t_bt_address_id_address )
        REFERENCES t_bt_address ( id_address );

ALTER TABLE t_bt_local_business
    ADD CONSTRAINT t_bt_local_business_user_fk FOREIGN KEY ( t_bt_user_id_user )
        REFERENCES t_bt_user ( id_user );

ALTER TABLE t_bt_service
    ADD CONSTRAINT t_bt_service_local_business_fk FOREIGN KEY ( t_bt_local_business_id_local_business )
        REFERENCES t_bt_local_business ( id_local_business );

ALTER TABLE t_bt_service_usage
    ADD CONSTRAINT t_bt_service_usage_payment_fk FOREIGN KEY ( t_bt_payment_id_payment )
        REFERENCES t_bt_payment ( id_payment );

ALTER TABLE t_bt_service_usage
    ADD CONSTRAINT t_bt_service_usage_service_fk FOREIGN KEY ( t_bt_service_id_service )
        REFERENCES t_bt_service ( id_service );

ALTER TABLE t_bt_service_usage
    ADD CONSTRAINT t_bt_service_usage_tourist_fk FOREIGN KEY ( t_bt_tourist_id_tourist )
        REFERENCES t_bt_tourist ( id_tourist );

ALTER TABLE t_bt_tourist_spot
    ADD CONSTRAINT t_bt_tourist_spot_address_fk FOREIGN KEY ( t_bt_address_id_address )
        REFERENCES t_bt_address ( id_address );

ALTER TABLE t_bt_tourist
    ADD CONSTRAINT t_bt_tourist_user_fk FOREIGN KEY ( t_bt_user_id_user )
        REFERENCES t_bt_user ( id_user );
        
        
CREATE SEQUENCE SEQ_T_LOG_ERRORS START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_USER START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_TOURIST_SPOT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_TOURIST START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_SERVICE_USAGE START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_SERVICE START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_PAYMENT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_LOCAL_BUSINESS START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_EVENT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_BOOKING START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_ADMINISTRATOR START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_T_BT_ADDRESS START WITH 1 INCREMENT BY 1;

