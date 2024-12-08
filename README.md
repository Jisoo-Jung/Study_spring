# 코리아 IT 아카데미 국비과정

## SPRING ⭐

#### Framework
```
라이브러리란, 개발자가 작성해 놓은 코드 파일을 의미하며,
API란, 여러 라이브러리가 모여있는 패키지(JAR)를 의미한다.
프레임워크란, API가 굉장히 많이 모여져서 덩치가 커져있는 것을 의미한다.
```
#### Framework의 장점
```
개발에 필요한 구조를 이미 코드로 만들어 놓았기 때문에, 실력이 부족한 개발자라 하더라도
반쯤 완성된 상태에서 필요한 부분을 조립하는 형태의 개발이 가능하다.
회사 입장에서는 프레임워크를 사용하면 일정한 품질이 보장되는 결과물을 얻을 수 있고,
개발자 입장에서는 완성된 구조에 자신이 맡은 서비스에 대한 코드를 개발해서 넣기 때문에
개발 시간을 단축할 수 있다.
```

#### Spring Framework
```
경량 프레임워크.
예전 프레임워크는 다양한 경우를 처리하기 위해 여러 기능을 넣다 보니
하나의 기능을 위해서 아주 많은 구조가 필요했다. 기술이 너무나 복잡하고
방대했기 때문에, 전체를 이해하고 개발하기에는 어려움이 많았다.
그래서 Spring Framework가 등장했고, 특정 기능을 위주로 간단한 JAR파일 등을
선택하여 모든 개발이 가능하도록 구성되어 있다.
```
#### Spring Framework 장점
```
- 프로젝트 전체 구조를 설계할 때 유용하다(빠른 속도로 서버 제작 가능)
- 다른 프레임워크들의 포용, 여러 프레임워크를 혼용해서 사용할 수 있기 때문에 접착성이 좋다.
- 개발 생산성과 개발도구의 지원
```
#### Spring Framework의 특징
```
- POJO 기반의 구성
- DI를 통한 객체간의 관계 구성
- AOP 지원
- Transaction 관리
- 편리한 MVC 구조
- WAS에 종속적이지 않은 개발 환경

▶ POJO 기반의 구성

	Plain Old Java Object.
	오래된 방식의 간단한 자바 객체라는 의미이며, JAVA 코드에서 일반적으로 객체를 구성하는 방식을
	Spring Framework에서 그대로 사용할 수 있다는 의미이다.

▶ DI를 통한 객체간의 관계 구성

	의존성(Dependency)이란 하나의 객체가 다른 객체 없이 제대로 된 역할을 할 수 없다는 것을 의미한다.
	예를 들어 A객체가 B객체 없이 동작이 불가능한 상황을 "A가 B에 의존적이다"라고 표현한다.
	하지만 직접 A필드에 B객체를 선언하면 결합도가 단단해지기 때문에 유연성이 떨어진다.

	주입(Injection)은 외부에서 내부로 밀어 넣는 것을 의미한다.
	필요한 객체를 외부에서 밀어 넣어 유연성을 높이고 결합도를 느슨하게 해준다.
	주입을 받는 입장에서는 어떤 객체인지 신경 쓸 필요가 없고 어떤 객체에 의존하든 자신의 역할은 변하지 않는다.

	***의존성
	A →→→→→→→→→→→→→ B
	A객체에서 B객체를 필드로 직접 생성

	***의존성 주입
	A ↔↔↔↔↔ ? ↔↔↔↔↔ B
	A는 B가 필요하다고 신호를 보내고, ?가 B객체를 외부에서 생성하여 주입하게 된다.
	Spring Framework에서는 ApplicationContext가 ?이며,
	필요한 객체들을 생성 및 주입해주는 역할을 한다. 따라서 개발자들은 기존의 프로그래밍과는 달리
	객체와 객체를 분리해서 생성하고, 이러한 객체를 엮는 wiring 작업의 형태로 개발하게 된다.

	ApplicationContext가 관리하는 객체들을 빈(Bean)이라 부르고,
	빈과 빈 사이의 의존 관계를 처리하는 방식으로는 XML, 어노테이션, JAVA 방식이 있다.

▶ AOP 지원

	관점 지향 프로그래밍.
	좋은 개발 환경에서는 개발자가 비지니스 로직에만 집중할 수 있게 한다.
	Spring Framework는 반복적인 코드를 분리해줌으로써 핵심 비지니스 로직에만
	집중할 수 있는 방법을 제공한다.
	보안이나 로그, 트랜잭션, 예외처리와 같이 비지니스 로직은 아니지만, 
	반드시 처리가 필요한 부분을 주변 로직(횡단 관심사)라고 하고, 개발해야할 서비스는 메인 로직(종단 관심사)라고 한다.
	Spring Framework는 이러한 횡단 관심사를 분리해서 설계하는 것이 가능하고, 횡단 관심사를 모듈로
	분리하는 프로그래밍을 AOP라고 한다.
	핵심 비지니스 로직에만 집중하여 코드 개발이 가능해지고, 각 프로젝트마다 다른 관심사 적용 시 코드 수정을
	최소화 할 수 있으며, 원하는 관심사의 유지보수가 수월한 코드로 구성이 가능해진다.
	※ 비지니스 로직: 서비스를 개발하기 위한 소스코드 및 알고리즘

▶ Transaction 관리

	DB 작업 시, 트랜잭션을 매번 상황에 맞게 관리하지 않고
	어노테이션을 사용하여 트랜잭션 영역을 구성한 뒤
	특정 예외 발생 시 자동으로 롤백을 처리하거나 커밋을 처리한다.

▶ WAS에 종속적이지 않은 개발 환경

	전체 Application을 실행하지 않아도 기능별 단위 테스트가 용이하기 때문에
	버그를 줄이고 개발 시간을 단축할 수 있다.
```
#### Spring Boot
```
Spring Framework를 사용함에 있어서 초기 설정 및 필요한 라이브러리에 대한 설정의 어려움이 많으며,
시간이 너무 오래 걸린다. 따라서 자동 설정과 개발에 필요한 모든 것을 관리해주는 Spring Boot를 선호한다.
각 코어 및 라이브러리의 버전들도 맞추어야 하지만 Spring Boot를 사용하면 이러한 복잡성을 해결하기에도 좋다.
```
#### 프로젝트 기본 경로
```
1) src/main/java			: 서버단 JAVA 파일
2) src/test/java			: 단위 테스트 JAVA 파일
3) src/main/resources		: 설정 파일 및 뷰단
4) src/main/resources/static		: css, js, image 등 정적 파일 경로
5) src/main/resources/templates	: html 파일 경로
6) build.gradle			: 라이브러리 관리
7) application.yml			: Spring의 모든 설정
```


