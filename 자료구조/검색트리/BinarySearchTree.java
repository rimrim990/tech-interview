package 자료구조.검색트리;

public class BinarySearchTree implements IndexInterface<TreeNode> {
    private TreeNode root;
    public BinarySearchTree() {
        root = null;
    }

    @Override
    public TreeNode search(Comparable x) {
        return searchItem(root, x);
    }

    private TreeNode searchItem(TreeNode root, Comparable x) {
        while (root != null) {
            if (root.key.compareTo(x) == 0) {
                return root;
            }
            if (root.key.compareTo(x) < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    // 삽입
    @Override
    public void insert(Comparable x) {
        root = insertItem(root, x);
    }

    private TreeNode insertItem(TreeNode root, Comparable x) {
        TreeNode newNode = new TreeNode(x);
        if (root == null) return newNode;
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.key.compareTo(x) < 0) {
                if (curNode.right == null) {
                    curNode.right = newNode;
                    break;
                }
                curNode = curNode.right;

            } else {
                if (curNode.left == null) {
                    curNode.left = newNode;
                    break;
                }
                curNode = curNode.left;
            }
        }
        return root;
    }

    // 삭제
    @Override
    public void delete(Comparable x) {
        root = deleteItem(root, x);
    }

    public void preOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.key + " ");
        if (root.left != null) printPreOrder(root.left);
        if (root.right != null) printPreOrder(root.right);
    }

    private TreeNode deleteItem(TreeNode root, Comparable x) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.key.compareTo(x) == 0) {
                if (prev == null) { // 루트 노드 삭제
                    return deleteNode(cur);
                } else if (prev.left == cur) {
                    prev.left = deleteNode(cur);
                } else {
                    prev.right = deleteNode(cur);
                }
                break;
            } else if (cur.key.compareTo(x) < 0) {
                prev = cur;
                cur = cur.left;
            } else {
                prev = cur;
                cur = cur.right;
            }
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode node) {
        if (node.left == null && node.right == null) { // CASE1. 자식 노드가 없음
            return null;
        } else if (node.left == null) { // CASE2. 자식 노드가 한개임 (오른쪽)
            return node.right;
        } else if (node.right == null) { // CASE3. 자식 노드가 한개임 (왼쪽)
            return node.left;
        } else { // CASE3. 자식 노드가 두개임
            // 오른쪽 서브트리의 최솟값 노드 찾기
            return deleteMin(node);
        }
    }

    private TreeNode deleteMin(TreeNode node) {
        TreeNode find = node.right;
        TreeNode prev = node;
        while (find != null) {
            if (find.left == null) {
                node.key = find.key;
                prev.left = deleteNode(find);
                break;
            }
            prev = find;
            find = find.left;
        }
        return node;
    }

    public TreeNode getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }
}
