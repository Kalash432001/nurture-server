package com.bal.asha.nurture.server.app.vehicle.rest;

import com.bal.asha.nurture.server.app.vehicle.domain.User_Detail;
import com.bal.asha.nurture.server.app.vehicle.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User_Detail addUser( @RequestParam(name = "userName") String userName, @RequestParam(name = "idProofType") String idProofType,
                               @RequestParam(name = "idDtls") String idDtls, @RequestParam(name = "address") String address, @RequestParam(name = "mobileNo") int mobileNo, @RequestParam(name = "userType") String userType, @RequestParam(name = "createDate") LocalDate createDate) {


        User_Detail user=User_Detail.create(userName, idProofType, idDtls, address, mobileNo, userType, createDate);
        return userDetailService.save(user);
    }
    @GetMapping("/userd")
    @ResponseBody
    public String getFoos(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }
}


