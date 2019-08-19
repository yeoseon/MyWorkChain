DROP TABLE IF EXISTS billionaires;
 
CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Bill22', 'Gates22', 'Billionaire Tech Entrepreneur22'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
  
  
DROP TABLE IF EXISTS system_info;

CREATE TABLE system_info (
	mwc_address VARCHAR(250) NOT NULL
);

INSERT INTO system_info (mwc_address) VALUES
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd');

 
DROP TABLE IF EXISTS company;

CREATE TABLE company (
	comp_address VARCHAR(250) PRIMARY KEY,
	mwc_address VARCHAR(250) NOT NULL,
	comp_name VARCHAR(250),
	comp_location VARCHAR(1000)	
);

INSERT INTO company (comp_address, mwc_address, comp_name, comp_location) VALUES
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd','0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', 'Bankware Global', '서울특별시 중구 소공동 통일로 86');
 
 
DROP TABLE IF EXISTS work_place;

CREATE TABLE work_place (
	work_code INT AUTO_INCREMENT PRIMARY KEY,
	comp_address VARCHAR(250) NOT NULL,
	work_name VARCHAR(250),
	work_address VARCHAR(1000),
	work_geo_location NUMBER(3),
	work_geo_longitude NUMBER(3),
	work_geo_altitude NUMBER(3),
	work_geo_accuracy NUMBER(3),
	work_use_yn boolean
);

INSERT INTO work_place (comp_address, work_name, work_address, work_geo_location, work_geo_longitude, work_geo_altitude, work_geo_accuracy, work_use_yn) VALUES
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '본사', '서울특별시 중구 소공동 통일로 86', '10', '10', '10', '10', true),
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '부산지사', '부산광역시 수영구 수영로 776', '30', '40', '20', '80', true),
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '신림지사', '서울특별시 관악구 미성3길 41', '90', '270', '60', '30', true);
 
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	user_address VARCHAR(250) PRIMARY KEY,
	comp_address VARCHAR(250) NOT NULL,
	user_name VARCHAR(250),
	current_work_seq VARCHAR(250)
);

INSERT INTO employee (user_address, comp_address, user_name, current_work_seq) VALUES
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', 'Kevin', '001'),
 ('0x82536a89099b6acfefa78ca15eb669d55d18528d', '0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', 'Mickey', '001'),
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', 'Celine', '002');
 

DROP TABLE IF EXISTS user_works;

CREATE TABLE work_history (
	work_seq VARCHAR(250) PRIMARY KEY,
	user_address VARCHAR(250) NOT NULL,
	work_code INT,
	work_start_ymd VARCHAR(100),
	work_end_ymd VARCHAR(100),
	work_start_time VARCHAR(100),
	work_end_time VARCHAR(100)
);
 
DROP TABLE IF EXISTS work_history;

CREATE TABLE work_history (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	user_address VARCHAR(250) NOT NULL,
	work_start_ymd VARCHAR(100),
	work_end_ymd VARCHAR(100),
	work_start_time VARCHAR(100),
	work_end_time VARCHAR(100)
);

INSERT INTO work_history (user_address, work_start_ymd, work_end_ymd, work_start_time, work_end_time) VALUES
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '20190819', '20190819', '093000', '183000'),
 ('0x82536a89099b6acfefa78ca15eb669d55d18528d', '20190819', '20190820', '093000', '013000'),
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '20190819', '20190819', '093000', '183000');
 
 