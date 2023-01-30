<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/stylesse.css">
  <title>Formulário</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
  <div class="sidebar">

    <div class="logo_menu">

      <img src="imagens\logo2.png" alt="">
      </img>
      <br>
      <span class="m">
        <i class="fas fa-user-tie teste "></i>Sistema de Evasão de Alunos</span>
      <p class="p"></p>
    </div>

    <nav>
      <ul>
        <li>
          <a href="usuarios.php">
            <i class="fas fa-users "></i>
            <span class="nav-item">Usuário</span>
          </a>
        </li>

        <li>
          <a href="alunos.php">
            <i class="fas fa-users "></i>
            <span class="nav-item">Alunos</span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fas fa-user "></i>
            <span class="nav-item">Perfil de acesso</span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fas fa-task "></i>
            <span class="nav-item">Apredizagem de máquina</span>
          </a>
        </li>

        <li>
          <a href="relatoriode.php">
            <i class="fas fa-chart-bar "></i>
            <span class="nav-item">Relatório de atributos</span>
          </a>
        </li>

        <li>
          <a href="relatorioevasao.php" class="active">
            <i class="fas fa-chart-bar  "></i>
            <span class="nav-item">Relatório de evasão</span>
          </a>
        </li>

        <li>
          <a href="suporte.php" class="suporte">
            <i class="fas fa-question-circle "></i>
            <span class="nav-item">Suporte</span>
          </a>
        </li>
        <p class="versao">versãoo 1.111</p>
      </ul>
    </nav>



  </div>

  <section>
    <h2>Contato</h2>
    <form action="https://api.staticforms.xyz/submit" method="post">
      <label>Nome</label>
      <input type="text" name="name" placeholder="Digite seu nome" autocomplete="off" required>
      <label>Email</label>
      <input type="email" name="email" placeholder="Digite seu email" autocomplete="off" required>
      <label>mensagem do erro detalhada</label>
      <textarea name="message" cols="30" rows="10" placeholder="Digite sua mensagem" required></textarea>
      <button type="submit">Enviar</button>

      <input type="hidden" name="accessKey" value="042be0d3-84fa-4ae8-aaed-2434cda72cac">
      <input type="hidden" name="redirectTo" value="http://127.0.0.1:5501/obrigado.html">
    </form>
  </section>
</body>

</html>