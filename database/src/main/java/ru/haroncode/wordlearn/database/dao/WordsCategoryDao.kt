package ru.haroncode.wordlearn.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import ru.haroncode.wordlearn.database.entity.WordCategoryEntity

/**
 * @author HaronCode.
 */
@Dao
interface WordsCategoryDao {

    @Query("SELECT * FROM WordCategoryEntity WHERE id=:categoryId")
    fun findById(categoryId: Long): Single<WordCategoryEntity>

    @Query("SELECT * FROM WordCategoryEntity")
    fun findAll(): Single<List<WordCategoryEntity>>

    @Insert
    fun save(wordCategoryEntity: WordCategoryEntity): Completable

    @Delete
    fun remove(wordCategoryEntity: WordCategoryEntity): Completable
}
