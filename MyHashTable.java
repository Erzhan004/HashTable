public class MyHashTable<K,V> {
    private HashNode<K,V>[] buckets;
    private int numOfBuckets;
    private int size;
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key,V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "{"+key.toString() + "  =  "+ value+"}";
        }
    }
    public MyHashTable(){
        this(11);
    }
    public MyHashTable(int capacity){
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size ==0)return true;
        return false;
    }
    public void put(K key, V value){
        if(key== null || value == null){
            throw new IllegalArgumentException("Key or Value is null");
        }
        int BucketIndex = hash(key);
        HashNode head = buckets[BucketIndex];
        while (head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = buckets[BucketIndex];
        HashNode node = new HashNode(key,value);
        node.next =head;
        buckets[BucketIndex] = node;

    }
    private int hash(K key){
        return Math.abs(key.hashCode()%numOfBuckets);
    }
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        int BucketIndex = hash(key);
        HashNode head = buckets[BucketIndex];
        HashNode previous = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if(head==null){
            return null;
        }
        size--;
        if(previous != null){
         previous.next =head.next;
        }
        else {
            buckets[BucketIndex] = head.next;
        }
        return (V) head.value;
    }
    public V get(K key){
        if (key == null) {
            throw new IllegalArgumentException("Key  is null");
        }
        int BucketIndex = hash(key);
        HashNode head = buckets[BucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return (V) head.value;
            }
            head = head.next;
        }
        return null;
    }
    public K getKey(V value){
        if (value == null) {
            throw new IllegalArgumentException(" value is null");
        }
        for (int i = 0; i < numOfBuckets; i++) {
            while (buckets[i] != null) {
                if (buckets[i].value.equals(value)) {
                    return (K) buckets[i].key;
                }
                buckets[i] = buckets[i].next;
            }
        }
       return null;
    }
    public boolean contains(V value){
        if (value == null) {
            throw new IllegalArgumentException("value  is null");
        }
        for (int i = 0; i < numOfBuckets; i++) {
            while (buckets[i] != null) {
                if (buckets[i].value.equals(value)) {
                    return true;
                }
                buckets[i] = buckets[i].next;
            }
        }
        return false;
    }
    public int getCapacity() {
        return numOfBuckets;
    }
    public void print(){
        for (int i = 0; i < numOfBuckets; i++) {
            HashNode<K,V> node = buckets[i];
            while (node != null) {
                System.out.println(node.toString());
                node = node.next;
            }
        }
    }
}
