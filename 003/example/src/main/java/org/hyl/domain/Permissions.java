package org.hyl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hyl.base.domain.AbstractLevelAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PERMISSIONS")
public class Permissions extends AbstractLevelAuditingEntity {

    private static final long serialVersionUID = 6746359187625456971L;

    @NotNull
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "TB_PERMISSIONS_AUTHORITY",
            joinColumns = {@JoinColumn(name = "PERMISSIONS_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_NAME", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
