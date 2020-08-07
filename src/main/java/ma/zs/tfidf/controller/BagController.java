package ma.zs.tfidf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.tfidf.bean.Bag;
import ma.zs.tfidf.dto.BagRequest;
import ma.zs.tfidf.dto.Course;
import ma.zs.tfidf.dto.SimilarityRequest;
import ma.zs.tfidf.service.BagService;
import ma.zs.tfidf.util.BagOfWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api("endPoint : make and compare bags of words ")
@RestController
public class BagController {

    @Autowired
    BagService bagService;

    @ApiOperation("make a bag of words for a given text")
    @PostMapping("/bag")
    public List<Bag> count(@RequestBody BagRequest br) {
        return bagService.makeBag(br);
    }


    @PostMapping("/similarity")
    @ApiOperation("calculate similarity between  bag of words and  text")
    public SimilarityRequest compare(@RequestBody SimilarityRequest similarityRequest) throws JsonProcessingException {
        String bagOriginal = similarityRequest.getBagOfWords();
        String text = similarityRequest.getText();
        List<Bag> createdBag = bagService.makeBag(new BagRequest(text));
        double similarity = BagOfWordsUtil.comapreBags(createdBag, bagOriginal);
        similarityRequest.setSimilarity(similarity);
        return similarityRequest;
    }

    @PostMapping("/getBag")
    public int treat(@RequestBody List<Bag> bags){
        System.out.println("haaaa bags => ");
        System.out.println(bags);
        return bags.size();
    }

    @PostMapping("/bagForCourse")
    public Course makeBagsCourse(@RequestBody Course course) throws JsonProcessingException {
        return bagService.makeBagsCourse(course);
    }


}
