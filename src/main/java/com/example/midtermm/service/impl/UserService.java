package com.example.midtermm.service.impl;


import com.example.midtermm.entity.Permission;
import com.example.midtermm.entity.UserModel;
import com.example.midtermm.repository.PermissionRep;
import com.example.midtermm.repository.UserRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRep userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRep permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(username);

        if(Objects.nonNull(user)) {     // if user != null
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(UserModel model){
        UserModel check = userRepository.findByEmail(model.getEmail());
        if (check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions = List.of(permissionRep.findByName("ROLE_USER"));

            model.setPermissions(permissions);
            userRepository.save(model);
        }
    }


}
