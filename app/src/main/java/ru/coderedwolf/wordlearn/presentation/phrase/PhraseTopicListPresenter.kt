package ru.coderedwolf.wordlearn.presentation.phrase

import moxy.InjectViewState
import ru.coderedwolf.wordlearn.Screens
import ru.coderedwolf.wordlearn.domain.interactors.phrase.PhraseTopicInteractor
import ru.coderedwolf.wordlearn.model.phrase.PhraseTopic
import ru.coderedwolf.wordlearn.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author CodeRedWolf. Date 16.06.2019.
 */
@InjectViewState
class PhraseTopicListPresenter @Inject constructor(
        private val router: Router,
        private val phraseTopicInteractor: PhraseTopicInteractor
) : BasePresenter<PhraseTopicView>() {

    private val topicList = mutableListOf<PhraseTopic>()

    override fun onFirstViewAttach() = launchUI {
        val list = phraseTopicInteractor.findAll()
        topicList.addAll(list)
        viewState.showAll(topicList)
    }

    override fun onViewAttach(view: PhraseTopicView?) = viewState.showAll(topicList)

    override fun onBackPressed() = router.finishChain()

    fun onClickTopic(phraseTopic: PhraseTopic) = router.navigateTo(Screens.PhraseFlowScreen(phraseTopic.id!!))
}