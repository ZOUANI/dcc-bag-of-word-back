package ma.zs.tfidf.dao;

import ma.zs.tfidf.bean.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends JpaRepository<Tag,Long> {
    Tag findByTag(String tag);
}
