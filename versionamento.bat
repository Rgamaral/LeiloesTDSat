@echo off
:: versionamento.bat - Script para versionamento automático do projeto de leilões
:: Atende todos os requisitos da Atividade 1

title Sistema de Versionamento - Casa de Leilões

:: Configuração de cores
color 0A

:: Verificar se o Git está instalado
where git >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] Git não está instalado ou não está no PATH
    echo Por favor, instale o Git em: https://git-scm.com/downloads
    pause
    exit /b
)

echo.
echo ###################################################
echo #       SISTEMA DE LEILÕES - VERSIONAMENTO       #
echo ###################################################
echo.

:: 1. Iniciar versionamento no repositório local
echo [1/6] INICIANDO VERSIONAMENTO LOCAL...
git init
if %errorlevel% neq 0 (
    echo [ERRO] Falha ao iniciar repositório Git
    pause
    exit /b
)

:: 2. Adicionar arquivos do projeto ao registro de commit
echo.
echo [2/6] ADICIONANDO ARQUIVOS AO STAGING AREA...
git add .
if %errorlevel% neq 0 (
    echo [ERRO] Falha ao adicionar arquivos
    pause
    exit /b
)

:: 3. Realizar o commit com a descrição "Projeto inicial"
echo.
echo [3/6] REALIZANDO COMMIT INICIAL...
git commit -m "Projeto inicial"
if %errorlevel% neq 0 (
    echo [ERRO] Falha ao realizar commit
    pause
    exit /b
)

:: 4. Criar um repositório remoto no GitHub (etapa manual)
echo.
echo [4/6] ATENÇÃO: CRIE O REPOSITÓRIO NO GITHUB
echo.
echo PASSO-A-PASSO:
echo 1. Acesse https://github.com/new
echo 2. Nome do repositório: sistema-leiloes
echo 3. Selecione 'Public'
echo 4. NÃO marque 'Initialize with README'
echo 5. Clique em 'Create repository'
echo.
set /p GITHUB_USER="Digite seu nome de usuário do GitHub: "
echo.
pause

:: 5. Criar o link para o repositório remoto
echo.
echo [5/6] CONFIGURANDO REPOSITÓRIO REMOTO...
git remote add origin https://github.com/%GITHUB_USER%/sistema-leiloes.git
if %errorlevel% neq 0 (
    echo [ERRO] Falha ao configurar repositório remoto
    pause
    exit /b
)

:: 6. Enviar para o repositório remoto
echo.
echo [6/6] ENVIANDO CÓDIGO PARA O GITHUB...
git push -u origin main
if %errorlevel% neq 0 (
    echo [ERRO] Falha ao enviar para o repositório remoto
    pause
    exit /b
)

:: Criar README.md com as informações do projeto
echo.
echo CRIANDO ARQUIVO README.md...
(
echo # Sistema de Leilões
echo.
echo ## Descrição do Projeto
echo Sistema desenvolvido para automatizar os processos de uma casa de leilões, permitindo:
echo - Cadastro de produtos para leilão
echo - Consulta de produtos disponíveis
echo - Registro de vendas
echo - Controle de status dos produtos
echo.
echo ## Tecnologias Utilizadas
echo - Java ^(linguagem de programação^)
echo - MySQL ^(banco de dados^)
echo - Swing ^(interface gráfica^)
echo - Git/GitHub ^(controle de versão^)
echo.
echo ## Como Executar
echo 1. Importar o banco de dados no MySQL
echo 2. Configurar conexão no arquivo conectaDAO.java
echo 3. Executar a classe cadastroVIEW.java
) > README.md

:: Atualizar repositório com README.md
echo.
echo ATUALIZANDO REPOSITÓRIO COM README...
git add README.md
git commit -m "Adiciona README com informações do projeto"
git push origin main

:: Mensagem final
echo.
echo ###################################################
echo #            PROCESSO CONCLUÍDO!                 #
echo ###################################################
echo.
echo Repositório criado com sucesso!
echo Acesse: https://github.com/%GITHUB_USER%/sistema-leiloes
echo.
echo Relatório de Comandos Executados:
echo 1. git init
echo 2. git add .
echo 3. git commit -m "Projeto inicial"
echo 4. git remote add origin https://github.com/%GITHUB_USER%/sistema-leiloes.git
echo 5. git push -u origin main
echo 6. git add README.md
echo 7. git commit -m "Adiciona README com informações do projeto"
echo 8. git push origin main
echo.
pause