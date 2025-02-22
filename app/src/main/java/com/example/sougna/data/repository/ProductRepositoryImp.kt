package com.example.sougna.data.repository

import com.example.sougna.data.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Registry containing mock products for demonstration purposes.
 */
class ProductRepositoryImp @Inject constructor(
    private val firestore: FirebaseFirestore
) : ProductRepository {

    override fun getAllProducts(): Flow<List<Product>> {
        return firestore.collection("products").snapshots().map{ it.toObjects(Product::class.java) }

    }

    override suspend fun addProduct(product: Product): Boolean {
        return try {
            firestore.collection("products").add(product).await()
            true
        } catch (e: Exception) {
            false
        }
    }
}
