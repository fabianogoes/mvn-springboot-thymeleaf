# MVC Application com Spring Boot

### Developer tools

[Reference][0]

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```


### Thymeleaf

***References***

* [Serving Web Content with Spring MVC][1]
* [Spring Boot Hello World Example – Thymeleaf][2]
* [Tutorial: Thymeleaf + Spring][3]
* [Standard URL Syntax][6]
* [Concatenate strings in Thymeleaf][8]

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```


```html
	<html xmlns:th="http://www.thymeleaf.org">

	<h1 th:text="${titulo}">MVC Application</h1>

	<tr th:each="pessoa : ${lista}">
		<td th:text="${pessoa.id}"></td>
		<td th:text="${pessoa.nome}"></td>
		<td>
			<a href="/editar">Editar</a>
			<a href="/deletar">Deletar</a>
		</td>
	</tr>

	<form action="#" th:action="@{/salvar}" th:object="${pessoa}" method="post">
		<label>ID</label>
		<input type="text" name="id" readonly="readonly" th:value="*{id}" />
		<br/>
		<br/>
		<label>Nome</label>
		<input type="text" name="nome" th:value="*{nome}" />
		<br/>
		<br/>
		<button type="submit">Salvar</button>
		<a href="/">Cancelar</a>
	</form>

	<a th:href="@{/editar/{id}(id=${pessoa.id})}">Editar</a>	

```




### Java 8 - Lambda

**Max/Min value**

[Finding Max/Min of a List or Collection][4]

```java
	int max = lista.stream()
		.mapToInt(p -> p.getId())
		.max().orElse(0);

	int max = lista.stream()
		.mapToInt(p -> p.getId())
		.min().orElse(0);		
```

**Filters**

[Java 8 Streams filter examples][5]


```java
	Pessoa pessoa = lista.stream()
		.filter(p -> p.getId() == id)
		.findAny()
		.orElse(null);
```

**Update Value List**.  

```java
	lista.forEach(p -> {
		if(p.getId() == pessoa.getId()){
			p.setNome(pessoa.getNome());
		}
	});
```

**Delete Object from List**

[Reference][7]

```java
lista.removeIf(p -> p.getId() == id);
```


[0]: https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html#using-boot-devtools
[1]: https://spring.io/guides/gs/serving-web-content/
[2]: https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/
[3]: http://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
[4]: http://www.baeldung.com/java-collection-min-max
[5]: https://www.mkyong.com/java8/java-8-streams-filter-examples/
[6]: http://www.thymeleaf.org/doc/articles/standardurlsyntax.html
[7]: https://www.leveluplunch.com/java/examples/remove-element-from-list/
[8]: https://gist.github.com/romach/10081ba3e24ffc9f75aadada7df80df8
