package theory.challenges.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity - O(v+e)
v- no of vertices
e- no of edges

Space complexity - O(v) - due to call stack because of the recursive calls

* */


public class Program {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        /*     A
             B   C
                D
        */
        public List<String> depthFirstSearch(List<String> array) {
            return depthFirstRecursiveSearch(array);
        }

        private List<String> depthFirstRecursiveSearch(List<String> array){
            array.add(name);
            if(children.size()==0){
                return array;
            }

            for(Node n: children){
                n.depthFirstRecursiveSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
