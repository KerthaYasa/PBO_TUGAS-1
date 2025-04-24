package investasi.Service;

import investasi.Model.SBN;
import investasi.Model.Saham;
import java.util.List;

public interface InvestasiService {
    List<Saham> getDaftarSaham();
    List<SBN> getDaftarSBN();
}
