# Desenvolvimento de Software para Persistência
Repositório de listas e trabalhos da disciplina de Desenvolvimento de Software para Persistência da UFC - Campus Quixadá oferta 2020.2

## Lista de Exercícios 01
1. Crie uma aplicação para receber via entrada de teclado um nome de arquivo texto e dois números inteiros (n1 e n2). 

    A aplicação deve exibir as linhas do arquivo entre n1 e n2, incluindo as linhas n1 e n2. Se n1 não for definido, deve-se exibir as linhas do arquivo a partir da primeira linha até n2. Se n2 não for definido, deve-se exibir as linhas do arquivo a partir de n1 até o final do arquivo.

2. Escreva uma aplicação para ler um arquivo qualquer e gravá-lo em outro arquivo (arquivo destino).
    - Os nomes dos arquivos (origem e destino) devem ser definidos na chamada da aplicação via teclado ou via argumentos de linha de comando.
    - Ao final, deve-se exibir o tempo total da cópia, caso a cópia tenha sido bem sucedida.

## Lista de Exercícios 02
1. Escreva uma aplicação para ler um arquivo binário origem e gravá-lo em outro arquivo (arquivo destino).

    Os nomes dos arquivos (origem e destino) devem ser definidos na chamada da aplicação via argumento de linha de comando.
    A leitura e gravação devem ser realizadas em blocos de bytes e não byte a byte.
    Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida.
    Teste vários tamanhos de bloco e encontre um tamanho que ofereça um bom desempenho. Crie uma tabela para comparar os resultados encontrados.
    
2. Escolha e baixe um arquivo csv a partir do link e use-o nas questões a seguir. Na resolução desta questão, não enviar os arquivos envolvidos, mas somente os resultados pedidos em arquivo PDF.

    Gere as somas md5 e sha1 do arquivo encriptado. 

    Compacte via linha de comando o arquivo csv original usando compressões zip, gzip, bzip2, rar e 7zip. Depois disso compare os tempos e tamanhos dos arquivos gerados. Dica: para obter o tempo de execução, use o comando time.
    
    Exemplo: time zip iris.zip iris.csv

3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:
   
    - arquivo config.properties
        ```
        linha_inicial = 1
        linha_final = 3
        ```
    Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da linha_inicial até a linha_final, conforme definidas no arquivo de propriedades config.properties.
    
## Lista de Exercícios 03
1. Crie uma classe Java de entidade. Exemplo: Pessoa (id, nome, email, fone).

2. Crie uma classe Java para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd.

3. Crie uma classe java para ler / desserializar os objetos Serializados na Questão 2 e exibi-los.

4. Crie uma classe Java para obter um arquivo via argumento de linha de comando e compactar e salvar o arquivo compactado em disco/ssd.

## Trabalho Prático 1
1. Defina uma entidade principal relacionada a um domínio de problema e crie uma classe Java para representá-la.
Exemplo: Cliente: id, nome, cpf, endereço, email, fone, cidade, uf, cep.

2. Crie uma classe Java para cadastrar dados relacionados à entidade definida na questão 1. A classe deve receber dados via teclado e os salvar ao final de um arquivo CSV (append).

3. Crie uma classe Java que recebe como entrada de teclado o nome de um arquivo qualquer em formato CSV e o converte para os formatos XML e JSON.

4. Crie uma classe Java que recebe como entrada de teclado o nome de um arquivo qualquer em formato CSV e o compacta para o formato ZIP ou outro formato de compressão à sua escolha.

## Trabalho Prático 2
1. Crie uma aplicação que use um banco relacional contendo uma tabela de funcionários e seus dependentes, com suas respectivas classes Java. Cada funcionário deve ter um id, cpf, matrícula, nome, email e telefone. Cada dependente tem somente id, cpf e nome. Os campos id, cpf e matrícula devem não devem permitir duplicação, ou seja devem ser únicos. Existe uma associação entre funcionários e dependentes de modo que um funcionário pode ter vários dependentes, mas um dependente somente está vinculado a um único funcionário. As tabelas devem ser criadas a partir dos mapeamentos das classes através do JPA. 

2. Use o padrão de persistência DAO neste trabalho.

3. Crie implementação JPA para seu DAO.

4. Crie uma classe para adicionar via DAO pelo menos 6 funcionários com seus dependentes no banco de dados. Pelo menos 50% dos funcionários devem ter dependentes.

5. Crie e exiba o resultado de consultas JPQL, Criteria, Named Query e SQL Nativas via uso do DAO para cada uma das consultas abaixo:

    a) Mostrar os nomes e todos os dependentes com nomes iniciador por uma determinada letra, juntamente com o nome do funcionário ao qual ele depende. A letra inicial deve ser um parâmetro nomeado da consulta.
    
    b) Mostrar todos os dados de todos os funcionários funcionários.

6. Crie uma transação em um método de um DAO com pelo menos 3 operações. Crie implementação para JPA. Faça com que a última operação por alguma restrição do banco de dados não funcione, e daí um rollback deve ocorrer.