package com.rpg.main;

import com.rpg.entitas.Pahlawan;
import com.rpg.entitas.Monster;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        // Menggunakan Scanner untuk menerima input dari pemain melalui Keyboard 
        Scanner input = new Scanner(System.in);
        System.out.println(" SELAMAT DATANG DI RPG SURVIVAL ARENA  ");
        System.out.print("Masukkan nama Pahlawan Anda: ");
        String namaHero = input.nextLine(); 

        // Inisialisasi objek Pahlawan (Nama, HP=150, BaseDamage=15, Mana=50, Level=2)
        Pahlawan hero = new Pahlawan(namaHero, 150, 15, 50, 2);

        // Membuat mode Survival dengan Array berisi 3 objek Monster yang bervariasi
        Monster[] daftarMonster = new Monster[3];
        daftarMonster[0] = new Monster("Bugster", 40, 10, "Normal");
        daftarMonster[1] = new Monster("Gurongi", 70, 15, "Elite");
        daftarMonster[2] = new Monster("Undeads", 120, 25, "Boss");

        System.out.println("\nPetualangan dimulai! Anda akan menghadapi 3 monster secara berurutan.\n");

        // Outer Loop: Mengambil dan menghadapi monster di dalam array satu per satu 
        for (int i = 0; i < daftarMonster.length; i++) {
            Monster monsterSaatIni = daftarMonster[i];
            System.out.println("--------------");
            System.out.println("MONSTER KE-" + (i + 1) + " MUNCUL: " + monsterSaatIni.getNama());
            System.out.println("--------------");

            // Inner Loop: Battle loop yang berjalan selama HP Hero dan HP Monster saat itu > 0
            while (hero.getHp() > 0 && monsterSaatIni.getHp() > 0) {
                // Tampilkan status terkini kedua pihak sebelum memilih aksi 
                monsterSaatIni.tampilkanStatus();

                // Menu Opsi Bertarung bagi Pemain 
                System.out.println("\nPilih Tindakan Anda:");
                System.out.println("1. Serang (Biasa)");
                System.out.println("2. Gunakan Skill (Butuh 20 Mana)");
                System.out.println("3. Bertahan / Heal (+30 HP)");
                System.out.print("Pilihan: ");
                int pilihan = input.nextInt();

                int damageKeMonster = 0; // Menampung damage yang diproduksi hero

                // Switch-case untuk merespon pilihan pemain 
                switch (pilihan) {
                    case 1:
                        damageKeMonster = hero.serang(); // Panggil metode serang biasa
                        monsterSaatIni.terimaDamage(damageKeMonster); // Kirim damage ke monster 
                        break;
                    case 2:
                        // Panggil metode Overloading serang dengan parameter skill
                        damageKeMonster = hero.serang("Kick Slash", 20); 
                        if (damageKeMonster > 0) { 
                            monsterSaatIni.terimaDamage(damageKeMonster); // Jika sukses, kurangi HP monster
                        }
                        break;
                    case 3:
                        hero.bertahan(); // Mengubah status isDefending hero menjadi true 
                        hero.gunakanItem(); // Menambah HP hero sebesar 30 
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Anda membuang giliran.");
                        break;
                }

                // Giliran Balasan Monster (Hanya jika monster tersebut masih hidup setelah diserang) 
                if (monsterSaatIni.getHp() > 0) {
                    System.out.println("\n Giliran Monster Membalas ");
                    
                    // Logika bawaan: Monster memiliki peluang 20% memilih bertahan/heal, 80% menyerang 
                    if (Math.random() < 0.2) {
                        monsterSaatIni.bertahan(); // Memulihkan sedikit HP monster 
                    } else {
                        int damageKeHero = monsterSaatIni.serang(); // Mengambil nilai damage monster
                        hero.terimaDamage(damageKeHero); // Memberikan damage tersebut ke Pahlawan
                    }
                }
                System.out.println("\n===========================\n");
            } 

            // Jika setelah Battle Loop selesai ternyata HP Hero habis, keluar dari perulangan monster (kalah) 
            if (hero.getHp() <= 0) {
                break; 
            }
            
            System.out.println("Anda berhasil mengalahkan " + monsterSaatIni.getNama() + "!\n");
        }

        // Jika Hero berhasil bertahan hidup setelah melewati loop semua monster
        if (hero.getHp() > 0) {
            System.out.println("=============================");
            System.out.println("SELAMAT! " + hero.getNama() + " berhasil menamatkan Dungeon!"); 
            System.out.println("=============================");
        } else {
            // Jika Hero mati di tengah jalan
            System.out.println("==============================");
            System.out.println("GAME OVER! Pahlawan Anda telah Mati di dalam Dungeon.");
            System.out.println("==============================");
        }

        input.close(); // Menutup resource scanner
    }
}