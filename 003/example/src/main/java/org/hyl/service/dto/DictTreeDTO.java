package org.hyl.service.dto;

import org.hyl.domain.Dict;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class DictTreeDTO extends Dict {

    private static final long serialVersionUID = -3145470272605554440L;

    private List<Dict> dicts = new ArrayList<>();

    public static DictTreeDTO adapt(Dict dict) {
        DictTreeDTO dto = new DictTreeDTO();
        BeanUtils.copyProperties(dict, dto);
        return dto;
    }

    public List<Dict> getDicts() {
        return dicts;
    }

    public void setDicts(List<Dict> dicts) {
        this.dicts = dicts;
    }
}
