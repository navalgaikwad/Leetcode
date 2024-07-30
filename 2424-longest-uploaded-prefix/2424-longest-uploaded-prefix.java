class LUPrefix {

    private boolean[] videos;
    private int maxIndex = 0;

    public LUPrefix(int n) {
        this.videos = new boolean[n + 1];
    }

    public void upload(int video) {
        this.videos[video] = true;
        while (maxIndex < this.videos.length - 1 && videos[maxIndex + 1])
            maxIndex++;
    }

    public int longest() {
        return maxIndex;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */