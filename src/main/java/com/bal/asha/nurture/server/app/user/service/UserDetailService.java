package com.bal.asha.nurture.server.app.user.service;

import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.app.user.domain.entity.UserAddress;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import com.bal.asha.nurture.server.app.user.domain.entity.repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import com.bal.asha.nurture.server.config.security.JwtTokenUtil;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailService {

    private UserDetailRepository userDetailRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    public UserDetail update(String token ,UserDetail userdetailupdate) {

          String userEmail=jwtTokenUtil.getUserEmail(token.substring(7));
          UserDetail userDetail;
          System.out.println(userdetailupdate);
          UserAddress userAddress=new UserAddress(userdetailupdate.getAddress().getAddress1(),userdetailupdate.getAddress().getAddress2(),userdetailupdate.getAddress().getCity(),userdetailupdate.getAddress().getZip());
        ;
          if(userDetailRepository.findByUserEmail(userEmail)==null){
              System.out.println("In If");
              LocalDateTime createDate = LocalDateTime.now();
                           userDetail= new UserDetail(0,userEmail,userdetailupdate.getUserEmail(),userdetailupdate.getIdProofType(), userdetailupdate.getIdDtls(), userAddress,
                     userdetailupdate.getMobileNo(), userdetailupdate.getUserType(), createDate);

          }else {

              System.out.println("In Else");
              userDetail=userDetailRepository.findByUserEmail(userEmail);
              userdetailupdate.setUserName(userdetailupdate.getUserName());
              userdetailupdate.setUserName(userdetailupdate.getIdProofType());
              userdetailupdate.setIdDtls(userdetailupdate.getIdDtls());
              userDetail.setAddress(userAddress);
              userDetail.setMobileNo(userdetailupdate.getMobileNo());
          }

          return userDetailRepository.save(userDetail);
    }




}
