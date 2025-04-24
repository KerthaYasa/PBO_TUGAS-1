package investasi.Model;

import java.util.HashMap;
import java.util.Map;

public class Portofolio {
    private Map<investasi.Model.Saham, Integer> sahamDimiliki; // Saham dan jumlah lembar
    private Map<investasi.Model.SBN, Double> sbnDimiliki; // SBN dan nominal investasi

    public Portofolio() {
        this.sahamDimiliki = new HashMap<>();
        this.sbnDimiliki = new HashMap<>();
    }

    public void tambahSaham(investasi.Model.Saham saham, int jumlah) {
        sahamDimiliki.merge(saham, jumlah, Integer::sum);
    }

    public void kurangiSaham(investasi.Model.Saham saham, int jumlah) {
        int jumlahSekarang = sahamDimiliki.getOrDefault(saham, 0);
        if (jumlahSekarang >= jumlah) {
            sahamDimiliki.put(saham, jumlahSekarang - jumlah);
        }
    }

    public void tambahSBN(investasi.Model.SBN sbn, double nominal) {
        sbnDimiliki.merge(sbn, nominal, Double::sum);
    }

    public Map<investasi.Model.Saham, Integer> getSahamDimiliki() {
        return sahamDimiliki;
    }

    public Map<investasi.Model.SBN, Double> getSbnDimiliki() {
        return sbnDimiliki;
    }
}

