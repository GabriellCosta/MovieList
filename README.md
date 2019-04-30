[![CircleCI](https://circleci.com/gh/GabriellCosta/MovieList.svg?style=svg)](https://circleci.com/gh/GabriellCosta/MovieList)

# Pipeline

  * Build
  * Lints
    * ktLint
    * detekt
  * Test
    * Unitario


# Arquitetura
  O Aplicativo segue tentando usar o mais basico de tudo que for possível para ser simples, existem algumas problemas em relação a UI que foram pedidos e implementados por falta de refinamento, mas sendo somente  um desafio segue desta maneira

# Usando via CLI

  Para gerar um apk -> assemble

  Para instalar o apk:

    * Versão de Debug -> installDebug

# Melhorias

Hoje é salvo somente itens favoritos, no entanto deveria ser salvo todos os valores da api de filmes e assim adicionar um indicativo de que ele é favorito
assim a implementação iria melhorar pois teriamos um single source of truth, e uma ordenação mais simples de ser elabora
