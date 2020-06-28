package ma.zs.tfidf.service;

import ma.zs.tfidf.bean.IgnoredWord;

import java.util.List;

public interface IgnoredWordService {
    public List<IgnoredWord> create(List<IgnoredWord> ignoredWords);
}
