# TheBible
성경을 검색할 수 있는 RESTful API 를 제공하는 서비스입니다. 개역개정(RT), 개역한글(KT) 총 두 버전의 성경을 제공합니다.

## Properties
### application.properties
- spring.datasource.url=jdbc:mysql://127.0.0.1:3306/bible_test?serverTimezone=UTC&characterEncoding=UTF-8
  <br>
  jdbc:[사용하는 데이터베이스]://주소:포트/데이터베이스명
  <br>
- spring.datasource.username=root
  <br>
  데이터베이스에서 설정한 username
- spring.datasource.password=anstkddn991011!A
  <br>
  데이터베이스에서 설정한 비밀번호
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  <br>
  사용하는 데이터베이스 드라이버

  위 설정 후, 데이터 베이스와 연동됩니다.

## Entity
테이블을 불러올 엔티티를 선언합니다. <br>
- @Entity, @Table 애노테이션을 통해 데이터베이스와 매칭시킬 수 있습니다. <br>
- @Table에는 매칭시킬 Table명을 지정해야 합니다.

## Controller
- /init : 창세기 1장을 불러옵니다.
- /verse : 권, 장, 절을 통해 특정 말씀을 불러옵니다.
- /chapter : 권, 장을 통해 특정 장에 해당하는 모든 말씀을 불러옵니다.
- /today : 오늘의 말씀을 모두 불러옵니다.

### Scheduler
- /range : 권과 장 그리고 절 범위를 받아와 오늘의 말씀에 등록합니다.
- /range/chatper ; 권과 장 범위를 받아와 오늘의 말씀에 등록합니다.

## Repository
JPA를 사용해 데이터베이스에 있는 데이터를 읽습니다. 읽기만 가능합니다(성경을 바꾸지 않기 때문).

## Service
- getBibleDetailsInfo : 몇 절인지를 통해 특정 성경 말씀을 찾습니다.
- getBibleChapterList : 몇 장인지를 통해 성경 말씀을 찾습니다.
- setBibleRange : 특정 절 범위에 대한 성경 말씀을 찾습니다.
- setBibleRangeByChatper : 특정 장 점위에 대한 성경 말씀을 찾습니다.
- getBiblesRequestRange : 오늘의 성경 말씀을 불러옵니다.

## Storage
- getTodayBibleWords : 오늘의 성경 말씀을 제공합니다.
- updateTodayBibleWords : 오늘의 성경 말씀을 등록합니다.
