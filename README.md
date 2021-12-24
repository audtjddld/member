# 실행방법

1. 환경

> jdk 11

3. 빌드

> ./gradlew build

2. 실행

> java -jar ./build/libs/cloud-application.jar

# API 명세

> http://localhost:8080/docs/index.html

위 링크로 확인하실 수 있습니다.

# 요구사항

아래 요구사항 명세의 링크는 위에 애플리케이션 구동 후 연결되어 있는 링크로 이동하시면 API 스펙을 확인할 수 있습니다.

## 회원 가입

### 전화번호 인증 후 가입

> [전화번호인증](http://localhost:8080/docs/index.html#_%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8_%EC%9D%B8%EC%A6%9D_%EC%9A%94%EC%B2%AD)

전화번호 인증은 입력받은 전화번호에 6자리의 난수를 발행하고, 그 내역을 입력했을 때 조회 되면 개인 정보 인증되었다고 판단하는 시나리오 입니다.

## 로그인기능

> 이메일 , 패스워드 입력으로 로그인, 토큰은 Jwt 토큰으로 발행. (spring security 미사용)

## 내 정보 보기

> [내 정보 보기](http://localhost:8080/docs/index.html#_%ED%94%84%EB%A1%9C%ED%8C%8C%EC%9D%BC) 발급된 토큰으로 profile 조회시 id인증을 하고 일치하면 회원 내역을 리턴 함.

## 비밀번호 재설정

> 전화번호 인증 API 호출 후 인증완료 되면 비밀번호 변경으로 재설정 하는 시나리오 입니다. [비밀번호 재설정](http://localhost:8080/docs/index.html#_%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8_%EB%B3%80%EA%B2%BD)

## API 테스트 방법은 첨부된 `rest-api-test.http` 파일을 인텔리제이에서 열고 호출하면 간단하게 테스트 할 수 있습니다.
