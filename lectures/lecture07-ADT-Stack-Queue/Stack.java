import java.util.ArrayList;

public interface Stack<E> {
  void push(E element);
  E pop();
  int size();
}

class ALStack<E> implements Stack<E> {
























  public String toString() {
    return "top → " + this.contents.toString();
  }
}
