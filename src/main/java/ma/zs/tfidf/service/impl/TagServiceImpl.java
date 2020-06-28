package ma.zs.tfidf.service.impl;

import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;
import ma.zs.tfidf.dao.IgnoredWordDao;
import ma.zs.tfidf.dao.TagDao;
import ma.zs.tfidf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> create(List<Tag> tags) {
        List<Tag> tagsToSave = new ArrayList<>();
        tags.forEach(tag -> {
            if (tagDao.findByTag(tag.getTag()) == null) {
                tagsToSave.add(tag);
            }
        });
        return tagDao.saveAll(tagsToSave);
    }


}
