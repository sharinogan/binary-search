
class Start {

    public static void main(String[] args) {
        int[] a = { 6, 8, 3, 5, 4, 2, 1, 9 };
        Element root = null;
        for(int i = 0; i < a.length; i++) {
            root = Tool.insert(root, a[i]);
        }
        System.out.println(root.value);
        System.out.println(root.right.value);
    }
}

class Tool {
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
