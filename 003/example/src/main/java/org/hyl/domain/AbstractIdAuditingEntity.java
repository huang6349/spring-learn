package org.hyl.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractIdAuditingEntity extends AbstractAuditingEntity {

    private static final long serialVersionUID = 2322624127778510779L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractIdAuditingEntity{" +
                "id=" + id +
                '}';
    }
}
