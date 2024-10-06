# Clean Architecture
Arsitektur "Clean Code" atau yang sering disebut juga sebagai "Clean Architecture" adalah sebuah pendekatan dalam pengembangan perangkat lunak yang fokus pada pembuatan kode yang bersih dan mudah dipelihara. Pendekatan ini diperkenalkan oleh Robert C. Martin (dikenal sebagai Uncle Bob) dan memiliki beberapa prinsip utama yang ditujukan untuk meningkatkan pemisahan kepentingan dan membuat sistem lebih modular, fleksibel, dan adaptif.
![Clean Architecture](https://raw.githubusercontent.com/AliAsadi/Android-Clean-Architecture/master/screenshot/architecture0.png)

Arsitektur ini biasanya digambarkan sebagai serangkaian lingkaran yang berurutan, yang dikenal sebagai "The Clean Architecture Circle", di mana setiap lingkaran mewakili tingkat keabstrakan yang berbeda. Lingkaran ini termasuk, dari luar ke dalam:

- Entities: Objek yang mengandung fungsi bisnis utama atau aturan aplikasi.
- Use Cases: Memuat logika aplikasi spesifik yang mengarahkan data ke dan dari entitas.
- Interface Adapters: Mengkonversi data antara format yang paling cocok untuk entitas atau kasus penggunaan dan format yang paling cocok untuk beberapa agen luar seperti database atau web.
- Frameworks and Drivers: Kode yang berhubungan dengan framework atau alat eksternal seperti database, UI, dan perangkat keras lain.

# Jetpack Compose
Jetpack Compose adalah kerangka kerja modern untuk membangun antarmuka pengguna (UI) yang lebih sederhana dan lebih reaktif pada aplikasi Android, menggunakan pendekatan berbasis deklaratif.

## Fungsi dari @Composable
Anotasi @Composable digunakan untuk menandai fungsi di Kotlin yang bisa digunakan untuk membangun, atau "menyusun", bagian dari UI aplikasi. Fungsi yang dianotasi dengan @Composable dapat memanggil fungsi @Composable lainnya, memungkinkan struktur UI yang modular dan reaktif. Ini berarti UI dapat memperbarui secara efisien respons terhadap perubahan data, tanpa memerlukan pemrogram untuk secara manual mengatur pembaruan tersebut.