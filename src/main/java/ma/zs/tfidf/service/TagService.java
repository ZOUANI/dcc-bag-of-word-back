package ma.zs.tfidf.service;

import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> create(List<Tag> tags);
}
