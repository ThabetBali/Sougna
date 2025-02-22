package com.example.sougna.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sougna.presentation.viewmodel.CategoryViewModel
import com.example.sougna.presentation.viewmodel.ProductViewModel
import com.example.sougna.presentation.view.components.CategoryList
import com.example.sougna.presentation.view.components.ProductList
import com.example.sougna.presentation.view.components.LoadingIndicator
import com.example.sougna.presentation.view.components.ErrorMessage
import com.example.sougna.presentation.view.components.AddProductFloatingButton


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onAddProductClick: () -> Unit,
    productViewModel: ProductViewModel
) {

    val categoryViewModel: CategoryViewModel = hiltViewModel()


    // Collect state from ViewModels
    val productState by productViewModel.uiState.collectAsState()
    val categoryState by categoryViewModel.categoryState.collectAsState()

    Box(modifier = modifier.padding(16.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(16.dp))

            // Display category list
            CategoryList(
                categories = categoryState.categories,
                modifier = Modifier.fillMaxWidth()
            )

            // Handle product state
            when {
                productState.isLoading or productState.products.isEmpty() -> {
                    // Show loading indicator
                    LoadingIndicator()
                }
                productState.errorMessage != null -> {
                    // Show error message
                    ErrorMessage(error = productState.errorMessage)
                }
                else -> {
                    // Display product list
                    ProductList(
                        products = productState.products,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            AddProductFloatingButton(
                onClick = onAddProductClick,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}