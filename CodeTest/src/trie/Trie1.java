package trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trie1 {

  private TrieNode1 rootNode;

  public Trie1() {
    super();
    rootNode = new TrieNode1(' ');
  }

  public void load(String phrase) {
    loadRecursive(rootNode, phrase + "$");
  }

  private void loadRecursive(TrieNode1 node, String phrase) {
	if (phrase==null||phrase.equals("")) {
      return;
    }
    char firstChar = phrase.charAt(0);
    node.add(firstChar);
    TrieNode1 childNode = node.getChildNode(firstChar);
    if (childNode != null) {
      loadRecursive(childNode, phrase.substring(1));
    }
  }

  public boolean matchPrefix(String prefix) {
    TrieNode1 matchedNode = matchPrefixRecursive(rootNode, prefix);
    return (matchedNode != null);
  }

  private TrieNode1 matchPrefixRecursive(TrieNode1 node, String prefix) {
    if (prefix==null||prefix.equals("")) {
      return node;
    }
    char firstChar = prefix.charAt(0);
    TrieNode1 childNode = node.getChildNode(firstChar);
    if (childNode == null) {
      // no match at this char, exit
      return null;
    } else {
      // go deeper
      return matchPrefixRecursive(childNode, prefix.substring(1));
    }
  }

  public List<String> findCompletions(String prefix) {
    TrieNode1 matchedNode = matchPrefixRecursive(rootNode, prefix);
    List<String> completions = new ArrayList<String>();
    findCompletionsRecursive(matchedNode, prefix, completions);
    return completions;
  }

  private void findCompletionsRecursive(TrieNode1 node, String prefix, List<String> completions) {
    if (node == null) {
      // our prefix did not match anything, just return
      return;
    }
    if (node.getNodeValue() == '$') {
      // end reached, append prefix into completions list. Do not append
      // the trailing $, that is only to distinguish words like ann and anne
      // into separate branches of the tree.
      completions.add(prefix.substring(0, prefix.length() - 1));
      return;
    }
    Collection<TrieNode1> childNodes = node.getChildren();
    for (TrieNode1 childNode : childNodes) {
      char childChar = childNode.getNodeValue();
      findCompletionsRecursive(childNode, prefix + childChar, completions);
    }
  }

  public String toString() {
    return "Trie:" + rootNode.toString();
  }


}