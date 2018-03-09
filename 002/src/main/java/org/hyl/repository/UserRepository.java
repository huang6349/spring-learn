package org.hyl.repository;

import org.hyl.domain.MyUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<MyUser> findOneWithAuthoritiesByUsername(String username);
}
