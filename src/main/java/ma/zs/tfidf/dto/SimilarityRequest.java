package ma.zs.tfidf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimilarityRequest {

    private String bagOfWords;
    private String text;
    private double similarity;

}
