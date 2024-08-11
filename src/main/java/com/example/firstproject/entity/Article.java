package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Article {


    @Id // PK값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 어노테이션
    private Long ID;

    @Column
    private String Title;
    @Column
    private String Content;


    public void patch(Article article) {
        if (article.Title != null)
            this.Title = article.Title;
        if (article.Content != null)
            this.Content = article.Content;
    }
}


