package com .kalpicapp.spacedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kalpicapp.spacedetails.Supplier.isromission


class MissionAdapter(
    private val list: MainActivity,
    isromission: List<Mission>
)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Mission = isromission[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = isromission.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_view_layout, parent, false)) {
    private var mTitleView: TextView? = null
    private var mMissionView: TextView? = null
//    private var mYearView: TextView? = null
//    private var mrating: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.textView)
        mMissionView = itemView.findViewById(R.id.detail_text)
//        mYearView = itemView.findViewById(R.id.list_description)
//        mrating = itemView.findViewById(R.id.text_rating)
    }

    fun bind(Mission: Mission) {
        mTitleView?.text = Mission.title
        mMissionView?.text = Mission.details

//        mYearView?.text = movie.year.toString()
//        mrating?.text = movie.rating



    }



}