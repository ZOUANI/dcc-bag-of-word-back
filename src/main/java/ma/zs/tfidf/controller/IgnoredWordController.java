package ma.zs.tfidf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.service.IgnoredWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api("endPoint : words to ignore while making bag of words ")
@RestController
@RequestMapping("/ignoredword")
public class IgnoredWordController {

    @Autowired
    private IgnoredWordService ignoredWordService;

    @ApiOperation("add list of words to ignore")
    @PostMapping("/")
    public List<IgnoredWord> create(@RequestBody List<IgnoredWord> ignoredWords){
        return ignoredWordService.create(ignoredWords);
    }
}
