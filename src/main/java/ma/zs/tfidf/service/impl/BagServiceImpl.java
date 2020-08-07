package ma.zs.tfidf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.zs.tfidf.bean.Bag;
import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;
import ma.zs.tfidf.dao.IgnoredWordDao;
import ma.zs.tfidf.dao.TagDao;
import ma.zs.tfidf.dto.BagRequest;
import ma.zs.tfidf.dto.Chapter;
import ma.zs.tfidf.dto.Course;
import ma.zs.tfidf.service.BagService;
import ma.zs.tfidf.util.BagOfWordsUtil;
import ma.zs.tfidf.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BagServiceImpl implements BagService {

    @Autowired
    private TagDao tagDao;
    @Autowired
    private IgnoredWordDao ignoredWordDao;

    @Override
    public List<Bag> makeBag(BagRequest br) {
        List<String> res = cleanText(br.getText());
        System.out.println(res);
        List<Bag> bags = new ArrayList<>();
        for (String s : res) {
            if (!isIgnoredWord(s) && !Util.exist(bags,s))
                bags.add(new Bag(s, BagOfWordsUtil.tf(res, s)));
        }
        return bags;
    }

    @Override
    public Course makeBagsCourse(Course course) throws JsonProcessingException {

        course.setBagOfWords(makeBagFromString(course.getCourseSummarySectionContent()));
        for (Chapter chapter : course.getChapters()) {
            chapter.setBagOfWords(makeBagFromString(chapter.getChapterContent()));
        }
        return course;
    }

    private String makeBagFromString(String s) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BagRequest br = new BagRequest(s);
        List<Bag> bags = makeBag(br);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bags);
    }

    private List<String> cleanText(String text) {
        String withoutPonctuation = Util.removePunctuation(text);
        String[] splited = withoutPonctuation.split(" ");
        List<String> allWords = new ArrayList<>();
        for (String s : splited) {
            if (!s.equals("")) {
                allWords.add(s);
            }
        }
        allWords.removeIf(allWord ->  isTag(allWord));
        return allWords;
    }

    private boolean isTag(String term) {
        for (Tag tag : tagDao.findAll()) {
            if (tag.getTag().equalsIgnoreCase(term)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIgnoredWord(String term) {
        for (IgnoredWord ignoredWord : ignoredWordDao.findAll()) {
            if (ignoredWord.getWord().equalsIgnoreCase(term)) {
                return true;
            }
        }
        return false;
    }
}
