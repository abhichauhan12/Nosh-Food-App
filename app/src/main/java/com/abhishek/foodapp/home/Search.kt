package com.abhishek.foodapp.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

private val _searchText = MutableStateFlow("")
val searchText = _searchText.asStateFlow()

private val _isSearching = MutableStateFlow(false)
val isSearching = _isSearching.asStateFlow()

private val _dish = MutableStateFlow(listOf<Dish>())
val dish = searchText
    .combine(_dish) { text, dishes ->
        if (text.isBlank()) {
            dishes
        } else {
            dishes.filter { it.matchSearch(text) }
        }
    }
