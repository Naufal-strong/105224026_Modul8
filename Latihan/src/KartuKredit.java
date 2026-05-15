public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN berhasil.");
        return true;
    }

    @Override
    public void prosesPembayaran() {

        double biayaAdmin = nominal * 0.02;
        double totalTagihan = nominal + biayaAdmin;
    
        System.out.println("Biaya Admin (2%): Rp" + biayaAdmin);
        System.out.println("Total Tagihan: Rp" + totalTagihan);
    }
}