<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Usuários</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

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
        <p class="versao">versão 1.111</p>
      </ul>
    </nav>
  </div>

  <div class="container">
    <div class="header">
      <div class="editar">
        <span class="red">Usuários Cadastrados no Sistema</span>
        <button onclick="openModal()" id="new">+ Cadastrar Novo Usuário</button>
        <button onclick="location.reload()" id="new" class="pls">Atualizar lista</button>
        <i class=" fa fa-bell"></i>
      </div>
    </div>


    <div class="divTable">
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Tipo de Usuário</th>
                    <th>Data de Criação</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $json = file_get_contents("http://localhost:8080/all/user");
                $data = json_decode($json, true);

                foreach ($data as $user) { ?>
                    <tr>
                        <td>
                            <?php echo $user["nome"]; ?>
                        </td>
                        <td>
                            <?php echo $user["tipoUsuario"]; ?>
                        </td>
                        <td>
                            <?php echo $user["dataCriacao"]; ?>
                        </td>
                        <td>
                            <?php echo $user["status"]; ?>
                        </td>
                    </tr>
                <?php }
                ?>
            </tbody>
        </table>
    </div>
  </div>
  <div class="modal-container">
            <div class="modal">
              <form action="cadastrausuario.php" method="post">

                <label for="m-nome">Nome do usuário:</label>
                <input id="m-nome" name="userName" type="text" required>

                <label for="m-nome">Senha:</label>
                <input id="m-nome" name="userPassword" type="password" required>

                <label for="m-Data">Email:</label>
                <input id="m-Data" name="userEmail" type="email" required>

                <label for="m-tipo">Tipo de Conta:</label>
                <select id="m-tipo" name="userType" required="required">
                  <option value="USER_READ_ONLY">USER_READ_ONLY</option>
                  <option value="USER_ADVANCED">USER_ADVANCED</option>
                  <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                </select>
                <br>
                <br>

                <button type="submit" name="btsalvar">Salvar</button>
              </form>
            </div>
          </div>
  <div class="clear"></div>

  <script src="script.js">


  </script>
</body>

</html>