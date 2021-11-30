import controller07266.AdminController07266;
import controller07266.PendudukController07266;
import entity07266.AdminEntity07266;
import entity07266.PendudukEntity07266;

import java.util.ArrayList;
import java.util.Scanner;

public class PendataanVaksin07266 {
    private final Scanner input = new Scanner(System.in);
    private final AdminController07266 adminC = new AdminController07266();
    private final PendudukController07266 pendudukC = new PendudukController07266();

    AdminEntity07266 logged = null;

    private void print(String text){
        System.out.print(text);
    }
    private void println(String text){
        System.out.println(text);
    }

    private void manajemenAkun(int pilih){
        switch (pilih) {
            case 1 -> {
                print("Masukan Password baru : ");
                logged.setPassword(input.nextLine());
            }
            case 2 -> {
                print("Masukan No Telp baru : ");
                logged.setNoTelp(input.nextLine());
            }
        }
        if (pilih >= 1 && pilih <=2){
            println((adminC.updateData(logged) > 0) ? "Berhasil Mengubah data" : "Gagal Mengubah data!");
        }
    }
    private void manajemenAkun(){
        print("""
                1. Ubah Password
                2. Ubah No Telpon
                """);
        print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();
        manajemenAkun(pilih);

    }

    private ArrayList<PendudukEntity07266> findby(String key, String option){
        print("Masukan " + key + " yang ingin dipilih : ");
        if (key.equals("id")){
            int intVal = input.nextInt();
            input.nextLine();
            return pendudukC.getData(key, intVal, option);
        } else {
            String value = input.nextLine();
            return pendudukC.getData(key, value, option);
        }
    }

    private void cekData(){
        ArrayList<PendudukEntity07266> data = findby("nik", "=");
        if (data.size() > 0){
            lihatData(data.get(0));
        } else {
            println("Tidak ada data yang sesuai!");
        }
    }

    private void lihatData(PendudukEntity07266 data){
        println("--------------------------------------");
        println("ID           : " + data.getId());
        println("Nama         : " + data.getNama());
        println("Nik          : " + data.getNik());
        println("No Telp      : " + data.getNoTelp());
        println("Dosis        : " + data.getDosis());
        println("Jenis Vaksin : " + data.getJenisVaksin());
        println("--------------------------------------");
    }
    private void showData(){
        ArrayList<PendudukEntity07266> dataPenduduk = pendudukC.getData();
        for (PendudukEntity07266 penduduk : dataPenduduk) {
            lihatData(penduduk);
        }
    }

    private void hapusData(){
        println("\n========= HAPUS DATA PENDUDUK =========");
        ArrayList<PendudukEntity07266> data = findby("id", "=");
        if (data.size() > 0){
            PendudukEntity07266 selected = data.get(0);
            println("Ingin menghapus data ini");
            lihatData(selected);

            print("yakin ? (y/n) ");
            String konf = input.nextLine().toLowerCase();

            if (konf.charAt(0) == 'y'){
                println((pendudukC.deleteData(selected) > 0) ? "Data Berhasil dihapus" : "Data Gagal dihapus");
            } else {
                println("Dibatalkan");
            }
        } else {
            println("Data tidak ditemukan!");
        }
    }

    private void updateData(int pilih, PendudukEntity07266 penduduk){
        switch (pilih){
            case 1 -> {
                print("Masukan No Telpon baru: ");
                penduduk.setNoTelp(input.nextLine());
            }
            case 2 -> {
                print("Masukan Dosis baru: ");
                penduduk.setDosis(input.nextLine());
            }
        }
        if (pilih>= 1 && pilih <= 2 ){
            println((pendudukC.updateData(penduduk) > 0) ? "Berhasil Mengubah data" : "Gagal Mengubah data!");
        }
    }
    private void updateData(){
        println("\n========= UBAH DATA PENDUDUK =========");
        ArrayList<PendudukEntity07266> data = findby("id", "=");
        if (data.size() > 0) {
            PendudukEntity07266 selected = data.get(0);
            lihatData(selected);

            print("""
                Ingin mengubah apa?
                1. No Telpon
                2. Dosis
                """);
            print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();
            updateData(pilih, selected);
        } else {
            println("Data tidak ditemukan!");
        }
    }

    private void tambahData(){
        println("\n========= TAMBAH DATA PENDUDUK =========");
        String nama, alamat, noTelp, nik, dosis, jenisVaksin;

        print("Masukan Nama             : ");
        nama = input.nextLine();
        print("Masukan Alamat           : ");
        alamat = input.nextLine();
        print("Masukan No Telp          : ");
        noTelp = input.nextLine();
        print("Masukan NIK              : ");
        nik = input.nextLine();
        print("Masukan Dosis            : ");
        dosis = input.nextLine();
        print("Masukan Jenis Vaksin     : ");
        jenisVaksin = input.nextLine();

        int status = pendudukC.insertData(
                new PendudukEntity07266(0, nama, alamat, noTelp, nik, dosis, jenisVaksin)
        );

        println((status > 0) ? "Berhasil Menambahkan data" : "Gagal Menambahkan Data");
    }

    private void homeAdmin(int pilih){
        switch (pilih){
            case 1 -> tambahData();
            case 2 -> updateData();
            case 3 -> hapusData();
            case 4 -> showData();
            case 5 -> cekData();
            case 6 -> manajemenAkun();
        }
    }
    private void homeAdmin(){
        int pilih;
        do {
            print("""
                \n========= MENU ========
                1. Tambah Data Penduduk
                2. Update Data Penduduk
                3. Hapus Data Penduduk
                4. Lihat Data Penduduk
                5. Cek Data Penduduk (NIK)
                6. Manajamen Akun
                0. Keluar
                """);
            print("Masukan menu: ");
            pilih = input.nextInt();
            input.nextLine();
            homeAdmin(pilih);
        } while (pilih != 0);
    }

    // admin login view
    private void adminAuth(){
        println("======== LOGIN ========");
        print("NIP      : ");
        String nip = input.nextLine();

        print("Password : ");
        String password = input.nextLine();

        logged = adminC.login(nip, password);

        if (logged != null) homeAdmin();
        else println("NIP atau Password anda Salah!");
    }

    public void init() {
        while (true){
            adminAuth();
        }
    }
}
