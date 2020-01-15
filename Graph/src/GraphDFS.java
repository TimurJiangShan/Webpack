import java.util.ArrayList;

public class GraphDFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    /*
        二叉树的遍历：
        前序遍历： 遍历发生在递归的前面。
        中序遍历： 先去递归访问左子树， 再遍历当前节点， 再递归的访问右子树
        后序遍历： 实际遍历的位置在两次递归的后面
    */
    public GraphDFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];       
        for(int i = 0; i < G.V(); i++){
            if(!visited[i])
                dfs(i);
        }
    }

    private void dfs(int v){

        visited[v] = true;
        pre.add(v);               // 深度优先先序遍历
        for(int w: G.adj(v))
            if(!visited[w])
                dfs(w);
        post.add(v);              // 深度优先后序遍历
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args){

        Graph g = new Graph("../g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println("DFS preOrder : " + graphDFS.pre());
        System.out.println("DFS postOrder : " + graphDFS.post());
    }
}
