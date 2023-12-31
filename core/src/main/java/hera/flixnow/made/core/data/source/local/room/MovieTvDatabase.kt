package hera.flixnow.made.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import hera.flixnow.made.core.data.source.local.entity.FavoriteMovieTvEntity
import hera.flixnow.made.core.data.source.local.entity.MovieTvEntity

@Database(
    entities = [MovieTvEntity::class, FavoriteMovieTvEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieTvDatabase : RoomDatabase() {
    abstract fun movieTvDao(): MovieTvDao
    abstract fun favoriteMovieTvDao(): FavoriteMovieTvDao
}