package com.m3c.agw;

import java.util.Map;

public class App {

    private static final String FILE_NAME = "C:\\Users\\alumniCurie02\\Documents\\WordsHistogram\\Resources\\aLargeFile";

    public static void main( String[] args ) {

        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int numberOfMostFrequentWordsToFind = 5;
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.findMostCommonWords(FILE_NAME, numberOfMostFrequentWordsToFind);
        System.out.println(topHistogramValues);
    }
}