#### Spring MVC(Front-Controller Pattern)
```	
						HandlerMaping
REQUEST		  ①	     		②↕	  	 ③		       		④
	]	  ↔	DispatcherServlet   ↔  HandlerAdapter   ↔  Controller
RESPONSE	⑦		 ⑥↕	     						⑤↕
					 View						ViewResolver
			   		   ↕
					HTML 및 기타
```
![spring_mvc](https://github.com/user-attachments/assets/47c78048-67ee-46e2-98d0-c0a577ffe4ca)

#### Spring MVC 패턴의 특징
```
	- HttpServletRequest, HttpServletResponse를 거의 사용할 필요 없이 구현 가능
	- 다양한 타입의 파라미터 처리, 다양한 타입의 리턴 타입 사용 가능
	- GET, POST 방식 등 전송 방식에 대한 처리를 어노테이션으로 처리 가능
	- 상속/인터페이스 방식 대신 어노테이션으로만 설정 가능
```
--------------------------------------------------------------
#### 3-tier
```
스프링 프로젝트는 3-tier 방식으로 설계된다.

▶ Presentation Tier - 화면 계층
		화면에 보여주는 기술을 사용하는 영역

▶ Buisiness Tier - 비지니스 계층, 로직 계층
		순수한 비지니스 로직을 담고 있는 영역

▶ Persistence Tier - 영속 계층, 데이터 계층
		데이터를 어떤 방식으로 보관하고, 사용하는가에 대한 설계가 들어가는 영역
```
**3-tier의 목적**
```
각 영역은 독립적으로 설계되어
나중에 특정 기술이 변하더라도 필요한 부분을 전자제품의 부품처럼 쉽게 교환할 수 있게 하자는 방식이다.
```
**3-tier의 구조**
```
Presentation ↔ Business ↔ Persistence ↔ DBMS
	↑             ↑       ↑            ↑
Controller       Service    Repository       Mapper
```
	
