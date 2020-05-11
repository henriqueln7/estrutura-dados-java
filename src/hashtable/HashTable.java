package hashtable;

import java.util.ArrayList;

public class HashTable<K> {
    
    ArrayList<TableNode<K>>[] table;
    
    public HashTable() {
        this(30);
    }

    public HashTable(int length) {
        this.table = new ArrayList[length];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public K get(int key) {
        int hash = hash(key);

        ArrayList<TableNode<K>> nodeList = this.table[hash];

        if (nodeList == null) {
            return null;
        }

        for(TableNode<K> node: nodeList) {
            if(node.key == key) {
                return node.value;
            }
        }

        return null;
    }

    public void put(int key, K value) {
        int hash = hash(key);
        TableNode<K> nodeToBeAdded = new TableNode<>(key, value);

        ArrayList<TableNode<K>> nodeList = this.table[hash];

        if(nodeList == null) {
            nodeList = new ArrayList<>();
            nodeList.add(nodeToBeAdded);
            this.table[hash] = nodeList;
            return;
        }

        for(TableNode<K> node: nodeList) {
            if(node.key == key) {
                node.value = value;
                return;
            }
        }
        nodeList.add(nodeToBeAdded);

    }

    public K remove(int key) {
        int hash = hash(key);
        ArrayList<TableNode<K>> nodes = table[hash];

        if(nodes == null) {
            return null;
        }

        for(TableNode<K> nodeValue: nodes) {
            if(nodeValue.key == key) {
                nodes.remove(nodeValue);
                return nodeValue.value;
            }
        }
        return null;
    }
}

class TableNode<K> {
    public int key;
    public K value;

    public TableNode(int key, K value) {
        this.key = key;
        this.value = value;
    }
}
