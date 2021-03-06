package ru.haroncode.wordlearn.mainflow.presentation.set

import ru.haroncode.wordlearn.common.domain.result.Product
import ru.haroncode.wordlearn.common.ui.adapter.SimpleComparableItem
import ru.haroncode.wordlearn.common.ui.adapter.delegate.Button
import ru.haroncode.wordlearn.common.ui.adapter.delegate.ButtonAdapterDelegate
import ru.haroncode.wordlearn.mainflow.ui.word.set.list.WordSetDelegate

/**
 * @author HaronCode. Date 29.10.2019.
 */

data class WordSetUserViewState(
    val items: Product<List<Item>> = Product.Loading
) {

    sealed class Item : SimpleComparableItem() {

        class AddWordSetItem(button: Button) : Item(), ButtonAdapterDelegate.RenderContract by button

        data class WordSetItem(
            override val title: CharSequence,
            override val color: Int
        ) : Item(), WordSetDelegate.RenderContact
    }
}
