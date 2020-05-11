package hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable<Aluno> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void testPut() {
       Aluno a1 = new Aluno(3332, "Henrique");
       Aluno a3 = new Aluno(3910, "Maria");

       hashTable.put(3332, a1);
       hashTable.put(3910, a3);

       assertEquals(a1, hashTable.get(3332));
       assertEquals(a3, hashTable.get(3910));
       assertNull(hashTable.get(2931));

       a1.setName("Henrique Lopes");
       hashTable.put(3332, a1);

//       assertEquals("Henrique Lopes", hashTable.get(3332));
    }

    @Test
    void remove() {
        Aluno a1 = new Aluno(3332, "Henrique");
        Aluno a3 = new Aluno(3910, "Maria");
        hashTable.put(3332, a1);
        hashTable.put(3910, a3);

        assertEquals(a1, hashTable.remove(3332));
        assertNull(hashTable.get(3332));
        assertEquals(a3, hashTable.remove(3910));
        assertNull(hashTable.get(3910));
        hashTable.put(3910, a3);
        assertEquals(a3, hashTable.get(3910));
    }
}