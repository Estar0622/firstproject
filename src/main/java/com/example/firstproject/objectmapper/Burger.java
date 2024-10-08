package com.example.firstproject.objectmapper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class Burger {

    private String name;
    private int price;
    private List<String> ingredients;
}
