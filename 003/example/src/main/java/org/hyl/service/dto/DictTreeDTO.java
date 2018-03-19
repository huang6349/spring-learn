package org.hyl.service.dto;

import org.hyl.domain.Dict;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class DictTreeDTO extends DictDTO {

    private static final long serialVersionUID = -3145470272605554440L;

    private List<DictDTO> dicts = new ArrayList<>();

    public static DictTreeDTO adapt(Dict dict) {
        DictTreeDTO dto = new DictTreeDTO();
        BeanUtils.copyProperties(dict, dto);
        return dto;
    }

    public List<DictDTO> getDicts() {
        return dicts;
    }

    public void setDicts(List<DictDTO> dicts) {
        this.dicts = dicts;
    }
}
