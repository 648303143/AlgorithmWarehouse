package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 前缀树
 *
 * @author zhangqingyang
 * @date 2022-06-02-10:52
 */
public class TrieTree {

    public TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char aChar : chars) {
            if (cur.paths.get(aChar) == null) {
                cur.paths.put(aChar, new TrieNode());
            }
            cur.pass++;
            cur = cur.paths.get(aChar);
        }
        cur.pass++;
        cur.end++;
    }

    public int search(String word) {
        if (word == null) {
            return 0;
        }
        if ("".equals(word)) {
            return root.end;
        }
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char aChar : chars) {
            if (cur.paths.get(aChar) == null) {
                return 0;
            }
            cur = cur.paths.get(aChar);
        }
        return cur.end;
    }

    public int searchPre(String pre) {
        if (pre == null) {
            return 0;
        }
        if ("".equals(pre)) {
            return root.pass;
        }
        char[] chars = pre.toCharArray();
        TrieNode cur = root;
        for (char aChar : chars) {
            if (cur.paths.get(aChar) == null) {
                return 0;
            }
            cur = cur.paths.get(aChar);
        }
        return cur.pass;
    }

    public void delete(String word) {
        if (word == null) {
            return;
        }
        if (search(word) > 0) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            cur.pass--;
            for (char aChar : chars) {
                if (--cur.paths.get(aChar).pass == 0) {
                    cur.paths.remove(aChar);
                    return;
                }
                cur = cur.paths.get(aChar);
            }
            cur.end--;
        }
    }


    class TrieNode {
        public int pass;
        public int end;
        HashMap<Character, TrieNode> paths;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.paths = new HashMap<>();
        }

        public TrieNode(int pass, int end) {
            this.pass = pass;
            this.end = end;
            this.paths = new HashMap<>();
        }
    }
}
