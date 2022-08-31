
# News

The project consumes the API GNews

## API Reference

#### Get articles filter by title, content, publish date

```http
  GET /news/v0/articles
```
| Params in |
| :------------------------- |
| Parameter | Type     | Description                |
| `content` | `string` | **Required**. Key word to find articles |
| `title` | `string` | **Optional**. Title concidences |
| `pageSize` | `string` | **Optional**. Pagesize response |
| `initDate` | `string` | **Optional**. First date to find article |
| `endDate` | `string` | **Optional**. Last date to find an article |

| Params out |
| :------------------------- |
| Parameter | Type     | Description                |
| `totalElements` | `int` | **Optional**. Number of articles with concidences |
| `articles[].content` | `string` | **Optional**. Description about the article |
| `articles[].title` | `string` | **Optional**. Title article |
| `articles[].description` | `string` | **Optional**. Description about the article |
| `articles[].url` | `string` | **Optional**. Link to article |
| `articles[].image` | `string` | **Optional**. Link to image |
| `articles[].publishedAt` | `string` | **Optional**. Publish date article |
| `articles[].source` | `string` | **Optional**. Source |
| `articles[].source.name` | `string` | **Optional**. Name site |
| `articles[].source.url` | `string` | **Optional**. Link to main site |

#### Get breaking news

```http
  GET /news/v0/top-headlines
```

| Params out |
| :------------------------- |
| Parameter | Type     | Description                |
| `list[].totalElements` | `int` | **Optional**. Number of articles with concidences |
| `list[].articles[].content` | `string` | **Optional**. Description about the article |
| `list[].articles[].title` | `string` | **Optional**. Title article |
| `list[].articles[].description` | `string` | **Optional**. Description about the article |
| `list[].articles[].url` | `string` | **Optional**. Link to article |
| `list[].articles[].image` | `string` | **Optional**. Link to image |
| `list[].articles[].publishedAt` | `string` | **Optional**. Publish date article |
| `list[].articles[].source` | `string` | **Optional**. Source |
| `list[].articles[].source.name` | `string` | **Optional**. Name site |
| `list[].articles[].source.url` | `string` | **Optional**. Link to main site |

## Getting started

For build the application you need

| **JDK 11** |
| **Maven 3** |

## Start the application localy

For start the application use the command in command line:

```
	mvn spring-boot:run
```
the project use the default port 8080

```
	http://localhost:8080/
```

you can consume the services of the API Reference






