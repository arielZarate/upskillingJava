package SimpleListOrdenada;

public class Nodo {
  private int info;
  private Nodo next;

  public Nodo(int info, Nodo next) {
    this.info = info;
    this.next = next;
  }
  public Nodo()
  {
  }

  public int getInfo() {
    return info;
  }

  public void setInfo(int info) {
    this.info = info;
  }

  public Nodo getNext() {
    return next;
  }

  public void setNext(Nodo next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Nodo{" +
            "info=" + info +
            ", next=" + next +
            '}';
  }
}




