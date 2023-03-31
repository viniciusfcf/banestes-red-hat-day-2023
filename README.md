

# Ambiente local

## Criar imagem docker do postgres com tabela de transacao

```
docker build -t postgres-transacoes .
```

```
docker run -it --rm=true --name postgres-transacoes -p 5432:5432 -e POSTGRES_PASSWORD=quarkus postgres-transacoes
```

## Subir imagem com servidor SFTP

```
docker compose up
```