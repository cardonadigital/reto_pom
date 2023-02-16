# language: es
Característica:  Registro

  Escenario: Registro no exitoso
    Dado que el cliente se dirigió al modulo de Create an Account
    Cuando ingrese los datos incorrectos y de clic en Create and Account
    Entonces podrá ver un mensaje de advertencia de campo invalido.