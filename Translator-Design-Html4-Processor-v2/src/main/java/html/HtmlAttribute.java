package html;

public abstract class HtmlAttribute {

    private String name;
    private String value;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Attribute: " + name + " with value: " + value;
    }

    public abstract boolean isSyntacticallyValid();
}
