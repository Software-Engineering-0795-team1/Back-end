# 팀과제5 보고서

# 1. 변경된 Class Diagram

---

![class diagram](https://github.com/Software-Engineering-0795-team1/Back-end/assets/129194613/d676b548-eb5b-41db-8f31-a410388542d6)

# 2. 변경사항

---

기존에 작성된 Class Diagram은 DDD(Domain-Driven Design) 도메인 주도 설계로 작성이 되었는데 MVC(Model-View-Controller)로 분리하여 새로 작성하였습니다. 

1. Facade 패턴
- 적용 위치: UserFacade 클래스
- 기존의 User클래스를 Facade 클래스를 만들어 다른 직군의 사용자들이 공통적인 작업에 대해 간편하게 메소드를 제공해주도록 적용하였습니다.

2. Strategy 패턴
- 적용위치: TegSearchStrategy 인터페이스 및 TagSearchStrategyFactory 클래스
- 기존의 Tag 클래스는 태그로 프로젝트나 채용정보를 검색할 수 있었는데 전략패턴(Strategy Pattern)을 적용하여 두 행위에 대해 전략 클래스를 생성하고 캡슐화 하는 인터페이스를 정의하여 적용하였습니다.

3. Observer 패턴
- 적용 위치: NotificationService 클래스 및 Observer 인터페이스
- LinkIT에서는 사용자가 채팅관련 알림 및 시스템 알림 그리고 개인쪽지 등을 받을 수 있는데 각각의 객체의 특정 이벤트가 발생 했을 때 마다 제공해주는 패턴을 적용하였습니다

4. Builder 패턴
- 적용 위치: UserBuilder 클래스
- 여러 직군의 사용자들이 많아 복잡한 객체의 생성을 각각에 직군에 맞게 생성되도록 기존 User class에서 적용 하였습니다.
