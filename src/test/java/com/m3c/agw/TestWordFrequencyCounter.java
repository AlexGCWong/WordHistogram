package com.m3c.agw;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alumniCurie02 on 13/10/2017.
 */

public class TestWordFrequencyCounter  {

    private WordFrequencyCounterImp wordFrequencyCounterImp;
    private Map<String,Integer> histogramOfWords;
//    private static final String FILE_NAME = "C:\\Users\\alumniCurie02\\Documents\\WordsHistogram\\Resources\\SampleTextFile.txt";
    private static final String FILE_NAME = "C:\\Users\\alumniCurie02\\Documents\\WordsHistogram\\Resources\\aLargeFile";

    @Test
    public void testingFirstLine() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int lineNumber = 1;
        String line = wordFrequencyCounterImp.readFileLine(FILE_NAME,lineNumber);
        System.out.println(line);
    }

    @Test
    public void testingSecondLine() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int lineNumber = 1;
        String line = wordFrequencyCounterImp.readFileLine(FILE_NAME, lineNumber);
        System.out.println(line);
    }

//    @Test
//    public void testingRemoveAllPunctuation() {
//        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
//        int lineNumber = 1;
//        String line = wordFrequencyCounterImp.readFileLine(FILE_NAME,lineNumber);
//        String puncLine = wordFrequencyCounterImp.deleteAllPunctuation(line);
//        System.out.println(puncLine);
//    }
//
//    @Test
//    public void testingSplitStringIntoWords() {
//        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
//        int lineNumber = 1;
//        String line = wordFrequencyCounterImp.readFileLine(FILE_NAME, lineNumber);
//        String puncLine = wordFrequencyCounterImp.deleteAllPunctuation(line);
//        List<String> words = wordFrequencyCounterImp.splitLineIntoWords(puncLine);
//        System.out.println(words);
//    }
//
//    @Test
//    public void testingCountWords() {
//        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
//        Map<String,Integer> histogramOfWords = new HashMap<String, Integer>();
//        int lineNumber = 1;
//        String line = wordFrequencyCounterImp.readFileLine(FILE_NAME, lineNumber);
//        String puncLine = wordFrequencyCounterImp.deleteAllPunctuation(line);
//        List<String> words = wordFrequencyCounterImp.splitLineIntoWords(puncLine);
//        Map<String,Integer> newHistogramOfWords= wordFrequencyCounterImp.addToHistogram(words,histogramOfWords);
//        System.out.println(newHistogramOfWords);
//    }

    @Test
    public void testingAppendHist() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
//        Map<String, Integer> histogramOfWords = new HashMap<String, Integer>();
        Map<String,Integer> newHistogramOfWords = wordFrequencyCounterImp.makeWholeHistogram(FILE_NAME);
        Map<String,Integer> newHistogramOfWords2 = wordFrequencyCounterImp.appendHistogram(FILE_NAME, newHistogramOfWords);
        System.out.println(newHistogramOfWords);
    }

    @Test
    public void testingWholeHistogram() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        Map<String, Integer> histogramOfWords = new HashMap<String, Integer>();
        Map<String,Integer> newHistogramOfWords = wordFrequencyCounterImp.makeWholeHistogram(FILE_NAME);
        System.out.println(newHistogramOfWords);
    }

    @Test
    public void testingTopWordsTimed() {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        Map<String, Integer> histogramOfWords = new HashMap<String, Integer>();
        Map<String,Integer> newHistogramOfWords = wordFrequencyCounterImp.makeWholeHistogram(FILE_NAME);
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.getTopHistogramValues(newHistogramOfWords, 5);
        System.out.println(topHistogramValues);
        String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp2);
    }

    @Test
    public void testingCreateandFindWordsTimed() {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int n = 10;
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.findMostCommonWords(FILE_NAME, n);
        System.out.println(topHistogramValues);
        String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp2);
    }

    @Test
    public void testingTopWords() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        Map<String, Integer> histogramOfWords = new HashMap<String, Integer>();
        Map<String,Integer> newHistogramOfWords = wordFrequencyCounterImp.makeWholeHistogram(FILE_NAME);
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.getTopHistogramValues(newHistogramOfWords, 5);
        System.out.println(newHistogramOfWords);
    }

    @Test
    public void testingCreateandFindWords() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int n = 5;
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.findMostCommonWords(FILE_NAME, n);
        System.out.println(topHistogramValues);
    }

    @Test
    public void testingCreateandFindTop10Words() {
        WordFrequencyCounterImp wordFrequencyCounterImp = new WordFrequencyCounterImp();
        int n = 10;
        Map<String,Integer> topHistogramValues = wordFrequencyCounterImp.findMostCommonWords(FILE_NAME, n);
        System.out.println(topHistogramValues);
    }

}
