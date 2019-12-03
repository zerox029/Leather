package leather.ast;

import java.awt.desktop.SystemEventListener;
import java.util.*;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData)
    {
        root = new Node<T>(rootData, new ArrayList<Node<T>>());
    }

    public Queue<Node<T>> preOrderDFSTraversal()
    {
        Queue<Node<T>> orderedNodes = new LinkedList<>();
        orderedNodes.add(root);

        orderedNodes = preOrderDfsTraverseChildren(orderedNodes, root);

        return orderedNodes;
    }

    private Queue<Node<T>> preOrderDfsTraverseChildren(Queue<Node<T>> orderedNodes, Node<T> currentNode)
    {
        for(Node<T> child : currentNode.getChildren())
        {
            if(!orderedNodes.contains(child))
            {
                currentNode = child;
                orderedNodes.add(child);
                orderedNodes = preOrderDfsTraverseChildren(orderedNodes, currentNode);
            }
        }

        return orderedNodes;
    }

    public Queue<Node<T>> PostOrderDFSTraversal()
    {
        Queue<Node<T>> orderedNodes = new LinkedList<>();

        orderedNodes = postOrderDfsTraverseChildren(orderedNodes, root);

        return orderedNodes;
    }

    private Queue<Node<T>> postOrderDfsTraverseChildren(Queue<Node<T>> orderedNodes, Node<T> currentNode)
    {
        for(Node<T> child : currentNode.getChildren())
        {
            if(!orderedNodes.contains(child))
            {
                if(child.getChildCount() == 0)
                {
                    //orderedNodes.add(child);
                    orderedNodes = preOrderDfsTraverseChildren(orderedNodes, currentNode.getParent());
                }
                else
                {
                    preOrderDfsTraverseChildren(orderedNodes, child);
                }
            }
        }

        return orderedNodes;
    }

    public Node getRoot() { return root; }
}
