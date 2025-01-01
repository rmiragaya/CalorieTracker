package com.rmiragaya.core.domain.use_case

/**
 * For Business logic we have to create Use Cases
 * Use Cases belong in de Domain layer
 * Use Cases are classes that contains one single expose function
 * and that function only does one thing.
 */
class FilterOutDigit {

    operator fun invoke(text: String): String {
        return text.filter { it.isDigit() }
    }
}