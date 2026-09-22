import java.util.Arrays;
class Solution {
    static class Node{
        int[] remain;
        int prod;
        Node(int k){
            this.remain = new int[k];
            this.prod = 1;
        }
    }
    private int k;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        /* These failed it called these brute force huhhh it faced TLE at 775/783 test case !!!!!!!
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            nums[queries[i][0]] = queries[i][1]; //update
            int product = 1;
            int validway = 0;
            for(int j = queries[i][2]; j < nums.length; j++){
                product = (product*(nums[j]%k))%k;

                if(product == queries[i][3]){
                    validway++;
                }
            }
            result[i] = validway;
        }
        **/
        this.k = k;
        int n = nums.length;
        this.tree = new Node[4*n];
        //initialize tree
        buildTree(nums,0,0,n-1);
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];
            //update
            updateTree(0,0,n-1,idx,val);
            //query range from start to end of nums array
            Node queryResult = queryTree(0,0,n-1,start,n-1);
            //extract count final output
            result[i] = queryResult.remain[targetX];
        }
        return result;
    }
     private void buildTree(int[] nums, int node, int start , int end){
        if(start == end){
            tree[node] = new Node(k);
            int rem = nums[start] % k;
            tree[node].remain[rem] = 1;
            tree[node].prod = rem;
            return;
        }
        int mid = start + (end - start)/2;
        buildTree(nums,2*node+1, start, mid);
        buildTree(nums, 2*node +2, mid+1, end);
        tree[node] = merge(tree[2*node+1], tree[2* node +2]);
     }

     private Node merge(Node left, Node right){
        Node parent = new Node(k);
        parent.prod = (left.prod * right.prod)%k;
        //copy prefix from left child
         for(int i = 0; i < k; i++){
             parent.remain[i] += left.remain[i];
         }
         //shift and copy prefix from roght child
         for(int i = 0; i<k;i++){
             if(right.remain[i] > 0){
                 int nextRemainder = (left.prod * i)%k;
                 parent.remain[nextRemainder] += right.remain[i];
             }
         }
         return parent;
     }

     private void updateTree(int node, int start, int end, int idx, int val){
         if(start == end){
             tree[node] = new Node(k);
             int rem = val % k;
             tree[node].remain[rem] = 1;
             tree[node].prod = rem;
             return;
         }
         int mid = start + (end - start)/2;
         if(idx <= mid){
             updateTree(2*node + 1, start ,mid, idx,val);
         }else{
             updateTree(2*node+2, mid+1, end, idx, val);
         }
         tree[node] = merge(tree[2*node+1], tree[2*node+2]);
     }

     private Node queryTree(int node, int start, int end, int l, int r){
        //complete overlap
         if(l <= start && end <= r){
             return tree[node];
         }
         int mid = start + (end - start)/2;
         //check if query is strictly in left or right child
         if(r <= mid){
             return queryTree(2*node+1, start,mid,l,r);
         }
         if(l > mid){
             return queryTree(2*node+2,mid+1,end,l,r);
         }
         //overlaps both children
         Node leftChild = queryTree(2*node+1 , start,mid,l,r);
         Node rightChild = queryTree(2*node+2, mid+1, end, l,r);
         return merge(leftChild, rightChild);
     }
     public static void main(String[] args) {
        Solution nw = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[][] queries = {{2,2,0,2},{3,3,3,0},{0,1,0,1}};
        int[] output = nw.resultArray( nums, 3, queries);
        System.out.print(Arrays.toString(output));
    }
}