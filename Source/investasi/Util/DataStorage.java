package investasi.Util;

import investasi.Model.Saham;
import investasi.Model.SBN;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static DataStorage instance;
    private List<Saham> daftarSaham = new ArrayList<>();
    private List<SBN> daftarSBN = new ArrayList<>();

    private DataStorage() {
        initializeSampleData();
    }

    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    private void initializeSampleData() {
        daftarSaham.add(new Saham("BBCA", "Bank Central Asia", 8500));
        daftarSaham.add(new Saham("TLKM", "Telkom Indonesia", 3500));

        daftarSBN.add(new SBN("SBR010", 5.75, 12,
                LocalDate.now().plusMonths(12), 1000000000));
    }

        public void tambahSaham(Saham saham) {
        daftarSaham.add(saham);
    }

    public List<Saham> getDaftarSaham() {
        return daftarSaham;
    }

    public void tambahSBN(SBN sbn) {
        daftarSBN.add(sbn);
    }

    public List<SBN> getDaftarSBN() {
        return daftarSBN;
    }
}
