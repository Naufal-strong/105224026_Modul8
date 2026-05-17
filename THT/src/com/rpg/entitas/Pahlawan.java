package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter {
    private int mana;
    private int level;
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); 
        this.mana = mana;
        this.level = level;
    }

    // Method Overriding: Mengubah perilaku metode serang standar sesuai formula Pahlawan 
    @Override
    public int serang() {
        int damageTotal = this.baseDamage * this.level; // Formula damage
        System.out.println(this.nama + " menyerang secara biasa dan menghasilkan " + damageTotal + " damage!");
        return damageTotal;
    }

    // Method Overloading: Metode serang versi kedua yang membutuhkan parameter Skill dan Mana 
    public int serang(String namaSkill, int manaCost) {
        // Cek kecukupan mana pahlawan sebelum meluncurkan skill 
        if (this.mana >= manaCost) {
            this.mana -= manaCost; // Mengurangi mana 
            int damageSkill = this.baseDamage * this.level * 2; // Formula damage skill 
            System.out.println(this.nama + " menggunakan skill [" + namaSkill + "]! Menghasilkan " + damageSkill + " damage!");
            return damageSkill;
        } else {
            // Jika mana tidak cukup, serangan gagal dan damage bernilai 0 
            System.out.println("Mana tidak cukup untuk menggunakan " + namaSkill + "!");
            return 0;
        }
    }

    // Method Overriding: Mengubah status bertahan menjadi true 
    @Override
    public void bertahan() {
        this.isDefending = true;
        System.out.println(this.nama + " mengambil posisi bertahan dan bersiaga!");
    }

    // Method Overriding: Menambahkan HP pahlawan sebesar 30 poin saat menggunakan item 
    @Override
    public void gunakanItem() {
        this.hp += 30;
        System.out.println(this.nama + " menggunakan Potion! HP bertambah 30. HP sekarang: " + this.hp);
    }

    // Method Overriding: Menampilkan status spesifik milik Pahlawan 
    @Override
    public void tampilkanStatus() {
        System.out.println("STATUS PAHLAWAN");
        System.out.println("Nama   : " + this.nama);
        System.out.println("HP     : " + this.hp);
        System.out.println("Mana   : " + this.mana); 
        System.out.println("Level  : " + this.level); 
        System.out.println("================");
    }
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}