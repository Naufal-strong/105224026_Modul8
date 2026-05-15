
public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    // Constructor yang memanggil constructor induk [cite: 17]
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public boolean autentikasi() {
        // Mencetak pesan autentikasi PIN berhasil dan mengembalikan true [cite: 19]
        System.out.println("Autentikasi PIN berhasil.");
        return true;
    }

    @Override
    public void prosesPembayaran() {
        // Menghitung biaya admin sebesar 2% dari nominal [cite: 18]
        double biayaAdmin = nominal * 0.02;
        double totalTagihan = nominal + biayaAdmin;
        
        // Mencetak biaya admin dan total tagihan keseluruhan [cite: 18]
        System.out.println("Biaya Admin (2%): Rp" + biayaAdmin);
        System.out.println("Total Tagihan: Rp" + totalTagihan);
    }
}