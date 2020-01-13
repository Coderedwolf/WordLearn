package ru.coderedwolf.mvi.core

import io.reactivex.observers.TestObserver

fun <T> TestObserver<T>.onNextEvents() = events.first() as List<T>