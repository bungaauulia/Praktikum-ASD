import java.util.Scanner;
public class LayananMain04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antrian04 antrian = new Antrian04();
        int menu;

        do {
            System.out.println("\n === Menu Antrian Layanan Unit Kemahasiswaan===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Layani Mahasiswa");
            System.out.println("3. Cek Antrian Paling Depan");
            System.out.println("4. Cek Antrian Paling Belakang");
            System.out.println("5. Jumlah Mahasiswa dalam Antrian");
            System.out.println("6. Lihat Semua Antrian");
            System.out.println("7. Kosongkan antrian");
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
                    Mahasiswa04 mhs = new Mahasiswa04(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilTerdepan();
                    break;
                case 4:
                    antrian.tampilTerbelakang();
                    break;
                case 5:
                    antrian.jumlahAntrian();
                    break;
                case 6:
                    antrian.print();
                    break;
                case 7:
                    antrian.clear();
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
