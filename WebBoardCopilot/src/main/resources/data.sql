-- 테스트용 샘플 데이터
INSERT IGNORE INTO user (user_id, username, password, nickname) VALUES 
(1, 'admin', '$2a$10$lN7eNfhxr8l5T1C.L.eCdeyC0bxh5yUz8Nj7YxCT.rIpLODdEPFmy', 'Admin User');

INSERT IGNORE INTO post (post_id, user_id, title, content, view_count) VALUES 
(1, 1, '첫 번째 게시글입니다', '환영합니다! 이것은 테스트 게시글입니다.', 5);

INSERT IGNORE INTO comment (comment_id, post_id, user_id, content) VALUES 
(1, 1, 1, '좋은 게시글입니다!');
