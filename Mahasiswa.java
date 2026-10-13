public class Mahasiswa {
    private String nama;
    private String nim;
    private double nilai;

    public Mahasiswa(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public double getNilai() { return nilai; }

    public String cekKelulusan() {
        if (nilai >= 60) return "LULUS";
        else return "TIDAK LULUS";
    }

    public void tampilkanData() {
        System.out.printf("%-22s %-16s %7.2f %-14s%n", nama, nim, nilai, cekKelulusan());
    }

    public String keFormatFile() {
        return nama + "|" + nim + "|" + nilai;
    }
}
