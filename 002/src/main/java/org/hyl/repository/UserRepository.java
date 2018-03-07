package org.hyl.repository;

import org.hyl.domain.MyUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String> {

    String USERS_BY_USER_NAME_CACHE = "usersByUsername";

    @EntityGraph(attributePaths = "roles")
    @Cacheable(cacheNames = USERS_BY_USER_NAME_CACHE)
    Optional<MyUser> findOneWithRolesByUsername(String username);
}
