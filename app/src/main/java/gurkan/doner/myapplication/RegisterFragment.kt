package gurkan.doner.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class RegisterFragment : Fragment() {
    private lateinit var editTextOgrenciNo: EditText
    private lateinit var editTextSifre: EditText
    private lateinit var orgun1box: CheckBox
    private lateinit var orgun2box: CheckBox
    private lateinit var buttonKayit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        editTextOgrenciNo = view.findViewById(R.id.editTextOgrenciNo)
        editTextSifre = view.findViewById(R.id.editTextSifre)
        orgun1box = view.findViewById(R.id.orgun1box)
        orgun2box = view.findViewById(R.id.orgun2box)
        buttonKayit = view.findViewById(R.id.buttonKayit)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                return@setOnKeyListener true
            }
            false
        }
        buttonKayit.setOnClickListener {

            val username = editTextOgrenciNo.text.toString()
            val password = editTextSifre.text.toString()



            if (username.length != 9 || !username.matches(Regex("\\d+"))) {
                val message = "????renci Numaran??z 9 haneli olmal??d??r."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
                return@setOnClickListener
            }

            if (password.length < 8 || password.length > 16) {
                val message = "??ifreniz 8 karakterden k??????k veya 16 karakterden b??y??k olamaz."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
                return@setOnClickListener
            }
            if (!orgun1box.isChecked && !orgun2box.isChecked) {
                val message = "??rg??n e??itim durumunuzu i??aretleyiniz."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
            return@setOnClickListener
            }

            if (orgun1box.isChecked && orgun2box.isChecked) {
                val message = "Yaln??zca Bir ??rg??n Se??iniz."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
                return@setOnClickListener
            }
            if (orgun1box.isChecked && !orgun2box.isChecked) {
                val orgunDegeri = 1
                println("1. ??rg??n se??ildi")
                val message = "Kay??t ba??ar??l??, giri?? ekran??na d??nebilirsiniz."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
                return@setOnClickListener

            }
            if (!orgun1box.isChecked && orgun2box.isChecked) {
                val orgunDegeri = 2
                println("2. ??rg??n se??ildi")
                val message = "Kay??t ba??ar??l??, giri?? ekran??na d??nebilirsiniz."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, message, duration)
                toast.show()
                return@setOnClickListener

            }
            else {

            }

        }

    }
}









