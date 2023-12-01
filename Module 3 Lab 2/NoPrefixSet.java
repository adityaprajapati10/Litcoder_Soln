import java.util.*;
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i) {
            children[i] = null;
        }
        isEnd = false;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    boolean hasPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
            if (node.isEnd) {
                return true;
            }
        }
        return false;
    }
}

public class NoPrefixSet {
    static boolean isGoodPassword(List<String> passwords) {
        Trie trie = new Trie();
        for (String password : passwords) {
            if (trie.hasPrefix(password)) {
                System.out.println("BAD PASSWORD");
                return false;
            }
            trie.insert(password);
        }
        System.out.println("GOOD PASSWORD");
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Scanner ss = new Scanner(input);
        List<String> passwords = new ArrayList<>();
        while (ss.hasNext()) {
            passwords.add(ss.next());
        }

        isGoodPassword(passwords);
        sc.close();
        ss.close();
    }
}
