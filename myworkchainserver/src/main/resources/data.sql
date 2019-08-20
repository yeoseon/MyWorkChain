DROP TABLE IF EXISTS system_info;

CREATE TABLE system_info (
	mwc_address VARCHAR(250) NOT NULL
);

INSERT INTO system_info (mwc_address) VALUES
 ('0xf2852cc72bed2cb039464d347154331fdd4d8491');

 
DROP TABLE IF EXISTS company;

CREATE TABLE company (
	comp_address VARCHAR(250) PRIMARY KEY,
	mwc_address VARCHAR(250) NOT NULL,
	comp_name VARCHAR(250),
	location VARCHAR(1000)	
);

INSERT INTO company (comp_address, mwc_address, comp_name, location) VALUES
 ('0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c','0xf2852cc72bed2cb039464d347154331fdd4d8491', 'Bankware Global', '서울특별시 중구 소공동 통일로 86');
 
 
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
 ('0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', '본사', '서울특별시 중구 소공동 통일로 86', '10', '10', '10', '10', true),
 ('0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', '부산지사', '부산광역시 수영구 수영로 776', '30', '40', '20', '80', true),
 ('0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', '신림지사', '서울특별시 관악구 미성3길 41', '90', '270', '60', '30', true);
 
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	empl_address VARCHAR(250) PRIMARY KEY,
	comp_address VARCHAR(250) NOT NULL,
	empl_name VARCHAR(250),
	current_work_code INT
);

INSERT INTO employee (empl_address, comp_address, empl_name, current_work_code) VALUES
 ('0xB31794ef274FFb1e6e4a55bAE4f9F18DeBA3C112', '0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', 'Gabriel', '2'),
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', 'Kevin', '1'),
 ('0x82536a89099b6acfefa78ca15eb669d55d18528d', '0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', 'Mickey', '1'),
 ('0x320988e96fc90a4097b23eb7f4ff987fa06a8dfd', '0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c', 'Celine', '2');
  
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
 
 