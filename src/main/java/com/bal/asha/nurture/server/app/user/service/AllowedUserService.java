package com.bal.asha.nurture.server.app.user.service;

import com.bal.asha.nurture.server.app.user.domain.AllowedUserDto;
import com.bal.asha.nurture.server.app.user.domain.UserType;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.app.user.domain.entity.QAllowedUser;
import com.bal.asha.nurture.server.app.user.domain.entity.repository.AllowedUserRepository;
import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.bal.asha.nurture.server.app.user.domain.AllowedUserStatus.ACTIVE;

@Slf4j
@Service
@AllArgsConstructor
public class AllowedUserService {

    private AllowedUserRepository allowedUserRepository;
    private static final QAllowedUser $ = QAllowedUser.allowedUser;

    public AllowedUser save(AllowedUserDto allowedUserDto) {
        AllowedUser allowedUser = AllowedUser.create(allowedUserDto.getEmailId(), allowedUserDto.getType());
        return allowedUserRepository.save(allowedUser);
    }

    public AllowedUser update(AllowedUser allowedUser) {
        return allowedUserRepository.save(allowedUser);
    }

    public AllowedUser disableUser(UUID userId) {
        AllowedUser allowedUser = getUser(userId);
        return allowedUserRepository.save(allowedUser.disable());
    }

    public AllowedUser activateUser(UUID userId) {
        AllowedUser allowedUser = getUser(userId);
        return allowedUserRepository.save(allowedUser.activate());
    }

    public AllowedUser getUser(UUID userId) {
        return allowedUserRepository.findById(userId).orElseThrow(() -> new NurtureServerException("User with Id :" + userId + " Doesn't Exists"));
    }

    public Page<AllowedUser> search(Predicate spec, Pageable pageable) {
        return allowedUserRepository.findAll(spec, pageable);
    }

    public AllowedUser updateType(UUID userId, UserType type) {
        AllowedUser user = getUser(userId);
        return allowedUserRepository.save(user.updateType(type));
    }

    public boolean isAllowed(String email) {
        return allowedUserRepository.existsByEmailIdAndStatus(email, ACTIVE);
    }

    @Async
    public void updateProfilePicUri(String emailId, String profilePictureUri) {
        Optional<AllowedUser> user = allowedUserRepository.findOne($.emailId.eq(emailId));
        if(user.isPresent()) {
            allowedUserRepository.save(user.get().updateProfilePicture(profilePictureUri));
        }
    }
}
