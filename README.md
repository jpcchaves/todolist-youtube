# Todo List
 
 Migrations para versionar o banco de dados:

### Criar tabela category
 ```
 CREATE TABLE
  public.categories (
    id bigserial NOT NULL,
    name character varying (255) NULL
  );

ALTER TABLE
  public.categories
ADD
  CONSTRAINT categories_pkey PRIMARY KEY (id)

```

### Criar table Todos
```
CREATE TABLE
  public.todos (
    id bigserial NOT NULL,
    active boolean NOT NULL,
    concluded boolean NOT NULL,
    concluded_at timestamp(6) without time zone NULL,
    created_at timestamp(6) without time zone NULL,
    deadline timestamp(6) without time zone NULL,
    todo character varying (255) NULL,
    updated_at timestamp(6) without time zone NULL,
    category_id bigint NULL
  );

ALTER TABLE
  public.todos
ADD
  CONSTRAINT todos_pkey PRIMARY KEY (id)
```

### Seed de categorias
```
INSERT INTO
 public.categories ("name")
VALUES
 ('Trabalho'),
 ('Casa'),
 ('Lazer');
```
