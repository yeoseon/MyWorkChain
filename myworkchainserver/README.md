# MyWorkChain Server Project

### WAS - Tomcat
기본 WAS Container - Tomcat

* Basic port : 8080 (port 가 겹치는 경우 'src/main/resources/application.properties' 파일에서 server.port=${PORT} 지정)

### 로컬 개발 환경 실행 방법

1. 프로젝트 오른쪽 클릭
2. [Run As 혹은 Debug As > Spring Boot App] 실행
3. 브라우저에서 [http://localhost:8080](http://localhost:8080) 접속

### Database - h2
h2 메모리 데이터베이스 사용 시 접속 정보

* [콘솔 접속 : http://localhost:8080/h2-console](http://localhost:8080/h2-console) (WAS 가 실행이 되어 있어야 함)
* 데이터베이스 접속 정보 : src/main/resources/application.properties 참조
* DDL, DML 작성 파일 : src/main/resources/data.sql
(서버 기동 시 자동으로 읽어서 실행)
(추후 MySQL 로 마이그레이션 진행 시 필요하므로, 모델 설계 시 꼭 작성한다)

### Lombok
IDE 환경에서 Getter, Setter, Constructor 등을 코드를 기술하지 않아도 자동으로 세팅해주는 라이브러리

설치 순서
1. [lombok 공식 다운로드 사이트](https://projectlombok.org/download) 에서 lombok.jar 다운로드
2. lombok.jar 실행 (바로 실행되지 않는 경우 cmd - java 명령어로 실행)
3. IDE 지정
4. IDE 설치된 경로로 가서 lombok.jar 가 생성이 되었는 지 확인 / *.ini 파일에 javaagent 로 lombok 이 세팅이 되었는 지 확인