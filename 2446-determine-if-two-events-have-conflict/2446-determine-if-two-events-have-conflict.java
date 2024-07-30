class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int startTime1 = parseTime(event1[0]);
        int endTime1 = parseTime(event1[1]);
        int startTime2 = parseTime(event2[0]);
        int endTime2 = parseTime(event2[1]);
        return !(endTime1 < startTime2 || endTime2 < startTime1);
    }

    private int parseTime(String text) {
        int hour = Integer.parseInt(text.substring(0, 2));
        int minute = Integer.parseInt(text.substring(3, 5));
        return hour * 60 + minute;
    }
}