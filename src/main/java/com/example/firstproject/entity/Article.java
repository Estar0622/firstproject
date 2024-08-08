package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue // 자동생성 어노테이션
    private Long ID;

    @Column
    private String Title;
    @Column
    private String Content;

}


