package hometask1.t06;

public class Notebook {
    private NotebookEntry[] entries;
    private int actualSize = 0;

    public Notebook(int size) {
        entries = new NotebookEntry[size];
    }

    public void addEntry(String text) {
        entries[actualSize++] = new NotebookEntry(text);
    }

    public void removeEntry(String text) {
        NotebookEntry[] array = getEntries();
        for (int i = 0; i < array.length; i++) {
            if ((array[i].getText().equals(text))) {
                array[i] = null;
            }
            actualSize--;
            break;
        }
    }

    public void editEntry(String text, String newText) {
        for (int i = 0; i < entries.length; i++) {
            if ((entries[i].getText().equals(text))) {
                entries[i].setText(newText);
            }
            break;
        }
    }


    public NotebookEntry[] getEntries() {
        return entries;
    }

}
