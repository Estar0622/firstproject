package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        // System.out.println(form.toString()); -> 로깅으로 대체
        log.info(form.toString());

        // 1. Dto를 변환 entity로
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository 에게 Entity 를 db안에 저장하게 함.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getID();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id =" + id);

        // 1. id로 DB에서 데이터를 가져옴!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);
        // 2. 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        model.addAttribute("commenDtos", commentDtos);
        // 3. 보여줄 페이지를 설정!
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        // List는 리스트 형태로 받으려고 하는 것. findAll()은 레포지토리에 있는 거 모든 걸 가져오는 것
        // 2. 가져온 Article 묶음을 뷰로 전달한다.
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지를 설정한다.
        return "articles/index"; // articles/index.mustache
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터를 등록!
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        //1. DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();

        //2. 엔티티를 DB로 저장
        //2-1. DB에서 기존 데이터를 가져온다.
        Article target = articleRepository.findById(articleEntity.getID()).orElse(null);
        //2-2. 기존데이터가 있다면 값을 갱신한다.
        if (target != null) {
            articleRepository.save(articleEntity); //엔티티가 db로 갱신됨.
        }

        //3. 수정 결과 페이지로 리다이렉트 한다.
        return "redirect:/articles/" + articleEntity.getID();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제요청이 들어왔습니다!");
        //1. 삭제 대상을 가져온다.
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "회원삭제가 완료되었습니다");
        }
        //2. 대상을 삭제한다.

        //3. 결과 페이지를 보여준다.
        return "redirect:/articles";

    }
}



