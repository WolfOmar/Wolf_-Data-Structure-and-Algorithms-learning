package adt;

import util.MapEntry;

import java.util.*;

/**
 * Created by aristark on 4/6/16.
 * A demonstration hashed map
 */
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {
    //Choose a prime number for the hash table size,to achieve a uniform distribution
    private static final int SIZE = 997;

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set; }

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key,V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode() % SIZE);
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }

        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K, V>(key,value);
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        boolean found = false;
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(iPair);
                found = true;
                break;
            }
        }

        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode() % SIZE);
        if (buckets[index] == null){
            return null;
        }

        for (MapEntry<K,V> pair : buckets[index]){
            if (pair.getKey().equals(key))
                return pair.getValue();
        }

        return null;
    }


    public static void main(String[] args){
        String a = "Hello";
        String b = "Hello";
        System.out.println(a.hashCode()+" "+b.hashCode());
    }
}

