package org.hyl.repository;

import org.hyl.domain.Authority;
import org.hyl.domain.Permissions;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {

    @EntityGraph(attributePaths = "authorities")
    List<Permissions> findByAuthoritiesIn(Collection<Authority> authorities);
}
