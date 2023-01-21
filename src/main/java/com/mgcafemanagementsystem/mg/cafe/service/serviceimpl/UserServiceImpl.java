package com.mgcafemanagementsystem.mg.cafe.service.serviceimpl;

import com.mgcafemanagementsystem.mg.cafe.entity.Users;
import com.mgcafemanagementsystem.mg.cafe.repository.UserRepository;
import com.mgcafemanagementsystem.mg.cafe.service.UserService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@Builder
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside SignUp {}", requestMap);
        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email") && requestMap.containsKey("password")) {

            Users users = userRepository.findByEmail(requestMap.get("email"));
            if (users.getEmail().isEmpty()) {
                Users users1 = new Users();

                users1.setName(requestMap.get("name"));
                users1.setContactNumber(requestMap.get("contactNumber"));
                users1.setEmail(requestMap.get("email"));
                users1.setPassword(requestMap.get("password"));
                users1.setStatus("false");
                users1.setRole("user");

                userRepository.save(users1);

            } else {
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
