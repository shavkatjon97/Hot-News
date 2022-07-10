package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shavkatjon.hotnews.entity.User;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.UserDto;
import shavkatjon.hotnews.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public ApiResponse addUser(UserDto userDto) {

        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());

        if (existsByPhoneNumber) {

            return new ApiResponse("This user already exist", false);
        }

        User customer = new User();
        customerDetails(customer, userDto);
        userRepository.save(customer);
        return new ApiResponse("User added", true);
    }

    public void customerDetails(User user, UserDto userDto) {
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
    }

    public ApiResponse updateUser(UserDto userDto, String id) {

        boolean byPhoneNumberAndIdNot = userRepository.existsByPhoneNumberAndIdNot(userDto.getPhoneNumber(), UUID.fromString(id));
        if (byPhoneNumberAndIdNot) {
            return new ApiResponse("no this cusytomer", false);
        }
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(id));
        if (!optionalUser.isPresent()) {
            return new ApiResponse("not found", false);

        }
        User user = optionalUser.get();
        customerDetails(user, userDto);
        User savedUser = userRepository.save(user);
        return new ApiResponse("hghgfhgfhh", true);


    }

    public ApiResponse deleteUser(String id) {
        userRepository.deleteById(UUID.fromString(id));
        return new ApiResponse("deleted", true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByPhoneNumber(username).orElseThrow(() ->
                new IllegalStateException("User not found"));
    }

    //currentUser
    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (User) principal;
    }

}
