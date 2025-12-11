public class Playlist {

    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeSong(String title) {
        if (head == null) return;

        if (head.song.getTitle().equals(title)) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.song.getTitle().equals(title)) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void playNext() {
        if (currentNode == null) currentNode = head;
        if (currentNode == null) return;

        System.out.println("Playing: " + currentNode.song.getTitle() +
                " by " + currentNode.song.getArtist());

        currentNode = currentNode.next;
        if (currentNode == null) currentNode = head;
    }

    public void displayPlaylist() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.song.getTitle() + " - " + temp.song.getArtist());
            temp = temp.next;
        }
    }
}
