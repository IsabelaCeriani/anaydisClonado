package anaydis.search;


public class TrieNode<T> {


    T elem;
    TrieNode<T>[] next = new TrieNode[256];
    int level;



}