package ma.zs.tfidf.service.impl;

import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.dao.IgnoredWordDao;
import ma.zs.tfidf.service.IgnoredWordService;
import ma.zs.tfidf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IgnoredWordServiceImpl implements IgnoredWordService {

    @Autowired
    private IgnoredWordDao ignoredWordDao;

    @Override
    public List<IgnoredWord> create(List<IgnoredWord> ignoredWords) {
        List<IgnoredWord> ignoredWordToSave = new ArrayList<>();
        ignoredWords.forEach(ignoredWord -> {
            if (ignoredWordDao.findByWord(ignoredWord.getWord()) == null){
                ignoredWordToSave.add(ignoredWord);
            }
        });
        return ignoredWordDao.saveAll(ignoredWordToSave);
    }
}
