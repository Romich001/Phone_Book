package phonebook;

import java.util.ArrayList;

public class Sorting implements ContactName{

    public boolean bubbleSort(ArrayList<String> listToSort, long duration){
        Clock clock = new Clock();
        var iterations = listToSort.size() - 1;
        clock.setStart();
        for (int i = 0; i < iterations; i++) {
            clock.setStop();
            if(clock.getDuration() > duration*10){
                return false;
            }
            for (int j = 0; j < iterations - i; j++) {
                String name = getContactName(listToSort.get(j));
                String nextName = getContactName(listToSort.get(j+1));
                if (name.compareTo(nextName) > 0) {
                    String temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j+1));
                    listToSort.set(j+1, temp);
                }
            }

        }
        return true;
    }

    public void quickSort(ArrayList<String> phoneBook) {
        quickSort(phoneBook, 0, phoneBook.size()-1);
    }

    private void quickSort(ArrayList<String> phoneBook, int low, int high) {

        if (low < high) {
            var pi = partition(phoneBook, low, high);
            quickSort(phoneBook, low, pi-1);
            quickSort(phoneBook, pi+1, high);
        }

    }
    private int partition(ArrayList<String> phoneBook, int low, int high) {
        var pivot = getContactName(phoneBook.get(high));
        var i = low - 1;
        for (int j = low; j < high; j++) {
            var name = getContactName(phoneBook.get(j));

            if (name.compareTo(pivot) < 0) {
                i++;
                var temp = phoneBook.get(i);
                phoneBook.set(i, phoneBook.get(j));
                phoneBook.set(j, temp);
            }

        }
        i++;
        var temp = phoneBook.get(i);
        phoneBook.set(i, phoneBook.get(high));
        phoneBook.set(high, temp);

        return i;

    }

    private static void prit(ArrayList<String> phoneBook) {
        for (String s :
                phoneBook) {
            System.out.println(s);
        }
    }
}
