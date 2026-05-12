class Programmer extends Karyawan {
    private double gajipokok;
    public Programmer(String nama, double gajipokok) {
        super(nama);
        this.gajipokok = gajipokok;
    }
    @Override
    public double hitungGaji() {
        return gajipokok;
    }


    
}
