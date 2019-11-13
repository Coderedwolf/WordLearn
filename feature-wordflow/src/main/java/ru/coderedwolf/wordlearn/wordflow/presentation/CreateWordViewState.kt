package ru.coderedwolf.wordlearn.wordflow.presentation

import ru.coderedwolf.wordlearn.common.domain.validator.NotValid
import ru.coderedwolf.wordlearn.common.domain.validator.VerifiableValue
import ru.coderedwolf.wordlearn.word.model.WordExample

/**
 * @author CodeRedWolf.
 */
data class CreateWordViewState(
    val categoryId: Long,
    val saveButtonEnable: Boolean = false,
    val word: VerifiableValue<String> = VerifiableValue("", NotValid),
    val translation: VerifiableValue<String> = VerifiableValue("", NotValid),
    val association: String = "",
    val transcription: String = "",
    val exampleListItem: List<Item> = listOf(Item.AddButtonItem)
) {

    sealed class Item {

        data class WordExampleItem(val wordExample: WordExample) : Item()
        object AddButtonItem : Item()
    }
}