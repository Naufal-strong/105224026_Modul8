public class Ewallet extends Pembayaran implements Keamanan {
    private String nomorHP;
    public Ewallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi berhasil.");
        return true;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Biaya Admin: Rp0 (Gratis)");
        System.out.println("Total Tagihan: Rp" + nominal);
    }
}