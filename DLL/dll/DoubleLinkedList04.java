package dll;
public class DoubleLinkedList04 {
    Node04 head;
    Node04 tail;
    int size;

    public DoubleLinkedList04() {
        head = null;
        tail = null;
        size = 0;
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
        size++;
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
        size++;
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
        size++;
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
        size--;
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
        size--;
    }

    public void add(int idx, Mahasiswa04 data) {
        Node04 newNode = new Node04(data);
    if (isEmpty()) {
        head = tail = newNode;
    } else if (idx == 0) {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    } else {
        Node04 current = head;
        for (int i = 0; i < idx - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
        newNode.prev = current;
    }
    size++;
    }

    public void removeAfter(String nim) {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }

        Node04 current = head;
        while (current != null && !current.data.nim.equals(nim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("NIM tidak ditemukan.");
            return;
        }

        if (current.next == null) {
            System.out.println("Tidak ada node setelah NIM tersebut.");
            return;
        }

        Node04 toDelete = current.next;
        current.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.prev = current;
        }

        size--;
        System.out.println("Data setelah NIM " + nim + " berhasil dihapus.");
    }

    public void remove (int idx, Mahasiswa04 data) {
        if (isEmpty()) {
        System.out.println("List kosong.");
        return;
        }

        if (idx < 0 || idx >= size) {
        System.out.println("Index tidak valid.");
        return;
        }

        Node04 current = head;

        for (int i = 0; i < idx; i++) {
        current = current.next;
        }

        if (current.prev != null) {
        current.prev.next = current.next;
        } else {
        head = current.next;
            }

        if (current.next != null) {
        current.next.prev = current.prev;
        }

        size--;
        System.out.println("Data pada index " + idx + " berhasil dihapus.");
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong. Tidak dapat menampilkan data");
        } else {
            System.out.println("Data pertama adalah: ");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong. Tidak dapat menampilkan data");
        } else {
            System.out.println("Data terakhir adalah: ");
            tail.data.tampil();
        }
    }

    public void getIndex(int idx) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong. Tidak dapat menampilkan data");
        } else if (idx < 0 || idx >= size) {
            System.out.println("Index di luar batas");
        } else {
            Node04 current = head;
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
            System.out.println("Data pada indeks ke-" + idx + " adalah: " );
            current.data.tampil();
        }
    }

    public void size() {
        if (size != 0) {
            System.out.println("Jumlah data dalam Linked List: " + size);
        } else {
            System.out.println("Belum ada data yang diinput. Jumlah data 0");
        }
    }
}
