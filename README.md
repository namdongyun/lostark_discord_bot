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

```
🔧 실행 흐름 예시
1. DiscordBotApplication 실행 시, JdaConfig를 통해 JDA 인스턴스 초기화
2. @Component로 등록된 리스너 클래스들 (ReadyEventListener, MessageEventListener 등)이 JDA에 등록됨
3. 메시지 수신 → MessageEventListener에서 감지
4. CommandHandler에서 메시지를 분석하여 명령어 실행
5. 각 명령어 클래스(PingCommand, HelpCommand)에서 해당 기능 수행
6. 필요 시 service 또는 repository 레이어를 통해 DB 연동
```
