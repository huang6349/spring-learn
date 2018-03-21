package org.hyl.domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractLevelAuditingEntity extends AbstractIdAuditingEntity {

    private static final long serialVersionUID = -1290268469143633319L;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long pid;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer seq = 0;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "AbstractLevelAuditingEntity{" +
                "pid=" + pid +
                ", level='" + level + '\'' +
                ", seq=" + seq +
                '}';
    }
}
