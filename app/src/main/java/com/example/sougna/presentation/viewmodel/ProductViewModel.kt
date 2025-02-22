package com.example.sougna.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sougna.data.model.Product
import com.example.sougna.domain.usecase.AddProductUseCase
import com.example.sougna.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject


data class UIState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val products: List<Product> = emptyList()
)


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {
    // Internal mutable state flow for product data
    private val _uiState = MutableStateFlow(UIState())

    // Public immutable state flow exposed to UI components
    //val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    private val _products = getAllProductsUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )

    val uiState = combine(
        _uiState,
        _products
    ) { uiState, products -> uiState.copy(products = products) }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        UIState()
    )

}
