package ma.zs.tfidf.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ma.zs.tfidf.bean.Bag;
import ma.zs.tfidf.dto.BagRequest;
import ma.zs.tfidf.dto.Course;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BagService {
    public List<Bag> makeBag(BagRequest br);
    public Course makeBagsCourse(Course course) throws JsonProcessingException;
}
