package ma.zs.tfidf.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.zs.tfidf.bean.Bag;

import java.util.List;

public class BagOfWordsUtil {

    public static double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

//    public double idf(List<List<String>> docs, String term) {
//        double n = 0;
//        for (List<String> doc : docs) {
//            for (String word : doc) {
//                if (term.equalsIgnoreCase(word)) {
//                    n++;
//                    break;
//                }
//            }
//        }
//        return Math.log(docs.size() / n);
//    }
//
//    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
//        return tf(doc, term) * idf(docs, term);
//
//    }

    public static List<Bag> stringJsonToBagsList(String bagJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(bagJson, new TypeReference<List<Bag>>(){});
    }

    public static double comapreBags(List<Bag> currentBags , String originalBag) throws JsonProcessingException {
        double res = 0;
        List<Bag> originalBags =  stringJsonToBagsList(originalBag);
        for (Bag bag : originalBags) {
            for (Bag currentBag : currentBags) {
                if (bag.getWord().equalsIgnoreCase(currentBag.getWord())){
                    res += bag.getTf() * currentBag.getTf();
                }
            }
        }
        return res;
    }

}
