package phonebook;

public interface ContactName {

    default String getContactName(String line) {
        int indexOfName = line.indexOf(' ');
        return line.substring(indexOfName).trim();
    }
}
