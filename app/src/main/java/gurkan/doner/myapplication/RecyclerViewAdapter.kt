package gurkan.doner.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class RecyclerViewAdapter(private val itemList: ArrayList<ListTemplate>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val grupKonu: TextView
        val grupNo: TextView
        val ogrenciNo1: TextView
        val ogrenciNo2: TextView
        val ogrenciNo3: TextView
        val odev1: Button
        val odev2: Button
        val odev3: Button
        val galeri1: Button
        val galeri2: Button
        val galeri3: Button
        val imageView : ImageView
        val delete : ImageButton

        init {
            // Define click listener for the ViewHolder's View
            grupKonu = view.findViewById(R.id.textViewGrupKonu)
            grupNo = view.findViewById(R.id.textViewGrupNo)
            ogrenciNo1 = view.findViewById(R.id.textViewOgrenciNo1)
            ogrenciNo2 = view.findViewById(R.id.textViewOgrenciNo2)
            ogrenciNo3 = view.findViewById(R.id.textViewOgrenciNo3)
            odev1 =view.findViewById(R.id.buttonOdev1)
            odev2 =view.findViewById(R.id.buttonOdev2)
            odev3 =view.findViewById(R.id.buttonOdev3)
            galeri1 =view.findViewById(R.id.buttonGaleri1)
            galeri2 =view.findViewById(R.id.buttonGaleri2)
            galeri3 =view.findViewById(R.id.buttonGaleri3)
            imageView = view.findViewById(R.id.imageView)
            delete = view.findViewById(R.id.buttonDelete)
        }




    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)



        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val currentItem = itemList[position]
        viewHolder.grupKonu.setText(currentItem.GrupKonu)
        viewHolder.grupNo.setText(currentItem.GrupNo)
        viewHolder.ogrenciNo1.setText(currentItem.OgrenciNo)
        viewHolder.ogrenciNo2.setText(currentItem.OgrenciNo2)
        viewHolder.ogrenciNo3.setText(currentItem.OgrenciNo3)
        viewHolder.odev1.setText(currentItem.Odev1)
        viewHolder.odev2.setText(currentItem.Odev2)
        viewHolder.odev3.setText(currentItem.Odev3)

        viewHolder.delete.setOnClickListener(View.OnClickListener {

        return@OnClickListener
        })

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int {

        return itemList.size

    }



}