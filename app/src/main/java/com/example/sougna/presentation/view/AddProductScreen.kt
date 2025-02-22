package com.example.sougna.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sougna.data.model.Product
import com.example.sougna.presentation.viewmodel.ProductViewModel
import com.example.sougna.presentation.view.components.ProductForm
import com.example.sougna.presentation.view.components.AddProductButton
import com.example.sougna.presentation.view.components.BackButton
import com.example.sougna.presentation.viewmodel.AddProductViewModel
import java.util.UUID

@Composable
fun AddProductScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    addProductViewModel: AddProductViewModel,

    ) {
    val uiState by addProductViewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProductForm(
            uiState = uiState,
            onEvent = addProductViewModel::onEvent,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        AddProductButton(
            onEvent = addProductViewModel::onEvent,

            modifier = Modifier.fillMaxWidth()
        )

        if (uiState.isLoading) {
            Text("Adding product...")
        }

        uiState.errorMessage?.let { error ->
            Text("Error: $error", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        BackButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
