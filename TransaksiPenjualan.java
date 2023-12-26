import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class TransaksiPenjualan {
    private String namaPelanggan;
    private String nomorHP;
    private String alamat;
    private String kodeBarang;
    private String namaBarang;
    private long hargaBarang;
    private int jumlahBeli;
    private long totalBayar;
    private String kasir;
    private Date tanggal;

    public void displayData() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy 'at' HH:mm:ss z");
        String strDate = dateFormat.format(tanggal);

        System.out.println("tiaRA Mart");
        System.out.println("Tanggal : " + strDate);
        System.out.println("========================");
        System.out.println("DATA PELANGGAN");
        System.out.println("---------------------");
        System.out.println("Nama Pelanggan : " + namaPelanggan);
        System.out.println("No. HP : " + nomorHP);
        System.out.println("Alamat : " + alamat);
        System.out.println("++++++++++++++++++++++++");
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("------------------------------");
        System.out.println("Kode Barang : " + kodeBarang);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Harga Barang : " + hargaBarang);
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.println("TOTAL BAYAR : " + totalBayar);
        System.out.println("++++++++++++++++++++++++");
        System.out.println("Kasir : " + kasir);
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Masukkan Nama Pelanggan: ");
            namaPelanggan = scanner.nextLine();

            System.out.println("Masukkan Nomor HP: ");
            nomorHP = scanner.nextLine();

            System.out.println("Masukkan Alamat: ");
            alamat = scanner.nextLine();

            System.out.println("Masukkan Kode Barang: ");
            kodeBarang = scanner.nextLine();

            System.out.println("Masukkan Nama Barang: ");
            namaBarang = scanner.nextLine();

            System.out.println("Masukkan Harga Barang: ");
            hargaBarang = scanner.nextLong();

            System.out.println("Masukkan Jumlah Beli: ");
            jumlahBeli = scanner.nextInt();

            totalBayar = hargaBarang * jumlahBeli;

            tanggal = new Date();



            scanner.nextLine();
            System.out.println("Masukkan Nama Kasir: ");
            kasir = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan dalam memasukkan data. Silakan coba lagi.");
        } finally{
            scanner.close();
        }
    }
}