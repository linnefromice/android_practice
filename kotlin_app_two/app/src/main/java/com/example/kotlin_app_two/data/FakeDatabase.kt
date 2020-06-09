package com.example.kotlin_app_two.data

// Private primary constructor inaccessible from other classes
class FakeDatabase private constructor() {
    // All the DAOs go here!
    var quoteDao: FakeQuoteDao
        private set

    init {
        quoteDao = FakeQuoteDao()
    }

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        // The only way to get hold of the FakeDatabase object
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}