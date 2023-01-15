package gurkan.doner.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(private val photos: List<Bitmap>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    private var isMultiSelect = false
    private val selectedPositions = HashSet<Int>()
    private var listener: OnItemClickListener? = null
//    private val context : Context
//    private val arrayList : ArrayList<>

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo = itemView.findViewById<ImageView>(R.id.photo)
        val checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.photo.setImageBitmap(photos[position])

        if (isMultiSelect) {
            holder.checkbox.visibility = View.VISIBLE
            holder.checkbox.isChecked = selectedPositions.contains(position)
        } else {
            holder.checkbox.visibility = View.GONE
        }



        holder.itemView.setOnClickListener {
            if (isMultiSelect) {
                if (selectedPositions.contains(position)) {
                    selectedPositions.remove(position)
                } else {
                    selectedPositions.add(position)
                }
                holder.checkbox.isChecked = selectedPositions.contains(position)
            } else {
                listener?.onItemClick(position)
            }
        }

        holder.itemView.setOnLongClickListener {
            if (!isMultiSelect) {
                isMultiSelect = true
                selectedPositions.add(position)
                holder.checkbox.visibility = View.VISIBLE
                holder.checkbox.isChecked = true
                true
            } else {
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}
