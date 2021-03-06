package ru.haroncode.wordlearn.mainflow.ui.word.set

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.haroncode.wordlearn.mainflow.R
import ru.haroncode.wordlearn.mainflow.ui.StubFragment
import ru.haroncode.wordlearn.mainflow.ui.word.set.user.WordSetUserFragment

/**
 * @author HaronCode.
 */
class WordSetPagerAdapter(
    private val context: Context,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {

        private const val PAGE_COUNT = 2
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> WordSetUserFragment.newInstance()
        1 -> StubFragment()
        else -> throw IllegalStateException("Unknown fragment position")
    }

    override fun getCount(): Int = PAGE_COUNT

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.fragment_word_set_user_title)
        1 -> context.getString(R.string.fragment_word_set_completed_title)
        else -> throw IllegalStateException("Unknown fragment position")
    }
}
