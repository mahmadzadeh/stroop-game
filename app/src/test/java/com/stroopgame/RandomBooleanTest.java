package com.stroopgame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.stroopgame.RandomBoolean.nextRandomTrue;

public class RandomBooleanTest {

    @Test
    public void testNextRandomTrueWithOneOutOfNChance() {

        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            list.add(nextRandomTrue());
        }

        checkDistribution(list);

    }

    private void checkDistribution(List<Boolean> list) {
        int trueCount = 0;

        for (Boolean val : list) {
            if (val) {
                trueCount++;
            }
        }

        System.out.println((100 * trueCount) / 100 + "% is set to true");
    }

}