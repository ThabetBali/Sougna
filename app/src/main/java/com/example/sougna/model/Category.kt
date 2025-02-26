package com.example.sougna.model

/**
 * Represents a product category in the application.
 *
 * @property id Unique identifier for the category.
 */
data class Category(
    val id: String,
    val name: String,
    val description: String,
    val icon: Int
)
