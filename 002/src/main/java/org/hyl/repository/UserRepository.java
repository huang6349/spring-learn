package org.hyl.repository;

import org.hyl.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, String> {

    Optional<MyUser> findOneByUsername(String username);
}
