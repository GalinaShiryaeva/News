package ru.galina_shiryaeva.news.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.galina_shiryaeva.news.R
import ru.galina_shiryaeva.news.databinding.ItemFoundNewsBinding
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem

interface NewsItemEventListener {
    fun onMore(newsItem: NewsItem)
}

class NewsAdapter(
    private val newsItemListener: NewsItemEventListener,
) : PagingDataAdapter<NewsItem, NewsItemViewHolder>(NewsItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding = ItemFoundNewsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(binding, newsItemListener)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val newsItem = getItem(position)
        newsItem?.let { holder.bind(newsItem) }
    }
}

class NewsItemViewHolder(
    private val binding: ItemFoundNewsBinding,
    private val listener: NewsItemEventListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(newsItem: NewsItem) {
        with(binding) {
            newsHeader.text = newsItem.title
            newsDesc.text = newsItem.description
            newsAuthor.text = newsItem.author
            date.text = newsItem.publishedAt

            Glide.with(binding.root)
                .load(newsItem.urlToImage)
                .placeholder(R.drawable.ic_img_placeholder)
                .error(R.drawable.ic_img_placeholder)
                .into(newsImage)
        }
    }
}

class NewsItemDiffCallback : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return ((oldItem.source?.id == newItem.source?.id)
                && (oldItem.publishedAt == newItem.publishedAt))
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}