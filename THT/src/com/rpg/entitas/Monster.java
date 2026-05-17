package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;
    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage); // Memanggil constructor dasar Karakter
        this.jenisMonster = jenisMonster;
    }
    // Method Overriding: Serangan monster hanya mengembalikan nilai baseDamage
    @Override
    public int serang() {
        System.out.println("Monster " + this.nama + " (" + this.jenisMonster + ") menyerang balik sebesar " + this.baseDamage + " damage!");
        return this.baseDamage;
    }

    // Method Overriding: Berbeda dengan pahlawan, aksi bertahan monster justru memulihkan HP-nya 
    @Override
    public void bertahan() {
        int pulihHp = 15; // Jumlah HP yang dipulihkan saat monster bertahan
        this.hp += pulihHp;
        System.out.println("Monster " + this.nama + " memilih bertahan dan memulihkan HP sebesar " + pulihHp + "!");
    }

    // Memenuhi kewajiban kontrak interface untuk menggunakan item (diabaikan atau dibuat default)
    @Override
    public void gunakanItem() {
        System.out.println("Monster tidak tahu cara menggunakan item.");
    }

    // Method Overriding: Menampilkan status spesifik milik Monster 
    @Override
    public void tampilkanStatus() {
        System.out.println("--> Musuh: " + this.nama + " [" + this.jenisMonster + "] | HP: " + this.hp);
    }
    public String getJenisMonster() { 
        return jenisMonster; }
        
    public void setJenisMonster(String jenisMonster) {
        this.jenisMonster = jenisMonster; }
}