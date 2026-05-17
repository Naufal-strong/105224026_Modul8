package com.rpg.arena;

public abstract class Karakter implements AksiBertarung {
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending; 

    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // Secara default, karakter tidak dalam posisi bertahan 
    }

    // Metode untuk memproses kalkulasi damage yang diterima dari musuh 
    public void terimaDamage(int damage) {
        // Jika sedang bertahan, damage yang masuk dipotong setengah
        if (this.isDefending) {
            damage = damage / 2;
            this.isDefending = false; // Status bertahan dikembalikan ke false setelah menerima serangan 
            System.out.println(this.nama + " menahan serangan! Damage berkurang menjadi " + damage);
        }
        
        // Mengurangi HP berdasarkan damage yang sudah dikalkulasi 
        this.hp -= damage;
        
        // Validasi agar HP tidak minus (jika di bawah 0, dipaksa mentok di angka 0) [cite: 8]
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.nama + " menerima " + damage + " damage. HP tersisa: " + this.hp);
    }

    // Metode abstrak yang wajib diimplementasikan oleh concrete class untuk cetak status [cite: 8, 9]
    public abstract void tampilkanStatus();

    public String getNama() {
         return nama; }

    public void setNama(String nama) { 
        this.nama = nama; }

    public int getHp() { 
        return hp; }

    public void setHp(int hp) { 
        this.hp = hp; }

    public int getBaseDamage() { 
        return baseDamage; }

    public void setBaseDamage(int baseDamage) { 
        this.baseDamage = baseDamage; }

    public boolean isDefending() { 
        return isDefending; }

    public void setDefending(boolean defending) {
         isDefending = defending; }
}