package org.hyl.domain;

import org.hyl.base.auditing.domain.AbstractAuditingEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AUTHORITY")
public class Authority extends AbstractAuditingEntity {

    private static final long serialVersionUID = 7584372570299432038L;

    @Id
    @Column(length = 50)
    private String name;

    @Column(nullable = false)
    private String ident;

    @Column(nullable = false)
    private String describe;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer seq = 0;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer state = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                ", ident='" + ident + '\'' +
                ", describe='" + describe + '\'' +
                ", seq=" + seq +
                ", state=" + state +
                '}';
    }
}
