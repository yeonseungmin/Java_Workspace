package com.webboard.service;

import com.webboard.model.Post;
import com.webboard.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    private static final int POSTS_PER_PAGE = 10;

    // 게시글 생성
    public void createPost(Post post) {
        postMapper.insertPost(post);
    }

    // 게시글 목록 조회
    public List<Post> getPostList(int page) {
        int offset = (page - 1) * POSTS_PER_PAGE;
        return postMapper.selectPostList(offset, POSTS_PER_PAGE);
    }

    // 전체 게시글 개수
    public int getTotalPostCount() {
        return postMapper.countPosts();
    }

    // 게시글 상세 조회
    public Post getPostById(Long postId) {
        // 조회수 증가
        postMapper.increaseViewCount(postId);
        return postMapper.selectPostById(postId);
    }

    // 게시글 수정
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    // 게시글 삭제
    public void deletePost(Long postId) {
        postMapper.deletePost(postId);
    }

    // 사용자별 게시글 목록
    public List<Post> getPostsByUserId(Long userId) {
        return postMapper.selectPostsByUserId(userId);
    }

    // 페이지 개수 계산
    public int getTotalPages() {
        int count = getTotalPostCount();
        return (count + POSTS_PER_PAGE - 1) / POSTS_PER_PAGE;
    }
}
