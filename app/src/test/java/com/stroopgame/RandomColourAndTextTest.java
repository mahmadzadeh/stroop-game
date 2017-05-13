package com.stroopgame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomColourAndTextTest {

    @Test
    public void nextRandom() {
        List<Parameters> parametersList = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {

            parametersList.add(RandomColourAndText.nextRandom());
        }

        outputPercentMatching(parametersList);

    }

    private void outputPercentMatching(List<Parameters> parametersList) {

        int countMatching = 0;

        for (Parameters parameters : parametersList) {
            if (parameters.textAndColourMatch()) {
                countMatching++;
            }
        }

        System.out.println("out of " + parametersList.size() + " there are: " + countMatching + " matching text/colour");
    }


}