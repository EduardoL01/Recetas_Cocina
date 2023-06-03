<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../Styles/estilos.css">
    <link rel="icon" href="../../Images/logo%20pagina%20web.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Nueva Receta</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="../../index.jsp">
            <img src="../../Images/logo%20pagina%20web.png" alt="" width="34" height="34"
                 class="d-inline-block align-text-center">
            Recetas de Mamá
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="recetas.jsp">Recetas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="categorias.jsp">Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="nreceta.jsp">Crear Nueva Receta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="perfil.jsp">Mi Perfil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../../index.jsp">Cerrar Sesion</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<center>
    <div class="snippet-container mt-5">
        <h2>
            Inicio de sesion
        </h2>
        <form action="../loginSV" method="post">
            <div class="card" style="width: 80rem;">
                <div class="card-body">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Correo</label>
                        <input type="text" name="correo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label mt-2">titulo</label>
                        <input type="text" name="contraseña" class="form-control mt-2" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label mt-2">descripcion</label>
                        <input type="text" name="contraseña" class="form-control mt-2" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label mt-2">Contraseña</label>
                        <input type="text" name="contraseña" class="form-control mt-2" id="exampleInputPassword1">
                    </div>
                    <button type="submit" name="accion" value="ingresar" class="btn btn-primary mt-2">Submit</button>
                    <div class="mt-3">
                        <a href="registro.jsp">
                            ¿no tienes cuenta? registrate aqui
                        </a>
                    </div>
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