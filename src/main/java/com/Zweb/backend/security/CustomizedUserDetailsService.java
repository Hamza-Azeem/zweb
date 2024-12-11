package com.Zweb.backend.security;

import com.Zweb.backend.dto.UserDto;
import com.Zweb.backend.entity.Role;
import com.Zweb.backend.entity.User;
import com.Zweb.backend.exception.DuplicateResourceException;
import com.Zweb.backend.exception.InvalidCredentialsException;
import com.Zweb.backend.models.LoginRequest;
import com.Zweb.backend.models.RegistrationRequest;
import com.Zweb.backend.repository.RoleRepository;
import com.Zweb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.Zweb.backend.mapper.UserMapper.convertToUserDto;

@Service
public class CustomizedUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    private final ZoneId zoneId = ZoneId.of("Africa/Cairo");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles()
        );
    }
    public UserDto registerUser(RegistrationRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new DuplicateResourceException("Email is linked to another account.");
        }
        if(roleRepository.findByName("ADMIN").isEmpty()){
            Role role = new Role("ADMIN");
            roleRepository.insert(role);
        }
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getPhoneNumber(),
                UUID.randomUUID() + ".jpg", // need to change  UUID.randomUUID() + ".jpg"
                LocalDateTime.now(zoneId), // ZoneDateTime.now(zoneId)
                LocalDateTime.now(zoneId)
        );
        user.addRole(roleRepository.findByName("ADMIN").get());
        userRepository.save(user);
        UserDto userDto = convertToUserDto(user);
        return userDto;
    }
    public String loginUser(LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isEmpty() || !passwordEncoder.matches(request.getPassword(), user.get().getPassword())){
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        user.get().setLastLogin(LocalDateTime.now(zoneId));
        userRepository.save(user.get());
        return jwtService.generateToken(request.getEmail());
    }
}
