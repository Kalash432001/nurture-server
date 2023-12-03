package com.bal.asha.nurture.server.app.user.service;

import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import com.bal.asha.nurture.server.app.user.domain.entity.repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailService {

    private UserDetailRepository userDetailRepository;

    public UserDetail save(UserDetail userdetail) {
        UserDetail u;

        if(userDetailRepository.findExistByUserEmail(userdetail.getUserEmail())){
            System.out.println("In if");
            u=userDetailRepository.findByUserEmail(userdetail.getUserEmail());;
        }
        else{
            System.out.println("In else");
            u=userDetailRepository.save(userdetail);
        }
        return u;
    }

    public  Set<UserDetail> getAllUserRecord(){
        return userDetailRepository.getAllUserRecord();
    }

//    public  Set<UserDetail> update(UserDetail userdetailupdate){
//
//        return userDetailRepository.findByUserEmail(userdetailupdate.getUserEmail());
//    }

    public UserDetail update(UserDetail userdetailupdate) {

          UserDetail userDetail= userDetailRepository.findByUserEmail(userdetailupdate.getUserEmail());
          userDetail.setAddress(userdetailupdate.getAddress());
          userDetail.setMobileNo(userdetailupdate.getMobileNo());

          return userDetailRepository.save(userDetail);
    }




}
