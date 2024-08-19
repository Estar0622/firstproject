package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {

        // 입력 데이터 준비
        Long articleId = 5L;

        // 실제 수행
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // 예상하기
        Article article = new Article(5L, "당신의 인생영화", "댓글 ㄱ");
        Comment a = new Comment(1L, article, "이순신", "해리포터");
        Comment b = new Comment(2L, article, "이 도", "기생충");
        Comment c = new Comment(3L, article, "장영실", "최애의 아이");
        List<Comment> expected = Arrays.asList(a, b, c);

        // 검증
        assertEquals(expected.toString(), comments.toString(), "4번글의 모든 댓글을 출력!");
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회") void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회 */
        {
            // 준비
            String nickname = "장영실";
            // 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 예상
            Comment a = new Comment(3L, new Article(5L, "당신의 인생영화", "댓글 ㄱ"), nickname, "최애의 아이");
            Comment b = new Comment(6L, new Article(6L, "당신의 인생음식", "댓긁ㄱ"), nickname, "나시고랭");
            Comment c = new Comment(9L, new Article(7L, "당신의 취미", "댓긁ㄱㄱ"), nickname, "축구");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력!");
        }
    }
}
