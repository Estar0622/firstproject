package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Test
    void index() {

        // 예상
        Article a = new Article(1L, "김동규","삼성전자 DX 사업부");
        Article b = new Article(2L, "이솔비","백석예술대학교");
        Article c = new Article(3L, "김동휘","토스 뱅크 개발부");
        Article d = new Article(4L, "유더미","한성대학교");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c,d));
        // 실제
        List<Article> articles = articleService.index();
        // 예상과 실제를 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공__존재하는id입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id, "김동규", "삼성전자 DX 사업부");
        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected.toString(), article.toString());


    }

    @Test
    void show_실패_존재하지않는ID_입력() {
        //예상
        Long id = 2L;
        Article expected = null;
        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected, article);
    }
}