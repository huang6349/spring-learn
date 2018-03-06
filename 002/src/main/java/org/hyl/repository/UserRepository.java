package org.hyl.repository;

import org.hyl.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, String> {
}
