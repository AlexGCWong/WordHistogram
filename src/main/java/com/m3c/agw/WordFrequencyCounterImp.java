package com.m3c.agw;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Map;

/**
 * Created by alumniCurie02 on 13/10/2017.
 */
public class WordFrequencyCounterImp implements WordFrequencyCounter {


    public String readFileLine(String FILE_NAME, int lineNumber) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = null;
            for (int i = 0; i<lineNumber;i++) {
                line = reader.readLine();
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String[] splitLineIntoWords(String line) {
        return line.split("\\s+");
    }


    private String deleteAllPunctuation(String line) {
        return line.toUpperCase().replaceAll("[^A-Z'\\s]", "");
    }

    public Map<String, Integer> addToHistogram(String[] words,  Map<String, Integer> histogramOfWords) {

        for (String word: words){
            if (histogramOfWords.containsKey(word)) {
                histogramOfWords.put(word, histogramOfWords.get(word) + 1);
            } else {
                histogramOfWords.put(word, 1);
            }
        }
        return histogramOfWords;
    }

    public Map<String, Integer> makeWholeHistogram(String FILE_NAME) {
        Map<String, Integer> newHistogramOfWords = new HashMap<String, Integer>();
        newHistogramOfWords = appendHistogram(FILE_NAME, newHistogramOfWords);
        newHistogramOfWords.remove("");
        return newHistogramOfWords;
    }


    public Map<String, Integer> appendHistogram(String FILE_NAME, Map<String, Integer> histogramOfWords) {
        BufferedReader reader;
        String line = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = reader.readLine()) != null) {
                String puncLine = deleteAllPunctuation(line);
                String[] words = splitLineIntoWords(puncLine);
                if (words != null) {
                    histogramOfWords = addToHistogram(words, histogramOfWords);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            return histogramOfWords;
        }
    }

    public Map<String, Integer> getTopHistogramValues(Map<String, Integer> histogramOfWords, int n) {
        List<Integer> listOfWordFrequencies = new ArrayList<Integer>();
        listOfWordFrequencies.addAll(histogramOfWords.values());
        Collections.sort(listOfWordFrequencies);
        Collections.reverse(listOfWordFrequencies);
        Map<String, Integer> topWordFrequencies = new LinkedHashMap<String, Integer>();
        for (int i=0; i<n; i++) {
            for (Map.Entry<String, Integer> entry : histogramOfWords.entrySet()) {
                if (listOfWordFrequencies.get(i) == entry.getValue()){
                    topWordFrequencies.put(entry.getKey(),listOfWordFrequencies.get(i));
                }
            }
        }
        return topWordFrequencies;
    }

    public Map<String, Integer> findMostCommonWords(String FILE_NAME, int n) {
        Map<String,Integer> newHistogramOfWords = makeWholeHistogram(FILE_NAME);
        Map<String,Integer> topHistogramValues = getTopHistogramValues(newHistogramOfWords, n);
        return topHistogramValues;
    }

}
