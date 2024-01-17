package com.java.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.AccountDTO;
import com.java.dto.UserDTO;
import com.java.model.Member;
import com.java.service.IMemberService;
import com.java.service.MemberServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {

  IMemberService memberService;

  public MainController(MemberServiceImpl memberService) {
    this.memberService = memberService;
  }

  @GetMapping(value = { "login", "" })
  public String goLogin(Model model) {
    model.addAttribute("account", new AccountDTO());
    return "login";
  }

  @GetMapping("register")
  public String goRegister(Model model) {
    model.addAttribute("register", new UserDTO());
    return "register";
  }

  @GetMapping("logout")
  public String logout(HttpSession session, Model model) {
    session.setAttribute("user", null);
    return goLogin(model);
  }

  @PostMapping("login")
  public String login(@Valid @ModelAttribute("account") AccountDTO accountDTO,
      BindingResult result, Model model, HttpSession session) {

    accountDTO.validate(accountDTO, result);
    Member member = memberService.findByEmailAndPassword(accountDTO, session);

    if (result.hasErrors()) {
      model.addAttribute(accountDTO);
      return "login";
    }

    if (member == null) {
      model.addAttribute("message", "Email or password are  incorrect!!!");
      return "login";
    }
    return "redirect:/user/listContent";
  }

  @PostMapping("register")
  public String register(
      @Valid @ModelAttribute("register") UserDTO registerDTO,
      BindingResult result, Model model, HttpSession session) {
    System.out.println(result);
    if (!registerDTO.getPassword().equals(registerDTO.getRepassword())
        || result.hasErrors()) {
      model.addAttribute("error", "No match");
      return "register";
    }
    memberService.save(registerDTO, session);
    return "redirect:/user";
  }
}
