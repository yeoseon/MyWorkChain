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
	location VARCHAR(1000),
	use_yn boolean
);

INSERT INTO company (comp_address, mwc_address, comp_name, location, use_yn) VALUES
 ('0x69f2d1bdc2430a3a067620f617fec3100b892d54','0xf2852cc72bed2cb039464d347154331fdd4d8491', 'SL2', '서울특별시 중구 소공동 통일로 86', true);
 
 
DROP TABLE IF EXISTS work_place;

CREATE TABLE work_place (
	work_code VARCHAR(50) PRIMARY KEY,
	comp_address VARCHAR(250) NOT NULL,
	work_name VARCHAR(250),
	work_address VARCHAR(1000),
	work_geo_longitude NUMBER(3),
	work_geo_latitude NUMBER(3),
	work_use_yn boolean
);

INSERT INTO work_place (work_code, comp_address, work_name, work_address, work_geo_longitude, work_geo_latitude, work_use_yn) VALUES
 ('01', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', '서울본사', '서울특별시 중구 소공동 통일로 86', '126.969542', '37.563264', true),
 ('02', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', '송도지사', '인천광역시 중구 영종해안남로321번길 208', '126.456209', '37.440220', true);

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	id VARCHAR(250) NOT NULL,
	empl_address VARCHAR(250) PRIMARY KEY,
	comp_address VARCHAR(250) NOT NULL,
	empl_name VARCHAR(250),
	current_work_code VARCHAR(50),
	department VARCHAR(250),
	position VARCHAR(250),
	join_date VARCHAR(250),
	email VARCHAR(250),
	phone_number VARCHAR(250)
);

INSERT INTO employee (id, empl_address, comp_address, empl_name, current_work_code, department, position, join_date, email, phone_number) VALUES
 ('Gabriel', '0xbFB07E725F66B2aC1187a5B134FbCF4a3f3bEaF0', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', 'Gabriel', '02', '개발팀', '매니저', '2019-02-18', 'dongshik.lee@gmail.com', '010-1111-1111'),
 ('Kevin', '0x425d268cB4075e809762eaf6644ADB71fBAe600D', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', 'Kevin', '01', '개발팀', '매니저', '2013-07-01', 'kylee1112@hotmail.com', '010-1111-1111'),
 ('Mickey', '0xf537938cC1A409db6eAeB557889795C28467Af96', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', 'Mickey', '01', '개발팀', '매니저', '2015-03-01', 'Sjh8341@gmail.com', '010-1111-1111'),
 ('Celine', '0xF1568fdE338a2641fEe85Dd2d3a936e0dEed4aAD', '0x69f2d1bdc2430a3a067620f617fec3100b892d54', 'Celine', '02', '개발팀', '매니저', '2019-01-21', 'devyyskr@gmail.com', '010-4692-6053');

/* WORK HISTORY */
DROP TABLE IF EXISTS work_history;

CREATE TABLE work_history (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	user_id VARCHAR(250) NOT NULL,
	time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	work_code VARCHAR(50),
	latitude DECIMAL NOT NULL,
	longitude DECIMAL NOT NULL,
	work_place_code VARCHAR(50) NOT NULL,
	reward INT NOT NULL
);

INSERT INTO work_history (user_id, time, work_code, latitude, longitude, work_place_code, reward) VALUES
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '2019-08-27 09:30:06', '01', 11111111, 22222222, '01', 100),
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '2019-08-27 18:31:21', '02', 11111111, 22222222, '01', 200),
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '2019-08-27 09:30:06', '01', 11111111, 22222222, '01', 100),
 ('0xeaed2747df494052ef8660ebada75ec1c9449508', '2019-08-27 18:31:21', '02', 11111111, 22222222, '01', 300),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-07 09:30:06', '01', 11111111, 22222222, '01', 100),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-07 18:31:21', '02', 11111111, 22222222, '01', 230),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-08 09:30:06', '01', 11111111, 22222222, '01', 100),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-08 18:25:21', '02', 11111111, 22222222, '01', 230),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-09 09:30:06', '01', 11111111, 22222222, '01', 120),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-09 20:32:21', '02', 11111111, 22222222, '01', 160),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-11 09:25:21', '01', 11111111, 22222222, '01', 160),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-23 09:33:06', '01', 11111111, 22222222, '01', 110),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-23 21:35:21', '02', 11111111, 22222222, '01', 50),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-24 09:30:06', '01', 11111111, 22222222, '01', 500),
 ('0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0', '2019-08-24 18:31:21', '02', 11111111, 22222222, '01', 1000);