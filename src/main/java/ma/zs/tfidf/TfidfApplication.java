package ma.zs.tfidf;

import ma.zs.tfidf.bean.IgnoredWord;
import ma.zs.tfidf.bean.Tag;
import ma.zs.tfidf.service.IgnoredWordService;
import ma.zs.tfidf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class TfidfApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TfidfApplication.class, args);
    }

    @Autowired
    private TagService tagService;
    @Autowired
    private IgnoredWordService ignoredWordService;

    private List<Tag> tags = new ArrayList<>();
    private List<IgnoredWord> ignoredWords = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
//        Stream.of("the","of", "to", "and", "a", "in", "is", "it",
//                "you", "that", "he" ,"was", "for", "on", "are" ,"with",
//                "as", "I", "his", "they", "be", "at", "one", "have",
//                "this", "from", "or", "had", "by", "but", "some", "what" ,
//                "there" ,"we", "can", "out", "other" ,"were", "all",
//                "your", "when" ,"up" ,"use" ,"word", "how" , "an", "each",
//                "she", "which" ,"do", "their", "if", "will", "way", "about" ,
//                "many", "then" ,"them", "would" , "like", "so", "these",
//                "her" , "thing" , "him", "two", "has",  "more" , "could",
//                "did", "my", "sound" ,"no", "most", "number", "who",
//                "over", "know", "than" , "first" , "may" ,"down" , "been",
//                "now",  "any", "new" , "get" , "made",  "where", "after",
//                "back", "little" ,"only", "round" , "year",  "every", "good" ,
//                "me" , "our", "under" , "very", "through", "just" ,"form",
//                "much", "great" ,"think" ,  "before" , "cause", "same",
//                "mean"  , "right" , "old", "too", "does", "tell" , "three",
//                "want" , "well", "also" , "small", "end", "put", "home" ,
//                "add", "even"  ,"here" ,"must", "big", "high", "such" ,
//                "why", "kind" ,"off", "need", "house" ,"picture", "try", "us",
//                "again" , "world", "near" , "self" , "own" , "should" , "found",
//                "answer" , "thought", "let" ,"keep",  "never", "last" ,
//                "between" , "since", "hard" ,"start" ,"might",  "left" ,"late" ,
//                "don't", "while" ,"real", "life", "few", "stop" ,"open",
//                "seem", "together", "next" ,"white" , "got" , "example" ,
//                "often", "always" , "those", "both" , "until", "mile" ,
//                "second", "group" , "once" , "sure",  "main", "enough" ,
//                "usual" , "above", "ever" , "though"  ,"soon"  ,"half" ,
//                "top", "whole" , "best" ,"better", "TRUE" ,"during" , "am" ,
//                "less" ,"simple", "against" , "center" ,"certain", "yet", "yes"
//        ).forEach(w->{
//            ignoredWords.add(new IgnoredWord(null,w));
//        });
//        ignoredWordService.create(ignoredWords);
//        Stream.of(
//                "DOCTYPE",
//                "a",
//                "abb",
//                "acronym",
//                "address",
//                "applet",
//                "area",
//                "article",
//                "aside",
//                "audio",
//                "b",
//                "base",
//                "basefont",
//                "bdi",
//                "bdo",
//                "big",
//                "blockquot",
//                "body",
//                "br",
//                "button",
//                "canvas",
//                "caption",
//                "center",
//                "cite",
//                "cod",
//                "col",
//                "colgroup",
//                "data",
//                "datalist",
//                "dd",
//                "del",
//                "detail",
//                "dfn",
//                "dialo",
//                "di",
//                "div",
//                "dl",
//                "dt",
//                "em",
//                "embed",
//                "fieldset",
//                "figcaptio",
//                "figur",
//                "font",
//                "footer",
//                "form",
//                "frame",
//                "frameset",
//                "h1",
//                "h2",
//                "h3",
//                "h4",
//                "h5",
//                "h6",
//                "head",
//                "header",
//                "hr",
//                "html",
//                "i",
//                "iframe",
//                "img",
//                "input",
//                "ins",
//                "kbd",
//                "label",
//                "legend",
//                "li",
//                "link",
//                "main",
//                "map",
//                "mark",
//                "meta",
//                "meter",
//                "nav",
//                "noframes",
//                "noscript",
//                "object",
//                "ol",
//                "optgroup",
//                "option",
//                "output",
//                "p",
//                "param",
//                "picture",
//                "pre",
//                "progress",
//                "q",
//                "rp",
//                "rt",
//                "ruby",
//                "s",
//                "samp",
//                "script",
//                "section",
//                "select",
//                "small",
//                "source",
//                "span",
//                "strike",
//                "strong",
//                "style",
//                "sub",
//                "summary",
//                "sup",
//                "svg",
//                "table",
//                "tbody",
//                "td",
//                "template",
//                "textarea",
//                "tfoot",
//                "th",
//                "thead",
//                "time",
//                "title",
//                "tr",
//                "track",
//                "tt",
//                "u",
//                "ul",
//                "var",
//                "video",
//                "wbr"
//        ).forEach(tag ->{
//            tags.add(new Tag(null,tag));
//        });
//        tagService.create(tags);
    }
}
