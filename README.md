```src/
└── main/
    ├── java/
    │   └── com/
    │       └── yourname/
    │           └── discordbot/
    │               ├── DiscordBotApplication.java      # 메인 클래스
    │               │
    │               ├── config/                         # JDA, Spring 설정
    │               │   ├── JdaConfig.java              # JDA 인스턴스 초기화
    │               │   └── BotProperties.java          # 토큰 등 환경 변수 바인딩
    │               │
    │               ├── listener/                       # 이벤트 리스너들
    │               │   ├── ReadyEventListener.java
    │               │   └── MessageEventListener.java
    │               │
    │               ├── command/                        # 명령어 관련 처리
    │               │   ├── CommandHandler.java         # 커맨드 분배기
    │               │   ├── Command.java                # 인터페이스 or 추상 클래스
    │               │   ├── PingCommand.java
    │               │   └── HelpCommand.java
    │               │
    │               ├── service/                        # 비즈니스 로직
    │               │   └── UserService.java
    │               │
    │               ├── domain/                         # 엔티티, DTO, DB 모델 등
    │               │   ├── User.java
    │               │   └── CommandLog.java
    │               │
    │               └── repository/                     # DB 레포지토리
    │                   └── UserRepository.java
    │
    └── resources/
        ├── application.yml                             # 환경 설정
        └── logback-spring.xml                          # 로깅 설정 (선택)
```
