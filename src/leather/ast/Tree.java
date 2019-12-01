package leather.ast;

import java.util.ArrayList;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData)
    {
        root = new Node<T>(rootData, new ArrayList<Node<T>>());
    }

    public Node getRoot() { return root; }
}
