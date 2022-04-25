package com.example.demo.user;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//* annotations
@Repository // Mark as a repository, a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
@Transactional(readOnly = true) // This interface will be executed in a transaction.
public interface UserRepository {
    Optional<User> findByEmail(String email);
}
