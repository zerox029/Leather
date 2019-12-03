package leather.ast;

import javax.lang.model.type.ArrayType;
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

    //Setters
    public void setParent(Node<T> parent)
    {
        this.parent = parent;
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

    //Getters
    public int getChildCount() { return children.size(); }
    public List<Node<T>> getChildren() { return children; }
    public Node<T> getFirstChild() { return children.get(0); }
    public Node<T> getChildAtIndex(int index) { return children.get(index); }
    public Node<T> getParent() { return parent; }
    public T getData() { return data; }
}
