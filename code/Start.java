class Start {

    public static void main(String[] args) {
        //Object o = new Object();
        //System.out.println(o); // Address in memory
        
        Element first;
        first = new Element();
        first.name = "Hydrogen";
        first.number = 1;
        System.out.println(first.name);
        System.out.println(first.number);
        
        Element second = new Element();
        second.name = "Helium";
        second.number = 2;
        System.out.println(second.name);
        System.out.println(second.number);
        
    }
}

class Element {
    String name;
    int number;
    Element next;
}
