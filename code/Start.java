
class Start {

    public static void main(String[] args) {
        int[] a = { 6, 8, 3, 5, 4, 2, 1, 9 };
        Element root = null;
        for(int i = 0; i < a.length; i++) {
            root = Tool.insert(root, a[i]);
        }
        root = Tool.insert(root, 7);
        Tool.show(root, "");
    }
}

class Tool {
    
    static void show(Element e, String status) {
        if (e == null) return;
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
