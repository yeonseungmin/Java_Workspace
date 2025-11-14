package com.webboard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private Long commentId;
    private Long postId;
    private Long userId;
    private String content;
    private String createdAt;
    private String updatedAt;
    private String authorName;  // Join을 위한 필드
}
