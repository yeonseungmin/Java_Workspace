package com.webboard.service;

import com.webboard.model.Comment;
import com.webboard.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    // 댓글 생성
    public void createComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    // 게시글별 댓글 목록
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }

    // 댓글 상세 조회
    public Comment getCommentById(Long commentId) {
        return commentMapper.selectCommentById(commentId);
    }

    // 댓글 수정
    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }

    // 사용자별 댓글 목록
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentMapper.selectCommentsByUserId(userId);
    }
}
