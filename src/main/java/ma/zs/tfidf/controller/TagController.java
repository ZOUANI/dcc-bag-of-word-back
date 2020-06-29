package ma.zs.tfidf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;
import ma.zs.tfidf.service.IgnoredWordService;
import ma.zs.tfidf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
@Api("endPoint : html tags to ignore while making bag of words ")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation("add list of html tags to ignore")
    @PostMapping("/")
    public List<Tag> create(@RequestBody List<Tag> tags){
        return tagService.create(tags);
    }
}
