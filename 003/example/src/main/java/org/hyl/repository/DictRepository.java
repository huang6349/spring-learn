package org.hyl.repository;

import org.hyl.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DictRepository extends JpaRepository<Dict, Long> {

    Optional<Dict> findOneByIdentIgnoreCase(String ident);
}
