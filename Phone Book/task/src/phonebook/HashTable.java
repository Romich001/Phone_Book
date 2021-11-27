package phonebook;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class HashTable implements ContactName{
    private Map<String, String > table;
    private ArrayList<String> phoneBook;

    public HashTable(ArrayList<String> phoneBook) {
        table = new HashMap<>((int)(phoneBook.size() * 0.75));
        this.phoneBook = phoneBook;
        createHashTable();

    }

    private void createHashTable() {
        for (String line :
                phoneBook) {
            var name = getContactName(line);
            var phoneNumber = line.substring(0, line.indexOf(' '));
            table.put(name, phoneNumber);

        }

    }

    public boolean search(String name) {
        return table.containsKey(name);

    }

}
