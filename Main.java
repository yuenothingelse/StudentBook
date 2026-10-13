import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final String RESET = "\u001B[0m";
    static final String BLUE = "\u001B[94m";
    static final String GREEN = "\u001B[92m";
    static final String YELLOW = "\u001B[93m";
    static final String RED = "\u001B[91m";
    static final String BOLD = "\u001B[1m";

    static final String NAMA_FILE = "mahasiswa.txt";
    static final int MAKS_MAHASISWA = 100; //default aja, kan cuma contoh
    static final Scanner input = new Scanner(System.in);
    static Mahasiswa[] daftarMahasiswa = new Mahasiswa[MAKS_MAHASISWA];
    static int jumlahMahasiswa = 0;

    public static void main(String[] args) {
        muatDataDariFile();

        if (jumlahMahasiswa == 0) {
            System.out.println(YELLOW +
                    "Belum ada data valid. Menambahkan tiga data contoh..." + RESET);
            daftarMahasiswa[jumlahMahasiswa++] =
                    new Mahasiswa("Alepp", "2567", 85.5);
            daftarMahasiswa[jumlahMahasiswa++] =
                    new Mahasiswa("Salwaa", "2558", 92.0);
            daftarMahasiswa[jumlahMahasiswa++] =
                    new Mahasiswa("Abrorr", "2578", 55.0);
            simpanDataKeFile();
        }

        int pilihan;
        do {
            tampilkanHeader();
            tampilkanMenu();
            pilihan = bacaInteger("Pilih menu [1-6]: ", 1, 6);

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanSemuaMahasiswa();
                    break;
                case 3:
                    cariMahasiswa();
                    break;
                case 4:
                    tampilkanStatistik();
                    break;
                case 5:
                    hapusMahasiswa();
                    break;
                case 6:
                    System.out.println(GREEN + BOLD +
                            "\nData sudah tersimpan di " + NAMA_FILE + "." + RESET);
                    System.out.println("Terima kasih telah menggunakan STUDENT HUB!");
                    break;
            }

            if (pilihan != 6) {
                System.out.print("\nTekan ENTER untuk kembali ke menu...");
                input.nextLine();
            }
        } while (pilihan != 6);

        input.close();
    }



    static void muatDataDariFile() {
        File file = new File(NAMA_FILE);

        if (!file.exists()) {
            System.out.println(YELLOW +
                    "File " + NAMA_FILE + " belum ada." + RESET);
            return;
        }

        int barisBerhasil = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;

            while ((baris = reader.readLine()) != null) {
                if (jumlahMahasiswa >= MAKS_MAHASISWA) {
                    System.out.println(YELLOW +
                            "Kapasitas maksimal mahasiswa telah tercapai." + RESET);
                    break;
                }

                String[] bagian = baris.split("\\|", -1);

                if (bagian.length != 3) {
                    System.out.println(YELLOW +
                            "Baris dilewati karena format salah: " + baris + RESET);
                    continue;
                }

                String nama = bagian[0].trim();
                String nim = bagian[1].trim();

                try {
                    double nilai = Double.parseDouble(bagian[2].trim());

                    if (nama.isEmpty() || nim.isEmpty()
                            || !Double.isFinite(nilai)
                            || nilai < 0 || nilai > 100
                            || nimSudahAda(nim)) {
                        System.out.println(YELLOW +
                                "Data tidak valid atau NIM duplikat, baris dilewati." + RESET);
                        continue;
                    }

                    daftarMahasiswa[jumlahMahasiswa] =
                            new Mahasiswa(nama, nim, nilai);
                    jumlahMahasiswa++;
                    barisBerhasil++;

                } catch (NumberFormatException e) {
                    System.out.println(YELLOW +
                            "Nilai bukan angka, baris dilewati: " + baris + RESET);
                }
            }

            System.out.println(GREEN +
                    "Berhasil membaca " + barisBerhasil +
                    " data dari " + NAMA_FILE + "." + RESET);

        } catch (IOException e) {
            System.out.println(RED +
                    "Gagal membaca file: " + e.getMessage() + RESET);
        }
    }

    static boolean simpanDataKeFile() {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(NAMA_FILE))) {
            for (int i = 0; i < jumlahMahasiswa; i++) {
                writer.write(daftarMahasiswa[i].keFormatFile());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println(RED +
                    "Gagal menyimpan file: " + e.getMessage() + RESET);
            return false;
        }
    }

    static void tampilkanHeader() {
        System.out.println("\n" + BLUE + BOLD + "  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║              SISTEM DATA MAHASISWA                   ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝" + RESET);
        System.out.println("  Total mahasiswa: " + jumlahMahasiswa + " | Data: " + NAMA_FILE);
        garis();
    }

    static void tampilkanMenu() {
        System.out.println(BOLD + "  BERANDA" + RESET);
        System.out.println("  " + BLUE + "[1]" + RESET + " Tambah mahasiswa");
        System.out.println("  " + BLUE + "[2]" + RESET + " Tampilkan semua mahasiswa");
        System.out.println("  " + BLUE + "[3]" + RESET + " Cari mahasiswa berdasarkan NIM");
        System.out.println("  " + BLUE + "[4]" + RESET + " Statistik kelulusan");
        System.out.println("  " + BLUE + "[5]" + RESET + " Hapus mahasiswa berdasarkan NIM");
        System.out.println("  " + RED + "[6]" + RESET + " Keluar");
        garis();
    }

    static void tambahMahasiswa() {
        judul("TAMBAH MAHASISWA");

        if (jumlahMahasiswa >= MAKS_MAHASISWA) {
            System.out.println(RED + "Kapasitas data penuh." + RESET);
            return;
        }

        String nama;
        do {
            System.out.print("Nama         : ");
            nama = input.nextLine().trim();
            if (nama.isEmpty() || nama.contains("|")) {
                System.out.println(YELLOW +
                        "Nama tidak boleh kosong atau mengandung |." + RESET);
            }
        } while (nama.isEmpty() || nama.contains("|"));

        String nim;
        do {
            System.out.print("NIM          : ");
            nim = input.nextLine().trim();
            if (nim.isEmpty() || nim.contains("|") || nimSudahAda(nim)) {
                System.out.println(YELLOW +
                        "NIM kosong, tidak valid, atau sudah terdaftar." + RESET);
            } else {
                break;
            }
        } while (true);

        double nilai = bacaDouble("Nilai (0-100): ", 0, 100);
        daftarMahasiswa[jumlahMahasiswa++] = new Mahasiswa(nama, nim, nilai);

        if (simpanDataKeFile()) {
            System.out.println(GREEN + BOLD +
                    "✓ Data berhasil ditambahkan dan disimpan ke file!" + RESET);
        }
    }

    static void tampilkanSemuaMahasiswa() {
        judul("DAFTAR MAHASISWA");

        if (jumlahMahasiswa == 0) {
            System.out.println(YELLOW + "Belum ada data mahasiswa." + RESET);
            return;
        }

        System.out.printf("%-4s %-22s %-16s %7s %-14s%n","No.", "NAMA", "NIM", "NILAI", "STATUS");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("%-4d ", i + 1);
            daftarMahasiswa[i].tampilkanData();
        }

        System.out.println("---------------------------------------------------------------------");
    }

    static void cariMahasiswa() {
        judul("CARI MAHASISWA");
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine().trim();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].getNim().equalsIgnoreCase(nim)) {
                System.out.println(GREEN + "\nData ditemukan!" + RESET);
                daftarMahasiswa[i].tampilkanData();
                return;
            }
        }
        System.out.println(RED + "Mahasiswa tidak ditemukan." + RESET);
    }

    static void tampilkanStatistik() {
        judul("STATISTIK KELULUSAN");
        int lulus = 0;
        int tidakLulus = 0;
        double totalNilai = 0;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            totalNilai += daftarMahasiswa[i].getNilai();
            if (daftarMahasiswa[i].getNilai() >= 60) {
                lulus++;
            } else {
                tidakLulus++;
            }
        }

        double rataRata = jumlahMahasiswa == 0 ? 0 : totalNilai / jumlahMahasiswa;
        double persen = jumlahMahasiswa == 0 ? 0 : 100.0 * lulus / jumlahMahasiswa;

        System.out.println("Total mahasiswa : " + jumlahMahasiswa);
        System.out.println(GREEN + "Lulus           : " + lulus + RESET);
        System.out.println(RED + "Tidak lulus     : " + tidakLulus + RESET);
        System.out.printf("Rata-rata nilai : %.2f%n", rataRata);
        System.out.printf("Persentase lulus: %.1f%%%n", persen);
    }

    static void hapusMahasiswa() {
        judul("HAPUS MAHASISWA");
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nim = input.nextLine().trim();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].getNim().equalsIgnoreCase(nim)) {
                System.out.println("Data ditemukan: " +
                        daftarMahasiswa[i].getNama());
                System.out.print("Yakin hapus? (y/n): ");

                if (input.nextLine().trim().equalsIgnoreCase("y")) {
                    for (int j = i; j < jumlahMahasiswa - 1; j++) {
                        daftarMahasiswa[j] = daftarMahasiswa[j + 1];
                    }
                    daftarMahasiswa[--jumlahMahasiswa] = null;

                    if (simpanDataKeFile()) {
                        System.out.println(GREEN +
                                "Data dihapus dan file diperbarui." + RESET);
                    }
                } else {
                    System.out.println("Penghapusan dibatalkan.");
                }
                return;
            }
        }
        System.out.println(RED + "NIM tidak ditemukan." + RESET);
    }

    static boolean nimSudahAda(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].getNim().equalsIgnoreCase(nim)) {
                return true;
            }
        }
        return false;
    }

    static int bacaInteger(String pesan, int min, int max) {
        while (true) {
            System.out.print(pesan);
            try {
                int angka = Integer.parseInt(input.nextLine().trim());
                if (angka >= min && angka <= max) {
                    return angka;
                }
            } catch (NumberFormatException e) {
                // ulangi input jika bukan bilangan bulat
            }
            System.out.println(YELLOW +
                    "Masukkan angka antara " + min + " dan " + max + "." + RESET);
        }
    }

    static double bacaDouble(String pesan, double min, double max) {
        while (true) {
            System.out.print(pesan);
            try {
                double angka = Double.parseDouble(
                        input.nextLine().trim().replace(',', '.'));
                if (Double.isFinite(angka) && angka >= min && angka <= max) {
                    return angka;
                }
            } catch (NumberFormatException e) {
                // ulangi input jika bukan angka desimal
            }
            System.out.println(YELLOW +
                    "Nilai harus antara " + min + " dan " + max + "." + RESET);
        }
    }

    static void judul(String teks) {
        System.out.println("\n" + BLUE +
                "  ──────────────────────────────────────────────────────" + RESET);
        System.out.println(BLUE + BOLD + "  " + teks + RESET);
        garis();
    }

    static void garis() {
        System.out.println(BLUE +
                "  ──────────────────────────────────────────────────────" + RESET);
    }
}


// 100 boleh kali pak👀
