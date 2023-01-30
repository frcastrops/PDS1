<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Relatório de Evasão</title>
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

  <div class="container">
    <div class="header">
      <div class="editar">
        <span class="red">Relatório de alunos propensos a evadir</span>
        <button onclick="gerarPdfs()" id="new" style="margin-left: 140px !important;" value="imprimir"> Baixar
          Relatório</button>
        <button onclick="location.reload()" id="new" class="pls"> Atualizar Relatório</button>
        <i class=" fa fa-bell"></i>
      </div>
    </div>
     <div class="divTable">
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Matrícula</th>
                    <th>Email</th>
                    <th>Situação</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    $json = file_get_contents('http://localhost:8080/report/studant');
                    $data = json_decode($json, true);

                    foreach ($data as $user) {
                ?>
                    <tr>
                        <td>
                            <?php echo $user["nome"]; ?>
                        </td>
                        <td>
                            <?php echo $user["matricula"]; ?>
                        </td>
                        <td>
                            <?php echo $user["email"]; ?>
                        </td>
                        <td>
                            <?php echo $user["situacao"]; ?>
                        </td>
                    </tr>
                <?php
                    }
                ?>
            </tbody>
        </table>
    </div>
  </div>
  <div class="clear"></div>

  <script src="script.js">


  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js"
    integrity="sha384-THVO/sM0mFD9h7dfSndI6TS0PgAGavwKvB5hAxRRvc0o9cPLohB0wb/PTA7LdUHs"
    crossorigin="anonymous"></script>

  <script>
    function gerarPdfs() {
      var doc = new jsPDF();
      doc.fromHTML('<h1>Gerar PDF com conteúdo HTML</h1>', 15, 15)
      doc.save('Relatório_De_Evasao.pdf');
    }
  </script>
</body>

</html>