package org.hyl.repository;

import org.hyl.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor {

    Optional<Dict> findOneByIdentIgnoreCase(String ident);
}
