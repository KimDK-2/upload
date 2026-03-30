package com.kdh.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Human {
    // 결과에서 물 쓸지? or db
    private String name;
    private int age;

}
