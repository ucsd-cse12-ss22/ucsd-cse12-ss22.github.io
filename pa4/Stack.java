public interface Stack {
	  void push(E element);
	  E pop();
	  int size();
}

class StackStringAL implements StackString {
  ArrayStringList<> contents;
  public StackAL() {
    this.contents = new ArrayStringList<>();
  }
  public int size() {
    return this.contents.size();
  }
  public void push(E element) {
    this.contents.add(0, element);
  }
  public E pop() {
    E toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
}