package org.hyl.service.dto;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.hyl.commons.utils.LevelUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractLevelDTO<T extends LevelDTO> {

    public List<T> listToTree(List<T> ts) {
        if (CollectionUtils.isEmpty(ts)) {
            return Lists.newArrayList();
        }
        Multimap<String, T> multimap = ArrayListMultimap.create();
        List<T> root = Lists.newArrayList();
        ts.forEach(t -> {
            multimap.put(t.getLevel(), t);
            if (LevelUtil.ROOT.equals(t.getLevel())) {
                root.add(t);
            }
        });
        transformTree(root, LevelUtil.ROOT, multimap);
        return root.stream().sorted(Comparator.comparingInt(T::getSeq)).collect(Collectors.toList());
    }

    private void transformTree(List<T> ts, String level, Multimap<String, T> multimap) {
        ts.forEach(t -> {
            String nextLevel = LevelUtil.calculateLevel(level, t.getId());
            List<T> list = (List<T>) multimap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(list)) {
                t.setChild((List<LevelDTO>) list);
                transformTree(list, nextLevel, multimap);
            }
        });
    }
}
