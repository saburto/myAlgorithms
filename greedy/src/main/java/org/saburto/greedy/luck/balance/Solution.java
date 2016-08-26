package org.saburto.greedy.luck.balance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class EventLuck implements Comparable<EventLuck> {

        private int luck;
        private boolean isImportant;

        public EventLuck(int luck, boolean isImportant) {
            this.luck = luck;
            this.isImportant = isImportant;
        }

        @Override
        public int compareTo(EventLuck o) {
            return Integer.compare(luck, o.luck);
        }

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int limit = scanner.nextInt();
            List<EventLuck> events = new ArrayList<>(n);
            int importantEvent = 0;
            for (int i = 0; i < n; i++) {
                int luck = scanner.nextInt();
                boolean isImportant = scanner.nextInt() == 1;
                importantEvent += isImportant ? 1 : 0;
                events.add(new EventLuck(luck, isImportant));
            }

            System.out.println(maxMountOfLuck(limit, importantEvent, events));
        }
    }

    static int maxMountOfLuck(int limit, int importantEvent, List<EventLuck> events) {

        int winning = importantEvent - limit;
        int total = 0;
        Collections.sort(events);

        for (EventLuck eventLuck : events) {
            if (eventLuck.isImportant && winning > 0) {
                total -= eventLuck.luck;
                winning--;
            } else {
                total += eventLuck.luck;
            }
        }

        return total;
    }
}
