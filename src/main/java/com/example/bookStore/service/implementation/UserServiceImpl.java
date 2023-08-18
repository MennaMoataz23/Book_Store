//package com.example.bookStore.service.implementation;
//
//import com.example.bookStore.model.entities.Role;
//import com.example.bookStore.model.entities.User;
//import com.example.bookStore.repository.RoleRepository;
//import com.example.bookStore.repository.UserRepository;
//import com.example.bookStore.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//@Slf4j
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    @Override
//    public User saveUser(User user) {
//        log.info("Saving new user {} to the database", user.getUserName());
//        return userRepository.save(user);
//    }
//
//    @Override
//    public Role saveRole(Role role) {
//        log.info("Saving new role {} to the database", role.name());
//        return roleRepository.findByName(String.valueOf(role));
//    }
//
//    @Override
//    public void addRoleToUser(String username, String roleName) {
//        User user = userRepository.findByUsername(username);
//        Role role = roleRepository.findByName(roleName);
//        user.getRoles().add(role);
//    }
//
//    @Override
//    public User getUser(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<User> getUser() {
//        return userRepository.findAll();
//    }
//}
