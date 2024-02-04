package com.bal.asha.nurture.server.app.workitem.domain;

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
public class WorkitemDTO {


        private int workitemId;
        private String workitemName;
        
        

}
