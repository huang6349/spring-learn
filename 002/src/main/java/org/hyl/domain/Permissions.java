package org.hyl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hyl.commons.domain.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PERMISSIONS")
public class Permissions extends AbstractAuditingEntity {

    private static final long serialVersionUID = 6746359187625456971L;

    @Id
    @GenericGenerator(name = "permissions", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "permissions")
    private String id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "TB_PERMISSIONS_ROLE",
            joinColumns = {@JoinColumn(name = "PERMISSIONS_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Role> roles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
