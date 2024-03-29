package com.example.demo.appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//* annotations
@Repository // Mark as a repository, a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
@Transactional(readOnly = true) // This interface will be executed in a transaction.
public interface UserRepository
        extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
