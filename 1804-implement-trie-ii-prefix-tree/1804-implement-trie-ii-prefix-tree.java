class Trie {

	private static class TrieNode {
		char val;
		int wordCount;
		int prefixCount;
		Map<Character, TrieNode> children = new HashMap<>(26);

		TrieNode(char val) {
			this.val = val;
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode('#');
	}

	public void insert(String word) {
		var node = root;

		for (var i = 0; i < word.length(); i++) {
			var key = word.charAt(i);
			node = node.children.computeIfAbsent(word.charAt(i), k -> new TrieNode(key));
			node.prefixCount++;
		}

		node.wordCount++;
	}

	public int countWordsEqualTo(String word) {
		return countWords(word, false);
	}

	public int countWordsStartingWith(String prefix) {
		return countWords(prefix, true);
	}

	private int countWords(String word, boolean isPrefix) {
		var node = root;
		for (var i = 0; i < word.length(); i++) {
			var key = word.charAt(i);
			if (!node.children.containsKey(key))
				return 0;
			node = node.children.get(key);
		}
		return isPrefix ? node.prefixCount : node.wordCount;
	}

	public void erase(String word) {
		var parent = root;

		for (var i = 0; i < word.length(); i++) {
			var key = word.charAt(i);
			var node = parent.children.get(key);

			if (--node.prefixCount == 0) {
				parent.children.remove(key);
				return;
			}
			parent = node;
		}
		parent.wordCount--;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */