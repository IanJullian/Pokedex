# Pokédex - Aplikasi Katalog dan Eksplorasi Pokémon
> Aplikasi Android berbasis Jetpack Compose dan PokéAPI untuk mencari, melihat, dan mengeksplorasi informasi Pokémon.

---

## 👤 Identitas Praktikan
- **Nama Lengkap:** Ian Jullian Sutrisno
- **NIM:** H1D024039
- **Shift Awal:** Shift I
- **Shift Akhir:** Shift C
- **Link Video Demo/Penjelasan:** [YouTube/Google Drive](https://...)

---

## 📱 Deskripsi Aplikasi
Pokémon memiliki banyak karakter dengan berbagai jenis (type), statistik, tinggi, berat, dan kemampuan (ability) yang berbeda. Dengan jumlah Pokémon yang sangat banyak, pengguna membutuhkan cara yang mudah untuk mencari dan mengeksplorasi informasi Pokémon secara interaktif melalui perangkat mobile.

Aplikasi **Pokédex** ini dikembangkan menggunakan **Kotlin**, **Jetpack Compose (Material Design 3)**, dan **REST API (PokéAPI)** dengan menerapkan arsitektur **MVVM (Model-View-ViewModel)**. Aplikasi ini memungkinkan pengguna untuk mencari Pokémon berdasarkan nama atau ID, melihat daftar Pokémon dalam format grid yang responsif, serta melihat statistik detail setiap Pokémon.

---

## 🛠️ Penjelasan Teknis

### 1. Spesifikasi & Tech Stack
- **Bahasa:** Kotlin 2.2.10
- **UI Framework:** Jetpack Compose (Material 3)
- **Min SDK:** 24 (Android 7.0) | **Target SDK:** 37 (Android 15)
- **Pola Arsitektur:** MVVM (Model-View-ViewModel)
- **Library Utama:**
  - `Navigation Compose` (Routing halaman Home ke Detail)
  - `ViewModel` & `StateFlow` (State Management & Reactive UI)
  - `Retrofit` & `Gson` (Networking / REST API)
  - `OkHttp Logging Interceptor` (HTTP Network Logging)
  - `Coil Compose` (Asynchronous Image Loading)
  - `Kotlin Coroutines` (Asynchronous processing)

### 2. Fitur Utama
- **Home Screen & Listing Pokémon:**
  - Menampilkan daftar Pokémon dalam `LazyVerticalGrid` (2 kolom).
  - Menampilkan Gambar (Official Artwork), Nama Pokémon, dan ID Pokémon (#001, #002, dst.).
- **Search Functionality:**
  - Fitur pencarian real-time berdasarkan nama Pokémon atau ID.
  - Memfilter daftar Pokémon secara dinamis melalui ViewModel dan StateFlow.
- **Loading & Error Handling State:**
  - Menampilkan `LoadingScreen` saat memuat data dari PokéAPI.
  - Menampilkan `ErrorScreen` dengan pesan error serta tombol **Try Again** (Retry) jika terjadi gangguan koneksi jaringan.
- **Pokémon Detail Screen:**
  - Menampilkan gambar hero official artwork Pokémon dengan warna latar belakang yang menyesuaikan tipe utama (misal: Hijau untuk Grass, Merah untuk Fire, Biru untuk Water).
  - Tipe Pokémon (Type Chips) dengan skema warna khas.
  - Informasi fisik: Tinggi (meter) dan Berat (kilogram) yang sudah dikonversi dari satuan PokéAPI.
  - Statistik Dasar (Base Stats: HP, ATK, DEF, SPA, SPD, Speed) dengan animasi progress bar (`StatBar`).
  - Kemampuan (Abilities) Pokémon.

### 3. API yang Digunakan
- **Base URL:** `https://pokeapi.co/api/v2/`
- **Endpoints:**
  1. `GET /pokemon?limit=151&offset=0` - Mengambil daftar Pokémon generasi pertama.
  2. `GET /pokemon/{id_atau_nama}` - Mengambil detail lengkap Pokémon (stats, types, height, weight, abilities, sprites).

### 4. Struktur Direktori Proyek
```text
com.ianjullian.pokedex/
├── data/
│   ├── remote/
│   │   ├── dto/
│   │   │   ├── PokemonDetailDto.kt
│   │   │   └── PokemonListResponse.kt
│   │   ├── PokeApiService.kt
│   │   └── RetrofitClient.kt
│   └── repository/
│       ├── PokemonRepository.kt
│       └── PokemonRepositoryImpl.kt
├── domain/
│   └── model/
│       ├── PokemonDetail.kt
│       └── PokemonItem.kt
├── navigation/
│   └── NavGraph.kt
├── ui/
│   ├── components/
│   │   ├── ErrorScreen.kt
│   │   ├── LoadingScreen.kt
│   │   ├── PokemonCard.kt
│   │   ├── SearchBarComponent.kt
│   │   ├── StatBar.kt
│   │   └── TypeChip.kt
│   ├── screens/
│   │   ├── detail/
│   │   │   ├── DetailUiState.kt
│   │   │   ├── DetailViewModel.kt
│   │   │   └── PokemonDetailScreen.kt
│   │   └── home/
│   │       ├── HomeScreen.kt
│   │       ├── HomeUiState.kt
│   │       └── HomeViewModel.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
├── utils/
│   ├── Extensions.kt
│   └── PokemonTypeUtils.kt
└── MainActivity.kt
```

---

## 📸 Tangkapan Layar (Screenshots)

|                                                     Home Screen                                                      |                                                      Search Pokémon                                                       |                                                      Detail Screen                                                       |
|:--------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://raw.githubusercontent.com/IanJullian/Pokedex/main/docs/home.jpeg" width="220" alt="Home Screen" /> | <img src="https://raw.githubusercontent.com/IanJullian/Pokedex/main/docs/search.jpeg" width="220" alt="Search Pokémon" /> | <img src="https://raw.githubusercontent.com/IanJullian/Pokedex/main/docs/detail.jpeg" width="220" alt="Detail Screen" /> |

---

## 🚀 Cara Menjalankan Proyek

1. **Prasyarat:**
   - Android Studio (Koala / Ladybug / versi terbaru).
   - JDK 17 atau lebih baru.
   - Perangkat fisik Android dengan USB Debugging aktif atau Emulator.

2. **Langkah-langkah:**
   ```bash
   # Clone repository
   git clone <URL_REPOSITORY>
   ```
3. Buka folder proyek di **Android Studio**.
4. Tunggu proses **Gradle Sync** selesai.
5. Pilih target perangkat/emulator, lalu klik tombol **Run (`Shift + F10`)**.
