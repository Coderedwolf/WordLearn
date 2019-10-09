package ru.coderedwolf.wordlearn.common.ui.item

import android.content.Context
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import ru.coderedwolf.wordlearn.common.util.ContextExtensionsHolder

/**
 * @author CodeRedWolf. Date 10.10.2019.
 */
class BaseViewHolder(
    override val containerView: View
) : com.xwray.groupie.ViewHolder(containerView), LayoutContainer, ContextExtensionsHolder {

    override val extensionContext: Context
        get() = containerView.context
}