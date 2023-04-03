

# Ambiente local

É necessário ter *docker* rodando

## Criar imagem docker do postgres com tabela de transacao

```
docker build -t postgres-transacoes .
```

```
docker run -it --rm=true --name postgres-transacoes -p 5432:5432 -e POSTGRES_PASSWORD=quarkus postgres-transacoes
```

## inicializar container com servidor SFTP

```
docker compose up
```


## Iniciar todos os projetos

Preferência de inicialização: plataforma-externa, buscador-arquivos, leitor-arquivo, leitor-banco-kafka-reader


## Servidor SFTP

Utilizar alguma GUI, ex FileZilla, conectar com parâmetros sftp://localhost 9922 user=foo e password=pass.
copiar arquivo *exemplo-arquivo.txt* para pasta /foo/files