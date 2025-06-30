package ru.galina_shiryaeva.news.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.galina_shiryaeva.news.R
import ru.galina_shiryaeva.news.databinding.ItemFoundNewsBinding
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.Article

interface ArticleEventListener {
    fun onMore(article: Article)
}

class FoundNewsAdapter(
    private val articleListener: ArticleEventListener,
) : ListAdapter<Article, ArticleViewHolder>(ArticlesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemFoundNewsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding, articleListener)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }
}

class ArticleViewHolder(
    private val binding: ItemFoundNewsBinding,
    private val listener: ArticleEventListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        println(":::::article")
        with(binding) {
            newsHeader.text = article.title
            newsDesc.text = article.description
            newsAuthor.text = article.author
            date.text = article.publishedAt

            Glide.with(binding.root)
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_img_placeholder)
                .error(R.drawable.ic_img_placeholder)
                .into(newsImage)
        }
    }
}

class ArticlesDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return ((oldItem.source?.id == newItem.source?.id)
                && (oldItem.publishedAt == newItem.publishedAt))
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}