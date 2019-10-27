package ru.coderedwolf.wordlearn.common.ui.adapter

import android.view.View

/**
 * @author CodeRedWolf. Date 26.10.2019.
 */

class DefaultClicker<ItemModel, VH : BaseViewHolder>(
    private val consumer: (ItemModel) -> Unit
) : ItemClicker<ItemModel, VH> {

    override fun onBindClicker(holder: VH) = Unit

    override fun invoke(holder: VH, view: View, item: ItemModel) {
        consumer(item)
    }

    override fun onUnbindClicker(holder: VH) = Unit

}