package ru.coderedwolf.wordlearn.mainflow.ui.word.set

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_word_user_set.*
import ru.coderedwolf.mvi.core.MviView
import ru.coderedwolf.wordlearn.common.domain.result.Product
import ru.coderedwolf.wordlearn.common.ui.BaseFragment
import ru.coderedwolf.wordlearn.common.ui.adapter.DefaultClicker
import ru.coderedwolf.wordlearn.common.ui.adapter.ItemAsyncAdapter
import ru.coderedwolf.wordlearn.common.ui.adapter.delegate.ButtonAdapterDelegate
import ru.coderedwolf.wordlearn.common.util.unsafeLazy
import ru.coderedwolf.wordlearn.mainflow.R
import ru.coderedwolf.wordlearn.mainflow.presentation.set.WordSetUserViewModel
import ru.coderedwolf.wordlearn.mainflow.presentation.set.WordSetUserViewModel.Action
import ru.coderedwolf.wordlearn.mainflow.presentation.set.WordSetUserViewModel.ViewEvent
import ru.coderedwolf.wordlearn.mainflow.presentation.set.WordSetUserViewState
import ru.coderedwolf.wordlearn.mainflow.presentation.set.WordSetUserViewState.Item
import ru.coderedwolf.wordlearn.mainflow.ui.word.set.list.WordSetDelegate
import javax.inject.Inject

/**
 * @author CodeRedWolf. Date 11.10.2019.
 */
class WordSetUserFragment : BaseFragment(),
    MviView<Action, WordSetUserViewState, ViewEvent> {

    companion object {

        fun newInstance() = WordSetUserFragment()
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val wordSetUserViewModel: WordSetUserViewModel by viewModels {
        viewModelFactory
    }

    override val layoutRes: Int = R.layout.fragment_word_user_set

    private val source = PublishSubject.create<Action>()

    private val itemAdapter: ItemAsyncAdapter<Item> by unsafeLazy {
        ItemAsyncAdapter.Builder<Item>()
            .add(WordSetDelegate())
            .add(ButtonAdapterDelegate(), DefaultClicker(::onClickAddSet))
            .build()
    }

    override fun onResume() {
        super.onResume()
        wordSetUserViewModel.bindView(this)
    }

    override fun onPause() {
        super.onPause()
        wordSetUserViewModel.unbindView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }

    }

    private fun onClickAddSet(item: Item) = source.onNext(Action.CreateNew)

    override val actions: Observable<Action>
        get() = source.hide()

    override fun render(state: WordSetUserViewState) = when (val items = state.items) {
        is Product.Data -> itemAdapter.updateItems(items.value)
        else -> Unit
    }

    override fun route(event: ViewEvent) = when (event) {
        is ViewEvent.CreateNewDialog -> Toast.makeText(requireContext(), "Dialog", Toast.LENGTH_SHORT).show()
    }

}