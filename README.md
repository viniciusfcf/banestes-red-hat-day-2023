

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

## Configuração do OCP

### Criar namespaces

```
oc new-project sistemas-internos
```

```
oc new-project sistemas-externos
```

```
oc new-project postgres
```

```
oc new-project my-kafka
```

```
oc new-project grafana
```


### Operadores

1. Serverless
2. Streams
3. Camel K
4. Grafana

### enable monitoring

https://docs.openshift.com/container-platform/4.12/monitoring/enabling-monitoring-for-user-defined-projects.html#granting-users-permission-to-monitor-user-defined-projects_enabling-monitoring-for-user-defined-projects

### Postgres (evoluir depois para usar o template)

Realizar deploy de um postgres ephemeral no namespace `postgres` com campos:
1. username=postgres
2. password=quarkus
3. database postgres

```
POSTGRES_POD=$(oc get pods -n postgres --field-selector=status.phase=Running  -o=jsonpath='{.items[0].metadata.name}')
```

```
oc rsh -n postgres $POSTGRES_POD
```

```
PGPASSWORD=quarkus psql -h postgresql postgres postgres
```

```
CREATE TABLE public.transacao(id serial PRIMARY KEY,nome VARCHAR (255) NOT NULL,valor INT NOT NULL,processado BOOLEAN NOT NULL);
```

Executar os arquivos deployOpenshift.sh

```
THANOS_QUERIER_HOST=`oc get route thanos-querier -n openshift-monitoring -o json | jq -r '.spec.host'`
```

Secret só depois de configurar cluster-monitoring.yml

```
SECRET=`oc get secret -n openshift-user-workload-monitoring | grep  prometheus-user-workload-token | head -n 1 | awk '{print $1 }'`
```

```
TOKEN=`echo $(oc get secret $SECRET -n openshift-user-workload-monitoring -o json | jq -r '.data.token') | base64 -d`
```

```
oc rsync arquivos-temp leitor-arquivo-<POD...>:/tmp/ftp/
```

```
oc rsh leitor-arquivo-1-5k5n9
```

Fazer deploy das apps, imagens estao no meu quay. Td nativo, menos o leitor de arquivo.