package com.rpg.arena;

public interface AksiBertarung {
    // untuk menyerang, mengembalikan nilai damage yang dihasilkan 
    int serang(); 
    // untuk mengambil posisi bertahan 
    void bertahan(); 
    // untuk menggunakan item pemulih 
    void gunakanItem(); 
}