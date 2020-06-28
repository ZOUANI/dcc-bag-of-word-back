package ma.zs.tfidf.controller;

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
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/")
    public List<Tag> create(@RequestBody List<Tag> tags){
        return tagService.create(tags);
    }
}
