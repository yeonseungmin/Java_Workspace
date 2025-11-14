package com.webboard.controller;

import com.webboard.model.Comment;
import com.webboard.model.User;
import com.webboard.service.CommentService;
import com.webboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 작성
    @PostMapping("/write")
    public String write(@RequestParam Long postId,
                       @RequestParam String content,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/login";
        }

        try {
            Comment comment = Comment.builder()
                    .postId(postId)
                    .userId(user.getUserId())
                    .content(content)
                    .build();
            commentService.createComment(comment);
            return "redirect:/post/detail/" + postId;
        } catch (Exception e) {
            model.addAttribute("error", "댓글 작성에 실패했습니다.");
            return "redirect:/post/detail/" + postId;
        }
    }

    // 댓글 수정
    @PostMapping("/edit/{commentId}")
    public String edit(@PathVariable Long commentId,
                      @RequestParam String content,
                      HttpSession session,
                      Model model) {
        User user = (User) session.getAttribute("user");
        Comment comment = commentService.getCommentById(commentId);
        
        if (user == null || !comment.getUserId().equals(user.getUserId())) {
            model.addAttribute("error", "수정 권한이 없습니다.");
            return "redirect:/post/detail/" + comment.getPostId();
        }

        try {
            comment.setContent(content);
            commentService.updateComment(comment);
            return "redirect:/post/detail/" + comment.getPostId();
        } catch (Exception e) {
            model.addAttribute("error", "댓글 수정에 실패했습니다.");
            return "redirect:/post/detail/" + comment.getPostId();
        }
    }

    // 댓글 삭제
    @PostMapping("/delete/{commentId}")
    public String delete(@PathVariable Long commentId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Comment comment = commentService.getCommentById(commentId);
        
        if (user == null || !comment.getUserId().equals(user.getUserId())) {
            model.addAttribute("error", "삭제 권한이 없습니다.");
            return "redirect:/post/detail/" + comment.getPostId();
        }

        try {
            Long postId = comment.getPostId();
            commentService.deleteComment(commentId);
            return "redirect:/post/detail/" + postId;
        } catch (Exception e) {
            model.addAttribute("error", "댓글 삭제에 실패했습니다.");
            return "redirect:/post/detail/" + comment.getPostId();
        }
    }
}
