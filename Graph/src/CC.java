import java.util.ArrayList;

public class CC {

    private Graph G;
    private boolean[] visited;
    private int cccount;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    /*
        二叉树的遍历：
        前序遍历： 遍历发生在递归的前面。
        中序遍历： 先去递归访问左子树， 再遍历当前节点， 再递归的访问右子树
        后序遍历： 实际遍历的位置在两次递归的后面
    */
    public CC(Graph G){

        this.G = G;
        visited = new boolean[G.V()];       
        for(int i = 0; i < G.V(); i++){
            if(!visited[i]){
                dfs(i);
                cccount++;
            }
        }
    }

    private void dfs(int v){

        visited[v] = true;
        for(int w: G.adj(v))
            if(!visited[w]){
                dfs(w);
            }
    }

    public int count(){
        return cccount;
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args){

        Graph g = new Graph("../g.txt");
        // GraphDFS graphDFS = new GraphDFS(g);
        CC cc = new CC(g);
        System.out.println(cc.count());
    }
}
