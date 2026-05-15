
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pembayaran transaksiCC = new KartuKredit("Opal Nugroho", 1500000.0, "4111-2222-3333-4444");
        Pembayaran transaksiEWallet = new Ewallet("Sarnadi Santoso", 300000.0, "081234444890");

        ArrayList<Pembayaran> daftarTransaksi = new ArrayList<>();
        daftarTransaksi.add(transaksiCC);
        daftarTransaksi.add(transaksiEWallet);

        System.out.println(" SISTEM PEMBAYARAN DIGITAL \n");
        for (Pembayaran transaksi : daftarTransaksi) {

            transaksi.tampilkanDetail();
            if (transaksi instanceof Keamanan) {
                Keamanan aman = (Keamanan) transaksi;
                
                if (aman.autentikasi()) {
                    transaksi.prosesPembayaran();
                }
            }
        }
    }
}