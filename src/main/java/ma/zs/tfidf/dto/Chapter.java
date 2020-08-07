package ma.zs.tfidf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {


    private Long id;
    private String title;
    private String chapterLink;
    private String chapterSection;
    private String chapterContent;
    private String bagOfWords;
}
