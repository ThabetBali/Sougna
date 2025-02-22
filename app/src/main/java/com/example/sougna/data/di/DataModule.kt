package com.example.sougna.data.di

import android.content.Context
import com.example.sougna.data.repository.CategoryRepository
import com.example.sougna.data.repository.CategoryRepositoryImp
import com.example.sougna.data.repository.ProductRepository
import com.example.sougna.data.repository.ProductRepositoryImp
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideProductRepository(firestore: FirebaseFirestore): ProductRepository {
        return ProductRepositoryImp(firestore)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepositoryImp()
    }


    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

}