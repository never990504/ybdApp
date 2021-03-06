package com.bingo.ybd.modules.main.custom

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bingo.ybd.constant.Constant
import com.bingo.ybd.data.model.MedBrief
import com.bingo.ybd.modules.main.activity.MedDetailActivity
import com.bumptech.glide.Glide
import com.youth.banner.adapter.BannerAdapter

class ImageBannerAdapter(
    private val mContext: Context,
    private val datas: MutableList<MedBrief>
) : BannerAdapter<MedBrief, ImageBannerAdapter.ViewHolder>(datas) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var imageView = ImageView(parent?.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return ViewHolder(imageView)
    }

    override fun onBindView(
        holder: ViewHolder,
        data: MedBrief,
        position: Int,
        size: Int
    ) {
        Glide.with(mContext).load(data.pic).into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent = Intent(mContext, MedDetailActivity::class.java)
            intent.putExtra(Constant.KEY_MED_ID, data.id)
            mContext.startActivity(intent)
        }
    }

    fun replaceAll(data: List<MedBrief>) {
        datas.clear()
        datas.addAll(data)
    }


    fun addAll(data: List<MedBrief>) {
        datas.addAll(data)
    }

    class ViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}
