package com.gustavobarbosa.fooddelivery.ui.cart

import com.gustavobarbosa.fooddelivery.data.repository.food.FoodRepository
import com.gustavobarbosa.fooddelivery.domain.model.FoodModel
import com.gustavobarbosa.fooddelivery.ui.cart.utils.RxSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyAll
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test

class CartPresenterTest {

    private val view: CartContract.View = mockk(relaxed = true)

    private val repository: FoodRepository = mockk(relaxed = true)

    private val compositeDisposable: CompositeDisposable = mockk(relaxed = true)

    private lateinit var cartPresenter: CartContract.Presenter

    @Before
    fun init() {
        cartPresenter = CartPresenter(view, repository, compositeDisposable)
    }

    @Test
    fun `reload cart and notify view`() {
        every {
            repository.getFoodCart()
        } returns Single.just(
            arrayListOf(
                FoodModel("", 22.40, "", ""),
                FoodModel("", 20.30, "", "")
            )
        )

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
            repository.getFoodCart()
        } returns Single.just(
            arrayListOf()
        )

        cartPresenter.reloadCart()

        verifyAll {
            view.hideTotalPriceView()
            view.hideButtonNext()
        }
    }

    @Test
    fun `remove item from cart`() {
        val model = FoodModel("", 22.0, "", "")
        every {
            repository.removeFoodOfCart(model)
        } returns Single.just(
            arrayListOf(
                FoodModel("", 22.40, "", "")
            )
        )

        cartPresenter.removeItem(model)

        verifyAll {
            view.reloadCart(any())
            view.showButtonNext()
            view.updatePrice(any())
        }
    }

    @Test
    fun `remove item from cart and empty cart`() {
        val model = FoodModel("", 22.0, "", "")
        every {
            repository.removeFoodOfCart(model)
        } returns Single.just(
            arrayListOf()
        )

        cartPresenter.removeItem(model)

        verifyAll {
            view.hideButtonNext()
            view.hideTotalPriceView()
        }
    }

    @Test
    fun `assert if view is destroyed`() {
        every {
            repository.getFoodCart()
        } returns Single.just(
            arrayListOf(
                FoodModel("", 22.40, "", ""),
                FoodModel("", 20.30, "", "")
            )
        )

        cartPresenter.destroy()
        cartPresenter.reloadCart()

        verify {
            compositeDisposable.dispose()
        }

        verify(exactly = 0) {
            view.hideButtonNext()
            view.hideTotalPriceView()
            view.reloadCart(any())
            view.showButtonNext()
            view.updatePrice(any())
        }
    }

    companion object {
        @ClassRule
        @JvmField
        val rxSchedulerRule = RxSchedulerRule()
    }
}