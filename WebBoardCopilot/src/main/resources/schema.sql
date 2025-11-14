-- User 테이블
CREATE TABLE IF NOT EXISTS user (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '사용자 고유 ID',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '로그인 ID',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호 (해시값)',
    nickname VARCHAR(50) NOT NULL COMMENT '닉네임',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '가입일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자 정보 테이블';

-- Post 테이블
CREATE TABLE IF NOT EXISTS post (
    post_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '게시글 고유 ID',
    user_id BIGINT NOT NULL COMMENT '작성자 user_id',
    title VARCHAR(150) NOT NULL COMMENT '게시글 제목',
    content TEXT NOT NULL COMMENT '게시글 내용',
    view_count INT DEFAULT 0 COMMENT '조회수',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    CONSTRAINT fk_post_user
        FOREIGN KEY (user_id) 
        REFERENCES user (user_id) 
        ON DELETE CASCADE,
    INDEX idx_post_title (title),
    INDEX idx_post_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시글 정보 테이블';

-- Comment 테이블
CREATE TABLE IF NOT EXISTS comment (
    comment_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '댓글 고유 ID',
    post_id BIGINT NOT NULL COMMENT '게시글 ID',
    user_id BIGINT NOT NULL COMMENT '댓글 작성자 user_id',
    content VARCHAR(500) NOT NULL COMMENT '댓글 내용',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    CONSTRAINT fk_comment_post
        FOREIGN KEY (post_id) 
        REFERENCES post (post_id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_comment_user
        FOREIGN KEY (user_id) 
        REFERENCES user (user_id) 
        ON DELETE CASCADE,
    INDEX idx_comment_post_id (post_id),
    INDEX idx_comment_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='댓글 정보 테이블';
