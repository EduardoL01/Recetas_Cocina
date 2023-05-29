<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../Images/logo pagina web.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>registrate</title>
</head>
<body>
<center>
    <div class="snippet-container mt-5">
        <h2>
            Crear cuenta
        </h2>
        <form action="" method="post">

            <div class="card" style="width: 30rem;">
                <div class="card-body">
                    <div class="mb-3">
                        <label for="Nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="Nombre">
                    </div>

                    <div class="mb-3">
                        <label for="Apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="Apellido">
                    </div>
                    <div class="mb-3">
                        <label for="Correo" class="form-label">Correo</label>
                        <input type="email" class="form-control" id="Correo"
                               aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="Contraseña" class="form-label mt-2">Contraseña</label>
                        <input type="password" class="form-control mt-2" id="Contraseña">
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Submit</button>
                </div>

            </div>
        </form>
    </div>
    <footer style="background: black">
        <p style="color: white">Derechos Reservados &copy; Recetas de Mamá</p>
    </footer>
</center>

</body>
</html>
