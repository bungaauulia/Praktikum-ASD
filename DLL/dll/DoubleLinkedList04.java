package dll;
public class DoubleLinkedList04 {
    Node04 head;
    Node04 tail;

    public DoubleLinkedList04() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa04 data) {
        Node04 newNode = new Node04(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa04 data) {
        Node04 newNode = new Node04(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail =  newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa04 data) {
        Node04 current = head;

        while (current != null && current.data.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node04 newNode = new Node04(data);
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public Node04 search (String nim) {
        Node04 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
            return current;
            }
            current = current.next;
        }
        return null;
    }

    public void print() {
    Node04 current = head;
    if (current == null) {
        System.out.println("Linked List masih kosong. Tidak ada data yang dapat ditampilkan");
        return;
        }

    System.out.println("Isi Linked List:");
    while (current != null) {
        current.data.tampil();
        current = current.next;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus");
            return;
        }
        Mahasiswa04 hapusDataDepan = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data berhasil dihapus. Data yang dihapus adalah: ");
        hapusDataDepan.tampil();
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus");
            return;
        }
        Mahasiswa04 hapusDataAkhir = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data berhasil dihapus. Data yang dihapus adalah: ");
        hapusDataAkhir.tampil();
    }
}
