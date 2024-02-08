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

    @PostMapping("/user")
    @ResponseBody
    public UserDetailDTO addUser(@RequestBody UserDetailDTO userDetailDTO){
       UserDetail user = UserDetail.toUserDetail(userDetailDTO);
        return userDetailService.save(user);
    }

    @GetMapping("/get-users")
    public UserDetailDTO getUsersByEmail(@RequestHeader("Authorization") String token){
        return userDetailService.getAllUserByEmail(token);
    }

    @CrossOrigin
    @PutMapping ("/update-user")
    public UserDetailDTO updateUser(@RequestHeader("Authorization") String token,@RequestBody UserDetailDTO userDetailDTO) {
        UserDetail user = UserDetail.toUserDetail(userDetailDTO);
        return userDetailService.update(token ,user);
    }




}


