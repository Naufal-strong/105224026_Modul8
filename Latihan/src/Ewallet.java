// File: EWallet.java
public class Ewallet extends Pembayaran implements Keamanan {
    // Atribut tambahan private [cite: 20]
    private String nomorHP;

    // Constructor sesuai dengan atribut [cite: 20]
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
        System.out.println("Biaya Admin: Rp0");
        System.out.println("Total Tagihan: Rp" + nominal);
    }
}