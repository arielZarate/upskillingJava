package ListasSimplesComparable;
public class Nodo {
    //private  Object info ;
    private Comparable info;
    private Nodo next;


   /*
    public Nodo(Object info, Nodo next) {
        this.info = info;
        this.next = next;
    }
    */
    public Nodo(Comparable info, Nodo next) {
        this.info = info;
        this.next = next;
    }

    /*
    public Object getInfo() {
        return (int)info;
    }
     */
    public Comparable getInfo() {
        return info;
    }

    public Nodo getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "info=" + info +
                ", next=" + ((next!=null)? next.toString(): "") +
                '}';
    }
}
