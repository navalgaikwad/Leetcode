class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
       // boolean[]visited = new boolean[n];
        Set<Integer> set = new HashSet<>();
       // visited[root] = true;
        while(!q.isEmpty()) {
            int current = q.remove();
            
            if(!set.add(current)) return false;
            //visited[current] = true;
            if(leftChild[current] != -1) {
                q.add(leftChild[current]);
            }
            if(rightChild[current] != -1) {
                q.add(rightChild[current]);
            }
            
        }
        return set.size()==n;
    }
    
    int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(i);
        }
        for(int leftChld:leftChild) {
            if(leftChld != -1) {
                set.remove(leftChld);
            }
        }
        
         for(int rChild:rightChild) {
            if(rChild != -1) {
                set.remove(rChild);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return set.size()==0? -1: list.get(0);
    }
}