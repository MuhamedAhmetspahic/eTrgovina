package ptf.aurea_etrgovina.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptf.aurea_etrgovina.Models.User;
import ptf.aurea_etrgovina.Repositories.UserRepository;


    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleService roleService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public void saveUser(User user) {
            user.setRole(roleService.getRoleByName("CLIENT"));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }