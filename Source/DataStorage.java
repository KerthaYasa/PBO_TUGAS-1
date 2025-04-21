package util;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class DataStorage {
    private List<Account> accounts = new ArrayList<>();
    private List<Saham> daftarSaham = new ArrayList<>();
    private List<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    public DataStorage() {
        accounts.add(new Admin("admin", "admin"));
        accounts.add(new Customer("user", "user"));
    }

    public Account login(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }

    public void addSaham(Scanner sc) {
        System.out.print("Kode: "); String kode = sc.nextLine();
        System.out.print("Nama Perusahaan: "); String nama = sc.nextLine();
        System.out.print("Harga: "); double harga = sc.nextDouble(); sc.nextLine();
        daftarSaham.add(new Saham(kode, nama, harga));
    }

    public void updateSaham(Scanner sc) {
        showSaham();
        System.out.print("Masukkan kode saham yang ingin diubah: ");
        String kode = sc.nextLine();
        for (Saham s : daftarSaham) {
            if (s.getKode().equals(kode)) {
                System.out.print("Harga baru: ");
                double newPrice = sc.nextDouble(); sc.nextLine();
                s.setHarga(newPrice);
                return;
            }
        }
        System.out.println("Saham tidak ditemukan");
    }

    public void addSBN(Scanner sc) {
        System.out.print("Nama: "); String nama = sc.nextLine();
        System.out.print("Bunga (%): "); double bunga = sc.nextDouble();
        System.out.print("Jangka Waktu (tahun): "); int waktu = sc.nextInt(); sc.nextLine();
        System.out.print("Tanggal Jatuh Tempo: "); String tanggal = sc.nextLine();
        System.out.print("Kuota Nasional: "); double kuota = sc.nextDouble(); sc.nextLine();
        daftarSBN.add(new SuratBerhargaNegara(nama, bunga, waktu, tanggal, kuota));
    }

    public void buySaham(Customer customer, Scanner sc) {
        showSaham();
        System.out.print("Kode saham: ");
        String kode = sc.nextLine();
        for (Saham s : daftarSaham) {
            if (s.getKode().equals(kode)) {
                System.out.print("Jumlah lembar: ");
                int lembar = sc.nextInt(); sc.nextLine();
                customer.getSahamOwned().merge(s, lembar, Integer::sum);
                return;
            }
        }
        System.out.println("Saham tidak ditemukan");
    }

    public void sellSaham(Customer customer, Scanner sc) {
        var sahamMap = customer.getSahamOwned();
        if (sahamMap.isEmpty()) {
            System.out.println("Tidak ada saham dimiliki");
            return;
        }
        sahamMap.forEach((s, j) -> System.out.println(s.getKode() + " - " + s.getNamaPerusahaan() + ": " + j + " lembar"));
        System.out.print("Kode saham: ");
        String kode = sc.nextLine();
        for (Saham s : sahamMap.keySet()) {
            if (s.getKode().equals(kode)) {
                System.out.print("Jumlah jual: ");
                int jumlah = sc.nextInt(); sc.nextLine();
                int owned = sahamMap.get(s);
                if (jumlah > owned) {
                    System.out.println("Gagal: lembar melebihi yang dimiliki");
                } else {
                    sahamMap.put(s, owned - jumlah);
                }
                return;
            }
        }
        System.out.println("Saham tidak ditemukan");
    }

    public void buySBN(Customer customer, Scanner sc) {
        showSBN();
        System.out.print("Nama SBN: ");
        String nama = sc.nextLine();
        for (SuratBerhargaNegara s : daftarSBN) {
            if (s.getNama().equals(nama)) {
                System.out.print("Nominal: ");
                double nominal = sc.nextDouble(); sc.nextLine();
                if (nominal > s.getKuotaNasional()) {
                    System.out.println("Kuota tidak mencukupi");
                    return;
                }
                customer.getSbnOwned().merge(s, nominal, Double::sum);
                s.kurangiKuota(nominal);
                return;
            }
        }
        System.out.println("SBN tidak ditemukan");
    }

    public void simulateSBN(Customer customer, Scanner sc) {
        System.out.print("Nominal investasi: ");
        double nominal = sc.nextDouble(); sc.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = sc.nextDouble(); sc.nextLine();
        double hasil = (bunga / 100 / 12) * 0.9 * nominal;
        System.out.printf("Simulasi kupon per bulan: Rp%.2f\n", hasil);
    }

    public void viewPortfolio(Customer customer) {
        System.out.println("-- Saham --");
        double totalBeli = 0, totalPasar = 0;
        for (var e : customer.getSahamOwned().entrySet()) {
            Saham s = e.getKey();
            int jumlah = e.getValue();
            double beli = s.getHarga() * jumlah;
            totalBeli += beli;
            totalPasar += beli;
            System.out.println(s.getKode() + " - " + s.getNamaPerusahaan() + ": " + jumlah + " lembar, Total: Rp" + beli);
        }
        System.out.println("Total Beli: Rp" + totalBeli + ", Total Nilai Pasar: Rp" + totalPasar);

        System.out.println("-- SBN --");
        for (var e : customer.getSbnOwned().entrySet()) {
            SuratBerhargaNegara s = e.getKey();
            double nominal = e.getValue();
            double bunga = (s.getBunga() / 100 / 12) * 0.9 * nominal;
            System.out.printf("%s: Rp%.2f, Bunga/bulan: Rp%.2f\n", s.getNama(), nominal, bunga);
        }
    }

    private void showSaham() {
        for (Saham s : daftarSaham) {
            System.out.printf("%s - %s (Rp%.2f)\n", s.getKode(), s.getNamaPerusahaan(), s.getHarga());
        }
    }

    private void showSBN() {
        for (SuratBerhargaNegara s : daftarSBN) {
            System.out.printf("%s - Bunga: %.2f%%, Kuota: Rp%.2f\n", s.getNama(), s.getBunga(), s.getKuotaNasional());
        }
    }
}