# language: es
Característica:  Logueo

  Escenario: Logueo exitoso
    Dado : que el usuario previamente registrado se dirige al modulo de Sing in
    Cuando : inicie sección con el email: "melocomape@gmail.com" y la contraseña: "Melo1234"
    Entonces : podrá ver el siguiente mensaje: "Welcome, Melo Compae!"
