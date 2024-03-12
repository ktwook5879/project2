package com.bitc.project1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.mental.SimActivity

class InfiniteAdapter(var list: MutableList<Int>) : RecyclerView.Adapter<InfiniteAdapter.InfiniteViewHolder>() {

    inner class InfiniteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView_banner = itemView.findViewById<ImageView>(R.id.imageView_banner)

        init {
            // 각 ViewHolder에 클릭 리스너를 설정합니다.
            itemView.setOnClickListener {
                val position = adapterPosition % list.size
                val context = itemView.context

                // 클릭된 이미지의 위치에 따라서 다른 Activity로 이동합니다.
                when (position) {
                    0 -> {
                        val intent = Intent(context, FortuneMainActivity::class.java)
                        context.startActivity(intent)
                    }
                    // 이 외의 경우에는 다른 동작을 수행하거나 아무것도 하지 않습니다.
                    1 -> {
                        val intent = Intent(context, TaroActivity::class.java)
                        context.startActivity(intent)
                        // 다른 동작 수행 혹은 아무것도 하지 않음
                    }
                    2 -> {
                        val intent = Intent(context, SimActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }
        }

        fun onBind(res: Int) {
            imageView_banner.setImageResource(res)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_banner, parent, false)
        return InfiniteViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfiniteViewHolder, position: Int) {
        holder.onBind(list[position % 3]) // position에 실제 배너의 개수를 나눈 나머지 값을 사용한다. (여기서는 3개라 하드코딩으로 3을 넣음)
    }

    override fun getItemCount(): Int = Int.MAX_VALUE // 아이템의 갯수를 임의로 확 늘린다.
}