package Hashmap.Basics;

import java.util.*;

public class HashmapImplementation {

    public static class MyHashMap<K, V> {

        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node {

            K key;
            V value;

            Node(K key, V value) {

                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Node>[] buckets;
        private int n; // number of entries in map


        public int size() {          // Returns the number of entries in the map

            return n;
        }

        private void initBuckets(int N) {    // N- capacity/size of buckets array

            buckets = new LinkedList[N];

            for (int i = 0; i < buckets.length; i++) {

                buckets[i] = new LinkedList<>();
            }


        }

        public MyHashMap() {

            initBuckets(DEFAULT_CAPACITY);
        }

        private int HashFunction(K key) {

            int hc = key.hashCode();


            return Math.abs(hc) % buckets.length;
        }


        // Traverse the ll and looks for a node with key,if found it returns its index otherwise it returns null
        private int searchInBucket(LinkedList<Node> ll, K key) {


            for (int i = 0; i < ll.size(); i++) {

                if (ll.get(i).key.equals(key)) {

                    return i;
                }


            }

            return -1;

        }

        public int capacity(){

            return buckets.length;

        }

        public float loadFactor(){

            return (n*1.0f)/buckets.length;
        }

        private void rehash(){

            LinkedList<Node>[] oldBuckets=buckets;
            initBuckets(oldBuckets.length*2);

            int oldSize = n; // save old size
            n = 0; // reset count before reinserting

            for (LinkedList<Node> bucket : oldBuckets) {
                for (Node node : bucket) { //  Loop over Node, not LinkedList
                    put(node.key, node.value);
                }
            }


        }

        public void put(K key, V value) {            // insert/update


            int bi = HashFunction(key);

            LinkedList<Node> currBucket = buckets[bi];

            int ei = searchInBucket(currBucket, key);

            if (ei != -1) {    // key exist just update

                Node currNode = currBucket.get(ei);
                currNode.value = value;
            } else {  // key does not exist we have to insert a new node


                Node node = new Node(key, value);
                currBucket.add(node);
                n++;


            }

            if(n>= buckets.length * DEFAULT_LOAD_FACTOR){

                rehash();
            }


        }

        public V get(K key) {

            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei != -1) {  // key exist

                Node currNode = currBucket.get(ei);
                return currNode.value;

            }


            // key does not exist
            return null;

        }


        public V remove(K key) {

            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei != -1) {  // key exist

                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;


            }


            // key does not exist
            return null;


        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (LinkedList<Node> bucket : buckets) {
                for (Node node : bucket) {
                    sb.append(node.key).append(" => ").append(node.value).append("\n");
                }
            }
            return sb.toString();
        }



    }


    public static void main(String[] args) {

        MyHashMap<String, Integer> mp = new MyHashMap<>();

        // Testing put
        System.out.println(" Testing Put ");
        mp.put("a", 1);
        mp.put("b", 2);
        mp.put("c", 3);
        mp.put("x", 60);
        mp.put("y", 70);


        System.out.println(mp.size());  // 5

        mp.put("c",30);
        System.out.println(mp.size()); // 5


        // Testing get
        System.out.println(" Testing get ");


        System.out.println(mp.get("a")); // 1
        System.out.println(mp.get("b")); // 2
        System.out.println(mp.get("c")); // 30
        System.out.println(mp.get("x")); // 60
        System.out.println(mp.get("y")); // 70
        System.out.println(mp.get("college")); // null

        // Testing remove
        System.out.println(" Testing remove ");


        System.out.println(mp.remove("c")); // 30
        System.out.println(mp.remove("c")); // null
        System.out.println(mp.size()); // 4


        System.out.println(mp.capacity());
        System.out.println(mp.loadFactor());


    }

}
