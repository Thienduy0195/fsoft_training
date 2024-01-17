package com.java.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.ContentDTO;
import com.java.model.Member;
import com.java.service.ContentServiceImpl;
import com.java.service.IContentService;
import com.java.service.IMemberService;
import com.java.service.MemberServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

  IMemberService memberService;

  IContentService contentService;

  public UserController(MemberServiceImpl memberService,
      ContentServiceImpl contentService) {
    this.memberService = memberService;
    this.contentService = contentService;
  }

  @GetMapping("")
  public String goFormEdit(@SessionAttribute("user") Member member,
      Model model) {
    model.addAttribute("member", member);
    return "edit-profile";
  }

  @PostMapping("")
  public String editSession(@ModelAttribute("member") Member member,
      Model model, HttpSession session) {
    model.addAttribute("member", memberService.editMember(member, session));
    return "edit-profile";
  }

  @PostMapping("/content")
  public String addContent(
      @Valid @ModelAttribute("content") ContentDTO contentDTO,
      BindingResult result, @SessionAttribute("user") Member member,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return "add-content";
    }
    contentService.saveContent(contentDTO, member);
    return "redirect:/user/listContent";
  }

  @GetMapping("form")
  public String addContentForm(Model model) {
    model.addAttribute("content", new ContentDTO());
    return "add-content";
  }

  @GetMapping("/edit/{id}")
  public String editFormContent(@PathVariable Long id, Model model) {
    model.addAttribute("content", new ContentDTO(contentService.findById(id)));
    return "add-content";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id, Model model,
      @SessionAttribute("user") Member member) {
    contentService.deleteById(id);
    return "redirect:/user/listContent";
  }

  @GetMapping("listContent")
  public String getListContent(Model model,
      @SessionAttribute("user") Member member) {
    model.addAttribute("contents", contentService.findAllByTitle("", member));
    return "list-content";
  }

  @GetMapping("/search")
  public String searchForm(Model model, @RequestParam("title") String title,
      @SessionAttribute("user") Member member) {
    model.addAttribute("contents",
        contentService.findAllByTitle(title, member));
    return "list-content";
  }
}
