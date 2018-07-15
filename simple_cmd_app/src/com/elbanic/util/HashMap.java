package com.elbanic.util;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class HashMap<K, V> {

    private ArrayList<hashPair> map;
    private int size;
    private int MEM_SIZE;

    private class hashPair {
        private K key;
        private V value;
        private hashPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        map = new ArrayList<hashPair>();
        size = 0;
    }

    public HashMap(K key, V value) {
        map = new ArrayList<hashPair>();
        int hash = getHash(key);
        for (int i=0; i<=hash; i++)
            map.add(null);

        map.set(hash, new hashPair(key, value));
        size = 1;
        MEM_SIZE = hash;
    }

    private int getHash(K key) { return key.hashCode(); }

    public V get(K key) {
        if (MEM_SIZE < getHash(key) || map.get(getHash(key)) == null)
            return null;
        return map.get(getHash(key)).value;
    }

    public void put(K key, V value) {

        if (size == 0) {
            int hash = getHash(key);
            for (int i=0; i<=hash; i++)
                map.add(null);
            map.set(hash, new hashPair(key, value));
            size = 1;
            MEM_SIZE = hash;
        }
        else {
            int hash = getHash(key);
            if (hash > MEM_SIZE) {
                for (int i=MEM_SIZE; i<=hash; i++)
                    map.add(null);
                MEM_SIZE = hash;
            }
            if (map.get(hash)==null)
                size++;
            map.set(hash, new hashPair(key, value));
        }

    }

    public void remove(K key) {
        if (size == 0) return;
        map.set(getHash(key), null);
    }

    public boolean containsKey(K key){
        if (MEM_SIZE > getHash(key) && map.get(getHash(key)) != null)
            return true;
        return false;
    }

    public ArrayList<K> getKeys() {
        ArrayList<K> keys = new ArrayList<K>();
        for (int i=0; i<map.size(); i++) {
            if (map.get(i) != null)
                keys.add(map.get(i).key);
        }
        return keys;
    }
}