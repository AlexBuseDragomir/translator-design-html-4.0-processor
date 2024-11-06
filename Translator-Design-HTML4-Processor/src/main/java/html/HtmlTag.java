package html;

public class HtmlTag {

    private Tag tag;
    private String tagContent;

    public HtmlTag(Tag tag, String tagContent) {
        this.tag = tag;
        this.tagContent = tagContent;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    @Override
    public String toString() {
        return tag.toString();
    }
}
