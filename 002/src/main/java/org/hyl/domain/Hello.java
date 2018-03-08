package org.hyl.domain;

import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TB_HELLO")
public class Hello implements Serializable {

    private static final long serialVersionUID = 6075105932543389178L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String node;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
