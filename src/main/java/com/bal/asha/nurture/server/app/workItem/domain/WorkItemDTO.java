package com.bal.asha.nurture.server.app.workItem.domain;

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
public class WorkItemDTO {


        private int workItemId;
        private String workItemName;
        
        

}
