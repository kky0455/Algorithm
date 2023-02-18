import java.util.*;
import java.io.*;
// 트리 문제
// 자바로 트리를 직접 구현해본 문제
// 파이썬은 딕셔너리를 이용해서 노드번호를 지정했는데 자바는 직접 탐색해서 자식 노드를 넣어줬다.
// 나머지는 조건에 맞춰 그대로 구현
public class B1991 {
    static int N;
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insert(head, root, left, right);
        }
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
        System.out.println();
    }

    static class Node{
        char root;
        Node left;
        Node right;

        Node(char root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    public static void insert(Node tmp, char root, char left, char right) {
        if (tmp.root == root) {
            if (left == '.') {
                tmp.left = null;
            }else {
                tmp.left = new Node(left, null, null);
            }
            if (right == '.') {
                tmp.right = null;
            }else {
                tmp.right = new Node(right, null, null);
            }
        } else {
            if (tmp.left != null) {
                insert(tmp.left, root, left, right);
            }
            if (tmp.right != null) {
                insert(tmp.right, root, left, right);
            }
        }
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.root);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.root);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.root);
    }
}
