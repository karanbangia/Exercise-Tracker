package com.webapp.ExcerciseTracker.repository;

        import com.webapp.ExcerciseTracker.model.User;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByuserName(String userName);

    User findByuserId(String userId);
}
