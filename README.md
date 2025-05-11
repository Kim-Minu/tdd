## 도메인 모델 설계
├── domain
│   ├── model
│   │   └── Transaction.java
│   ├── port
│   │   └── TransactionRepositoryPort.java   // 포트
│   └── service
│       └── TransactionSearchService.java    // 유스케이스
│
├── adapter
│   ├── in
│   │   └── web
│   │       └── TransactionController.java    // 웹 어댑터
│   └── out
│       └── persistence
│           ├── TransactionJpaEntity.java
│           ├── TransactionJpaRepository.java
│           └── TransactionRepositoryAdapter.java  // 아웃 어댑터
│
└── Application.java

## 아키텍처
Domain (Core) -> 비즈니스 로직의 심장부. 외부에 전혀 의존하지 않음
Port (Interface) -> 외부에 기대하는 동작 명세. ex) Repository, 외부 API 호출
Adapter (Implementation) -> 실제 구현. 예: JPA, REST, Kafka 등
Application Service -> 도메인 로직을 조합해서 유스케이스 구현
Web Adapter HTTP API -> (Spring MVC Controller 등)