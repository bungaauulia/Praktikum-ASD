import java.util.Scanner;
public class LayananKRS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);
        int menu;

        do {
            System.out.println("\n === Menu Antrian Persetujuan KRS ===");
            System.out.println("1. Tambah KRS Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS Mahasiswa");
            System.out.println("3. Lihat 2 Mahasiswa Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Jumlah Mahasiswa dalam Antrian");
            System.out.println("6. Cek Antrian Paling Belakang");
            System.out.println("7. Jumlah Mahasiswa yang Sudah Proses KRS");
            System.out.println("8. Jumlah Mahasiswa yang Belum Proses KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("NIM : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi: ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    Mahasiswa[] diproses = antrian.prosesKRS();
                    if (diproses != null) {
                        System.out.println("Memproses KRS mahasiswa:");
                        for (Mahasiswa m : diproses) {
                        System.out.println();
                    }
                }
                    break;
                case 3:
                    antrian.lihatDuaTerdepan();
                    break;
                case 4: 
                    antrian.tampilkanSemua();
                    break;
                case 5:
                    System.out.print("Jumlah dalam antrian: " + antrian.getJumlahAntrian());
                    break;
                case 6:
                    antrian.lihatAkhir();
                    break;
                case 7:
                    antrian.sudahProsesKRS();
                    break;
                case 8:
                    antrian.belumProsesKRS();
                    break;
                case 0:
                    System.out.println("Terima kasih");
                    break;
                default:
                    break;
            }
        } while (menu != 0);
        sc.close();
    }
}