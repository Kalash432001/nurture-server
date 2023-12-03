package com.bal.asha.nurture.server.app.user.controller;

import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import com.bal.asha.nurture.server.app.user.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
@CrossOrigin
public class UserDetailController {

    private UserDetailService userDetailService;

    //http://localhost:8080/user?userId=1&userName=John&idProofType=Passport&idDtls=AB12345&address=123 Main St&mobileNo=1234567890&userType=Customer&createDate=2023-11-02
    @PostMapping("/user")
    @ResponseBody
    public UserDetailDTO addUser(@RequestBody UserDetailDTO userDetailDTO){
//        UserDetail user= UserDetail.create(userName, idProofType, idDtls, address, mobileNo, userType, createDate);
        UserDetail user = UserDetail.toUserDetail(userDetailDTO);

        return UserDetail.toUserDetailDTO(userDetailService.save(user));
    }

    @GetMapping("/get-users")
    public Set<UserDetailDTO> getAllUsers(){

        return UserDetail.toUserDetailDTO(userDetailService.getAllUserRecord());
    }

//    @PostMapping("/update-user")
//    public Set<UserDetailDTO> updateUser(@RequestBody UserDetailDTO userDetailDTO){
//        UserDetail user = UserDetail.toUserDetail(userDetailDTO);
//        return UserDetail.toUserDetailDTO(userDetailService.update(user));
//    }
    @CrossOrigin
    @PutMapping ("/update-user")
    public UserDetailDTO updateUser(@RequestBody UserDetailDTO userDetailDTO) {
        UserDetail user = UserDetail.toUserDetail(userDetailDTO);
        System.out.println("hiiiii" + user.toString());
        return UserDetail.toUserDetailDTO(userDetailService.update(user));
    }


}


