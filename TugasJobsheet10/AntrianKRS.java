public class AntrianKRS {
    int mahasiswa = 30;
    Mahasiswa[] data;
    int front, rear, max, size;
    int sudahProsesKRS = 0;

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa[max];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void lihatDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("2 Mahasiswa terdepan: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[front].tampilkanData();
            System.out.println();
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[front + 1].tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("Mahasiswa terdepan: ");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public Mahasiswa[] prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return null;
        } else{
            if (size < 2) {
                System.out.println("Antrian kurang dari 2, tidak bisa diproses.");
                return null;
            }
            Mahasiswa[] diproses = new Mahasiswa[2];
            System.out.println("2 KRS antrian terdepan sudah diproses");
            for (int i = 0; i < 2; i++) {
                diproses[i] = data[front];
                front = (front + 1) % max;
                size--;
                sudahProsesKRS++;
            }
        }
        return null;
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Tidak ada antrian.");
        } else {
            System.out.println("Mahasiswa di antrian paling akhir: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }

    public Mahasiswa[] sudahProsesKRS() {
        System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + sudahProsesKRS);
        return null;
    }
    
    public void belumProsesKRS() {
        int belumProsesKRS = mahasiswa - sudahProsesKRS;
        System.out.println("Jumlah mahasiswa yang belum proses KRS: " + belumProsesKRS);
    }
}