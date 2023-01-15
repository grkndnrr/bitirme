package gurkan.doner.myapplication

import java.sql.Connection
import java.sql.DriverManager
/**import java.sql.ResultSet
import java.sql.Statement
import android.content.Context
*/

class DatabaseConnection {
    companion object {
        private const val URL = "jdbc:mysql://localhost:3306/bitirmeprojesi"
        private const val USERNAME = "root"
        private const val PASSWORD = "iste123"

        fun connect(): Connection? {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver")
                return DriverManager.getConnection(URL, USERNAME, PASSWORD)
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }
            fun testConnection() {
                val connection = connect()
                if (connection != null) {
                    println("Veritabanına bağlantı kuruldu.")
                    connection.close()
                } else {
                    println("Veritabanına bağlantı kurulamadı.1")
                }
            }

        }
    }







/**class Database(context: Context) {
    fun query(sql: String): ResultSet {
        // Veritabanı sürücüsünü yükle ve veritabanına bağlan
        val connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bitirmeprojesi",
            "root",
            "iste123"
        )

        // Bağlantı kuruluysa, bir statement oluştur ve sorguyu çalıştır
        if (connection != null) {
            val statement: Statement = connection.createStatement()
            return statement.executeQuery(sql)
        } else {
            throw Exception("Veritabanı bağlantısı kurulamadı.")
        }

    }
}
*/