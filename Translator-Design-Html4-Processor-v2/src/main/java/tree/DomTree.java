package tree;

import file.FileWriterUtility;
import utility.FileUtility;
import utility.NodePrinter;

public class DomTree {

    private Node root;

    private static final FileUtility FILE_UTILITY = new FileUtility();
    private static final FileWriterUtility FILE_WRITER_UTILITY = new FileWriterUtility();

    public DomTree() {
        this.root = null;
    }

    public DomTree(Node root) {
        this.root = root;
    }

    public void writeTreeToFile(String fileName, int indentationValue) {
        printTree(fileName, indentationValue);
    }

    public void writeTreeAsHtmlToFile(String fileName, int indentationValue) {
        printTreeAsHtml(fileName, indentationValue);
    }

    public void addRoot(Node root) {
        this.root = root;
    }

    public Node obtainRoot() {
        return root;
    }

    // private methods for the printing functionality

    private void printTree(String fileName, int indentationValue) {
        FILE_UTILITY.eraseContentFromFile(fileName);

        FILE_WRITER_UTILITY.appendStringToFile(root.getName().toUpperCase(), fileName);
        FILE_WRITER_UTILITY.appendStringToFile("\n\n", fileName);

        root.getChildren().forEach(child -> {
            NodePrinter.print(child, indentationValue, indentationValue);
        });
    }

    private void printTreeAsHtml(String fileName, int indentationValue) {
        FILE_UTILITY.eraseContentFromFile(fileName);

        FILE_WRITER_UTILITY.appendStringToFile(root.getName(), fileName);
        FILE_WRITER_UTILITY.appendStringToFile("\n\n", fileName);

        root.getChildren().forEach(child -> {
            NodePrinter.printAsHtml(child, indentationValue, indentationValue);
        });
    }
}