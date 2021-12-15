<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="cadastrado_com_sucesso2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../Home/css/style.css">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">
    <title>Cadastro Concluído</title>
</head>

<body>

    <div id="container">
        <!-- Início container -->

        <header>
            <div class="center-header">
                <div class="vó-fundo">
                    <img src="../Home/imagem/fundo-3.jpeg">
                </div><!--vó-fundo-->
            </div><!--center-->
        </header>

        <nav>
            <div class="center-nav">
                <div class="logo">
                    <a href="../Home/index.php">
                    <img src="../Home/imagem/Vó-logo.png">
                    </a>
                </div><!--logo-->

                <ul class="menu">
                    <li><a href="../Home/index.php">Home</a></li>
                    <li><a href="../Sobre/sobre.php">Sobre</a></li>
                    <li><a href="../Projetos/projetos.php">Projetos</a></li>
                    <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                    <li><a href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a href="../Home/index.php">Home</a></li>
                        <li><a href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                        <li><a href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>

        <section class="check">
            <div class="center-check">
                <div class="imagem_check">
                    <a href="..//Home/index.php">
                        <img src="Accept-icon.png" alt="Imagem check">
                    </a>
                </div>
            </div>
        </section>

        <section class="sucesso">
            <div class="center-sucesso">
                <div class="titulo-sucesso">
                    <h1 class="h1">SUCESSO!</h1>
                </div>

                <div class="subtitulo-sucesso">
                    <h2 class="h2">Seu cadastro foi enviado!</h2>
                </div>

                <div class="imagem_maos">
                    <img src="../Participantes/mãos_cadastrado_com_sucesso.jpeg" alt="Imagem de mÃ£os coloridas">
                </div>

                <div class="titulo-agradecimento">
                    <h3 class="h3">AGRADECEMOS A SUA PARTICIPAÇÃO!</h3>
                </div>
            </div>
        </section>
        
        <footer class="footer-vó">
            <div class="center-footer">
                <div class="footer-left">
                        <p>Telefone : (12) 3966- 2833</p>
                        <p>E-mail: administracao@aamu.org.br</p>
                        <p>Horário de Segunda a Sexta, das 07:00h às 17:00hs</p>
                </div>

                <div class="footer-right" style="justify-content: center;
                flex-wrap: wrap;">
                    <p>Você pode nos ajudar compartilhando nossa causa</p>
                    <span>
                        <a target="_blank" href="javascript:void(0)" onclick="share()">
                            <img class="vó-icons-share"src="../Home/imagem/compartilhar.png" />
                        </a>
                                
                        <a target="_blank" href="https://www.instagram.com/explore/locations/1023028168/cecoi-vo-maria-felix/">
                            <img class="vó-icons-share vó-icons-share-insta"src="../Home/imagem/logo-instagram.png" />
                        </a>

                        <a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https://www.facebook.com/fatecjessenvidal/">
                            <img class="vó-icons-share vó-icons-share-face" src="../Home/imagem/logo-facebook.png" >
                        </a>
                                
                        <a target="_blank" href="https://api.whatsapp.com/send?text=https://www.facebook.com/fatecjessenvidal/">
                            <img class="vó-icons-share vó-icons-share-whats" src="../Home/imagem/logo-whatsapp.png" />
                        </a>
                    </span>
                </div>

                <div class="footer-center">
                    <p>2021 
                    <a href="">Vó Maria Félix</a> 
                    - Todos os direitos reservados.</p>
                </div>

            </div>
        </footer>
        
    </div>

    <script>
        function share(){
            if (navigator.share !== undefined) {
                navigator.share({
                    title: 'Maria Vó Félix',
                    text: 'Um texto de resumo',
                    url: 'https://www.facebook.com/fatecjessenvidal/',
                })
                    .then(() => console.log('Successful share'))
                    .catch((error) => console.log('Error sharing', error));
                }
            }
    </script>

    <script>

        var el = document.querySelector('.menu-mobile-icon');

        el.addEventListener('click',()=>{
            //Queremos mostrar o menu.
            var menuItens = document.querySelector('.menu-itens');
            if(menuItens.classList.contains('show')){
                menuItens.classList.add('hide'); 
                menuItens.classList.remove('show'); 
            }else{
                menuItens.classList.add('show'); 
                menuItens.classList.remove('hide'); 
            }       
        });

    </script>

</body>
  
<?php
            $conexao = mysqli_connect("localhost","root","","bd_participantes");

            $nome         = isset($_POST['nome'])?$_POST['nome']:"";
            $nome_pai     = isset($_POST['nome_pai'])?$_POST['nome_pai']:"";
            $nascimento   = isset($_POST['nascimento'])?$_POST['nascimento']:"";
            $nome_mae     = isset($_POST['nome_mae'])?$_POST['nome_mae']:"";
            $cpf          = isset($_POST['cpf'])?$_POST['cpf']:"";
            $tel_number   = isset($_POST['tel_number'])?$_POST['tel_number']:"";
            $celular      = isset($_POST['celular'])?$_POST['celular']:"";
            $email        = isset($_POST['email'])?$_POST['email']:"";
            $redesocial   = isset($_POST['redesocial'])?$_POST['redesocial']:"";
            $youtube      = isset($_POST['youtube'])?$_POST['youtube']:"";
            $outros       = isset($_POST['outros'])?$_POST['outros']:"";
            $especifique  = isset($_POST['especifique'])?$_POST['especifique']:"";
    
            $sql_participantes = "insert into tb_participantes (nome,nome_pai,nascimento,nome_mae,cpf,tel_number,celular,email,redesocial,youtube,outros,especifique) values ('$nome','$nome_pai','$nascimento','$nome_mae','$cpf','$tel_number','$celular','$email','$redesocial','$youtube','$outros','$especifique')";
            $salvar = mysqli_query($conexao,$sql_participantes);
            
        ?>
    

</html>