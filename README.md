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