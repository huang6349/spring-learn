package org.hyl.service.dto;

import java.util.ArrayList;
import java.util.List;

public class DictLevelDTO extends DictDTO {

    private List<DictDTO> dicts = new ArrayList<>();

    public List<DictDTO> getDicts() {
        return dicts;
    }

    public void setDicts(List<DictDTO> dicts) {
        this.dicts = dicts;
    }
}
