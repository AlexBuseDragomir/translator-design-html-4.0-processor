package tree;

import html.HtmlAttribute;
import utility.NodeUtility;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Node> children;
    private List<HtmlAttribute> attributes;

    public Node(String name, List<Node> children) {
        this.name = name;

        if (children == null) {
            this.children = new ArrayList<>();
        } else {
            this.children = children;
        }

        this.attributes = new ArrayList<>();
    }

    public String getSimpleName() {
        return NodeUtility.getNodeName(this);
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public void updateAttributes() {
        this.attributes = NodeUtility.getNodeAttributes(this);
    }
}