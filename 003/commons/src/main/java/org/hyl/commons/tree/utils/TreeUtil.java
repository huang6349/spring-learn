package org.hyl.commons.tree.utils;

import org.hyl.commons.tree.domain.TreeEntity;

import java.io.Serializable;
import java.util.List;

public interface TreeUtil<T extends TreeEntity<T, ID>, ID extends Serializable> {

    List<T> listToTreeByPid(List<T> lists, ID pid);
}
