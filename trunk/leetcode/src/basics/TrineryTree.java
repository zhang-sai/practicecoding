package basics;


//http://en.wikipedia.org/wiki/Ternary_search_tree
//http://en.wikipedia.org/wiki/Ternary_tree

//ternary tree
/**
 
 a ternary search tree with the strings "as", "at", "cup", "cute", "he", "i" and "us":
 
 ternary search trees can become degenerate depending on the order of the keys
 
 Tries and ternary search trees represent a time/space trade off. If your alphabet
 has k symbols in it, then each node in a trie holds k pointers plus one extra bit
 for whether or not the node encodes a word. Looking up a word of length L always
 takes time O(L). A ternary search tree stores three pointers per node, plus one
 character and one bit for whether or not the node encodes a word. Looking up a
 word of length L takes time O(L log k).

For cases where each node in the Trie has most of its children used, the Trie
is substantially more space efficient and time efficient than th ternary search
tree. If each node stores comparatively few child nodes, the ternary search
tree is much more space efficient. Typically speaking, tries are much, much
faster than ternary search trees because fewer pointer indirections are required.
           c
        / | \
       a  u  h
       |  |  | \
       t  t  e  u
     /  / |   / |
    s  p  e  i  s
 
 **/
public class TrineryTree {

}
