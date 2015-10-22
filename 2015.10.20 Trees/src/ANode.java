/**
 * Abstract Node Class.
 *
 * Supports many types of nodes that can have many types of data. Hopefully it is extensible enough to use for most types
 * of trees.
 *
 * @author JD Porterfield
 */
public abstract class ANode<T> implements INode<T>{

    protected INode children[];
    protected INode parent;
    protected int n;
    protected T data;


    public void printTree(){
    }



    @Override
    public String toString(){
        String result = "";
        result += (data+"[");

        for(int i = 0; i < n; i++){
            if(children[i] != null)
                result += children[i].toString();

            if(i < n - 1)
                result += ",";
        }
        result += "]";

        return result;
    }

    public INode[] getChildren(){
        return children;
    }

    @Override
    public boolean checkFor(INode node){
        if(this.equals(node))
            return true;

        for(INode child : children) {
            if(child == null)
                continue;
            if (child.checkFor(node))
                return true;
        }

        return false;
    }

    @Override
    public boolean checkFor(T data){
        if(this.getData().equals(data))
            return true;

        for(INode child : children) {
            if(child == null)
                continue;
            if (child.checkFor(data))
                return true;
        }

        return false;
    }

    @Override
    public T getData(){
        return data;
    }

    @Override
    public void replaceChild(INode child, INode replacement) {
        for(int i = 0; i < children.length; i++)
            if(children[i].equals(child))
                children[i] = replacement;
    }

    @Override
    public void setParent(INode node){
        parent = node;
    }

    @Override
    public INode getParent(){
        return parent;
    }
}
