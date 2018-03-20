package org.hyl.commons.tree.utils.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.hyl.commons.tree.domain.TreeEntity;
import org.hyl.commons.tree.utils.TreeUtil;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTreeUtil<T extends TreeEntity<T, ID>, ID extends Serializable> implements TreeUtil<T, ID> {

    @Override
    public List<T> listToTreeByPid(List<T> list, ID pid) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        Multimap<ID, T> multimap = ArrayListMultimap.create();
        List<T> root = Lists.newArrayList();
        list.forEach(t -> {
            multimap.put(t.getPid(), t);
            if (t.getPid() == pid) {
                root.add(t);
            }
        });
        transformTree(root, multimap, pid);
        return root.stream().sorted(Comparator.comparingInt(T::getSeq)).collect(Collectors.toList());
    }

    private void transformTree(List<T> list, Multimap<ID, T> multimap, ID key) {
        list.forEach(t -> {
            List<T> nexts = (List<T>) multimap.get(t.getId());
            if (!CollectionUtils.isEmpty(nexts)) {
                t.setChild(nexts);
                transformTree(nexts, multimap, t.getId());
            }
        });
    }
}
