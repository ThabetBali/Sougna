package com.example.sougna.repository

import com.example.sougna.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class ProductRepository {

    fun getProducts(): Flow<List<Product>> = flow {
        emit(generateMockProducts())
    }

    private fun generateMockProducts(): List<Product> {
        return listOf(
            Product(
                id = "1",
                name = "Iphone 16",
                description = "The latest Iphone from Apple.",
                price = 41000.0,
                userId = "user1",
                categoryId = "2",
                thumbnailUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn1.smartprix.com%2Frx-i5n1dTTOB-w280-h280%2Fapple-iphone-16-pro.jpg&f=1&nofb=1&ipt=261214cf8af00f16af4be327d001886688f3af584b450b6968616b16ae1dd0f1&ipo=images",
                rating = 4.9,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Product(
                id = "2",
                name = "Samsung S25 ultra",
                description = "The best Samsung phone ever",
                price = 38000.0,
                userId = "user2",
                categoryId = "2",
                thumbnailUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fnightechs.com%2Fwp-content%2Fuploads%2F2024%2F09%2FSamsung-Galaxy-S25-Ultra.png&f=1&nofb=1&ipt=f612e94a7560ea9d5f19926f1a128137f6102422f7dffb8a4dda9078ca5e1fe8&ipo=images",
                rating = 4.8,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Product(
                id = "3",
                name = "Lenovo ThinkPad",
                description = "A thin and powerful laptop from Lenovo",
                price = 20000.0,
                userId = "user3",
                categoryId = "3",
                thumbnailUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Flaptopdecision.com%2Fimg%2Fcropped%2Fpx600%2FLenovo-ThinkPad-T15-Gen-2-top-view.jpg&f=1&nofb=1&ipt=0819bbdd6659d46636ec7182b334d451de0c83b6b811e2a212dbca71d72cca0e&ipo=images",
                rating = 4.7,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Product(
                id = "5",
                name = "Nike Air Jordans",
                description = "A brand new shoes for sports",
                price = 1200.0,
                userId = "user5",
                categoryId = "5",
                thumbnailUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpics.craiyon.com%2F2023-09-27%2F285f7a327be147ed865f9ac295c79d31.webp&f=1&nofb=1&ipt=e18c24523396d66def0b1582c85e55c5e62e63e06bccc48dc393419d2ec3c907&ipo=images",
                rating = 4.6,
                createdAt = Date(),
                updatedAt = Date()
            )
        )
    }
}
