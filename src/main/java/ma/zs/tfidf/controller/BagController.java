package ma.zs.tfidf.controller;

import ma.zs.tfidf.bean.Bag;
import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;
import ma.zs.tfidf.dao.IgnoredWordDao;
import ma.zs.tfidf.dao.TagDao;
import ma.zs.tfidf.dto.BagRequest;
import ma.zs.tfidf.util.BagOfWordsUtil;
import ma.zs.tfidf.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BagController {

    @Autowired
    private TagDao tagDao;
    @Autowired
    private IgnoredWordDao ignoredWordDao;

//    String wordsToIgnoreEn = "a an you your that this is there over by their has its it if now he but will two was not up more for " +
//            "what other down on all about go day am are were out did as we many with when then no his " +
//            "your them way they can these could may I so in some to any";
//
//
//    String test = "A general-purpose computer programming language designed to produce programs that will run on any computer system";

    String test = "<p>you are smart</p>";

    @GetMapping("/bag")
    public List<Bag> count(@RequestBody BagRequest br) {
        List<String> res = cleanText(br.getText());
        System.out.println(res);
        List<Bag> bags = new ArrayList<>();
        for (String s : res) {
            if (!isIgnoredWord(s) && !Util.exist(bags,s))
            bags.add(new Bag(s, BagOfWordsUtil.tf(res, s)));
        }
        return bags;
//        return null;
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
