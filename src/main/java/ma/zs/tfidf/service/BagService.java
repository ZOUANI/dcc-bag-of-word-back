package ma.zs.tfidf.service;

import ma.zs.tfidf.bean.Bag;
import ma.zs.tfidf.dto.BagRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BagService {
    public List<Bag> makeBag(BagRequest br);
}
