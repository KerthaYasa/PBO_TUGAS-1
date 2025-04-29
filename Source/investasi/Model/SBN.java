package investasi.Model;

import java.time.LocalDate;

public class SBN {
    private String nama;
    private double bunga;
    private int jangkaWaktu;
    private LocalDate tanggalJatuhTempo;
    private double kuotaNasional;

    public SBN(String nama, double bunga, int jangkaWaktu, LocalDate tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void setKuotaNasional(double kuotaNasional) {
        this.kuotaNasional = kuotaNasional;
    }

    @Override
    public String toString() {
        return String.format("%-15s Bunga: %.2f%% Jangka: %d bulan Jatuh Tempo: %s Kuota: Rp%,.2f",
                nama, bunga, jangkaWaktu, tanggalJatuhTempo.toString(), kuotaNasional);
    }
}


