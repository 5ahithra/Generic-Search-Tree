
//Sahithra Kesavan
//GenericNode
//The purpsoe of this file is to create a generic ndoe that is to be used in the generic searchtree class

public class GenericNode<T extends Comparable<T>>
{
    T data;
    GenericNode<T> left;
    GenericNode<T> right;

    public GenericNode(T data) 
    {
        this(data, null, null);
    }

    public GenericNode(T data, GenericNode<T> left, GenericNode<T> right) 
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
