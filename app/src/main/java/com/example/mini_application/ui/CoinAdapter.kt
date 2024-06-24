package com.example.mini_application.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_application.R
import com.example.mini_application.data.model.Data
import com.example.mini_application.databinding.CoinItemBinding

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    private val listOfCoin = ArrayList<Data>()

    inner class CoinViewHolder(val coinItem: CoinItemBinding) :
        RecyclerView.ViewHolder(coinItem.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCoin.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val currentItem = listOfCoin[position]
        holder.coinItem.item = currentItem
        when(currentItem.code){
            "BTCUSD"->holder.coinItem.imageView2.setImageResource(R.drawable.coin1)
            "BTCTRY"->holder.coinItem.imageView2.setImageResource(R.drawable.coin2)
            "ETHBTC"->holder.coinItem.imageView2.setImageResource(R.drawable.coin3)
            "ETHTRY"->holder.coinItem.imageView2.setImageResource(R.drawable.coin4)
            "BTCEUR"->holder.coinItem.imageView2.setImageResource(R.drawable.coin5)
            "ETHEUR"->holder.coinItem.imageView2.setImageResource(R.drawable.coin6)

        }

    }

    fun updateList(newList: List<Data>) {
        listOfCoin.clear()
        listOfCoin.addAll(newList)
        notifyDataSetChanged()
    }
}
