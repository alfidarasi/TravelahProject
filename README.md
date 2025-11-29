TravelahProject: Sebuah aplikasi konsol yang mensimulasikan sistem pemesanan perjalanan. Aplikasi ini memungkinkan user untuk mencari penerbangan, mencari hotel, memesan, 
melihat reservasi, dan membatalkan reservasi. Project ini dikembangkan untuk kebutuhan Tugas Kelompok dari mata kuliah Introduction to Programming for Business dari Binus University. 

Fitur Utama: 
    1. Cari & Pesan Penerbangan
        Input:
          - Kota asal
          - Kota tujuan
          - Tanggal perjalanan
          - Jumlah penumpang
        Sistem menampilkan daftar penerbangan yang sesuai.
        User dapat memilih salah satu untuk dipesan.
        Sistem meng-generate nomor konfirmasi unik (6 digit).
        Kursi tersedia otomatis berkurang.
    2. Cari & Pesan Hotel
        Input:
          - Kota / lokasi
          - Tanggal check-in
          - Tanggal check-out
        Jumlah tamu
        Sistem menampilkan daftar hotel tersedia.
        User memilih hotel dan membuat reservasi.
    3. Lihat Semua Reservasi
        User memilih hotel dan membuat reservasi.
    4. Batalkan Reservasi
        User memasukkan nomor konfirmasi.
        Sistem mencari di seluruh reservasi.
        Menggunakan pattern matching instanceof (Java 17+).
        Jika flight dibatalkan maka kursi dikembalikan.
        Jika hotel dibatalkan maka Reservasi dihapus.
        Jika tidak ditemukan maka akan tampil pesan error.

Struktur & Konsep OOP yang Digunakan: 
    1. Encapsulation di mana setiap class (FlightItem, HotelItem, Reservation, dsb) menggunakan:
       - private fields
       - public getter + setter
    2. Inheritance & Polymorphism dengna menggunakan sealed abstract class:
          sealed abstract class Reservation permits FlightReservation, HotelReservation
        Subclass:
          - FlightReservation
          - HotelReservation
        Semua memiliki:
          - confirmationNumber
          - customerName
          - method display()
        Polimorfisme muncul saat iterasi reservasi:
          reservations.forEach(Reservation::display);
    3. Abstract + Sealed Class
        Class Reservation:
          - abstract class
          - sealed
          - mendefinisikan struktur dasar reservasi
          - hanya bisa diturunkan oleh 2 class yang diizinkan (flight & hotel)

Cara Menjalankan Program: 
    1. Clone repository
        git clone https://github.com/alfidarasi/TravelahProject.git
        cd TravelahProject
    2. Jalankan
        - Jika menggunakan CLI:
          javac src/**/*.java
          java app.Travelah
        - Jika pakai VS Code:
        - Tekan tombol ▶️ “Run Java”
        - Program akan berjalan di terminal VS Code

      
