//SearchTree
//Sahithra Kesavan
//The purpose of this file is to make a generic search tree class that is compatiable with any date type

import java.util.Collection;
import java.util.Stack;

public class SearchTree<T extends Comparable<T>> 
{

    private GenericNode<T> overallRoot;
    private int size;

    public SearchTree() 
    {
        overallRoot = null;
    }

    public SearchTree(T value) 
    {
        overallRoot = new GenericNode<>(value);
    }

    public SearchTree(Collection<T> list)
    {
        overallRoot = null;
        
        for (T value : list) 
        {
            add(value);
        }
    }

    public int getSize() 
    {
        return size;
    }

    public void clear() 
    {
        overallRoot = null;
    }

    public T smallest()
    {
        if (overallRoot == null) 
        {
            throw new IllegalStateException("The tree is empty");
        }

        GenericNode<T> current = overallRoot;

        while (current.left != null) 
        {
            current = current.left;
        }

        return current.data;
    }

    public T largest()
    {
        if (overallRoot == null)
        {
            throw new IllegalStateException("tree is empty");
        }

        GenericNode<T> current = overallRoot;
        while (current.right != null) 
        {
            current = current.right;
        }

        return current.data;
    }

    public int countLeaves(GenericNode<T> root)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.left == null && root.right == null) 
        {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public boolean isEmpty() 
    {
        return overallRoot == null;
    }

    public void add(T value) 
    {
        overallRoot = add(overallRoot, value);
    }

    private GenericNode<T> add(GenericNode<T> root, T value) 
    {
        if (root == null) 
        {
            size++;
            return new GenericNode<>(value);
        }

        if (value.compareTo(root.data) < 0) 
        {
           
        	root.left = add(root.left, value);
        } 
        else if (value.compareTo(root.data) > 0) 
        {
            root.right = add(root.right, value);
        }

        return root;
    }

    public boolean contains(T value)
    {
        return contains(overallRoot, value);
    }

    private boolean contains(GenericNode<T> root, T value) 
    {
        if (root == null)
        {
            return false;
        }

        if (value.compareTo(root.data) < 0) 
        {
            return contains(root.left, value);
        } 
        
        else if (value.compareTo(root.data) > 0) 
        {
            return contains(root.right, value);
        } 
        else 
        {
            return true;
        }
    }

    private static <T extends Comparable<T>> GenericNode<T> minNode(GenericNode<T> root) 
    {
        if (root == null)
        {
            return null;
        }

        while (root.left != null) 
        {
            root = root.left;
        }

        return root;
    }

    //Does not work
    public boolean remove(T value) 
    {
    	GenericNode<T> parent = null;
    	GenericNode<T> current = overallRoot;

        while (current != null && current.data.compareTo(value) != 0) 
        {
            parent = current;
            if (value.compareTo(current.data) < 0) 
            {
                current = current.left;
            } else 
            {
                current = current.right;
            }
        }

        if (current == null)
        {
            return false;
        }

       

        size--;
        return true;
    }

    public String toString() 
    {
        if (overallRoot == null)
        {
            return "";  
        }

        String result = "";

        Stack<GenericNode<T>> stack = new Stack<>();
        GenericNode<T> current = overallRoot;

        while (current != null || !stack.isEmpty())
        {
            while (current != null) 
            {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result += current.data + " ";
            current = current.right;
        }

        return result;
    }

    private String inOrderTraversal(GenericNode<T> root) {
        if (root == null)
        {
            return "";
        }

        String lefttree = inOrderTraversal(root.left);
        String currentNode = root.data + " ";
        String righttree = inOrderTraversal(root.right);
 
        return lefttree + currentNode + righttree;
    }


    
}
