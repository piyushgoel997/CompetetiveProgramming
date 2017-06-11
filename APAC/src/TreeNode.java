import java.util.ArrayList;

/**
 * Created by Piyush on 23-10-2016.
 */
public class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public ArrayList<TreeNode<T>> getChildren() {
        return children;
    }

    public void addChildren(T data) {
        TreeNode<T> child = new TreeNode<T>(data);
        children.add(child);
    }

    public TreeNode<T> searchInChildren(T data) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getData().equals(data)) {
                return children.get(i);
            }
        }
        return null;
    }
}
