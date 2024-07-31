public class Solution {
    class Pair {
        String sender;
        int countOfWord;
        int largestName;

        Pair(String sender) {
            this.sender = sender;
            this.countOfWord = 0;
            this.largestName = sender.length();
        }

        void addWords(int count) {
            this.countOfWord += count;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "sender='" + sender + '\'' +
                    ", countOfWord=" + countOfWord +
                    ", largestName=" + largestName +
                    '}';
        }
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Pair> map = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            String sender = senders[i];
            int wordCount = messages[i].split(" ").length;

            if (!map.containsKey(sender)) {
                map.put(sender, new Pair(sender));
            }

            Pair pair = map.get(sender);
            pair.addWords(wordCount);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
            a.countOfWord == b.countOfWord ? b.sender.compareTo(a.sender) : b.countOfWord - a.countOfWord
        );

        for (Pair pair : map.values()) {
            pq.add(pair);
        }

        return pq.poll().sender;
    }
}