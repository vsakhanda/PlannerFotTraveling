package com.planner.travel.utils;

public class questions {

}
/*
Сергій, доброго дня.

Другий день перемагаю збереження. Зараз видає помилку:
2023-10-06T11:36:11.017+03:00 ERROR 7882 --- [nio-8080-exec-4] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.NullPointerException: Cannot invoke "com.planner.travel.entity.User.getId()" because "user" is null] with root cause

java.lang.NullPointerException: Cannot invoke "com.planner.travel.entity.User.getId()" because "user" is null

логічно, оскільки id не передаю, так як вона повинна генеритись на стороні DB.
якщо в DAO додаю реквізит id, то виникають помилки  - відсутнє значення в рядку 1, або не заповнений параметр 7
Можете підказати в яку сторону копати?


*/
