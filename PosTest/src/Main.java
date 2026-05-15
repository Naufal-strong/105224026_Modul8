public class Main {
    public static void main(String[] args) {
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        darat.updateStatus("Sedang di jalan tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        LayananPengiriman[] daftarPengiriman = {darat, udara};

        System.out.println(" SISTEM LOGISTIK-PRO \n");
        for (LayananPengiriman layanan : daftarPengiriman) {
            
            
        
            layanan.cetakResi();
            
            if (layanan instanceof LacakKargo) {
                LacakKargo kargo = (LacakKargo) layanan;
                System.out.println("Status Lokasi: " + kargo.cekLokasiTerakhir());
            }
            double ongkirDasar = layanan.hitungOngkosKirim();
            double totalTagihan = ongkirDasar;
            System.out.println("Ongkos Kirim Dasar: Rp " + ongkirDasar);

            if (layanan instanceof Asuransi) {
                Asuransi asuransi = (Asuransi) layanan;
                asuransi.cetakPolis(); // Memanggil default method
                
                double nilaiBarang = 0;
                if (layanan instanceof PengirimanUdara) {
                    nilaiBarang = ((PengirimanUdara) layanan).getNilaiBarang();
                }
                
                double premi = asuransi.hitungPremi(nilaiBarang);
                System.out.println("Biaya Premi Asuransi (3%): Rp " + premi);
                totalTagihan += premi;
            }

            System.out.println("Total Tagihan: Rp " + totalTagihan);
        }
    }
}