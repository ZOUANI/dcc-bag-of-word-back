package ma.zs.tfidf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course  {


    private Long id;
    private String entitled;
    private String description;
    private int hourlyVolume;
    private String difficulty;
    private int rating;
    private String language;
    private String courseLink;
    private String courseSummarySection;
    private String courseSummarySectionContent;
    private List<Chapter> chapters = new ArrayList<>();
    private String bagOfWords;


}
