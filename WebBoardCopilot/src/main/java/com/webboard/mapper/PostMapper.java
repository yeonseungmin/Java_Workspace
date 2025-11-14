package com.webboard.mapper;

import com.webboard.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    // 게시글 생성
    void insertPost(Post post);
    
    // 게시글 목록 조회 (페이지네이션)
    List<Post> selectPostList(@Param("offset") int offset, @Param("limit") int limit);
    
    // 전체 게시글 개수
    int countPosts();
    
    // 게시글 상세 조회
    Post selectPostById(@Param("postId") Long postId);
    
    // 게시글 수정
    void updatePost(Post post);
    
    // 게시글 삭제
    void deletePost(@Param("postId") Long postId);
    
    // 조회수 증가
    void increaseViewCount(@Param("postId") Long postId);
    
    // 사용자별 게시글 목록
    List<Post> selectPostsByUserId(@Param("userId") Long userId);
}
