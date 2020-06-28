package ma.zs.tfidf.controller;

import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.service.IgnoredWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ignoredword")
public class IgnoredWordController {

    @Autowired
    private IgnoredWordService ignoredWordService;

    @PostMapping("/")
    public List<IgnoredWord> create(@RequestBody List<IgnoredWord> ignoredWords){
        return ignoredWordService.create(ignoredWords);
    }
}
