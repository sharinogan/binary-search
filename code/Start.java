class Start {

    public static void main(String[] args) {
        int[] b = { 3, 2, 1, 6 ,4, 2, 8 };
                  //   ^              ^
        int left = 0, right = b.length - 1;
        while(left <= right) {
            if (b[left] % 2 == 0 && b[right] % 2 == 0) {
                int t = b[left];
                b[left] = b[right];
                b[right] = t;
                left++;
                right--;
            }
            if (b[left] % 2 != 0 && b[right] % 2 == 0) { left++; }
            if (b[left] % 2 == 0 && b[right] % 2 != 0) { right++; }
            if (b[left] % 2 != 0 && b[right] % 2 != 0) {
                left++;
                right--;
            }
        }
        for (int i = 0; i < b.length; i++)  
            System.out.print(" " + b[i]);
       
        int[] a = { 6, 8, 3, 5, 4, 2, 1 };
        java.util.Arrays.sort(a);  // binary search tree
        Element root = Tool.build(a, 0, a.length - 1);
        //Tool.reveal(root);
    }
}

// Given an array of integers, write code to reverse
// even values.         3 2 1 6 4 2 8
//                        ^   ^ ^ ^ ^
//                      3 8 1 2 4 6 2

class Tool {
    
    // inorder binary tree
    static void reveal(Element e) {
        if (e == null) return;
        reveal(e.left);
        System.out.println(e.value);
        reveal(e.right);
    }
    
    // binary tree
    static Element build(int[]a, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        Element e = new Element();
        e.value = a[mid];
        e.left = build(a, left, mid -1);
        e.right = build(a, mid + 1, right);
        return e;
    }
    
    // binary tree
    static int find(Element e) {
        int c = e.value;
        if (e.left == null && e.right == null) return e.value;
        if (e.left == null && e.right != null){
            int b = find(e.right);
            return b > c ? b : c;
        }
        if (e.left != null && e.right == null){
            int a = find(e.left);
            return a > c ? a : c;
        }
        int a = find(e.left);
        int b = find(e.right);
        if (a >= b && a >= c) return a;
        if (b >= a && b >= c) return b;
        return c;
    }
    
    // binary search tree
    static int findMaxValue(Element e) {
        if (e.right == null) return e.value;
        return findMaxValue(e.right);
    }
    
    static void display(Element e, int status) {
        if (e == null) return;
        status = status * 10 + e.value;
        if (e.left == null && e.right == null) {
            System.out.println(status);
            return;
        }
        display(e.left, status);
        display(e.right, status);
    }
    
    static void show(Element e, String status) {
        if (e == null) return;
        status += e.value;
        if (e.left == null & e.right == null) {
            System.out.println(status + e.value);
            return;
        }
        show(e.left, status + e.value);
        show(e.right, status + e.value);
    }
    
    static Element insert(Element e, int key) {
        if (e == null) {
            e = new Element();
            e.value = key;
            return e;
        }
        if (key < e.value) e.left = insert(e.left, key);
        if (key > e.value) e.right = insert(e.right, key);
        return e;
    }
}

class Element {
    int value;
    Element left;
    Element right;
}
