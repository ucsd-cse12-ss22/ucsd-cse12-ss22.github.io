import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestStringList {

  @Test
  public void testAdd() {
    StringList slist = new LinkedStringList();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals("banana", slist.get(1));
    assertEquals("apple", slist.get(0));
  }

  @Test
  public void testAddThenSize() {
    StringList slist = new LinkedStringList();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals(2, slist.size());
  }


  @Test
  public void testAddMany() {
    StringList slist = new LinkedStringList();
    slist.add("a");
    slist.add("b");
    slist.add("c");
    slist.add("d");
    slist.add("e");

    assertEquals("e", slist.get(4));
    assertEquals("d", slist.get(3));
    assertEquals("c", slist.get(2));
    assertEquals("b", slist.get(1));
    assertEquals("a", slist.get(0));

  }


  @Test
  public void testRemove() {
    StringList slist = new LinkedStringList();
    slist.add("a");
    slist.add("b");
    slist.add("c");
    slist.add("d");
    slist.add("e");

    slist.remove(2);

    assertEquals("e", slist.get(3));
    assertEquals("d", slist.get(2));
    assertEquals("b", slist.get(1));
    assertEquals("a", slist.get(0));

    slist.remove(3);

    assertEquals("d", slist.get(2));
    assertEquals("b", slist.get(1));
    assertEquals("a", slist.get(0));

    slist.remove(0);

    assertEquals("d", slist.get(1));
    assertEquals("b", slist.get(0));

    slist.insert(2, "c");

    assertEquals("c", slist.get(2));
    assertEquals("d", slist.get(1));
    assertEquals("b", slist.get(0));

    slist.insert(1, "f");

    assertEquals("c", slist.get(3));
    assertEquals("d", slist.get(2));
    assertEquals("f", slist.get(1));
    assertEquals("b", slist.get(0));

  }


}