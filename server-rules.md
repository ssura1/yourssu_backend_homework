<h1>서버 규칙 API</h1>

<h2>작업 등록 처리</h2>

* URL : localhost:8080/todo/save
* Http Method : POST
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
  "result":true,
  "message":"작업 추가에 성공했습니다."
}

// 에러 발생 시
{
  "result":false,
  "message":"에러에 해당하는 메시지"
}
```
<hr/>

<h2>작업 상태 변경 처리</h2>

* URL : localhost:8080/todo/update
* Http Method : PUT
* 제공해야하는 JSON 형식
```json
{
  "todo_id":"작업 고유 id값, int형",
  "todo_state":"DONE 또는 TODO의 String형"
}
```
* 응답 형식
```json
// 정상 처리 시
{
  "result":true,
  "message":"작업의 처리 상태가 변경되었습니다."
}

// 에러 발생 시
{
  "result":false,
  "message":"에러에 해당하는 메시지"
}
```
<hr/>

<h2>특정 사용자(이메일)의 작업 목록 조회</h2>

* URL : localhost:8080/todo/list/이메일
* HTTP Method : GET
* 제공해야하는 JSON 형식 : __없음__
* 응답 형식
```json
// 작업 목록이 존재할 때
{
    "result": true,
    "todo": [
        {
            "todo_state": "TODO",
            "todo_id": 1,
            "content": "First TODO content of hi"
        },
        {
            "todo_state": "TODO",
            "todo_id": 2,
            "content": "Second TODO content of hi"
        }
    ],
    "message": "해당 이메일의 작업 목록 가져오기 성공"
}

// 작업 목록이 존재하지 않을 때
{
    "result": false,
    "message": "해당 이메일로 등록된 작업이 존재하지 않습니다."
}
```
<hr/>

<h2>모든 사용자들의 작업 목록 조회</h2>

* URL : localhost:8080/todo/all
* Http Method : GET
* 제공해야하는 JSON 형식 : __없음__
* 응답 형식
```json
// 작업 목록이 존재할 때
{
    "result": true,
    "todo": [
        {
            "todo_state": "TODO",
            "todo_id": 1,
            "email": "hi@naver.com",
            "content": "First TODO content of hi"
        },
        {
            "todo_state": "TODO",
            "todo_id": 2,
            "email": "hi@naver.com",
            "content": "Second TODO content of hi"
        },
        {
            "todo_state": "TODO",
            "todo_id": 3,
            "email": "bye@naver.com",
            "content": "First TODO content of bye"
        },
        {
            "todo_state": "TODO",
            "todo_id": 4,
            "email": "bye@naver.com",
            "content": "Second TODO content of bye"
        }
    ],
    "message": "모든 작업 목록 가져오기 성공"
}

// 작업 목록이 존재하지 않을 때
{
    "result": false,
    "message": "등록된 작업 목록이 존재하지 않습니다."
}
```

<hr/>