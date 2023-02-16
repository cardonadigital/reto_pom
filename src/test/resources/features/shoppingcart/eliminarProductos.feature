# language: es
Característica:  Eliminar productos al carrito de compras

  Antecedentes: el usuario debe tener productos en el carrito de compras
    Dado que el usuario se encuentre en la página principal
    Cuando añada productos al carrito de compras
    Entonces podrá ver los productos añadidos en el carrito de compras

  Escenario: Eliminar productos al carrito de compras exitoso
    Dado que el usuario se encuentra en el modulo de Shopping Cart
    Cuando elimine un producto del carro de compras
    Entonces podrá ver que el producto fue eliminado del carrito.