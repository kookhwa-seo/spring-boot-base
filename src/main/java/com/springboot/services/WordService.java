package com.springboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WordService {
    public static Map<Integer, String> wordMap = new HashMap<>();
    public static Map<String, Integer> countMap = new HashMap<>();
    public static Integer id = 0;

    public Integer createWord(String request){
        //wordMap에 저장
        wordMap.put(++id, request);

        //countMap에 단어 카운팅 저장
        String[] wordArray = request.split(" ");
        for(String word : wordArray){
            String convertedWord = String.valueOf(word);
            countMap.put(convertedWord, countMap.getOrDefault(convertedWord, 0)+1);
        }

        return id;
    }

    public String getWord(Integer id){
        return wordMap.get(id);
    }

    public String updateWord(Integer id, String word){
        wordMap.put(id, word);
        return wordMap.get(id);
    }

    public void deleteWord(Integer id){
        wordMap.remove(id);
    }

    public Map<String, Integer> countWord(){
        countMap.size();
        return countMap;
    }
}
