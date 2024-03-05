package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String text;
    private TagInterface childTag;

    LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", text, childTag.render());
    }
}
// END
