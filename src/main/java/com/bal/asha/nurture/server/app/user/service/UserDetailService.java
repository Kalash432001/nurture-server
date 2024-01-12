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

    public UserDetailDTO save(UserDetail userdetail) {
        UserDetail u;

        if(userDetailRepository.findExistByUserEmail(userdetail.getUserEmail())){
            u=userDetailRepository.findByUserEmail(userdetail.getUserEmail());;
        }
        else{
            u=userDetailRepository.save(userdetail);
        }
        return UserDetail.toUserDetailDTO(u);
    }

    public  Set<UserDetailDTO> getAllUserRecord(){
        return userDetailRepository.getAllUserRecord();
    }

    public UserDetailDTO update(String token ,UserDetail userdetailupdate) {

          String userEmail=jwtTokenUtil.getUserEmail(token.substring(7));
          UserDetail userDetail;
          System.out.println(userdetailupdate);
          UserAddress userAddress=new UserAddress(userdetailupdate.getAddress().getAddress1(),userdetailupdate.getAddress().getAddress2(),userdetailupdate.getAddress().getCity(),userdetailupdate.getAddress().getZip());
        ;
          if(userDetailRepository.findByUserEmail(userEmail)==null){
              LocalDateTime createDate = LocalDateTime.now();
                           userDetail= new UserDetail(0,userEmail,userdetailupdate.getUserEmail(),userdetailupdate.getIdProofType(), userdetailupdate.getIdDtls(), userAddress,
                     userdetailupdate.getMobileNo(), userdetailupdate.getUserType(), createDate);

          }else {

              userDetail=userDetailRepository.findByUserEmail(userEmail);
              userdetailupdate.setUserName(userdetailupdate.getUserName());
              userdetailupdate.setUserName(userdetailupdate.getIdProofType());
              userdetailupdate.setIdDtls(userdetailupdate.getIdDtls());
              userDetail.setAddress(userAddress);
              userDetail.setMobileNo(userdetailupdate.getMobileNo());
          }

          return UserDetail.toUserDetailDTO(userDetailRepository.save(userDetail));
    }




}
