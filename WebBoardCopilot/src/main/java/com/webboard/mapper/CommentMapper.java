package com.webboard.mapper;

import com.webboard.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 댓글 생성
    void insertComment(Comment comment);
    
    // 게시글별 댓글 목록
    List<Comment> selectCommentsByPostId(@Param("postId") Long postId);
    
    // 댓글 상세 조회
    Comment selectCommentById(@Param("commentId") Long commentId);
    
    // 댓글 수정
    void updateComment(Comment comment);
    
    // 댓글 삭제
    void deleteComment(@Param("commentId") Long commentId);
    
    // 사용자별 댓글 목록
    List<Comment> selectCommentsByUserId(@Param("userId") Long userId);
}
