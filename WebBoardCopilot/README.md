# Web Board - Spring Boot 게시판

Spring Boot 3.x, MyBatis, Thymeleaf를 이용한 웹 게시판 애플리케이션입니다.

## 프로젝트 정보

- **언어**: Java 21
- **프레임워크**: Spring Boot 3.3.4
- **빌드 도구**: Gradle
- **ORM**: MyBatis
- **템플릿 엔진**: Thymeleaf
- **데이터베이스**: MariaDB 11.4
- **보안**: Spring Security (BCrypt 패스워드 인코딩)

## 기능

### 1. 회원관리 (User)
- ✅ 회원가입 (username, password, nickname)
- ✅ 로그인 (BCrypt 해시 기반)
- ✅ 마이페이지 조회
- ✅ 로그아웃

### 2. 게시글 관리 (Post)
- ✅ 게시글 작성 (CREATE)
- ✅ 게시글 목록 조회 (READ) - 페이지네이션 지원
- ✅ 게시글 상세 조회 (READ) - 조회수 자동 증가
- ✅ 게시글 수정 (UPDATE) - 작성자만 가능
- ✅ 게시글 삭제 (DELETE) - 작성자만 가능

### 3. 댓글 관리 (Comment)
- ✅ 댓글 작성 (CREATE)
- ✅ 댓글 목록 조회 (READ)
- ✅ 댓글 수정 (UPDATE) - 작성자만 가능
- ✅ 댓글 삭제 (DELETE) - 작성자만 가능

## 데이터베이스 스키마

