package org.hyl.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_DICT")
public class Dict extends AbstractLevelAuditingEntity {

    private static final long serialVersionUID = 5710585163341980109L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ident;

    @Column(nullable = false)
    private String data;

    private String code;

    private String describe;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0")
    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", ident='" + ident + '\'' +
                ", data='" + data + '\'' +
                ", code='" + code + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                '}';
    }
}
