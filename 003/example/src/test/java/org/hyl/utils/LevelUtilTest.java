package org.hyl.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelUtilTest {

    @Test
    public void calculateLevel0() throws Exception {
        String a = LevelUtil.calculateLevel();
        String b = "0";
        assertThat(a).isEqualTo(b);
    }

    @Test
    public void calculateLevel1() throws Exception {
        String a = LevelUtil.calculateLevel(null, 1);
        String b = "0";
        assertThat(a).isEqualTo(b);
    }

    @Test
    public void calculateLevel2() throws Exception {
        String a = LevelUtil.calculateLevel("0", 1);
        String b = "0.1";
        assertThat(a).isEqualTo(b);
    }
}