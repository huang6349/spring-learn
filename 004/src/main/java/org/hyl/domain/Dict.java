package org.hyl.domain;

import org.hyl.base.level.auditing.domain.AbstractLevelAuditingEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DICT")
public class Dict extends AbstractLevelAuditingEntity {

    private static final long serialVersionUID = 5710585163341980109L;

    @Column(nullable = false, unique = true)
    private String ident;

    @Column(nullable = false)
    private String data;

    private String code;

    private String describe;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0")
    private Byte state;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "ident='" + ident + '\'' +
                ", data='" + data + '\'' +
                ", code='" + code + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                '}';
    }
}
