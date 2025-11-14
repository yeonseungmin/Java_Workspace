package com.webboard.controller;

import com.webboard.model.Post;
import com.webboard.model.User;
import com.webboard.service.PostService;
import com.webboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    // 게시글 목록
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Post> posts = postService.getPostList(page);
        int totalPages = postService.getTotalPages();
        
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        
        return "post/list";
    }

    // 게시글 작성 페이지
    @GetMapping("/write")
    public String writePage() {
        return "post/write";
    }

    // 게시글 작성 처리
    @PostMapping("/write")
    public String write(@RequestParam String title,
                       @RequestParam String content,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/login";
        }

        try {
            Post post = Post.builder()
                    .userId(user.getUserId())
                    .title(title)
                    .content(content)
                    .build();
            postService.createPost(post);
            return "redirect:/post/list";
        } catch (Exception e) {
            model.addAttribute("error", "게시글 작성에 실패했습니다.");
            return "post/write";
        }
    }

    // 게시글 상세 조회
    @GetMapping("/detail/{postId}")
    public String detail(@PathVariable Long postId, Model model, HttpSession session) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        
        // 댓글 목록 조회
        var comments = commentService.getCommentsByPostId(postId);
        model.addAttribute("comments", comments);
        
        // 현재 로그인 사용자 정보
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("loginUser", user);
        }
        
        return "post/detail";
    }

    // 게시글 수정 페이지
    @GetMapping("/edit/{postId}")
    public String editPage(@PathVariable Long postId, Model model, HttpSession session) {
        Post post = postService.getPostById(postId);
        User user = (User) session.getAttribute("user");
        
        if (user == null || !post.getUserId().equals(user.getUserId())) {
            return "redirect:/post/detail/" + postId;
        }
        
        model.addAttribute("post", post);
        return "post/edit";
    }

    // 게시글 수정 처리
    @PostMapping("/edit/{postId}")
    public String edit(@PathVariable Long postId,
                      @RequestParam String title,
                      @RequestParam String content,
                      HttpSession session,
                      Model model) {
        User user = (User) session.getAttribute("user");
        Post post = postService.getPostById(postId);
        
        if (user == null || !post.getUserId().equals(user.getUserId())) {
            model.addAttribute("error", "수정 권한이 없습니다.");
            return "redirect:/post/detail/" + postId;
        }

        try {
            post.setTitle(title);
            post.setContent(content);
            postService.updatePost(post);
            return "redirect:/post/detail/" + postId;
        } catch (Exception e) {
            model.addAttribute("error", "게시글 수정에 실패했습니다.");
            return "post/edit";
        }
    }

    // 게시글 삭제
    @PostMapping("/delete/{postId}")
    public String delete(@PathVariable Long postId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Post post = postService.getPostById(postId);
        
        if (user == null || !post.getUserId().equals(user.getUserId())) {
            model.addAttribute("error", "삭제 권한이 없습니다.");
            return "redirect:/post/detail/" + postId;
        }

        try {
            postService.deletePost(postId);
            return "redirect:/post/list";
        } catch (Exception e) {
            model.addAttribute("error", "게시글 삭제에 실패했습니다.");
            return "redirect:/post/detail/" + postId;
        }
    }
}
