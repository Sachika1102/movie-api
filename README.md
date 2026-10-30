# 映画管理API (Movie API)
## 概要
映画の情報を管理するREST APIです。
映画のタイトルや公開日、監督、出演者などの情報をデータベースに保存し、登録・取得・更新・削除を行うことができます。
また、Postmanを使用して各APIの動作確認を行っています。
フロントエンドの実装は行っていません。

## 使用技術
- Java
- Spring Boot
- Spring Boot DevTools
- Lombok
- Spring Web
- JDBC API
- MyBatis Framework
- PostgreSQL Driver
- PostgreSQL

## 主な機能
|HTTPメソッド|エンドポイント|機能|
|---|---|---|
|GET|/api/movies|映画の全件取得|
|POST|/api/movies|映画の新規登録|
|GET|/api/movies/{movieId}|映画の1件取得|
|PUT|/api/movies/{movieId}|映画情報の更新|
|DELETE|/api/movies/{movieId}|映画の削除|

## 管理する映画情報
|項目|内容|
|---|---|
|movieId|映画ID|
|title|映画タイトル|
|releaseDate|公開日|
|runningTime|上映時間|
|director|監督|
|originalWork|原作|
|script|脚本|
|castMembers|出演者|
|description|映画の説明|

## APIの動作確認
Postmanを使用して、以下の機能が正常に動作することを確認しました。
- 映画の全件取得
- 映画の新規登録
- 映画の1件取得
- 映画情報の更新
- 映画の削除
