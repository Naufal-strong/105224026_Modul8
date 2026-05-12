public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Joko Anwar", 1000000.0);
        System.out.println("Nama: " + programmer.nama);
        System.out.println("Gaji: " + programmer.hitungGaji());
    }
}
