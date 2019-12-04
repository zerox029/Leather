package leather.parse.ast;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    //Constructors
    public Node(T data)
    {
        this.data = data;
        this.children = new ArrayList<Node<T>>();
    }
    public Node(T data, List<Node<T>> children)
    {
        this.data = data;
        this.children = children;
    }

    public void addChild(Node<T> child)
    {
        child.parent = this;
        children.add(child);
    }
    public void addChild(T childData)
    {
        Node<T> child = new Node<T>(childData);
        child.parent = this;
        children.add(child);
    }
    public void addChild(Tree<T> tree)
    {
        children.add(tree.getRoot());
    }

    //Setters
    public void setParent(Node<T> parent)
    {
        this.parent = parent;
    }

    //Getters
    public int getChildCount() { return children.size(); }
    public Node<T> getFirstChild() { return children.get(0); }
    public Node<T> getChildAtIndex(int index) { return children.get(index); }
    public Node<T> getParent() { return parent; }
    public T getData() { return data; }
}
