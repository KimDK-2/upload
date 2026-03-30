package com.kdh.board.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
    // 결과 뭐? or DB table
       private int no;
       private String title;
       private String actor;
       private String img;
       private String story;


}
