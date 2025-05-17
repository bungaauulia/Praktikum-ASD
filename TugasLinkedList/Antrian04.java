public class Antrian04 {
    NodeAntrian04 head, tail;
    int size = 0, data[];
    int max = 4;

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean isFull() {
        return size >= max;
    }

    public void tambahAntrian(Mahasiswa04 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!. Tidak dapat menambah data");
            return;
        }
        NodeAntrian04 nodeInput = new NodeAntrian04(mhs, null);
        if (isEmpty()) {
            head = tail = nodeInput;
        } else {
            tail.next = nodeInput;
            tail = nodeInput;
        }
        size++;
    }

    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada data yang dapat dipanggil.");
            return;
        }
        System.out.print("Memanggil mahasiswa: ");
        head.data.tampilkanData();
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public void tampilTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa Terdepan: ");
            head.data.tampilkanData();
        }
    }

    public void tampilTerbelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa Terakhir: ");
            tail.data.tampilkanData();
        }
    }

    public void print() {
        if (!isEmpty()) {
            NodeAntrian04 tmp = head;
            System.out.println("Isi Antrian:");
            while (tmp != null) {
                tmp.data.tampilkanData();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Antrian kosong.");
        }
    }

    public void jumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
    }

    public void clear() {
        if (!isEmpty()) {
            head = tail = null;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }
}