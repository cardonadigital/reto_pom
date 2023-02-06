# language: es
Característica:  Filtro en categoría Gear/Fitness

  Escenario: Filtro por Actividad/Genero exitoso
    Dado : que el usuario se dirige al modulo de Gear/Fitness Equipement
    Cuando : filtre los productos de Actividad en "Gym"
    Y : filtre los productos de Genero en "unisex"
    Y : añada los 4 primeros productos al carrito de compras
    Entonces : podrá ver que la cantidad de items en el carrito de compras es de 4