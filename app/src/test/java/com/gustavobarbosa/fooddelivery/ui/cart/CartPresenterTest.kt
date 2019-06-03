package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CartPresenterTest {

    private val view: CartContract.View = mockk(relaxed = true)

    private val repository: FoodRepository = mockk(relaxed = true)

    private lateinit var cartPresenter: CartContract.Presenter

    @Before
    fun init() {
        cartPresenter = CartPresenter(view, repository)
    }

    @Test
    fun `reload cart with empty list and notify view`() {
        every { repository.getFoodCart() } returns listOf()

        cartPresenter.reloadCart()

        verify(exactly = 1) {
            view.hideButtonNext()
        }
    }

    @Test
    fun `reload cart and notify view`() {
        every { repository.getFoodCart() } returns listOf(FoodModel("",22F,""))

        cartPresenter.reloadCart()

        verify(exactly = 1) {
            view.reloadCart(any())
            view.showButtonNext()
        }
    }

    @Test
    fun `assert if view is destroyed`() {
        every { repository.getFoodCart() } returns listOf(FoodModel("",22F,""))

        cartPresenter.destroy()
        cartPresenter.reloadCart()

        verify(exactly = 0) {
            view.reloadCart(any())
            view.showButtonNext()
            view.hideButtonNext()
        }

    }
}