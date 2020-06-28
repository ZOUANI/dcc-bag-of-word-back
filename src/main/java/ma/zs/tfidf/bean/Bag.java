package ma.zs.tfidf.bean;

import lombok.Data;

@Data
public class Bag {
    private String word;
    private double tf;

    public Bag(String word, double tf) {
        this.word = word;
        this.tf = tf;
    }
}
