<?php
session_start();
include("conexao.php");
include('verifica_login.php');
?>

<!DOCTYPE html>
<html>
    
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CPU | Sistema de Edição de editor</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>
    <section class="hero is-success is-fullheight">
        <div class="hero-body">
            <div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Sistema de Edição de editor</h3>
                    <?php
                    if($_SESSION['status_cadastro']):
                    ?>
                    <div class="notification is-success">
                      <p>Alteração efetuada!</p>
                      <p>Volte para o menu <a href="painel.php">aqui</a></p>
                    </div>
                    <?php
                    endif;
                    unset($_SESSION['status_cadastro']);
                    ?>
                    <?php
                    if($_SESSION['usuario_existe']):
                    ?>
                    <div class="notification is-info">
                        <p>O usuário escolhido já existe. Informe outro e tente novamente.</p>
                    </div>
                    <?php
                    endif;
                    unset($_SESSION['usuario_existe']);
                    ?>
                    <?php
                        $query = "SELECT * FROM usuario WHERE adm = '3'";
                        $result = mysqli_query($conexao, $query);
                        while($row = mysqli_fetch_assoc($result)){

                            echo '<div class="box"><form action="editareditor.php" method="POST"><input type="hidden" name="id" value="'. $row["usuario_id"] .'"><div class="field"><div class="control"><input name="nome" type="email" class="input is-large" placeholder="Email" value="' . $row["nome"] . '"autofocus></div></div>';
			                echo '<div class="field"><div class="control"><input name="usuario" type="text" class="input is-large" placeholder="Usuário" value="' . $row["usuario"] . '"></div></div>';
			                echo '<div class="field"><div class="control"><input name="senha" class="input is-large" type="password" placeholder="Senha" value="' . $row["senha"] . '"></div></div><button type="submit" class="button is-block is-link is-large is-fullwidth">Editar</button></form></div>';
                            
                        }

                    ?>
                    
                </div>
            </div>
        </div>
    </section>
</body>

</html>