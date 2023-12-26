public import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/cloudmart";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    
    public static void main(String[] args) {
        setupDatabase();
        displayStock();
        performTransaction();
        deleteTransaction();
        readTransactions();
        updateTransaction();
        deleteTransaction();
        closeResources();
    }

    private static void setupDatabase() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayStock() {
        try {
            String sql = "SELECT * FROM stok";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Kode Barang : " + rs.getInt("product_code"));
                System.out.println("Nama Barang: " + rs.getString("product_name"));
                System.out.println("Harga Barang: " + rs.getString("product_price"));
                System.out.println("Kasir: " + rs.getString("cashier"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void performTransaction() {
        // Your existing code for user login and transaction
        Scanner scanner = new Scanner(System.in);
        // Login 
        System.out.println("SELAMAT DATANG DI CLOUD MART");
        System.out.println("==============================");
        System.out.println("Log in");

        // Password yang benar
        String predefinedPassword = "cloudmart99";

        // Input Password
        System.out.print("Password     : ");
        String enteredPassword = scanner.nextLine();

        // Message
        if (enteredPassword.equals(predefinedPassword)) {
            
           
            String generatedCaptcha = generateCaptcha();
            System.out.println("Inputkan Captcha sesuai yang tertera!");
            System.out.println("Kode Captcha : " + generatedCaptcha);
            System.out.print("Entry Captcha : ");
            String enteredCaptcha = scanner.nextLine();

            if (enteredCaptcha.equals(generatedCaptcha)) {
              // Input data transaksi
              System.out.print("Nama Pelanggan : ");
              String name = scanner.nextLine();

              System.out.print("No. HP         : ");
              String phoneNumber = scanner.nextLine();

              System.out.print("Alamat         : ");
              String address = scanner.nextLine();

              System.out.print("Kode Barang    : ");
              String productCode = scanner.nextLine();

              System.out.print("Nama Barang    : ");
              String productName = scanner.nextLine();

              System.out.print("Harga Barang   : ");
              double productPrice = scanner.nextDouble();

              System.out.print("Jumlah Beli    : ");
              int quantity = scanner.nextInt();

              System.out.print("Kasir          : ");
              String cashier = scanner.next();

              CustomerData customerData = new CustomerData(name, phoneNumber, address);

              Date currentDate = new Date();
            
              SupermarketTransaction transaction = new SupermarketTransaction(currentDate,
              "hh:mm:ss time zone", customerData, productCode, productName, productPrice,
              quantity, cashier);

            transaction.displayTransaction();

             // Call createTransaction method in TransactionManager
        TransactionManager.createTransaction(transaction); 
        
             } else {
        System.out.println("Captcha salah. Silahkan log in kembali.");
         }
            } else {
        System.out.println("Password salah. Silakan log in kembali.");
    }
}
private static String generateCaptcha() {

return "CLM09";
}

                





       
    

    private static void readTransactions() {
        System.out.println("=== READ TRANSACTIONS ===");
        // Call readTransactions method in TransactionManager
        TransactionManager.readTransactions();
    }

    private static void updateTransaction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UPDATE TRANSACTION ===");
        try {
        // Input transaction ID to update
        System.out.print("Enter Transaction ID to update: ");
        int transactionId = scanner.nextInt();

        // Input updated data
        System.out.print("New Product Name: ");
        String newProductName = scanner.next();

        // Create SupermarketTransaction object with updated data
        SupermarketTransaction updatedTransaction = new SupermarketTransaction(
                new Date(), "hh:mm:ss time zone", new CustomerData("", "", ""),
                "", newProductName, 0.0, 0, "");

        // Call updateTransaction method in TransactionManager
        TransactionManager.updateTransaction(updatedTransaction, transactionId);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteTransaction() {
        try {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DELETE TRANSACTION ===");

        // Input transaction ID to delete
        System.out.print("Inputkan Kode Barang: ");
        int productCode = scanner.nextInt();

        // Call deleteTransaction method in TransactionManager
        TransactionManager.deleteTransaction(productCode);
    }
    catch(Exception e) {
            e.printStackTrace();
        }
}
    private static void closeResources() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} Main {
    
}
