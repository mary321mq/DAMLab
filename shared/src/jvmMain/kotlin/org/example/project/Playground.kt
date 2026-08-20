package org.example.project

import org.example.project.domain.model.Categoria
import org.example.project.domain.model.Producto

fun main() {
    val trucha = Producto(
        id = "p-01",
        nombre = "Trucha frita",
        precio = 24.50,
        categoria = Categoria.PLATO_FONDO
    )

    val chicha = Producto(
        id = "p-04",
        nombre = "Chicha morada",
        precio = 8.00,
        categoria = Categoria.BEBIDA
    )

    val chairo = Producto(
        id = "p-02",
        nombre = "Chairo paceño",
        precio = 15.50,
        categoria = Categoria.ENTRADA,
        descripcion = "Sopa tradicional con chuño, carne y verduras"
    )

    val emoliente = Producto(
        id = "p-05",
        nombre = "Emoliente",
        precio = 4.50,
        categoria = Categoria.BEBIDA,
        disponible = false
    )

    val catalogo = listOf(trucha, chicha, chairo, emoliente)

    println("=== CATALOGO (${catalogo.size} productos) ===")
    catalogo.forEach { producto ->
        println(producto)
    }

    println("\n=== REPORTE ===")
    catalogo.forEach { producto ->
        val estado = if (producto.sePuedePedir) "DISPONIBLE" else "AGOTADO"
        println("[$estado] ${producto.nombre} - ${producto.precioFormateado}")
        println("  ${producto.descripcionCorta}")
    }

    println("\nPedibles: ${catalogo.count { it.sePuedePedir }}")
    println("Suma de precios: ${catalogo.sumOf { it.precio }}")
    println("Más caro: ${catalogo.maxByOrNull { it.precio }?.nombre}")
    println("Solo bebidas: ${catalogo.filter { it.categoria == Categoria.BEBIDA }.map { it.nombre }}")

    println("\n=== COPY E IGUALDAD ===")
    val truchaEnOferta = trucha.copy(precio = 19.90)
    val copiaExacta = trucha.copy()

    println("Original: ${trucha.precio}")
    println("En oferta: ${truchaEnOferta.precio}")
    println("Son iguales: ${trucha == copiaExacta}")

    val (identificador, nombreProducto, precioProducto) = trucha
    println("$identificador | $nombreProducto | S/ $precioProducto")
}