package ru.coderedwolf.mvi.core

import io.reactivex.functions.Consumer
import org.reactivestreams.Publisher

/**
 * @author HaronCode.
 */
interface StoreView<Action : Any, State : Any> : Consumer<State>, Publisher<Action>
