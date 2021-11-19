
public class TreeNode<T> {

	private TreeNode<T> parentNode;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    
    private T data;
    
    public TreeNode()
    {
        this.setData(null);
        this.setParentNode(null);
        this.setLeftChild(null);
        this.setRightChild(null);
    }
    
    public TreeNode(TreeNode<T> parent)
    {
        this.setData(null);
        this.setParentNode(parent);
        this.setLeftChild(null);
        this.setRightChild(null);
    }
    
    public TreeNode(TreeNode<T> parent, T data)
    {
        this.setData(data);
        this.setParentNode(parent);
        this.setLeftChild(null);
        this.setRightChild(null);
    }
    
    public T getData()
    {
        return this.data;
    }
    
    public void setData(T newEntry)
    {
        this.data = newEntry;
    }
    
    public TreeNode<T> getLeftChild()
    {
        return this.leftChild;
    }
    
    public void setLeftChild(TreeNode<T> left)
    {
        this.leftChild = left;
    }
    
    public TreeNode<T> getRightChild()
    {
        return this.rightChild;
    }
    
    public void setRightChild(TreeNode<T> right)
    {
        this.rightChild = right;
    }
    
    public TreeNode<T> getParentNode()
    {
        return this.parentNode;
    }
    
    public void setParentNode(TreeNode<T> parent)
    {
        this.parentNode = parent;
    }
    
    public Boolean isLeaf()
    {
        if(this.getLeftChild() == null && this.getRightChild() == null)
            return true;
        else
            return false;
    }
}
