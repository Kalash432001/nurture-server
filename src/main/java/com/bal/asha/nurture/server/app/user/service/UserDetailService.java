package com.bal.asha.nurture.server.app.user.service;

import com.bal.asha.nurture.server.app.user.entity.UserDetail;
import com.bal.asha.nurture.server.app.user.dto.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail save(UserDetail userdetail) {

        return userDetailRepository.save(userdetail);
    }

    public  Set<UserDetailDTO> getAllUserRecord(){
        return userDetailRepository.getAllUserRecord();
    }

}
