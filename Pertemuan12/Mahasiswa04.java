public class Mahasiswa04 {
    String nama, nim, kelas;
    double ipk;

    Mahasiswa04() {
    }

    Mahasiswa04(String nm, String name, String kls, double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    public void tampilInformasi() {
        System.out.println(nama + " | " + nim + " | " + kelas + " | " + ipk);
    }
}