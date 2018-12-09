package sample;

import java.util.ArrayList;

public class JournalManager {

    String journal;

    JournalManager(String jour) {
        journal = jour;

    }

    public void addItem(String newElement) {
        journal += newElement;
    }

    public String writeJournal() {
        return journal;
    }

    public void removeItem(String Element)
    {
        String parts = "";
        int length;
        ArrayList<String> journalList = new ArrayList<>();
        for (length = 0; length < journal.length(); length++) {
            if (journal.charAt(length) == '\n') {
                journalList.add(parts);
                parts = "";
            } else {
                parts += journal.charAt(length);
            }
        }

        if (journalList.contains(Element)) {
            journalList.remove(Element);
        }
        journal = "";
        for (length = 0; length < journalList.size(); length++) {
            journal += journalList.get(length);
            if (length != journalList.size() - 1) {
                journal += "\n";
            }
        }
        return;
    }


}
