package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
//small_directory.txt
    private static final String addressFind = "E:\\projects\\exc\\find.txt";
    private static final String addressDir = "E:\\projects\\exc\\directory.txt";
    public static ArrayList<String> phoneBook;
    public static ArrayList<String> findList;

    public static void main(String[] args) {




        String find = readFile(addressFind);
        String dir = readFile(addressDir);

        findList = toArrList(find);
        phoneBook = toArrList(dir);

        var linerDuration = linerSearch();

        System.out.println("\n");

        bubbleJump(linerDuration);

        System.out.println("\n");

        quickBinary();

        System.out.println("\n");

        hashSearch();

    }

    private static void print(){
        for (String s :
                phoneBook) {
            System.out.println(s);
        }
    }

    private static void hashSearch() {
        Clock hashClock = new Clock();

        System.out.println("Start searching (hash table)...");

        hashClock.setStart();
        HashTable hashTable = new HashTable(phoneBook);
        hashClock.setStop();

        Clock hashSearch = new Clock();
        hashSearch.setStart();
        var found = 0;

        for (String name:
                findList) {
            if(hashTable.search(name)) found++;
        }

        hashSearch.setStop();

        System.out.printf("Found: %d/%d entries. ", found, findList.size());
        System.out.print("Time taken: ");
        hashSearch.printTime(hashSearch.getDuration() + hashClock.getDuration());
        System.out.println();
        System.out.print("Creating time: ");
        hashClock.printTime();
        System.out.println();
        System.out.print("Searching time: ");
        hashSearch.printTime();
        System.out.println();
    }

    private static void quickBinary(){
        Clock quickClock = new Clock();

        System.out.println("Start searching (quick sort + binary search)...");
        Sorting quick = new Sorting();
        quickClock.setStart();
        quick.quickSort(phoneBook);
        quickClock.setStop();

        Clock binaryClock = new Clock();
        binaryClock.setStart();
        var found = 0;
        Search binary = new Search();


          for (String name:
                findList) {
            if(binary.binarySearch(phoneBook, name)) found++;
        }

        binaryClock.setStop();

        System.out.printf("Found: %d/%d entries. ", found, findList.size());
        System.out.print("Time taken: ");
        binaryClock.printTime(binaryClock.getDuration() + quickClock.getDuration());
        System.out.println();
        System.out.print("Sorting time: ");
        quickClock.printTime();
        System.out.println();
        System.out.print("Searching time: ");
        binaryClock.printTime();
        System.out.println();
    }

    private static void bubbleJump(long linerDuration) {
        Clock bubbleClock = new Clock();

        System.out.println("Start searching (bubble sort + jump search)...");
        String notification = "";
        Sorting bubble = new Sorting();
        bubbleClock.setStart();
        var sortingSucsess = bubble.bubbleSort(phoneBook, linerDuration);


        bubbleClock.setStop();

        Clock jumpClock = new Clock();
        jumpClock.setStart();
        var found = 0;
        Search jump = new Search();
        if (sortingSucsess) {

            for (String name:
                    findList) {
                if(jump.jumpSearch(phoneBook, name)) found++;
            }
        } else {
            notification = "STOPPED";
            for (String name:
                    findList) {
                if(jump.linerSearch(phoneBook, name)) found++;
            }
        }


        jumpClock.setStop();

        System.out.printf("Found: %d/%d entries. ", found, findList.size());
        System.out.print("Time taken: ");
        jumpClock.printTime(jumpClock.getDuration() + bubbleClock.getDuration());
        System.out.println();
        System.out.print("Sorting time: ");
        bubbleClock.printTime();
        System.out.println(notification);
        System.out.print("Searching time: ");
        jumpClock.printTime();
        System.out.println();
    }



    private static long linerSearch() {
        Clock linerClock = new Clock();

        System.out.println("Start searching (linear search)...");
        linerClock.setStart();
        Search ls = new Search();
        var found = 0;
        for (String name :
                findList) {
            if (ls.linerSearch(phoneBook, name)) found++;
        }
        linerClock.setStop();

        var toFind = findList.size();
        System.out.printf("Found: %d/%d entries. ", found, toFind);
        linerClock.printTime();

        return linerClock.getDuration();
    }

    private static void prit() {
        for (String s :
                phoneBook) {
            System.out.println(s);
        }
    }



    private static ArrayList<String> toArrList(String string) {
        String[] arr = string.split("\r\n");
        return new ArrayList<>(Arrays.asList(arr));
    }

    private static String readFile(String address) {
        String result = null;
        try  {
            result = new String(Files.readAllBytes(Paths.get(address)));
        } catch (IOException exception) {
            System.out.println("Error of reading");
            System.exit(0);
        }
        return result;
    }
}
