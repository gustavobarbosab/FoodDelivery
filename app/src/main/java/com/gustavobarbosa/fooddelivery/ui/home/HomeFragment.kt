package com.gustavobarbosa.fooddelivery.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.ui.home.list.FoodListFragment
import kotlinx.android.synthetic.main.content_button_food.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        bindShortcutImages()
        bindShortcutTextName()
        bindShortcutTextPrice()
        bindList()
    }

    private fun bindList() {
        val ft = childFragmentManager.beginTransaction()
        ft.add(R.id.frFoodHome, FoodListFragment())
        ft.commit()
    }

    private fun bindShortcutImages() {
        btHamburguer.ivShortcutFood.setImageResource(R.drawable.ic_hamburguer)
        btPasta.ivShortcutFood.setImageResource(R.drawable.ic_pasta)
        btPizza.ivShortcutFood.setImageResource(R.drawable.ic_pizza)
    }

    private fun bindShortcutTextName() {
        btHamburguer.tvShortcutFoodName.text = "Hamburguer"
        btPasta.tvShortcutFoodName.text = "Pasta"
        btPizza.tvShortcutFoodName.text = "Pizza"
    }

    private fun bindShortcutTextPrice() {
        btHamburguer.tvShortcutFoodNamePrice.text = "R$ 12"
        btPasta.tvShortcutFoodNamePrice.text = "R$ 13"
        btPizza.tvShortcutFoodNamePrice.text = "R$ 16"
    }
}
