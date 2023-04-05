## Домашнее задание
Обернуть приложение в docker-образ и запушить его на Dockerhub

## Описание/Пошаговая инструкция выполнения домашнего задания:
1. Создать минимальный сервис, который отвечает на порту 8000 имеет http-метод: GET /health/ </br>
RESPONSE: {"status": "OK"}
2. Cобрать локально образ приложения в докер. </br>
Запушить образ в dockerhub
На выходе необходимо предоставить </br> имя репозитория и тэг на Dockerhub
ссылку на github c Dockerfile, либо приложить Dockerfile в ДЗ 

Обратите внимание, что при сборке на m1 при запуске вашего контейнера на стандартных платформах будет ошибка такого вида:
standard_init_linux.go:228: exec user process caued: exec format error
Для сборки рекомендую указать тип платформы linux/amd64:
docker build --platform linux/amd64 -t tag </br>
Более подробно можно прочитать в статье: https://programmerah.com/how-to-solve-docker-run-error-standard_init_linux-go219-exec-user-process-caused-exec-format-error-39221/