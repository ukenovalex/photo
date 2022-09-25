package ru.ukenov.foodo.presentation.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import ru.ukenov.foodo.R
import ru.ukenov.foodo.presentation.main.adapters.items.FirstSectionItem
import ru.ukenov.foodo.presentation.main.adapters.items.MainItem
import ru.ukenov.foodo.presentation.main.adapters.items.SecondSectionItem
import ru.ukenov.foodo.presentation.main.adapters.items.ThirdSectionItem

class MainAdapter(private val items: List<MainItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is FirstSectionItem -> FIRST_SECTION_TYPE
            is SecondSectionItem -> SECOND_SECTION_TYPE
            is ThirdSectionItem -> THIRD_SECTION_TYPE
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FIRST_SECTION_TYPE -> FirstSectionViewHolder(
                itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.main_page_first_section, parent, false),
            )
            SECOND_SECTION_TYPE -> SecondSectionViewHolder(
                itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.main_page_second_section, parent, false)
            )
            THIRD_SECTION_TYPE -> {
                val container =  LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.main_page_third_section_container, parent, false)
                ThirdSectionViewHolder(
                    itemView = LayoutInflater
                        .from(container.context)
                        .inflate(R.layout.main_page_third_section, parent, false)
                )
            }
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FirstSectionViewHolder -> holder.slider.adapter =
                (items[position] as FirstSectionItem).sliderAdapter
            is ThirdSectionViewHolder -> {
                val image = (items[position] as ThirdSectionItem).image
                Glide.with(holder.itemView).load(image).into(holder.imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FirstSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val slider: ViewPager2 = itemView.findViewById(R.id.slider)
    }

    class SecondSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class ThirdSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.image)
    }

    companion object {
        private const val FIRST_SECTION_TYPE = 1
        private const val SECOND_SECTION_TYPE = 2
        private const val THIRD_SECTION_TYPE = 3
    }
}