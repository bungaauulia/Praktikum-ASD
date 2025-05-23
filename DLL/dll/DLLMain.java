package dll;
import java.util.Scanner;
public class DLLMain {
    public static void main(String[] args) {
        DoubleLinkedList04 list = new DoubleLinkedList04();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Tambah data setelah NIM tertentu");
            System.out.println("7. Cari Mahasiswa berdasarkan NIM");
            System.out.println("8. Tambah data di suatu indeks");
            System.out.println("9. Hapus data setelah data key");
            System.out.println("10. Hapus data pada indeks tertentu");
            System.out.println("11. Tampilkan data paling depan");
            System.out.println("12. Tampilkan data paling akhir");
            System.out.println("13. Tampilkan data di indeks tertentu");
            System.out.println("14. Jumlah data pada Double Linked List");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa04 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                }
                case 2 -> {
                    Mahasiswa04 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                }
                case 3 -> list.removeFirst();
                case 4 -> list.removeLast();
                case 5 -> list.print();
                case 6 -> {
                    System.out.print("Masukkan key NIM tertentu: ");
                    String keynim = scan.nextLine();
                    Mahasiswa04 mhs = inputMahasiswa(scan);
                    list.insertAfter(keynim, mhs);
                }
                case 7 -> {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node04 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                }
                case 8 -> {
                    System.out.print("Masukkan index: ");
                    int idx = scan.nextInt();
                    Mahasiswa04 mhs = inputMahasiswa(scan);
                    list.add(idx, mhs);
                }
                case 9 -> {
                    System.out.print("Masukkan nim: ");
                    String nim = scan.nextLine();
                    list.removeAfter(nim);
                }
                case 10 -> {
                    System.out.print("Masukkan index: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    list.remove(idx, null);
                }
                case 11 -> list.getFirst();
                case 12 ->  list.getLast();
                case 13 -> {
                    System.out.print("Masukkan index: ");
                    int idx = scan.nextInt();
                    list.getIndex(idx);
                }
                case 14 -> list.size();
                case 0 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        scan.close();
    }

    public static Mahasiswa04 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: " );
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa04(nim, nama, kelas, ipk);
    }
}
