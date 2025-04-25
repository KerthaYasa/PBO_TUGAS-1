package investasi;

import investasi.Service.AppService;
import investasi.Util.ClearScreen;

public class Main {
    public static void main(String[] args) {
        ClearScreen.clear();

        AppService appService = new AppService();
        appService.run();
    }
}