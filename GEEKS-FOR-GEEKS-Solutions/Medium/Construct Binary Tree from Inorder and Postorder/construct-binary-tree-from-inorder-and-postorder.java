//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG {
    int postIndex;
    Node buildTree(int in[], int post[], int n) {
        postIndex = n - 1;
        return buildTreeUtil(in, post, 0, n - 1);
    }
    
    Node buildTreeUtil(int in[], int post[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        Node node = new Node(post[postIndex]);
        postIndex--;
        
        if (inStart == inEnd)
            return node;
        
        int inIndex = search(in, inStart, inEnd, node.data);
        
        node.right = buildTreeUtil(in, post, inIndex + 1, inEnd);
        node.left = buildTreeUtil(in, post, inStart, inIndex - 1);
        
        return node; 
    }
    
    int search(int arr[], int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}