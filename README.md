# Todo List

## Implementando DTO com ModelMapper

### Dependência do ModelMapper
```
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.1</version>
</dependency>
```
### Classe de configuração p/ tornar o mapper um componente gerenciado pelo Spring
```
@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
```

### Classe utilitária com métodos que iremos utilizar na implementação dos DTOs
```
@Component
public class MapperUtils {
    private final ModelMapper mapper;

    public MapperUtils(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <O, D> D parseObject(O origin,
                                Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObjects(List<O> origin,
                                           Class<D> destination) {

        List<D> destinationObjects = new ArrayList<>();

        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
```
 
## Migrations para versionar o banco de dados:

### Dependencia do Flyway

```
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

### Criar tabela category
 ```
 CREATE TABLE
  public.categories (
    id bigserial NOT NULL,
    name character varying (100) UNIQUE NOT NULL
  );

ALTER TABLE
  public.categories
ADD
  CONSTRAINT categories_pkey PRIMARY KEY (id)

```

### Criar table Todos
```
CREATE TABLE
    public.todos
(
    id           bigserial                      NOT NULL,
    concluded    boolean                        NOT NULL,
    concluded_at timestamp(6) without time zone NULL,
    created_at   timestamp(6) without time zone NULL,
    deadline     timestamp(6) without time zone NULL,
    todo         character varying(255)         NULL,
    updated_at   timestamp(6) without time zone NULL,
    category_id  bigint                         NULL
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
 ('Lazer'),
 ('Outro');
```
