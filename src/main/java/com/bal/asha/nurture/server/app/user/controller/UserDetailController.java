package com.bal.asha.nurture.server.app.user.controller;

import com.bal.asha.nurture.server.app.user.table.UserDetail;
import com.bal.asha.nurture.server.app.user.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class UserDetailController {


    private UserDetailService userDetailService;


    //http://localhost:8080/user?userId=1&userName=John&idProofType=Passport&idDtls=AB12345&address=123 Main St&mobileNo=1234567890&userType=Customer&createDate=2023-11-02
    @GetMapping("/user")
    @ResponseBody
    public UserDetail addUser(@RequestParam(name = "userName") String userName, @RequestParam(name = "idProofType") String idProofType,
                              @RequestParam(name = "idDtls") String idDtls, @RequestParam(name = "address") String address, @RequestParam(name = "mobileNo") int mobileNo, @RequestParam(name = "userType") String userType, @RequestParam(name = "createDate") LocalDate createDate) {


        UserDetail user= UserDetail.create(userName, idProofType, idDtls, address, mobileNo, userType, createDate);
        return userDetailService.save(user);
    }

}


