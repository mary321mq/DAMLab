package org.example.project.domain.model

data class Producto(
    val id: String,
    val nombre: String,
    val precio: Double,
    val categoria: Categoria,
    val descripcion: String? = null,
    val disponible: Boolean = true
) {
    val descripcionCorta: String
        get() = descripcion ?: "Sin descripción"

    val sePuedePedir: Boolean
        get() = disponible && precio > 0

    val precioFormateado: String
        get() = "S/ $precio"
}