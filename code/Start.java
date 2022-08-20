class Start {

    public static void main(String[] args) {
        int[] a = { 1, 2, 6, 3, 8 };
        
        Element list = create(a);
        print(list);
        
    }
    
    static Element create(int ... data) {
        Element head = null;
        Element tail = null;
        for (int i = 0; i < data.length; i++) {
            if (tail == null) {
                tail = new Element();
                tail.number = data[i];
                head = tail;
            } else {
                tail.next = new Element();
                tail.next.number = data[i];
                tail = tail.next;
            }
        }
        return head;
    }
    
    static void print(Element e) {
        if (e == null) return;
        System.out.println(e.number);
        print(e.next);
    }
}

class Element {
    String name;
    int number;
    Element next;
}
