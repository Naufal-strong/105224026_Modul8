// File: PengirimanUdara.java
public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String nomorPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.nilaiBarang = nilaiBarang;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
    }

    @Override
    public double hitungOngkosKirim() {
        // Algoritma tarif dasar armada udara
        return (beratBarang * 25000) + (jarakTempuh * 5000);
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        // Mengembalikan nilai premi sebesar 3% (0.03) dari nilai barang
        return 0.03 * nilaiBarang;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return this.statusSaatIni;
    }

    // Getter (opsional, namun berguna untuk mengambil nilai barang saat casting polimorfik)
    public double getNilaiBarang() {
        return nilaiBarang;
    }
}