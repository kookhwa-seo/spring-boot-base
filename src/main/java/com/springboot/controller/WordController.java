package com.springboot.controller;

import com.springboot.services.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/words")
@Validated
public class WordController {
    private final WordService wordService;

/*    @PostMapping("")
    public ResponseEntity<Integer> createWord(@Valid @RequestBody WordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wordService.createWord(request));
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<String> getWord(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(wordService.getWord(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWord(@PathVariable("id") Integer id, String word) {
        return ResponseEntity.ok(wordService.updateWord(id, word));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable("id") Integer id) {
        wordService.deleteWord(id);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> countWord() {
        return ResponseEntity.ok(wordService.countWord());
    }
}
