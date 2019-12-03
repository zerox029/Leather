package leather.ast;

import java.util.*;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData)
    {
        root = new Node<T>(rootData, new ArrayList<Node<T>>());
    }

    public Queue<Node<T>> toQueuePreOrderDFS()
    {
        Queue<Node<T>> orderedNodes = new LinkedList<>();
        orderedNodes.add(root);

        orderedNodes = preOrderDfsTraverseChildren(orderedNodes, root);

        return orderedNodes;
    }

    private Queue<Node<T>> preOrderDfsTraverseChildren(Queue<Node<T>> orderedNodes, Node<T> currentNode)
    {
        for(int i = 0; i < currentNode.getChildCount(); i++)
        {
            if(!orderedNodes.contains(currentNode.getChildAtIndex(i)))
            {
                orderedNodes.add(currentNode.getChildAtIndex(i));
                orderedNodes = preOrderDfsTraverseChildren(orderedNodes, currentNode.getChildAtIndex(i));
            }
        }

        return orderedNodes;
    }

    public Queue<Node<T>> toQueuePostOrderDFS()
    {
        Queue<Node<T>> orderedNodes = new LinkedList<>();

        postOrderDfsTraverseChildren(orderedNodes, root);

        return orderedNodes;
    }

    private void postOrderDfsTraverseChildren(Queue<Node<T>> orderedNodes, Node<T> currentNode)
    {
        for(int i = 0; i < currentNode.getChildCount(); i++)
        {
            //If it's a branch, loop through its children
            if(currentNode.getChildAtIndex(i).getChildCount() != 0)
            {
                postOrderDfsTraverseChildren(orderedNodes, currentNode.getChildAtIndex(i));
            }
            //If it's a leaf, add it to the queue
            else if(!orderedNodes.contains(currentNode.getChildAtIndex(i)))
            {
                orderedNodes.add(currentNode.getChildAtIndex(i));
            }
        }

        orderedNodes.add(currentNode);
    }

    public Node getRoot() { return root; }
}
