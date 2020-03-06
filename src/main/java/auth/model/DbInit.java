package auth.model;


import auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
}

  /*  @Override
    public void run(String... args) {
        // Delete all
       this.userRepository.deleteAll();

        // Crete users
       // User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User admin = new User("admin@admin.com","Administrator",passwordEncoder.encode("admin123"),"ADMIN","admin_dashboard");
       // User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        //List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.save(admin);
    }
}

   */