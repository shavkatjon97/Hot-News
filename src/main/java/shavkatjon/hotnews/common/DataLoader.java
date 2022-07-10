package shavkatjon.hotnews.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import shavkatjon.hotnews.entity.*;
import shavkatjon.hotnews.enums.LikesTypes;
import shavkatjon.hotnews.repository.*;


import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    String initMode;

    final UserRepository userRepo;
    final RoleRepository roleRepo;
    final PasswordEncoder passwordEncoder;
    final ProfileRepository profileRepository;
    final PostRepository postRepository;
    final CommentRepository commentRepository;
    final LikeRepository likeRepository;

    public DataLoader(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder,
                      ProfileRepository profileRepository, PostRepository postRepository,
                      CommentRepository commentRepository, LikeRepository likeRepository) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
    }

    @Override
    public void run(String... args) {

        if (initMode.equals("always")) {
            //role
            Role super_admin = new Role("ROLE_SUPER_ADMIN");
            Role other = new Role("ROLE_OTHER");

            Role savedSuperAdmin = roleRepo.save(super_admin);
            Role savedOther = roleRepo.save(other);

            Set<Role> super_admin_role = new HashSet<>();
            super_admin_role.add(savedSuperAdmin);

            Set<Role> user_role = new HashSet<>();
            user_role.add(savedOther);

            User admin = new User(passwordEncoder.encode("1111"), "1000", super_admin_role);
            User user = new User(passwordEncoder.encode("1111"), "1020", user_role);
            userRepo.save(admin);
            userRepo.save(user);

            Profile profile = new Profile(user, "user", "Qobil", null);
            Profile save = profileRepository.save(profile);
            Post post = new Post("Title", "Description", null, save, null, null);
            Post savedPost = postRepository.save(post);
            Comment comment = new Comment(user, "comment", savedPost, null);
            commentRepository.save(comment);
            Like like = new Like(savedPost, user, LikesTypes.LIKE);
            likeRepository.save(like);
        }

    }
}
