package com.webboard.controller;

import com.webboard.model.User;
import com.webboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입 페이지
    @GetMapping("/register")
    public String registerPage() {
        return "user/register";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String register(@RequestParam String username, 
                          @RequestParam String password,
                          @RequestParam String nickname,
                          Model model) {
        try {
            User user = User.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .build();
            userService.register(user);
            model.addAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/user/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "user/register";
        }
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    // 로그인 처리 (Spring Security가 처리)
    @PostMapping("/login")
    public String login(@RequestParam String username,
                       @RequestParam String password,
                       HttpSession session,
                       Model model) {
        try {
            User user = userService.login(username, password);
            session.setAttribute("user", user);
            return "redirect:/post/list";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "user/login";
        }
    }

    // 마이페이지
    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            user = userService.getUserById(user.getUserId());
            model.addAttribute("user", user);
        }
        return "user/mypage";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
