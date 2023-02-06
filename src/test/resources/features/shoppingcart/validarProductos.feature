# language: es
Característica:  Validar productos en el carrito de compras

  Escenario: Validar productos de categoría diferentes en el carrito de compras
    Dado : que el usuario se dirige al modulo de Gear
    Cuando : en la categoría de Bags añada un producto al carrito de compras
    Y : en la categoría de  Fitness Equipment añada un producto al carrito de compras
    Y : en la categoría de  Watches añada otro producto al carrito de compras
    Y : se dirige al carrito de compras
    Entonces : podrá ver los productos añadidos al carrito de compras exitosamente