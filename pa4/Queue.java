public interface Queue {
  void enqueue(E element);
  E dequeue();
}

public class QueueStringAL {
  ArrayStringList<E> contents;
  public QueueStringAL() {
    this.contents = new ArrayStringList<>();
  }

  public void enqueue(E element) {
    this.contents.add(this.contents.size(), element);
  }
  public E dequeue() {
    E toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
}