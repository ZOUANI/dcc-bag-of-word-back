package ma.zs.tfidf;

import ma.zs.tfidf.bean.Tag;
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

    private List<Tag> tags = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
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