### user 테이블
```sql
CREATE TABLE user (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### post 테이블
```sql
CREATE TABLE post (
    post_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    title VARCHAR(150) NOT NULL,
    content TEXT NOT NULL,
    view_count INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### comment 테이블
```sql
CREATE TABLE comment (
    comment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content VARCHAR(500) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES post (post_id) ON DELETE CASCADE,
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

## 프로젝트 구조

```
WebBoardCopilot/
├── src/main/java/com/webboard/
│   ├── WebBoardApplication.java        # 메인 애플리케이션
│   ├── controller/                      # 컨트롤러
│   │   ├── HomeController.java
│   │   ├── UserController.java
│   │   ├── PostController.java
│   │   └── CommentController.java
│   ├── service/                         # 비즈니스 로직
│   │   ├── UserService.java
│   │   ├── PostService.java
│   │   └── CommentService.java
│   ├── mapper/                          # MyBatis 매퍼 인터페이스
│   │   ├── UserMapper.java
│   │   ├── PostMapper.java
│   │   └── CommentMapper.java
│   ├── model/                           # 도메인 모델
│   │   ├── User.java
│   │   ├── Post.java
│   │   └── Comment.java
│   └── config/                          # 설정
│       ├── SecurityConfig.java          # Spring Security 설정
│       └── MyBatisConfig.java           # MyBatis 설정
├── src/main/resources/
│   ├── templates/                       # Thymeleaf 템플릿
│   │   ├── index.html                  # 홈페이지
│   │   ├── user/
│   │   │   ├── register.html            # 회원가입
│   │   │   ├── login.html               # 로그인
│   │   │   └── mypage.html              # 마이페이지
│   │   ├── post/
│   │   │   ├── list.html                # 게시글 목록
│   │   │   ├── write.html               # 게시글 작성
│   │   │   ├── detail.html              # 게시글 상세
│   │   │   └── edit.html                # 게시글 수정
│   │   └── layout/
│   │       └── base.html                # 레이아웃 템플릿
│   ├── mappers/                         # MyBatis XML 매퍼
│   │   ├── UserMapper.xml
│   │   ├── PostMapper.xml
│   │   └── CommentMapper.xml
│   └── application.yml                  # 애플리케이션 설정
├── build.gradle                         # Gradle 빌드 설정
└── README.md                            # 이 파일
```

## 설치 및 실행

### 1. 사전 요구사항
- Java 21 이상
- MariaDB 11.4 이상 (또는 MySQL 8.0+)
- Gradle (또는 ./gradlew 사용)

### 2. MariaDB 설정

MariaDB 또는 MySQL이 설치되어 있고 실행 중인지 확인합니다.

```bash
# MariaDB/MySQL 접속
mysql -u root -p

# 데이터베이스 생성
CREATE DATABASE test;
USE test;
```

**주의**: `application.yml`에서 설정한 비밀번호(`!@test1234`)와 일치해야 합니다.

### 3. 프로젝트 설정

#### Windows (PowerShell)
```powershell
cd c:\Workspace\Java_Workspace\WebBoardCopilot
```

#### Mac/Linux
```bash
cd ~/path/to/WebBoardCopilot
```

### 4. 빌드

```bash
# Windows
.\gradlew.bat clean build -x test

# Mac/Linux
./gradlew clean build -x test
```

### 5. 애플리케이션 실행

#### IDE에서 실행 (권장)
- IDE에서 `WebBoardApplication.java` 우클릭 → `Run` 선택

#### 커맨드라인에서 실행
```bash
# Windows
.\gradlew.bat bootRun

# Mac/Linux
./gradlew bootRun
```

#### JAR 파일로 실행
```bash
java -jar build/libs/webboard-0.0.1-SNAPSHOT.jar
```

### 6. 애플리케이션 접속

브라우저에서 다음 주소로 접속합니다:
```
http://localhost:8080
```

### 7. 테스트 계정

자동으로 생성되는 테스트 계정:
- **Username**: admin
- **Password**: admin123 (schema.sql에서 설정)

> **💡 팁**: 첫 실행 시 `schema.sql`이 자동 실행되어 데이터베이스 테이블이 생성됩니다.

## 주요 기술

### Spring Security
- BCrypt를 이용한 비밀번호 암호화
- 세션 기반 인증
- CSRF 보호 비활성화 (개발 목적)

### MyBatis
- SQL 기반의 데이터 접근
- 동적 SQL 지원
- 결과 맵핑 (ResultMap)

### Thymeleaf
- 자동 HTML 이스케이핑
- 스프링 통합
- 폼 처리

## API 엔드포인트

### 사용자 관련
- `GET /` - 홈페이지
- `GET /user/register` - 회원가입 페이지
- `POST /user/register` - 회원가입 처리
- `GET /user/login` - 로그인 페이지
- `POST /user/login` - 로그인 처리
- `GET /user/mypage` - 마이페이지
- `GET /user/logout` - 로그아웃

### 게시글 관련
- `GET /post/list` - 게시글 목록 (페이지네이션)
- `GET /post/write` - 게시글 작성 페이지
- `POST /post/write` - 게시글 작성 처리
- `GET /post/detail/{postId}` - 게시글 상세
- `GET /post/edit/{postId}` - 게시글 수정 페이지
- `POST /post/edit/{postId}` - 게시글 수정 처리
- `POST /post/delete/{postId}` - 게시글 삭제

### 댓글 관련
- `POST /comment/write` - 댓글 작성
- `POST /comment/edit/{commentId}` - 댓글 수정
- `POST /comment/delete/{commentId}` - 댓글 삭제

## 참고사항

- 페이지네이션: 게시글 목록은 10개 단위로 페이지네이션됩니다
- 권한 관리: 게시글과 댓글은 작성자만 수정/삭제 가능합니다
- 조회수: 게시글 상세 조회 시 자동으로 조회수가 증가합니다
- 비밀번호: BCrypt를 이용하여 암호화되어 저장됩니다

## 트러블슈팅

### localhost 접속이 안 되는 경우

1. **MariaDB/MySQL 실행 확인**
   ```bash
   # Windows
   mysql -u root -p
   
   # 데이터베이스 존재 확인
   SHOW DATABASES;
   ```

2. **포트 충돌 확인**
   ```bash
   # Windows - 8080 포트 사용 중인 프로세스 확인
   netstat -ano | findstr :8080
   
   # 필요시 application.yml에서 포트 변경
   server:
     port: 9090  # 다른 포트로 변경
   ```

3. **로그 확인**
   - 콘솔 출력에서 에러 메시지 확인
   - "Tomcat started on port 8080" 메시지 확인 (정상 시작)

4. **데이터베이스 연결 오류**
   - `application.yml` 설정 확인
   - MariaDB 사용자명/비밀번호 확인
   - `test` 데이터베이스 존재 확인

### "Table 'test.user' doesn't exist" 오류

schema.sql이 자동 실행되지 않은 경우:
```bash
# MariaDB에서 수동으로 실행
mysql -u root -p < src/main/resources/schema.sql
```

### 빌드 실패

```bash
# 캐시 제거 후 재빌드
./gradlew clean build -x test --refresh-dependencies
```

### Spring Boot 시작 실패

콘솔 로그에서 다음 항목 확인:
- Java 버전 (21 이상 필요)
- MariaDB 연결 상태
- 포트 사용 가능 여부
