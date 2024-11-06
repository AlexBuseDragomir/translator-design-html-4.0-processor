package html;

import java.util.LinkedList;
import java.util.List;

public class HtmlTagUtility {

    public static HtmlTag htmlTagOf(Tag tag, String tagContent) {
        return new HtmlTag(tag, tagContent);
    }

    public static List<String> getListOfAllTags() {
        Tag[] tags = Tag.values();
        List<String> allTagNames = new LinkedList<>();

        for (Tag tag: tags) {
            allTagNames.add(tag.toString().toLowerCase());
        }

        return allTagNames;
    }
}
