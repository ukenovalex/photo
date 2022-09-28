package ru.ukenov.foodo.presentation.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import ru.ukenov.foodo.R
import ru.ukenov.foodo.presentation.main.adapters.items.NewsSectionItem
import ru.ukenov.foodo.presentation.main.adapters.items.MainItem
import ru.ukenov.foodo.presentation.main.adapters.items.BrowseSectionItem

class MainAdapter(private val items: List<MainItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is NewsSectionItem -> NEWS_SECTION_TYPE
            is BrowseSectionItem -> BROWSE_SECTION_TYPE
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NEWS_SECTION_TYPE -> FirstSectionViewHolder(
                itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.main_page_news_section, parent, false),
            )
            BROWSE_SECTION_TYPE -> {
                ThirdSectionViewHolder(
                    itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.main_page_browse_section, parent, false)
                )
            }
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FirstSectionViewHolder -> holder.slider.adapter =
                (items[position] as NewsSectionItem).sliderAdapter
            is ThirdSectionViewHolder -> {
                val images = (items[position] as BrowseSectionItem).images
                val adapter = BrowserAllAdapter(images)
                holder.rvBrowserAll.adapter = adapter
                holder.rvBrowserAll.setRecycledViewPool(viewPool)

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FirstSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val slider: ViewPager2 = itemView.findViewById(R.id.slider)
    }

    class ThirdSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvBrowserAll: RecyclerView = itemView.findViewById(R.id.rv_browser_all)
    }

    companion object {
        private const val NEWS_SECTION_TYPE = 1
        private const val BROWSE_SECTION_TYPE = 3
    }
}