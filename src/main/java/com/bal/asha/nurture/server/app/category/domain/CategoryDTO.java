package com.bal.asha.nurture.server.app.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {


        private int categoryId;
        private String CategoryName;
        

}
