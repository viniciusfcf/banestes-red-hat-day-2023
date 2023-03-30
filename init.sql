CREATE TABLE public.transacao(
   id serial PRIMARY KEY,
   nome VARCHAR (255) NOT NULL,
   valor INT NOT NULL,
   processado BOOLEAN NOT NULL
);