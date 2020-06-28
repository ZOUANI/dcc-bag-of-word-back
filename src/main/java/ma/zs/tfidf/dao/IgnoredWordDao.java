package ma.zs.tfidf.dao;

import ma.zs.tfidf.bean.IgnoredWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgnoredWordDao extends JpaRepository<IgnoredWord,Long> {
    IgnoredWord findByWord(String word);
}
