package phonebook;

import java.util.ArrayList;

public class Search implements ContactName
{

    public boolean binarySearch(ArrayList<String> phoneBook, String name) {

        var left = 0;
        var right = phoneBook.size() - 1;

        while (left <= right) {
            var middle = (left + right) / 2;
            String contactName = getContactName(phoneBook.get(middle));
            var compareNames = contactName.compareTo(name);
            if (compareNames == 0) return true;
            else if (compareNames > 0) right = middle - 1;
            else left = middle + 1;
        }

        return false;
    }

    public boolean jumpSearch(ArrayList<String> phoneBook, String name){
        if (phoneBook.size() == 1) {
            return phoneBook.get(0).equals(name);
        }
        var jumpSize = (int) Math.floor(Math.sqrt(phoneBook.size()));
        for (int i = jumpSize; i < phoneBook.size() ;) {
            var bookName = getContactName(phoneBook.get(i));
            var comp = bookName.compareTo(name);
            if (comp == 0) return true;
            if (comp > 0) {
                ArrayList<String> subList = new ArrayList<>(phoneBook.subList(i-jumpSize, i));
                return jumpSearch(subList, name);
            }
            i += jumpSize;
            if (i > phoneBook.size() - 1 && phoneBook.get(phoneBook.size()-1).compareTo(name) > 0) {
                ArrayList<String> subList = new ArrayList<>(phoneBook.subList(i-jumpSize, phoneBook.size()-1));
                return jumpSearch(subList, name);
            }
        }
        return false;
    }

    public boolean linerSearch(ArrayList<String> phoneBook, String name) {
        for (String contName :
                phoneBook) {
            contName = getContactName(contName);
            if (contName.equals(name)) return true;
        }
        return false;
    }
}
