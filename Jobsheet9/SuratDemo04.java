package Jobsheet9;
import java.util.Scanner;

public class SuratDemo04 {
    public static void main(String[] args) {
        
        StackSurat04 stack = new StackSurat04(3);
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat       : ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa : ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas          : ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I/A) : ");
                    char jenis = sc.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)    : ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    stack.push(new Surat04(id, nama, kelas, jenis, durasi));
                    break;
                case 2:
                    Surat04 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Surat sudah diproses.");
                    }
                    break;
                case 3:
                    Surat04 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Surat teratas adalah surat milik " + lihat.namaMahasiswa);
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cariNama = sc.nextLine();
                    boolean ditemukan = stack.cariSurat(cariNama);
                    if (ditemukan) {
                        System.out.println("Surat atas nama " + cariNama + " ditemukan di stack.");
                    } else {
                        System.out.println("Surat atas nama " + cariNama + " tidak ditemukan.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}