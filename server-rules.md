<h1>서버 규칙 API</h1>

<h2>작업 등록 처리</h2>
* URL : localhost:8080/todo/save
* Http Method : GET
* 제공해야하는 JSON 형식
```json
{
  "email": "이메일",
  "content": "작업 내용"
}
```
* 응답 형식
```json
// 정상 처리 시
{
}
```