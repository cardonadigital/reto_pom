# language: es
Característica:  Logueo

  Escenario: Logueo no exitoso
    Dado que el usuario con datos incorrectos
    Cuando inicie sección con el email: "melocomape1234@gmail.com" y con la contraseña: "Melo12345"
    Entonces podrá ver el siguiente mensaje de error : "Incorrect CAPTCHA".