package trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class TrieNode1 {

  private Character character;
  private HashMap<Character,TrieNode1> children;

  public TrieNode1(char c) {
    super();
    this.character = new Character(c);
    children = new HashMap<Character,TrieNode1>();
  }

  public char getNodeValue() {
    return character.charValue();
  }

  public Collection<TrieNode1> getChildren() {
    return children.values();
  }

  public Set<Character> getChildrenNodeValues() {
    return children.keySet();
  }

  public void add(char c) {
    if (children.get(new Character(c)) == null) {
      // children does not contain c, add a TrieNode
      children.put(new Character(c), new TrieNode1(c));
    }
  }

  public TrieNode1 getChildNode(char c) {
    return children.get(new Character(c));
  }

  public boolean contains(char c) {
    return (children.get(new Character(c)) != null);
  }

  public int hashCode() {
    return character.hashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof TrieNode1)) {
      return false;
    }
    TrieNode1 that = (TrieNode1) obj;
    return (this.getNodeValue() == that.getNodeValue());
  }


}