package exercise;

// BEGIN
interface TagInterface {
    String render();
}

// Класс для представления тега <input>
class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", type, value);
    }
}
// END
