package com.m3c.agw;

import java.util.List;
import java.util.Map;

/**
 * Created by alumniCurie02 on 13/10/2017.
 */
public interface WordFrequencyCounter {

    String readFileLine(String FILE_NAME, int lineNumber);

    Map<String, Integer> addToHistogram(String[] words,  Map<String, Integer> histogramOfWords);

    Map<String, Integer> makeWholeHistogram(String FILE_NAME);

    Map<String, Integer> appendHistogram(String FILE_NAME, Map<String, Integer> histogramOfWords);

    Map<String, Integer> getTopHistogramValues(Map<String, Integer> histogramOfWords,int numberOfMostFrequentWordsToFind);

    Map<String, Integer> findMostCommonWords(String FILE_NAME, int n);

}
