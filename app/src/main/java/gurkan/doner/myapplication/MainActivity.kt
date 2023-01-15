package gurkan.doner.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DatabaseConnection.testConnection()


        // get reference to all views
        val buttonGiris = findViewById<View>(R.id.buttonGiris)
        val buttonRegister = findViewById(R.id.buttonRegister) as Button
        val editTextOgrenciNo = findViewById<EditText>(R.id.editTextOgrenciNo)
        val editTextSifre = findViewById<EditText>(R.id.editTextSifre)

        buttonRegister.setOnClickListener{
        val registerFragment = RegisterFragment()
        val fragment:Fragment? = supportFragmentManager.findFragmentByTag(RegisterFragment::class.java.simpleName)
            if(fragment !is RegisterFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.ConstraintLayout, registerFragment, RegisterFragment::class.java.simpleName )
                    .commit()
            }
        }

        fun checkLogin(ogrNo: String, ogrSifre: String): Boolean {
            val connection = DatabaseConnection.connect()
            if (connection != null) {
                try {
                    val query = "SELECT * FROM bitirmeprojesi.ogrencikayit WHERE ogr_no = ? AND ogr_sifre = ?"
                    val statement = connection.prepareStatement(query)
                    statement.setString(1, ogrNo)
                    statement.setString(2, ogrSifre)
                    val resultSet = statement.executeQuery()
                    if (resultSet.next()) {
                        connection.close()
                        return true
                    } else {
                        connection.close()
                        return false
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    connection.close()
                    return false
                }
            } else {
                println("Veritabanına bağlantı kurulamadı.2")
                return false
            }
        }

        buttonGiris.setOnClickListener {

            val ogrenciNo = editTextOgrenciNo.text.toString()
            val sifre = editTextSifre.text.toString()

            if(checkLogin(ogrenciNo,sifre)){
                Toast.makeText(this,"Giriş Başarılı !!",Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this,"Kullanıcı adı veya şifre hatalı",Toast.LENGTH_SHORT).show()
            }
        }
        }


    }




/** val ogrencino = findViewById(R.id.editTextOgrenciNo) as EditText
val sifre= findViewById(R.id.editTextSifre) as EditText
if(ogrencino.text.isNullOrBlank()&&sifre.text.isNullOrBlank()) {
Toast.makeText(
this,
"Kullanıcı Adı veya şifre boş bırakılamaz.",
Toast.LENGTH_SHORT
).show()
return@setOnClickListener
}
else{
Toast.makeText(this,
" Giriş Başarılı",
Toast.LENGTH_SHORT
).show()
return@setOnClickListener
}*/