package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.ResponseListener
import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import io.mockk.verifyAll
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CartPresenterTest {

    private val view: CartContract.View = mockk(relaxed = true)

    private val repository: FoodRepository = mockk(relaxed = true)

    private val slotListener = slot<ResponseListener<ArrayList<FoodModel>>>()

    private lateinit var cartPresenter: CartContract.Presenter

    @Before
    fun init() {
        cartPresenter = CartPresenter(view, repository)
    }

    @Test
    fun `reload cart and notify view`() {
        every {
            repository.getFoodCart(capture(slotListener))
        } answers {
            slotListener.captured.onSuccess(arrayListOf(
                FoodModel("", 22.40, ""),
                FoodModel("", 20.30, "")))
        }

        cartPresenter.reloadCart()

        verifyAll {
            view.updatePrice("R$ 42,70")
            view.reloadCart(any())
            view.showButtonNext()
        }
    }

    @Test
    fun `reload cart with empty list and notify view`() {
        every {
            repository.getFoodCart(capture(slotListener))
        } answers {
            slotListener.captured.onSuccess(arrayListOf())
        }

        cartPresenter.reloadCart()

        verifyAll {
            view.hideTotalPriceView()
            view.hideButtonNext()
        }
    }

    @Test
    fun `remove item from cart`() {
        val model = FoodModel("", 22.0, "")
        every {
            repository.removeFoodOfCart(model, capture(slotListener))
        } answers {
            slotListener.captured.onSuccess(arrayListOf(model))
        }

        cartPresenter.removeItem(model)

        verifyAll {
            view.reloadCart(any())
            view.showButtonNext()
            view.updatePrice(any())
        }
    }

    @Test
    fun `remove item from cart and empty cart`() {
        val model = FoodModel("", 22.0, "")
        every {
            repository.removeFoodOfCart(model, capture(slotListener))
        } answers {
            slotListener.captured.onSuccess(arrayListOf())
        }

        cartPresenter.removeItem(model)

        verifyAll {
            view.hideButtonNext()
            view.hideTotalPriceView()
        }
    }

    @Test
    fun `assert if view is destroyed`() {
        every {
            repository.getFoodCart(capture(slotListener))
        } answers {
            slotListener.captured.onSuccess(arrayListOf(
                FoodModel("", 22.40, "")))
        }

        cartPresenter.destroy()
        cartPresenter.reloadCart()

        verify(exactly = 0) {
            view.hideButtonNext()
            view.hideTotalPriceView()
            view.reloadCart(any())
            view.showButtonNext()
            view.updatePrice(any())
        }
    }
}